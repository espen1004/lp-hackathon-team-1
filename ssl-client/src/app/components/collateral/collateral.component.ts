import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";


@Component({
  styleUrls: ['collateral.component.css'],
  templateUrl: './collateral.component.html'
})
export class CollateralComponent implements OnInit {
  realEstateBrokers: string[] = ['OBOS', 'DNB', 'Nordvik'];

  constructor(private router: Router) {
  }

  ngOnInit(): void {
  }

  next() {
    this.router.navigate(['product-adviser']);
  }

  fetchContract() {
  }
}
