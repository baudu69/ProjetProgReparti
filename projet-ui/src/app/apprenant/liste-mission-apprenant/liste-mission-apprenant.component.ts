import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {IInscription} from "../../shared/metier/Inscription";
import {InscriptionService} from "../../shared/service/inscription.service";
import {IApprenant} from "../../shared/metier/Apprenant";
import {ApprenantService} from "../apprenant.service";

@Component({
  selector: 'app-liste-mission-apprenant',
  templateUrl: './liste-mission-apprenant.component.html',
  styleUrls: ['./liste-mission-apprenant.component.css']
})
export class ListeMissionApprenantComponent implements OnInit {
  idApprenant: number;
  inscriptions: IInscription[] = []
  userInfo: IApprenant | undefined;
  displayedColumns: string[] = ['nom', 'date'];

  constructor(private route: ActivatedRoute, private inscriptionService: InscriptionService, private apprenantService: ApprenantService) {
    this.idApprenant = Number(this.route.snapshot.paramMap.get('idApprenant'));
  }

  ngOnInit(): void {
    this.inscriptionService.getInscriptionsByUserID(this.idApprenant).subscribe(
      (data) => {
        if (data.ok && data.body) {
          this.inscriptions = data.body;
        }
      });

    this.apprenantService.getApprenantById(this.idApprenant).subscribe(
      (data) => {
        if (data.ok && data.body) {
          this.userInfo = data.body;
        }
      });
  }

}
