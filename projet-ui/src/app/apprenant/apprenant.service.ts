import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {IApprenant} from "../shared/metier/Apprenant";
import {IAction} from "../shared/metier/Action";
import {IBilan} from "../shared/metier/Bilan";

@Injectable({
  providedIn: 'root'
})
export class ApprenantService {

  constructor(private http: HttpClient) {
  }

  getAllApprenants(): Observable<HttpResponse<IApprenant[]>> {
    return this.http.get<IApprenant[]>('api/apprenant', {observe: "response"});
  }

  getApprenantById(id: number): Observable<HttpResponse<IApprenant>> {
    return this.http.get<IApprenant>(`api/apprenant/${id}`, {observe: "response"});
  }

  deleteApprenant(id: number): Observable<HttpResponse<any>> {
    return this.http.delete(`api/apprenant/${id}`, {observe: "response"});
  }

  enregistrerAction(apprenant: IApprenant, action: IAction, scoreTotal: number, retourMoniteur: string): Observable<HttpResponse<any>> {
    return this.http.post('api/apprenant/score', {
      idApprenant: apprenant.id,
      idAction: action.id,
      score: scoreTotal,
      retourMoniteur: retourMoniteur
    }, {observe: "response"});
  }

  getBilan(idApprenant: number): Observable<HttpResponse<IBilan>> {
    return this.http.get<IBilan>(`api/apprenant/bilan/${idApprenant}`, {observe: "response"});
  }
}
