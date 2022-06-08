import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {NavbarComponent} from './navbar/navbar.component';
import {AccueilComponent} from './accueil/accueil.component';
import {AppRoutingModule} from "./app-routing.module";
import {ListeApprenantComponent} from './apprenant/liste-apprenant/liste-apprenant.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClientModule} from "@angular/common/http";
import {MatTableModule} from "@angular/material/table";
import {MatButtonModule} from "@angular/material/button";
import {ListeMissionComponent} from './mission/liste-mission/liste-mission.component';
import {ListeMissionApprenantComponent} from './apprenant/liste-mission-apprenant/liste-mission-apprenant.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AccueilComponent,
    ListeApprenantComponent,
    ListeMissionComponent,
    ListeMissionApprenantComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatTableModule,
    MatButtonModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
