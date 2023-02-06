import { Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Training} from "../interfaces/training";

@Injectable({
  providedIn: 'root'
})

export class TrainingService {
  private apiServerUrl = '';

  constructor(private http: HttpClient) {
  }

  public getTrainings() : Observable<Training[]> {
    return this.http.get<Training[]>(`${this.apiServerUrl}/training/all`);
  }

  public addTraining(training: Training): Observable<Training> {
    return this.http.post<Training>(`${this.apiServerUrl}/training/add`, training);
  }

  public updateTraining(training: Training): Observable<Training> {
    return this.http.put<Training>(`${this.apiServerUrl}/training/update`, training);
  }

  public deleteTraining(trainingId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/training/delete/${trainingId}`);
  }
}
