import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { ServiceProvided } from './service-provided/service-provided';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';
import { ServiceProvidedSearch} from './service-provided/service-provided-list/service-provide-search'


@Injectable({
  providedIn: 'root'
})
export class ServiceProvidedService {

  apiURL: string = environment.apiURL + "/api/services-provided"
  

  constructor(private http: HttpClient) { }

  save(ServiceProvided: ServiceProvided) : Observable<ServiceProvided>{
    return this.http.post<ServiceProvided>(this.apiURL, ServiceProvided);
  }

  search(name: string, month: number): Observable<ServiceProvidedSearch[]>{

    const httpParams = new HttpParams()
    .set("name", name)
    .set("month", month ? month.toString(): '');

    const url = this.apiURL + "?" + httpParams.toString();
    return this.http.get<any>(url)
  }
}
