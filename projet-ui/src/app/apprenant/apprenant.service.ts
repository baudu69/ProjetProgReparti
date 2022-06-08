import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {IApprenant} from "../shared/metier/Apprenant";

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
}
