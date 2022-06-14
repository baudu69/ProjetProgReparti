import {Component, OnInit} from '@angular/core';
import {JeuService} from "../../shared/service/jeu.service";
import {IJeu} from "../../shared/metier/Jeu";

@Component({
  selector: 'app-liste-jeu',
  templateUrl: './liste-jeu.component.html',
  styleUrls: ['./liste-jeu.component.css']
})
export class ListeJeuComponent implements OnInit {

  jeux: IJeu[] = [];
  displayedColumns: string[] = ['id', 'libelle', 'listeMissions'];

  constructor(private serviceJeu: JeuService) { }

  ngOnInit(): void {
    this.serviceJeu.getAllJeux().subscribe(
      (data) => {
        if (data.ok && data.body) {
          this.jeux = data.body;
        }
      });
  }

}
