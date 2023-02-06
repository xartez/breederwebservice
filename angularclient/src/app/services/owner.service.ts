import { Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Owner} from "../interfaces/owner";
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: 'root'
})

export class OwnerService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }

  public getOwners() : Observable<Owner[]> {
    return this.http.get<Owner[]>(`${this.apiServerUrl}/owner/all`);
  }

  public addOwner(owner: Owner): Observable<Owner> {
    return this.http.post<Owner>(`${this.apiServerUrl}/owner/add`, owner);
  }

  public updateOwner(owner: Owner): Observable<Owner> {
    return this.http.put<Owner>(`${this.apiServerUrl}/owner/update`, owner);
  }

  public deleteOwner(ownerId: string): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/owner/delete/${ownerId}`);
  }
}
