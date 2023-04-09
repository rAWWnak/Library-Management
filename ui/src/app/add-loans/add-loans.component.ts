import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {FormBuilder , FormGroup, Validators} from '@angular/forms'
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-loans',
  templateUrl: './add-loans.component.html',
  styleUrls: ['./add-loans.component.css']
})
export class AddLoansComponent implements OnInit {
  loansForm : FormGroup;
  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router ) { 
    this.loansForm = this.formbuilder.group({
      bookId: ['',Validators.required],
      studentId: ['',Validators.required],
      checkoutDate: [],
      dueDate: [],
      returnDate: []
    })
  }

  ngOnInit(): void {
  }

  saveLoan(){    
    let loanData = this.loansForm.value;
    this.http.post('http://localhost:8080/loans/saveLoans',loanData)
    .subscribe(response => {
      console.log('Loan saved to DB', response)
      this.router.navigateByUrl('/loans')
    }, error =>{
      console.error("Error in loan save", error)
    }
    );

  }

  



}