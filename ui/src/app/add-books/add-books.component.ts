import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {FormBuilder , FormGroup, Validators} from '@angular/forms'
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-books',
  templateUrl: './add-books.component.html',
  styleUrls: ['./add-books.component.css']
})
export class AddBooksComponent implements OnInit {
  booksForm : FormGroup;
  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router ) { 
    this.booksForm = this.formbuilder.group({
      name: ['', Validators.required],
      author: [],
      isbn: [],
      publicationDate: [],
      publisher: [],
      copies: [],
      category: [],
      genre: [],
      subgenre: []
    })
  }

  ngOnInit(): void {
  }

  saveBook(){    
    let bookData = this.booksForm.value;
    // Handle date to string
    this.http.post('http://localhost:8080/books/saveBooks',bookData)
    .subscribe(response => {
      console.log('Book saved to DB', response)
      this.router.navigateByUrl('/books')
    }, error =>{
      console.error("Error in book save", error)
    }
    );

  }

  



}