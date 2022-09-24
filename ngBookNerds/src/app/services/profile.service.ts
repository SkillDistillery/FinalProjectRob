import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, catchError, throwError, tap } from "rxjs";
import { environment } from "src/environments/environment";
import { User } from "../models/user";
import { AuthService } from "./auth.service";

@Injectable({
  providedIn: "root",
})
export class ProfileService {
  private url = environment.baseUrl + "api/profile";

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

  updateProfile(user: User): Observable<User> {
    // Create POST request to register a new account
    return this.http.put<User>(this.url, user, this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error("AuthService.register(): error registering user.")
        );
      })
    );
  }
}
