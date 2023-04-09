import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-loan',
  templateUrl: './loan.component.html',
  styleUrls: ['./loan.component.css']
})
export class LoanComponent implements OnInit {

  title = 'Loans Management'
  loans: any = [];

  isGreen = true
  

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllLoans()
  }

  addLoans(){
   
    console.log("addLoans button clicked!!")
    this.router.navigateByUrl('/add-loans')
  }

  fetchAllLoans(){
    this.http.get("http://localhost:8080/loans/getAllLoans")
    .subscribe(resp =>{
      this.loans = resp;
      console.log('Loans retrieved successfully:', this.loans)
    }, error => {
      console.error('Error retrieving loans:', error);
    });
  }

  deleteLoan(loanId:Number){
    
    const url = 'http://localhost:8080/loans/deleteLoans/' +loanId
    console.log(url)
    this.http.delete(url)
    .subscribe(resp => {
      console.log('Loan deleted successfully');
      this.fetchAllLoans()
    }, error => {
      console.error('Error deleting loan:', error);
    });
  }

}