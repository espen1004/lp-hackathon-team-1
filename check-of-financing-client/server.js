const express = require('express');
const bodyParser = require('body-parser');
const restServer = require('./rest_mock/restServer');
const eventEmitters = require('./rest_mock/eventEmitters');

const app = express();
const port = 5000;

app.use(bodyParser.json());
app.use('/api', restServer);
app.set('eventEmitter', eventEmitters);
app.get('eventEmitter');

app.listen(port, () => console.log(`Listening on port ${port}`));
