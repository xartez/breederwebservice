import { Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Litter} from "../interfaces/litter";

@Injectable({
  providedIn: 'root'
})

export class LitterService {
  private apiServerUrl = '';

  constructor(private http: HttpClient) {
  }

  public getLitters() : Observable<Litter[]> {
    return this.http.get<Litter[]>(`${this.apiServerUrl}/litter/all`);
  }

  public addLitter(litter: Litter): Observable<Litter> {
    return this.http.post<Litter>(`${this.apiServerUrl}/litter/add`, litter);
  }

  public updateLitter(litter: Litter): Observable<Litter> {
    return this.http.put<Litter>(`${this.apiServerUrl}/litter/update`, litter);
  }

  public deleteLitter(litterId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/litter/delete/${litterId}`);
  }
}
