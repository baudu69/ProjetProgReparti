import {Component, OnInit} from '@angular/core';
import {IAction} from "../../../shared/metier/Action";
import {CdkDragDrop, moveItemInArray, transferArrayItem} from "@angular/cdk/drag-drop";
import {MissionService} from "../../../shared/service/mission.service";
import {ActivatedRoute} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-liste-action-mission',
  templateUrl: './liste-action-mission.component.html',
  styleUrls: ['./liste-action-mission.component.css']
})
export class ListeActionMissionComponent implements OnInit {
  idMission: number;

  actionsInMission: IAction[] = []
  actionsNotInMission: IAction[] = []

  constructor(
    private route: ActivatedRoute,
    private missionService: MissionService,
    private _snackBar: MatSnackBar
  ) {
    this.idMission = this.route.snapshot.params['idMission'];
  }

  ngOnInit(): void {
    this.loadActions()
  }

  loadActions() {
    this.loadActionsInMisson()
    this.loadActionsNotInMisson()
  }

  loadActionsInMisson(): void {
    this.missionService.getActionsInMission(this.idMission).subscribe(
      (data) => {
        if (data.ok && data.body) {
          this.actionsInMission = data.body;
        }
      }
    )
  }

  loadActionsNotInMisson(): void {
    this.missionService.getActionsNotInMission(this.idMission).subscribe(
      (data) => {
        if (data.ok && data.body) {
          this.actionsNotInMission = data.body;
        }
      }
    )
  }

  drop(event: CdkDragDrop<IAction[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      if (event.previousContainer.id === 'actionsInMission') {
        transferArrayItem(
          event.previousContainer.data,
          event.container.data,
          event.previousIndex,
          event.currentIndex,
        );
      } else {
        this._snackBar.open("Impossible d'enlever une action", "Ok", {duration: 2000})
      }
    }
  }

}