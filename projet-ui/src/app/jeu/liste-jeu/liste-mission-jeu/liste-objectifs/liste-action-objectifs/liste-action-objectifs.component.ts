import {Component, OnInit} from '@angular/core';
import {IAction} from "../../../../../shared/metier/Action";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ActionService} from "../../../../../shared/service/action.service";
import {ActivatedRoute} from "@angular/router";
import {ObjectifService} from "../../../../../shared/service/objectif.service";

@Component({
  selector: 'app-liste-action-objectifs',
  templateUrl: './liste-action-objectifs.component.html',
  styleUrls: ['./liste-action-objectifs.component.css']
})
export class ListeActionObjectifsComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name', 'scoreMini', 'listeIndicators', 'supprimer'];

  actions: IAction[] = [];

  idObjectif: number;

  displayForm = false
  formAdd = new FormGroup({
    wording: new FormControl('', [Validators.required]),
    scoreMinimum: new FormControl(0, [Validators.required]),
  })

  constructor(
    private actionService: ActionService,
    private objectifService: ObjectifService,
    private route: ActivatedRoute,
  ) {
    this.idObjectif = Number(this.route.snapshot.paramMap.get('idObjectif'));
  }

  ngOnInit(): void {
    this.loadActions()
  }

  loadActions(): void {
    this.objectifService.getActionsOfObjectif(this.idObjectif).subscribe(
      (data) => {
        if (data.ok && data.body) {
          this.actions = data.body;
        }
      });
  }

  supprimerAction(id: number) {
    this.actionService.deleteAction(id).subscribe(
      (data) => {
        if (data.ok) {
          this.actions = this.actions.filter(action => action.id !== id);
        }
      }
    )
  }

}
