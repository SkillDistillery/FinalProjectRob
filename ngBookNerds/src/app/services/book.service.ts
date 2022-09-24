import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Book } from '../models/book';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private url = environment.baseUrl + "api/books";

  constructor(private http: HttpClient, private auth: AuthService) {}

  getHttpOptions() {
    let options = {
      headers: {
        Authorization: "Basic " + this.auth.getCredentials(),
        "X-Requested-With": "XMLHttpRequest",
      },
    };
    return options;
  }

  getAllBooks():Observable<Book[]> {
    return this.http.get<Book[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('BookService.getAllBooks(): error registering user.')
        );
      })
    );
  }
}
