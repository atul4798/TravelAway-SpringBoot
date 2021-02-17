import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { BookserviceService } from '../BookService/bookservice.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {
  status: number;
  errorMsg: string;

  constructor(private _Bookservice: BookserviceService, private router: Router) { }

  ngOnInit(): void {
  }

  submitBook(form: NgForm)
  {
    this._Bookservice.addbook(form.value.email, form.value.cno, form.value.Residential, form.value.DTravel, form.value.adults, form.value.children).subscribe(

      responsebookstatus => {
        this.status = responsebookstatus;
        if (this.status > 0) {
          console.log("Added Successfully");
          alert("Added Successfully");
          this.router.navigate(['\View']);

        }
      },
      responseLoginError => {
        this.errorMsg = responseLoginError;
      },
      () => console.log("Method Executed Successfully")
    );

  }


}
