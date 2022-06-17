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
import {ListeMissionApprenantComponent} from './apprenant/liste-mission-apprenant/liste-mission-apprenant.component';
import {ListeActionComponent} from './action/liste-action/liste-action.component';
import {ListeIndicatorsComponent} from './action/liste-action/liste-indicators/liste-indicators.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {DragDropModule} from "@angular/cdk/drag-drop";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {ListeJeuComponent} from './jeu/liste-jeu/liste-jeu.component';
import {ListeMissionJeuComponent} from './jeu/liste-jeu/liste-mission-jeu/liste-mission-jeu.component';
import {EnregistrerActionComponent} from './action/enregistrer-action/enregistrer-action.component';
import {MatSelectModule} from "@angular/material/select";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {BilanComponent} from './apprenant/bilan/bilan.component';
import {MissionBilanComponent} from './apprenant/bilan/mission-bilan/mission-bilan.component';
import {ActionBilanComponent} from './apprenant/bilan/mission-bilan/action-bilan/action-bilan.component';
import {MatCardModule} from "@angular/material/card";
import {MatExpansionModule} from "@angular/material/expansion";
import {SearchApprenantComponent} from './apprenant/search-apprenant/search-apprenant.component';
import {EditApprenantComponent} from './apprenant/edit-apprenant/edit-apprenant.component';
import {InscriptionApprenantComponent} from './jeu/inscription-apprenant/inscription-apprenant.component';
import {ListeObjectifsComponent} from './jeu/liste-jeu/liste-mission-jeu/liste-objectifs/liste-objectifs.component';
import {
  ListeActionObjectifsComponent
} from './jeu/liste-jeu/liste-mission-jeu/liste-objectifs/liste-action-objectifs/liste-action-objectifs.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AccueilComponent,
    ListeApprenantComponent,
    ListeMissionApprenantComponent,
    ListeActionComponent,
    ListeIndicatorsComponent,
    EnregistrerActionComponent,
    BilanComponent,
    MissionBilanComponent,
    ActionBilanComponent,
    ListeJeuComponent,
    ListeMissionJeuComponent,
    EnregistrerActionComponent,
    SearchApprenantComponent,
    EditApprenantComponent,
    InscriptionApprenantComponent,
    ListeObjectifsComponent,
    ListeActionObjectifsComponent,
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
    DragDropModule,
    MatSnackBarModule,
    MatSelectModule,
    MatCheckboxModule,
    FormsModule,
    MatCardModule,
    MatExpansionModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
