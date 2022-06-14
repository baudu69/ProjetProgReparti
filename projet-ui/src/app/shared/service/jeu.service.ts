import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {IJeu} from "../metier/Jeu";
import {IMission} from "../metier/Mission";

@Injectable({
  providedIn: 'root'
})
export class JeuService {

  constructor(private http: HttpClient) {
  }

  getAllJeux(): Observable<HttpResponse<IJeu[]>> {
    return this.http.get<IJeu[]>('api/jeu', {observe: "response"});
  }

  getJeuById(id: number): Observable<HttpResponse<IJeu>> {
    return this.http.get<IJeu>(`api/jeu/${id}`, {observe: "response"});
  }

  public getMissionsInJeu(id: number): Observable<HttpResponse<IMission[]>> {
    return this.http.get<IMission[]>(`api/jeu/mission/${id}`, {observe: 'response'});
  }
}
