import {Component, OnInit} from '@angular/core';
import {IBilan} from "../../shared/metier/Bilan";
import {ApprenantService} from "../apprenant.service";
import {ActivatedRoute} from "@angular/router";
import {HttpResponse} from "@angular/common/http";

@Component({
  selector: 'app-bilan',
  templateUrl: './bilan.component.html',
  styleUrls: ['./bilan.component.css']
})
export class BilanComponent implements OnInit {

  bilan: IBilan | undefined;
  idApprenant: number;

  constructor(private apprenantService: ApprenantService, private route: ActivatedRoute,) {
    this.idApprenant = Number(this.route.snapshot.paramMap.get('idApprenant'));
  }

  ngOnInit(): void {
    this.loadBilan();
  }

  loadBilan(): void {
    this.apprenantService.getBilan(this.idApprenant).subscribe(
      (response: HttpResponse<IBilan>) => {
        if (response.ok && response.body) {
          this.bilan = response.body;
        }
      })
  }

}
