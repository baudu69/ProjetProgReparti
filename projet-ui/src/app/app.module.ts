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
import {ListeActionComponent} from './action/liste-action/liste-action.component';
import {ListeIndicatorsComponent} from './action/liste-action/liste-indicators/liste-indicators.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AccueilComponent,
    ListeApprenantComponent,
    ListeMissionComponent,
    ListeMissionApprenantComponent,
    ListeActionComponent,
    ListeIndicatorsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatTableModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
