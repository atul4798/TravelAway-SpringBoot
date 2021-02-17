import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Ibooking } from '../Interface/Ibooking';

@Injectable({
  providedIn: 'root'
})
export class BookserviceService {

  constructor(private http:HttpClient) { }

  addbook(email:string,cno:string,residential:string,date:string,adults:number,children:number): Observable<number>
  {
    let userobj: string;
    userobj = "Email=" + email + "&ContactNumber=" + cno + "&ResidentialAddress=" + residential + "&DateofTravel=" + date + "&NumberofAdults=" + adults.toString() + "&NumberofChildren=" + children.toString();
    return this.http.get<number>("http://localhost:8080/AddBooking?" + userobj).pipe(catchError(this.errorHandler));


  }


  getbook(): Observable<Ibooking[]> {
   
    return this.http.get<Ibooking[]>("http://localhost:8080").pipe(catchError(this.errorHandler));


  }

  update(id:number): Observable<number> {

    return this.http.get<number>("http://localhost:8080/UpdateStatus?id=" + id.toString()).pipe(catchError(this.errorHandler));


  }

  delete(id: number): Observable<number> {

    return this.http.get<number>("http://localhost:8080/DeleteBooking?id=" + id.toString()).pipe(catchError(this.errorHandler));


  }



  errorHandler(error: HttpErrorResponse) {
    console.error(error);
    return throwError(error.message || "server Error");
  }
}
