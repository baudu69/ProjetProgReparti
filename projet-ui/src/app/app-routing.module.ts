import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AccueilComponent} from "./accueil/accueil.component";
import {ListeApprenantComponent} from "./apprenant/liste-apprenant/liste-apprenant.component";
import {ListeMissionApprenantComponent} from "./apprenant/liste-mission-apprenant/liste-mission-apprenant.component";
import {ListeActionComponent} from "./action/liste-action/liste-action.component";
import {ListeIndicatorsComponent} from "./action/liste-action/liste-indicators/liste-indicators.component";
import {ListeJeuComponent} from "./jeu/liste-jeu/liste-jeu.component";
import {ListeMissionJeuComponent} from "./jeu/liste-jeu/liste-mission-jeu/liste-mission-jeu.component";
import {EnregistrerActionComponent} from "./action/enregistrer-action/enregistrer-action.component";
import {BilanComponent} from "./apprenant/bilan/bilan.component";
import {SearchApprenantComponent} from "./apprenant/search-apprenant/search-apprenant.component";
import {EditApprenantComponent} from "./apprenant/edit-apprenant/edit-apprenant.component";
import {InscriptionApprenantComponent} from "./jeu/inscription-apprenant/inscription-apprenant.component";
import {ListeObjectifsComponent} from "./jeu/liste-jeu/liste-mission-jeu/liste-objectifs/liste-objectifs.component";
import {
  ListeActionObjectifsComponent
} from "./jeu/liste-jeu/liste-mission-jeu/liste-objectifs/liste-action-objectifs/liste-action-objectifs.component";

const routes: Routes = [
  {path: '', component: AccueilComponent},
  {path: 'apprenant', component: ListeApprenantComponent},
  {path: 'apprenant/mission/:idApprenant', component: ListeMissionApprenantComponent},
  {path: 'apprenant/bilan/:idApprenant', component: BilanComponent},
  {path: 'apprenant/search/:str', component: SearchApprenantComponent},
  {path: 'apprenant/search', component: SearchApprenantComponent},
  {path: 'apprenant/edit/:idApprenant', component: EditApprenantComponent},
  {path: 'action', component: ListeActionComponent},
  {path: 'action/indicators/:idIndicator', component: ListeIndicatorsComponent},
  {path: 'jeu', component: ListeJeuComponent},
  {path: 'jeu/inscription', component: InscriptionApprenantComponent},
  {path: 'jeu/missions/:idJeu', component: ListeMissionJeuComponent},
  {path: 'enregistrerAction', component: EnregistrerActionComponent},
  {path: 'jeu/missions/:idMission/objectifs/mission', component: ListeObjectifsComponent},
  {path: 'objectif/:idObjectif/action', component: ListeActionObjectifsComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
