'use strict';

exports.setup = function (router) {

  router.get('/financing', (req, res) => {
    var response = [{
      financingId: 123456,
      userId: "01019522334",
      financingObject: 'G241/B345/Oslo',
      amount: 3000000,
      acceptanceDeadline: new Date(),
      status: 'APPROVED'
    }, {
      financingId: 665544,
      userId: "01019178945",
      financingObject: 'G150/B564/Oslo',
      amount: 3500000,
      acceptanceDeadline: new Date(),
      status: 'MANUAL_CONTROL '
    }]
    res.status(200).json(response);
  });

  router.put('/financing/:caseNumber', (req, res) => {
    res.status(200).send();
  });

};
