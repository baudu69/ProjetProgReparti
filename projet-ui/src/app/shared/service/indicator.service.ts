import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {IIndicator} from "../metier/Indicator";

@Injectable({
  providedIn: 'root'
})
export class IndicatorService {

  constructor(private http: HttpClient) {
  }

  public getIndicatorsOfAnAction(actionId: number): Observable<HttpResponse<IIndicator[]>> {
    return this.http.get<IIndicator[]>('api/action/indicator' + actionId, {observe: 'response'});
  }

  public addIndicator(indicator: IIndicator): Observable<HttpResponse<any>> {
    return this.http.put<any>('api/action/indicator', indicator, {observe: 'response'});
  }
}
