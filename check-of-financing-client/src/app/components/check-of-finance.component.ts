import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatSort} from "@angular/material/sort";
import {HttpClient} from "@angular/common/http";

export interface FinancingInfo {
  customers: Customer[];
  object: string;
  bidAmount: number;
  caseNumber: number;
  acceptanceDeadline: Date;
  status: Status;
}

export interface Customer {
  name: string;
  pid: string;
}

export enum Status {
  BID_WON = "Bud vunnet",
  AWAITING_ACTION = "Avventer handling"
}

@Component({
  styleUrls: ['check-of-finance.component.css'],
  templateUrl: './check-of-finance.component.html'
})
export class CheckOfFinanceComponent implements OnInit {

  displayedColumns: string[] = ['customers', 'object', 'bidAmount', 'caseNumber', 'acceptanceDeadline', 'status'];
  dataSource = new MatTableDataSource<FinancingInfo>();
  @ViewChild(MatSort) sort: MatSort = new MatSort();

  constructor(private readonly httpClient: HttpClient) {}

  ngOnInit() {
    this.httpClient
    .get<FinancingInfo[]>('api/financing')
    .toPromise()
    .then(
      data => {
        this.dataSource = new MatTableDataSource(data);
        this.dataSource.sort = this.sort;
      }
    );
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}
