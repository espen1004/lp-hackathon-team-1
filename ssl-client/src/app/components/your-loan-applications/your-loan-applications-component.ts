import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";

interface Link<T extends LinkVerbs = LinkVerbs> {
  href: string;
  verbs: T[];
}

type LinkVerbs = 'GET' | 'PUT' | 'POST' | 'DELETE';


interface PreApproval {
  date: Date;
  amount: number;
  name: string;
  applicant: string;
  status: string;
  links?: { [key: string]: Link };
}

@Component({
  styleUrls: ['your-loan-applications-component.css'],
  templateUrl: './your-loan-applications-component.html'
})
export class YourLoanApplicationsComponent implements OnInit {
  preapprovals: PreApproval[] = [];


  constructor(private router: Router) {
  }

  ngOnInit(): void {
    this.preapprovals.push({date: new Date(), amount: 5000000, name: 'Finansieringsbevis', applicant: 'Kari Nordmann', status: 'IN_PROGRESS'});
    this.preapprovals.push({date: new Date(), amount: 6000000, name: 'Finansieringsbevis', applicant: 'Kari Nordmann', status: 'DOCUMENT_FOR_DOWNLOAD'});
    this.preapprovals.push({date: new Date(), amount: 7000000, name: 'Finansieringsbevis', applicant: 'Kari Nordmann', status: 'BANK_REFUSAL'});
  }


  mapStatusToText(status: string) {
    switch (status) {
      case 'IN_PROGRESS':
        return 'Til behandling i banken';
      case 'DOCUMENT_FOR_DOWNLOAD':
        return 'Klar til bruk';
      case 'BANK_REFUSAL':
        return 'Avslått';
      default:
        return 'Ukjent status';
    }
  }

  convertToLoan(preApproval: PreApproval) {
    this.router.navigate(['collateral']);
  }
}
