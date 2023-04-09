import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {FormBuilder , FormGroup, Validators} from '@angular/forms'
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-students',
  templateUrl: './add-students.component.html',
  styleUrls: ['./add-students.component.css']
})
export class AddStudentsComponent implements OnInit {
  studentsForm : FormGroup;
  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router ) { 
    this.studentsForm = this.formbuilder.group({
      name: ['', Validators.required],
      dept: [],
      rollNumber: [],
      mobileNo: [],
      birthDate: [],
    })
  }

  ngOnInit(): void {
  }

  saveStudent(){    
    let studentData = this.studentsForm.value;
    // Handle date to string
    this.http.post('http://localhost:8080/students/saveStudents',studentData)
    .subscribe(response => {
      console.log('Student saved to DB', response)
      this.router.navigateByUrl('/students')
    }, error =>{
      console.error("Error in student save", error)
    }
    );

  }

  



}