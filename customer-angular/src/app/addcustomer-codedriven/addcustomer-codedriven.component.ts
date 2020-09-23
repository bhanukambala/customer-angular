import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer';
import { CustomerService } from '../service/customerservice';

@Component({
  selector: 'addcustomer-codedriven',
  templateUrl: './addcustomer-codedriven.component.html',
  styleUrls: ['./addcustomer-codedriven.component.css']
})
export class AddcustomerCodedrivenComponent implements OnInit {

  customerForm:FormGroup;
  customernameCtrl:FormControl;
  balanceCtrl:FormControl;
  customer:Customer;

  constructor(private customerService:CustomerService, fb:FormBuilder) {
    this.customernameCtrl=fb.control('',[Validators.minLength(3),Validators.required]);
    this.balanceCtrl=fb.control('',[Validators.required]);
      this.customerForm=fb.group({
      customername:this.customernameCtrl,
      balance:this.balanceCtrl
    });
   }

  ngOnInit(): void {
  }

  addCustomer(){
    let customername:string=this.customernameCtrl.value;
    let balance:number=this.balanceCtrl.value;
    this.customer=new Customer(-1,customername,balance);
    let observable:Observable<Customer>=this.customerService.addCustomer(this.customer);
    observable.subscribe(
      customerArg=>{
        this.customer=customerArg;
      }
    )
  }
}
