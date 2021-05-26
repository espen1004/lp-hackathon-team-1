const events = require('events');
const em = new events.EventEmitter();

em.on('myEvent', () => {
  console.log('Data Received');
});

em.emit('FirstEvent', 'This is my first Node.js event emitter example.');

module.exports = em;
