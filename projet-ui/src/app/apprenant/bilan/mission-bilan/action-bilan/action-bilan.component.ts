import {Component, Input, OnInit} from '@angular/core';
import {IActionBilan} from "../../../../shared/metier/Bilan";

@Component({
  selector: 'app-action-bilan',
  templateUrl: './action-bilan.component.html',
  styleUrls: ['./action-bilan.component.css']
})
export class ActionBilanComponent implements OnInit {

  @Input()
  actionBilan: IActionBilan | undefined

  actionComplete: string = "A compléter";

  constructor() {
  }

  ngOnInit(): void {
    this.loadActionComplete()
  }

  loadActionComplete(): void {
    if (this.actionBilan)
      if (this.actionBilan?.obtenir.valeurDebut >= this.actionBilan?.action.scoreMinimum)
        this.actionComplete = "Complétée";
  }

}
