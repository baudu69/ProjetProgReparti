import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {IAction} from "../../../shared/metier/Action";
import {IIndicator} from "../../../shared/metier/Indicator";
import {ActionService} from "../../../shared/service/action.service";
import {HttpResponse} from "@angular/common/http";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {IndicatorService} from "../../../shared/service/indicator.service";

@Component({
  selector: 'app-liste-indicators',
  templateUrl: './liste-indicators.component.html',
  styleUrls: ['./liste-indicators.component.css']
})
export class ListeIndicatorsComponent implements OnInit {
  displayedColumns: string[] = ['id', 'name', 'scoreCorrect', 'scoreIncorrect'];
  idAction: number
  action: IAction | undefined
  indicators: IIndicator[] = []

  displayAddForm = false
  formAdd = new FormGroup({
    wording: new FormControl('', [Validators.required]),
    valueIfCheck: new FormControl(0, [Validators.required]),
    valueIfUnCheck: new FormControl(0, [Validators.required])
  })

  constructor(
    private route: ActivatedRoute,
    private serviceAction: ActionService,
    private serviceIndicator: IndicatorService,
  ) {
    this.idAction = Number(this.route.snapshot.paramMap.get('idIndicator'));
  }

  ngOnInit(): void {
    this.loadAction();
  }

  loadAction() {
    this.serviceAction.getActionById(this.idAction).subscribe(
      (data: HttpResponse<IAction>) => {
        if (data.ok && data.body) {
          this.action = data.body;
          this.indicators = this.action.indicator;
        }
      });
  }

  diplayForm(): void {
    this.displayAddForm = !this.displayAddForm
  }

  onSubmit() {
    console.log(this.formAdd.value)
    const wording = this.formAdd.value.wording || ''
    const valueIfCheck = this.formAdd.value.valueIfCheck || 0
    const valueIfUnCheck = this.formAdd.value.valueIfUnCheck || 0
    const indicator: IIndicator = {
      id: 0,
      idAction: this.idAction,
      wording: wording,
      valueIfCheck: valueIfCheck,
      valueIfUnCheck: valueIfUnCheck,
    }
    this.serviceIndicator.addIndicator(indicator).subscribe(
      (data: HttpResponse<any>) => {
        if (data.ok) {
          this.loadAction()
          this.formAdd.reset()
          this.diplayForm()
        }
      });

  }

}
