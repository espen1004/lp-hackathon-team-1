ALTER TABLE public.financing
    ADD COLUMN "financingId" bigserial NOT NULL;
ALTER TABLE public.financing DROP COLUMN financeobject;
ALTER TABLE public.financing
    ADD COLUMN "financeObject" text NOT NULL;
ALTER TABLE public.financing
    ADD PRIMARY KEY ("financingId");
