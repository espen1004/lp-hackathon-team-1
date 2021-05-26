import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {YourLoanApplicationsComponent} from "./components/your-loan-applications/your-loan-applications-component";
import {MaterialModule} from "./material.module";
import {AppRoutingModule} from "./app-routing.module";
import {BrowserAnimationsModule, NoopAnimationsModule} from "@angular/platform-browser/animations";
import {HttpClientModule} from "@angular/common/http";
import {CollateralComponent} from "./components/collateral/collateral.component";
import {ProductAdviserComponent} from "./components/product-adviser/product-adviser.component";

@NgModule({
  declarations: [
    AppComponent,
    YourLoanApplicationsComponent,
    CollateralComponent,
    ProductAdviserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MaterialModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
