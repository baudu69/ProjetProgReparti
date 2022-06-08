import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {IMission} from "../shared/metier/Mission";

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
}
