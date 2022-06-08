import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AccueilComponent} from "./accueil/accueil.component";
import {ListeApprenantComponent} from "./apprenant/liste-apprenant/liste-apprenant.component";
import {ListeMissionComponent} from "./mission/liste-mission/liste-mission.component";
import {ListeMissionApprenantComponent} from "./apprenant/liste-mission-apprenant/liste-mission-apprenant.component";

const routes: Routes = [
  {path: '', component: AccueilComponent},
  {path: 'apprenant', component: ListeApprenantComponent},
  {path: 'mission', component: ListeMissionComponent},
  {path: 'apprenant/mission/:idApprenant', component: ListeMissionApprenantComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
