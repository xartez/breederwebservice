import { Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Title} from "../interfaces/title";

@Injectable({
  providedIn: 'root'
})

export class TitleService {
  private apiServerUrl = '';

  constructor(private http: HttpClient) {
  }

  public getTitles() : Observable<Title[]> {
    return this.http.get<Title[]>(`${this.apiServerUrl}/title/all`);
  }

  public addTitle(title: Title): Observable<Title> {
    return this.http.post<Title>(`${this.apiServerUrl}/title/add`, title);
  }

  public updateTitle(title: Title): Observable<Title> {
    return this.http.put<Title>(`${this.apiServerUrl}/title/update`, title);
  }

  public deleteTitle(titleId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/title/delete/${titleId}`);
  }
}
