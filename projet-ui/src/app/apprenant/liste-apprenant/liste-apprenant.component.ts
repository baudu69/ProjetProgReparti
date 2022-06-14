import {Component, OnInit} from '@angular/core';
import {ApprenantService} from "../apprenant.service";
import {IApprenant} from "../../shared/metier/Apprenant";

@Component({
  selector: 'app-liste-apprenant',
  templateUrl: './liste-apprenant.component.html',
  styleUrls: ['./liste-apprenant.component.css']
})
export class ListeApprenantComponent implements OnInit {

  apprenants: IApprenant[] = [];
  displayedColumns: string[] = ['id', 'nom', 'prenom', 'missions', 'bilan', 'modifier', 'supprimer'];

  constructor(private serviceApprenant: ApprenantService) {
  }

  ngOnInit(): void {
    this.serviceApprenant.getAllApprenants().subscribe(
      (data) => {
        if (data.ok && data.body) {
          this.apprenants = data.body;
        }
      });
  }

  supprimerApprenant(id: number) {
    this.serviceApprenant.deleteApprenant(id).subscribe(
      (data) => {
        if (data.ok) {
          this.apprenants = this.apprenants.filter(apprenant => apprenant.id !== id);
        }
      }
    )
  }

}
