'use strict';

exports.setup = function (router) {

  router.get('/financing', (req, res) => {
    var response = [{
      customers: [{
        name: "Ola Nordmann",
        pid: "01019055555"
      }, {
        name: "Kari Nordmann",
        pid: "01019166666"
      }],
      object: 'G241/B345/Oslo',
      bidAmount: 3000000,
      caseNumber: 123456,
      acceptanceDeadline: new Date(),
      status: 'BID_WON'
    }, {
      customers: [{
        name: "Espen Nordlie",
        pid: "01019178945"
      }],
      object: 'G150/B564/Oslo',
      bidAmount: 3500000,
      caseNumber: 665544,
      acceptanceDeadline: new Date(),
      status: 'AWAITING_ACTION'
    }]
    res.status(200).json(response);
  });

};
