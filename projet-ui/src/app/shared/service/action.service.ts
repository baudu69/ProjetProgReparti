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

  getActionById(id: number): Observable<HttpResponse<IAction>> {
    return this.http.get<IAction>(`/api/action/${id}`, {observe: 'response'});
  }

  addAction(action: IAction): Observable<HttpResponse<any>> {
    return this.http.put<any>('/api/action', action, {observe: 'response'});
  }

  deleteAction(id: number): Observable<HttpResponse<any>> {
    return this.http.delete(`api/action/${id}`, {observe: "response"});
  }
}
