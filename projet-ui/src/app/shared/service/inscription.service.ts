import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {IInscription} from "../metier/Inscription";
import {IMission} from "../metier/Mission";

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

  inscrire(idUser: number, idMission: number): Observable<HttpResponse<boolean>> {
    return this.http.get<boolean>(`api/mission/inscription/${idUser}/${idMission}`, {observe: 'response'});
  }
}
