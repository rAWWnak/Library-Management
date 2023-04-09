import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookComponent } from './book/book.component';
import { AdminComponent } from './admin/admin.component';
import { AuthorComponent } from './author/author.component';
import { StudentComponent } from './student/student.component';
import { LoanComponent } from './loan/loan.component';
import { PublisherComponent } from './publisher/publisher.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { HomeComponent } from './home/home.component';
import { AddAdminsComponent } from './add-admin/add-admin.component';
import { AddBooksComponent } from './add-books/add-books.component';
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { AddStudentsComponent } from './add-students/add-students.component';
import { AddPublishersComponent } from './add-publishers/add-publishers.component';
import { AddAuthorsComponent } from './add-authors/add-authors.component';
import { AddLoansComponent } from './add-loans/add-loans.component'

@NgModule({
  declarations: [
    AppComponent,
    BookComponent,
    AdminComponent,
    AuthorComponent,
    StudentComponent,
    LoanComponent,
    PublisherComponent,
    SidenavComponent,
    HomeComponent,
    AddAdminsComponent,
    AddBooksComponent,
    AddStudentsComponent,
    AddPublishersComponent,
    AddAuthorsComponent,
    AddLoansComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, 
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
