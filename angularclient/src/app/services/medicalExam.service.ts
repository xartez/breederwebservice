import { Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {MedicalExam} from "../interfaces/medicalExam";

@Injectable({
  providedIn: 'root'
})

export class MedicalExamService {
  private apiServerUrl = '';

  constructor(private http: HttpClient) {
  }

  public getMedicalExams() : Observable<MedicalExam[]> {
    return this.http.get<MedicalExam[]>(`${this.apiServerUrl}/medicalExam/all`);
  }

  public addMedicalExam(medicalExam: MedicalExam): Observable<MedicalExam> {
    return this.http.post<MedicalExam>(`${this.apiServerUrl}/medicalExam/add`, medicalExam);
  }

  public updateMedicalExam(medicalExam: MedicalExam): Observable<MedicalExam> {
    return this.http.put<MedicalExam>(`${this.apiServerUrl}/medicalExam/update`, medicalExam);
  }

  public deleteMedicalExam(medicalExamId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/medicalExam/delete/${medicalExamId}`);
  }
}
