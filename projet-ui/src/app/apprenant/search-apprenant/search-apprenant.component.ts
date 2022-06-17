import {Component, OnInit} from '@angular/core';
import {IApprenant} from "../../shared/metier/Apprenant";
import {ApprenantService} from "../apprenant.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-search-apprenant',
  templateUrl: './search-apprenant.component.html',
  styleUrls: ['./search-apprenant.component.css']
})
export class SearchApprenantComponent implements OnInit {

  apprenants: IApprenant[] | undefined;
  str: string | null;

  constructor(
    private apprenantService: ApprenantService,
    private route: ActivatedRoute
  ) {
    this.str = this.route.snapshot.paramMap.get('str');
  }

  ngOnInit(): void {
    this.loadSearchApprenant();
  }

  loadSearchApprenant() {
    if (this.str === null) {
      this.str = ""
    }
    this.apprenantService.searchApprenant(this.str).subscribe(
      (data) => {
        if (data.ok && data.body) {
          this.apprenants = data.body;
        }
      })
  }


}
