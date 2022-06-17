import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {IObjectif} from "../metier/IObjectif";
import {IAction} from "../metier/Action";

@Injectable({
  providedIn: 'root'
})
export class ObjectifService {

  constructor(private http: HttpClient) {
  }

  public getObjectifsOfMission(idMission: number): Observable<HttpResponse<IObjectif[]>> {
    return this.http.get<IObjectif[]>('/api/objectif/mission/' + idMission, {observe: 'response'});
  }

  public getActionsOfObjectif(idObjectif: number): Observable<HttpResponse<IAction[]>> {
    return this.http.get<IAction[]>('/api/objectif/' + idObjectif + '/action', {observe: 'response'});
  }


}
