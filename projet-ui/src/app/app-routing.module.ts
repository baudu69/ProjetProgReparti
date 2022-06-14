import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AccueilComponent} from "./accueil/accueil.component";
import {ListeApprenantComponent} from "./apprenant/liste-apprenant/liste-apprenant.component";
import {ListeMissionComponent} from "./mission/liste-mission/liste-mission.component";
import {ListeMissionApprenantComponent} from "./apprenant/liste-mission-apprenant/liste-mission-apprenant.component";
import {ListeActionComponent} from "./action/liste-action/liste-action.component";
import {ListeIndicatorsComponent} from "./action/liste-action/liste-indicators/liste-indicators.component";
import {ListeActionMissionComponent} from "./mission/liste-mission/liste-action-mission/liste-action-mission.component";
import {EnregistrerActionComponent} from "./action/enregistrer-action/enregistrer-action.component";
import {BilanComponent} from "./apprenant/bilan/bilan.component";

const routes: Routes = [
  {path: '', component: AccueilComponent},
  {path: 'apprenant', component: ListeApprenantComponent},
  {path: 'mission', component: ListeMissionComponent},
  {path: 'mission/action/:idMission', component: ListeActionMissionComponent},
  {path: 'apprenant/mission/:idApprenant', component: ListeMissionApprenantComponent},
  {path: 'apprenant/bilan/:idApprenant', component: BilanComponent},
  {path: 'action', component: ListeActionComponent},
  {path: 'action/indicators/:idIndicator', component: ListeIndicatorsComponent},
  {path: 'enregistrerAction', component: EnregistrerActionComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
