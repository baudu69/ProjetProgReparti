import {Component, OnInit} from '@angular/core';
import {ApprenantService} from "../apprenant.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {IApprenant} from "../../shared/metier/Apprenant";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-apprenant',
  templateUrl: './add-apprenant.component.html',
  styleUrls: ['./add-apprenant.component.css']
})
export class AddApprenantComponent implements OnInit {

  formApprenant: FormGroup = new FormGroup({
    nomUtil: new FormControl<string>('', [Validators.required]),
    motPasse: new FormControl<string>('', [Validators.required]),
    surname: new FormControl<string>('', [Validators.required]),
    forename: new FormControl<string>('', [Validators.required])
  })

  constructor(private apprenantService: ApprenantService, private snackBar: MatSnackBar, private route: Router) {
  }

  ngOnInit(): void {

  }

  submit() {
    const apprennant: IApprenant = {
      id: 0,
      nomUtil: this.formApprenant.get('nomUtil')?.value,
      motPasse: this.formApprenant.get('motPasse')?.value,
      forename: this.formApprenant.get('forename')?.value,
      surname: this.formApprenant.get('surname')?.value
    }

    this.apprenantService.addApprenant(apprennant).subscribe(
      (data) => {
        if (data.ok) {
          this.snackBar.open('Apprenant ajouté avec succès', '', {duration: 2000});
          this.route.navigate(['/apprenant']);
        }
      })
  }

}
