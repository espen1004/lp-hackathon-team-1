package com.example.checkoffinancingservice.financing;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("financing")
public class FinancingResource {

    private final FinancingService financingService;
    private final ConcurrentHashMap<String, SseEmitter> emitters = new ConcurrentHashMap<>();

    @Autowired
    public FinancingResource(FinancingService financingService) {
        this.financingService = financingService;
    }

    @GetMapping("")
    public List<Financing> getAll() {
        return financingService.getAll();
    }

    @GetMapping("/subscribe")
    @CrossOrigin
    public SseEmitter getNewNotification(@RequestParam String id) {
        SseEmitter emitter = new SseEmitter();
        this.emitters.put(id, emitter);
        try {
            emitter.send("Connected");
        } catch (IOException e) {
            e.printStackTrace();
        }

        emitter.onCompletion(() -> this.emitters.remove(id));
        emitter.onTimeout(() -> {
            emitter.complete();
            this.emitters.remove(id);
        });

        return emitter;
    }

    @GetMapping("/unsub")
    @CrossOrigin
    public void unsub(@RequestParam String id) {
        if (emitters.containsKey(id)) {
            emitters.get(id).complete();
            emitters.remove(id);
        }
    }

    @EventListener
    public void onNewFinancingCheck(Financing financing) {
        Set<String> deadEmitters = new HashSet<>();
        this.emitters.forEach((k, v) -> {
            try {
                v.send(financing);
            } catch (Exception e) {
                deadEmitters.add(k);
            }
        });
        deadEmitters.forEach(emitters::remove);
    }
}
