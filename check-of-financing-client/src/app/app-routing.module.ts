import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CheckOfFinanceComponent} from "./components/check-of-finance.component";

const ROUTES: Routes = [
  {path: '', component: CheckOfFinanceComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(ROUTES, {
      useHash: true
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
