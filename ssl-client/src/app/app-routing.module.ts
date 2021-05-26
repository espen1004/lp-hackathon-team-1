import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {YourLoanApplicationsComponent} from "./components/your-loan-applications/your-loan-applications-component";
import {CollateralComponent} from "./components/collateral/collateral.component";
import {ProductAdviserComponent} from "./components/product-adviser/product-adviser.component";

const ROUTES: Routes = [
  {path: '', component: YourLoanApplicationsComponent},
  {path: 'collateral', component: CollateralComponent},
  {path: 'product-adviser', component: ProductAdviserComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(ROUTES, {
      useHash: true
    })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
