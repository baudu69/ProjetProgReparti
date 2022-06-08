import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {IAction} from "../../../shared/metier/Action";
import {IIndicator} from "../../../shared/metier/Indicator";
import {ActionService} from "../../../shared/service/action.service";
import {HttpResponse} from "@angular/common/http";

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

  constructor(
    private route: ActivatedRoute,
    private serviceAction: ActionService
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

}
