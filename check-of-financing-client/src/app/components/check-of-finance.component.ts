import {ChangeDetectorRef, Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatSort} from "@angular/material/sort";
import {HttpClient} from "@angular/common/http";
import { v4 as uuid } from 'uuid';

export interface FinancingInfo {
  financingId: number;
  userId: string;
  financeObject: string;
  amount: number;
  /*
    acceptanceDeadline?: Date;
  */
  status: string;
}

@Component({
  styleUrls: ['check-of-finance.component.css'],
  templateUrl: './check-of-finance.component.html'
})
export class CheckOfFinanceComponent implements OnInit, OnDestroy {

  displayedColumns: string[] = ['userId', 'financeObject', 'amount', 'caseNumber', /*'acceptanceDeadline',*/ 'status', 'actions'];
  dataSource = new MatTableDataSource<FinancingInfo>();
  financingInfo: FinancingInfo[] = [];
  @ViewChild(MatSort) sort: MatSort = new MatSort();
  eventSource: any;
  id: string = uuid();

  constructor(
    private readonly httpClient: HttpClient,
    private changeDetection: ChangeDetectorRef,
  ) {
  }

  ngOnInit() {
    this.httpClient
    .get<FinancingInfo[]>('financing')
    .toPromise()
    .then(
      data => {
        this.financingInfo = data;
        this.dataSource = new MatTableDataSource(data);
        this.dataSource.sort = this.sort;
      }
    );
    this.setupEventSource();
  }

  setupEventSource() {
    this.eventSource = new EventSource('financing/subscribe?id=' + this.id);
    this.eventSource.onopen = () => {
      console.log("connection opened")
    }
    this.eventSource.onmessage = (event: any) => {
      if (!event.data.includes('Connected')) {
        this.updateFinancingObject(JSON.parse(event.data));
      }
    }
    this.eventSource.onerror = (event: any) => {
      console.log(event);
      this.eventSource.close();
      this.setupEventSource();
    }
  }

  ngOnDestroy(): void {
    if (this.eventSource) {
      this.httpClient.get('financing/unsub?id=' + this.id).subscribe(() =>
        this.eventSource.close()
      );
    }
  }

  approve(element: FinancingInfo) {
    this.updateFinancing(element, 'APPROVED');
  }

  decline(element: FinancingInfo) {
    this.updateFinancing(element, 'DENIED');
  }

  updateFinancing(element: FinancingInfo, newStatus: string) {
    this.httpClient
    .put<any>('financing/' + element.financingId + '/decide', {decision: newStatus})
    .toPromise()
    .then(
      () => {
        element.status = newStatus;
        this.updateFinancingObject(element);
      }
    );
  }

  updateFinancingObject(updatedObject: FinancingInfo) {
    let index = this.financingInfo.findIndex(item => item.financingId === updatedObject.financingId);
    if (index !== -1) {
      this.financingInfo[index] = updatedObject;
    } else {
      this.financingInfo.push(updatedObject);
    }
    this.dataSource = new MatTableDataSource(this.financingInfo);
    this.dataSource.sort = this.sort;
    this.changeDetection.detectChanges();
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  mapStatusToText(status: string) {
    switch (status) {
      case 'BID_WON':
        return 'Bud vunnet';
      case 'MANUAL_CONTROL':
        return 'Avventer handling';
      case 'APPROVED':
        return 'Godkjent';
      case 'DENIED':
        return 'Avslått';
      default:
        return 'Ukjent status';
    }
  }

  showActions(status: string): boolean {
    return status !== 'APPROVED' && status !== 'DENIED';
  }

}
