import {Component, OnInit} from '@angular/core';
import {IApprenant} from "../../shared/metier/Apprenant";
import {ApprenantService} from "../../apprenant/apprenant.service";
import {HttpErrorResponse, HttpResponse} from "@angular/common/http";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {IJeu} from "../../shared/metier/Jeu";
import {InscriptionService} from "../../shared/service/inscription.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-inscription-apprenant',
  templateUrl: './inscription-apprenant.component.html',
  styleUrls: ['./inscription-apprenant.component.css']
})
export class InscriptionApprenantComponent implements OnInit {
  apprenants: IApprenant[] = []
  jeux: IJeu[] = []

  formGroup: FormGroup = new FormGroup({
    apprenant: new FormControl<IApprenant | null>(null, [Validators.required]),
    jeu: new FormControl<IJeu | null>(null, [Validators.required, Validators.nullValidator]),
  });

  constructor(
    private apprenantService: ApprenantService,
    private inscriptionService: InscriptionService,
    private _snackBar: MatSnackBar,
  ) {
  }

  ngOnInit(): void {
    this.loadListeApprenant();
  }

  loadListeApprenant() {
    this.apprenantService.getAllApprenants().subscribe(
      (response: HttpResponse<IApprenant[]>) => {
        if (response.ok && response.body) {
          this.apprenants = response.body;
        }
      });
  }

  loadJeux() {
    this.jeux = [];
    const apprenant: IApprenant = this.formGroup.get('apprenant')?.value;
    this.inscriptionService.getJeuxNonInscrit(apprenant.id).subscribe(
      (response: HttpResponse<IJeu[]>) => {
        if (response.ok && response.body) {
          this.jeux = response.body;
        }
      });
  }

  inscription() {
    const apprenant: IApprenant = this.formGroup.get('apprenant')?.value;
    const jeu: IJeu = this.formGroup.get('jeu')?.value;
    this.inscriptionService.inscrire(apprenant.id, jeu.id).subscribe(
      {
        next: (response: HttpResponse<any>) => {
          if (response.ok) {
            this._snackBar.open("Inscription effectuée", "Fermer")
          }
        },
        error: (error: HttpErrorResponse) => {
          if (error.status === 409) {
            this._snackBar.open("Inscription déjà effectuée", "Fermer")
          } else
            this._snackBar.open("Erreur lors de l'inscription", "Fermer")
        }
      });

  }

}
