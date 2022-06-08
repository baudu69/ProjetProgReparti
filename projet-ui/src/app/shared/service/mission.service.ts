import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {IMission} from "../metier/Mission";
import {IAction} from "../metier/Action";

@Injectable({
  providedIn: 'root'
})
export class MissionService {

  constructor(private http: HttpClient) {
  }

  public getAllMissions(): Observable<HttpResponse<IMission[]>> {
    return this.http.get<IMission[]>('api/mission', {observe: 'response'});
  }

  public getMissionById(id: number): Observable<HttpResponse<IMission>> {
    return this.http.get<IMission>(`api/mission/${id}`, {observe: 'response'});
  }

  public getActionsInMission(id: number): Observable<HttpResponse<IAction[]>> {
    return this.http.get<IAction[]>(`api/mission/action/${id}`, {observe: 'response'});
  }

  public getActionsNotInMission(id: number): Observable<HttpResponse<IAction[]>> {
    return this.http.get<IAction[]>(`api/mission/action/${id}/not`, {observe: 'response'});
  }
}
