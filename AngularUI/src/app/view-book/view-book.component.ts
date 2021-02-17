import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookserviceService } from '../BookService/bookservice.service';
import { Ibooking } from '../Interface/Ibooking';

@Component({
  selector: 'app-view-book',
  templateUrl: './view-book.component.html',
  styleUrls: ['./view-book.component.css']
})
export class ViewBookComponent implements OnInit {
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
        this.book1 = this.book[this.book.length-1];
        if (this.book.length > 0) {
          console.log("Added Successfully");
          
         
        }
      },
      responseLoginError => {
        this.errorMsg = responseLoginError;
      },
      () => console.log("Method Executed Successfully")
    );

  }

  next() {

    this.router.navigate(['\Pay']);
  }

  delete(id: number) {
    this._Bookservice.delete(id).subscribe(

      responsebookstatus => {
        this.check = responsebookstatus;

        if (this.check > 0) {
          console.log("Added Successfully");
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
