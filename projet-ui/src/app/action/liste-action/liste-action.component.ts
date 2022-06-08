import {Component, OnInit} from '@angular/core';
import {IAction} from "../../shared/metier/Action";
import {ActionService} from "../../shared/service/action.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-liste-action',
  templateUrl: './liste-action.component.html',
  styleUrls: ['./liste-action.component.css']
})
export class ListeActionComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name', 'scoreMini', 'listeIndicators'];

  actions: IAction[] = [];

  displayForm = false
  formAdd = new FormGroup({
    wording: new FormControl('', [Validators.required]),
    scoreMinimum: new FormControl(0, [Validators.required]),
  })

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

  diplayForm() {
    this.displayForm = !this.displayForm
  }

  onSubmit() {
    console.log(this.formAdd.value)
    const wording = this.formAdd.value.wording || ''
    const scoreMinimum = this.formAdd.value.scoreMinimum || 0
    const action: IAction = {
      id: 0,
      wording: wording,
      scoreMinimum: scoreMinimum,
      indicator: [],
    }
    this.actionService.addAction(action).subscribe(
      (data) => {
        if (data.ok) {
          this.formAdd.reset()
          this.diplayForm()
          this.loadActions()
        }
      });
  }
}


