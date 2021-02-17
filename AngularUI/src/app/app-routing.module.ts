import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookingComponent } from './booking/booking.component';
import { PaymentComponent } from './payment/payment.component';
import { ViewBookComponent } from './view-book/view-book.component';

const routes: Routes = [
  { path: 'book', component: BookingComponent },
  { path: 'View', component: ViewBookComponent },
  { path: 'Pay', component: PaymentComponent },
{ path: '', component: BookingComponent },
{ path: '**', component: BookingComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
