import { Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Dog} from "../interfaces/dog";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})

export class DogService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }

  public getDogs() : Observable<Dog[]> {
    return this.http.get<Dog[]>(`${this.apiServerUrl}/dog/all`);
  }

  public addDog(dog: Dog): Observable<Dog> {
    return this.http.post<Dog>(`${this.apiServerUrl}/dog/add`, dog);
  }

  public updateDog(dog: Dog): Observable<Dog> {
    return this.http.put<Dog>(`${this.apiServerUrl}/dog/update`, dog);
  }

  public deleteDog(dogId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/dog/delete/${dogId}`);
  }
}
