import {Component, OnInit} from '@angular/core';
import {IAction} from "../../shared/metier/Action";
import {ActionService} from "../../shared/service/action.service";

@Component({
  selector: 'app-liste-action',
  templateUrl: './liste-action.component.html',
  styleUrls: ['./liste-action.component.css']
})
export class ListeActionComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name', 'scoreMini', 'listeIndicators'];

  actions: IAction[] = [];

  constructor(private actionService: ActionService) {
  }

  ngOnInit(): void {
    this.loadActions()
  }

  loadActions(): void {
    this.actionService.getAllActions().subscribe(
      (data) => {
        if (data.ok && data.body) {
          this.actions = data.body;
        }
      });
  }
}


