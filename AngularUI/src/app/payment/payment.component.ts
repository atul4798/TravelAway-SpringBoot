import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookserviceService } from '../BookService/bookservice.service';
import { Ibooking } from '../Interface/Ibooking';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  errorMsg: string;
  book: Ibooking[];
  book1: Ibooking
  check: number;
  constructor(private _Bookservice: BookserviceService, private router: Router) {
    this.getBook();
  }

  ngOnInit(): void {
  }
  getBook() {
    this._Bookservice.getbook().subscribe(

      responsebookstatus => {
        this.book = responsebookstatus;
        this.book1 = this.book[this.book.length - 1];
        if (this.book.length > 0) {
          console.log("Fetched Successfully");
         


        }
      },
      responseLoginError => {
        this.errorMsg = responseLoginError;
      },
      () => console.log("Method Executed Successfully")
    );

  }

  next(id: number) {
    this._Bookservice.update(id).subscribe(
      responsebookstatus => {
        this.check = responsebookstatus;

        if (this.check > 0) {
        console.log("Fetched Successfully");
        this.router.navigate(['\book']);



      }
    },
      responseLoginError => {
        this.errorMsg = responseLoginError;
      },
      () => console.log("Method Executed Successfully")
    );
   
  }


}
