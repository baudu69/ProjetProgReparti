import {Component, OnInit} from '@angular/core';
import {MissionService} from "../mission.service";
import {IMission} from "../../shared/metier/Mission";

@Component({
  selector: 'app-liste-mission',
  templateUrl: './liste-mission.component.html',
  styleUrls: ['./liste-mission.component.css']
})
export class ListeMissionComponent implements OnInit {
  missions: IMission[] = [];
  displayedColumns: string[] = ['id', 'name'];

  constructor(private serviceMission: MissionService) {
  }

  ngOnInit(): void {
    this.serviceMission.getAllMissions().subscribe(
      (data) => {
        if (data.ok && data.body) {
          this.missions = data.body;
        }
      });
  }

}
