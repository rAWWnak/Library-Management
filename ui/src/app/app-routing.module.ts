import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { AddAdminsComponent } from './add-admin/add-admin.component';
import { AuthorComponent } from './author/author.component';
import { BookComponent } from './book/book.component';
import { LoanComponent } from './loan/loan.component';
import { PublisherComponent } from './publisher/publisher.component';
import { StudentComponent } from './student/student.component';
import { AddBooksComponent } from './add-books/add-books.component';
import { HomeComponent } from './home/home.component';
import { AddAuthorsComponent } from './add-authors/add-authors.component';
import { AddLoansComponent } from './add-loans/add-loans.component';
import { AddPublishersComponent } from './add-publishers/add-publishers.component';
import { AddStudentsComponent } from './add-students/add-students.component';

const routes: Routes = [
{
path: '',
component: HomeComponent,
},
{
path: 'add-books',
component: AddBooksComponent,
},
{
  path: 'add-authors',
  component: AddAuthorsComponent,
},
{
  path: 'add-loans',
  component: AddLoansComponent,
},
{
  path: 'add-students',
  component: AddStudentsComponent,
},
{
  path: 'add-publishers',
  component: AddPublishersComponent,
},
{
  path : 'books',
  component : BookComponent,
},
{
  path : 'admins',
  component : AdminComponent
},
{
  path : 'add-admin',
  component : AddAdminsComponent
},
{
  path : 'authors',
  component : AuthorComponent
},
{
  path : 'students',
  component : StudentComponent
},
{
  path : 'loans',
  component : LoanComponent
},
{
  path : 'publishers',
  component : PublisherComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
