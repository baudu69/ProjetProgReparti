import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AccueilComponent} from "./accueil/accueil.component";
import {ListeApprenantComponent} from "./apprenant/liste-apprenant/liste-apprenant.component";

const routes: Routes = [
  {path: '', component: AccueilComponent},
  {path: 'apprenant', component: ListeApprenantComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
