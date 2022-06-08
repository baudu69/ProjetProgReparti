import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {IInscription} from "../metier/Inscription";

@Injectable({
  providedIn: 'root'
})
export class InscriptionService {

  constructor(private http: HttpClient) {
  }

  getInscriptionsByUserID(idUser: number): Observable<HttpResponse<IInscription[]>> {
    return this.http.get<IInscription[]>(`api/mission/user/${idUser}`, {observe: 'response'});
  }
}
