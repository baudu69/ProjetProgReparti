import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ObjectifService} from "../../../../shared/service/objectif.service";
import {IObjectif} from "../../../../shared/metier/IObjectif";
import {HttpResponse} from "@angular/common/http";

@Component({
  selector: 'app-liste-objectifs',
  templateUrl: './liste-objectifs.component.html',
  styleUrls: ['./liste-objectifs.component.css']
})
export class ListeObjectifsComponent implements OnInit {

  idMission: number;
  objectifs: IObjectif[] = [];

  displayedColumns: string[] = ['id', 'libelle', 'actions'];


  constructor(
    private route: ActivatedRoute,
    private objectifService: ObjectifService
  ) {
    this.idMission = Number(this.route.snapshot.paramMap.get('idMission'));
  }

  ngOnInit(): void {
    this.loadObjectifs()
  }

  loadObjectifs() {
    this.objectifService.getObjectifsOfMission(this.idMission).subscribe(
      (res: HttpResponse<IObjectif[]>) => {
        if (res.ok && res.body) {
          this.objectifs = res.body;
        }
      });
  }

}
