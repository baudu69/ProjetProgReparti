import { Component, OnInit } from '@angular/core';
import {ApprenantService} from "../apprenant.service";
import {IApprenant} from "../../shared/metier/Apprenant";
import {ActivatedRoute} from "@angular/router";
import {Router} from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-edit-apprenant',
  templateUrl: './edit-apprenant.component.html',
  styleUrls: ['./edit-apprenant.component.css']
})
export class EditApprenantComponent implements OnInit {
  idApprenant: number;

  apprenant: IApprenant | undefined;

  formEdit = new FormGroup({
    nomUtil: new FormControl<string>('', [Validators.required]),
    surname: new FormControl<string>('', [Validators.required]),
    forename: new FormControl<string>('', [Validators.required])
  });

  constructor(
    private apprenantService: ApprenantService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.idApprenant = this.route.snapshot.params['idApprenant'];
  }

  ngOnInit(): void {
    this.apprenantService.getApprenantById(this.idApprenant).subscribe(
      (data) => {
        if (data.ok && data.body) {
          this.apprenant = data.body;
          this.formEdit.setValue({
            nomUtil: this.apprenant.nomUtil,
            surname: this.apprenant.surname,
            forename: this.apprenant.forename
          });
        }
      });
  }

  onSubmit() {
    if (this.formEdit.valid && this.formEdit.value.nomUtil && this.formEdit.value.surname && this.formEdit.value.forename) {
      this.apprenantService.editApprenant(this.idApprenant, this.formEdit.value.nomUtil, this.formEdit.value.surname, this.formEdit.value.forename)
        .subscribe(
          (data) => {
            if (data.ok) {
              this.router.navigate(['/apprenant'])
            }
          }
        )
    }
  }

}
