import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer';
import { CustomerService } from '../service/customerservice';

@Component({
  selector: 'add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent {

  customerService:CustomerService;

  constructor(customerService:CustomerService){
    this.customerService=customerService;
   }
  
  addCustomer(form:any){
    let data=form.value;
    let name=data.name;
    let balance=data.balance;
   this.customer=new Customer(-1,name,balance);
   let successFun = (userArg: Customer) => {
    this.customer = userArg;
  };

  let errFun = err => {
    console.log("err in addusercomponent " + err.message);
  }

  let observable: Observable<Customer> = this.customerService.addCustomer(this.customer);
  observable.subscribe(successFun, errFun);
}
  }

}
