import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first, tap } from 'rxjs';

import { Course } from '../model/course';

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  private readonly API = 'http://localhost:8080/api/courses';

  constructor(private httpClient: HttpClient) {
  }

  list() {
    return this.httpClient.get<Course[]>(this.API)
      .pipe(
        first(),
        tap(courses => console.log(courses))
      );
  }

  save(record: Partial<Course>){
    return this.httpClient.post<Course>(this.API, record).pipe(first());
  }

  loadById(id: string){
   return this.httpClient.get<Course>(`${this.API}/${id}`);
  }

  delete(id: string){
    return this.httpClient.delete(`${this.API}/${id}`).pipe(first());
  }

}
