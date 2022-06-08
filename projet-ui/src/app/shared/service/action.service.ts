import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {IAction} from "../metier/Action";

@Injectable({
  providedIn: 'root'
})
export class ActionService {

  constructor(private http: HttpClient) {
  }

  getAllActions(): Observable<HttpResponse<IAction[]>> {
    return this.http.get<IAction[]>('/api/action', {observe: 'response'});
  }
}