import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  title = 'Students Management'
  students: any = [];

  isGreen = true
  

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllStudents()
  }

  addStudents(){
   
    console.log("addStudents button clicked!!")
    this.router.navigateByUrl('/add-students')
  }

  fetchAllStudents(){
    this.http.get("http://localhost:8080/students/getAllStudents")
    .subscribe(resp =>{
      this.students = resp;
      console.log('Students retrieved successfully:', this.students)
    }, error => {
      console.error('Error retrieving students:', error);
    });
  }

  deleteStudent(studentId:Number){
    
    const url = 'http://localhost:8080/students/deleteStudents/' +studentId
    console.log(url)
    this.http.delete(url)
    .subscribe(resp => {
      console.log('Student deleted successfully');
      this.fetchAllStudents()
    }, error => {
      console.error('Error deleting student:', error);
    });
  }

}