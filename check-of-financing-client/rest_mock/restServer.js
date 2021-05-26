const express = require('express');
const app = express();
const router = express.Router();

const routes = [
  require('./routes/financingRoute')
];

routes.forEach(function (route) {
  route.setup(router, app);
});

module.exports = router;
