import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {IInscription} from "../metier/Inscription";
import {IMission} from "../metier/Mission";
import {IJeu} from "../metier/Jeu";

@Injectable({
  providedIn: 'root'
})
export class InscriptionService {

  constructor(private http: HttpClient) {
  }

  getInscriptionsByUserID(idUser: number): Observable<HttpResponse<IInscription[]>> {
    return this.http.get<IInscription[]>(`api/mission/user/${idUser}`, {observe: 'response'});
  }

  getMissionsUserNotInscrit(idUser: number): Observable<HttpResponse<IMission[]>> {
    return this.http.get<IMission[]>(`api/mission/user/noninscrit/${idUser}`, {observe: 'response'});
  }

  inscrire(idUser: number, idJeu: number): Observable<HttpResponse<any>> {
    return this.http.get<boolean>(`api/jeu/${idJeu}/inscription/${idUser}`, {observe: 'response'});
  }

  getJeuxNonInscrit(idUser: number): Observable<HttpResponse<IJeu[]>> {
    return this.http.get<IJeu[]>(`api/jeu/jeuNonInscrit/${idUser}`, {observe: 'response'});
  }
}
