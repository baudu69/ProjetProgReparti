import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {IInscription} from "../../shared/metier/Inscription";
import {InscriptionService} from "../../shared/service/inscription.service";
import {IApprenant} from "../../shared/metier/Apprenant";
import {ApprenantService} from "../apprenant.service";
import {IMission} from "../../shared/metier/Mission";

@Component({
  selector: 'app-liste-mission-apprenant',
  templateUrl: './liste-mission-apprenant.component.html',
  styleUrls: ['./liste-mission-apprenant.component.css']
})
export class ListeMissionApprenantComponent implements OnInit {
  idApprenant: number;
  inscriptions: IInscription[] = []
  missionsDisponibles: IMission[] = [];
  userInfo: IApprenant | undefined;
  displayedColumns: string[] = ['nom', 'date'];
  displayedColumns2: string[] = ['nom', 'btn'];

  constructor(
    private route: ActivatedRoute,
    private inscriptionService: InscriptionService,
    private apprenantService: ApprenantService) {
    this.idApprenant = Number(this.route.snapshot.paramMap.get('idApprenant'));
  }

  ngOnInit(): void {
    this.loadInscriptions()
    this.loadMissionsDisponibles()
    this.getApprenantInfo()
  }

  private loadMissionsDisponibles(): void {
    this.inscriptionService.getMissionsUserNotInscrit(this.idApprenant).subscribe(
      (data) => {
        if (data.ok && data.body) {
          this.missionsDisponibles = data.body;
        }
      });
  }

  private getApprenantInfo(): void {
    this.apprenantService.getApprenantById(this.idApprenant).subscribe(
      (data) => {
        if (data.ok && data.body) {
          this.userInfo = data.body;
        }
      });
  }

  private loadInscriptions(): void {
    this.inscriptionService.getInscriptionsByUserID(this.idApprenant).subscribe(
      (data) => {
        if (data.ok && data.body) {
          this.inscriptions = data.body;
        }
      });
  }

}
