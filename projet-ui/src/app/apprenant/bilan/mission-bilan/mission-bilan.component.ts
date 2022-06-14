import {Component, Input, OnInit} from '@angular/core';
import {IMissionBilan} from "../../../shared/metier/Bilan";

@Component({
  selector: 'app-mission-bilan',
  templateUrl: './mission-bilan.component.html',
  styleUrls: ['./mission-bilan.component.css']
})
export class MissionBilanComponent implements OnInit {

  @Input()
  missionBilan: IMissionBilan | undefined

  constructor() {
  }

  ngOnInit(): void {
  }

}
