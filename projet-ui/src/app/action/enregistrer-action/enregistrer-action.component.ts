import {Component, OnInit} from '@angular/core';
import {IApprenant} from "../../shared/metier/Apprenant";
import {IAction} from "../../shared/metier/Action";
import {IIndicator} from "../../shared/metier/Indicator";
import {ApprenantService} from "../../apprenant/apprenant.service";
import {ActionService} from "../../shared/service/action.service";
import {HttpResponse} from "@angular/common/http";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MatCheckboxChange} from "@angular/material/checkbox";
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-enregistrer-action',
  templateUrl: './enregistrer-action.component.html',
  styleUrls: ['./enregistrer-action.component.css']
})
export class EnregistrerActionComponent implements OnInit {

  apprenants: IApprenant[] = []
  actions: IAction[] = []
  actionChoisie: IAction | undefined
  indicators: IIndicator[] = []
  scoreTotal: number = 0

  frmChoix = new FormGroup({
    apprenant: new FormControl<IApprenant | null>(null, [Validators.required]),
    action: new FormControl<IAction | null>(null, [Validators.required]),
    retourMoniteur: new FormControl<string>('', [Validators.required]),
  });

  constructor(
    private apprenantService: ApprenantService,
    private actionService: ActionService,
    private _snackBar: MatSnackBar
  ) {
  }

  ngOnInit(): void {
    this.loadApprenants()
    this.loadActions()
  }

  loadApprenants() {
    this.apprenantService.getAllApprenants().subscribe(
      (response: HttpResponse<IApprenant[]>) => {
        if (response.ok && response.body) {
          this.apprenants = response.body
        }
      }
    )
  }

  loadActions() {
    this.actionService.getAllActions().subscribe(
      (response: HttpResponse<IAction[]>) => {
        if (response.ok && response.body) {
          this.actions = response.body
        }
      }
    )
  }

  tryLoadIndicators() {
    if (this.frmChoix.value.apprenant && this.frmChoix.value.action) {
      this.actionChoisie = this.frmChoix.value.action
      this.indicators = this.actionChoisie.indicator
      this.scoreTotal = 0
    }
  }

  clickIndicator(indicator: MatCheckboxChange, iIndicator: IIndicator) {
    if (indicator.checked) {
      this.scoreTotal += iIndicator.valueIfCheck
      this.scoreTotal -= iIndicator.valueIfUnCheck
    } else {
      this.scoreTotal -= iIndicator.valueIfCheck
      this.scoreTotal += iIndicator.valueIfUnCheck
    }
  }

  submit() {
    if (this.frmChoix.valid && this.frmChoix.value.apprenant && this.frmChoix.value.action && this.frmChoix.value.retourMoniteur) {
      this.apprenantService.enregistrerAction(this.frmChoix.value.apprenant, this.frmChoix.value.action, this.scoreTotal, this.frmChoix.value.retourMoniteur).subscribe(
        (response: HttpResponse<any>) => {
          if (response.ok) {
            this._snackBar.open("Enregistrement effectué", "Ok")
          }
        }
      )
    }

  }
}
