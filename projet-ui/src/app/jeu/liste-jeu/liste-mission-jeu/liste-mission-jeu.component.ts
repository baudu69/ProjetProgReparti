import { Component, OnInit } from '@angular/core';
import {IMission} from "../../../shared/metier/Mission";
import {JeuService} from "../../../shared/service/jeu.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-liste-mission-jeu',
  templateUrl: './liste-mission-jeu.component.html',
  styleUrls: ['./liste-mission-jeu.component.css']
})
export class ListeMissionJeuComponent implements OnInit {
  idJeu: number;
  missions: IMission[] = [];
  displayedColumns: string[] = ['id', 'name', 'gestion'];

  constructor(
    private route: ActivatedRoute,
    private serviceJeu: JeuService
  ) {
    this.idJeu = this.route.snapshot.params['idJeu'];
  }

  ngOnInit(): void {
    this.serviceJeu.getMissionsInJeu(this.idJeu).subscribe(
      (data) => {
        if (data.ok && data.body) {
          this.missions = data.body;
        }
      });
  }

}
