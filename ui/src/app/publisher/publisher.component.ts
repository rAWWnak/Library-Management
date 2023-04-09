import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-publisher',
  templateUrl: './publisher.component.html',
  styleUrls: ['./publisher.component.css']
})
export class PublisherComponent implements OnInit {

  title = 'publishers Management'
  publishers: any = [];

  isGreen = true
  

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllPublishers()
  }

  addPublishers(){
   
    console.log("addPublishers button clicked!!")
    this.router.navigateByUrl('/add-publishers')
  }

  fetchAllPublishers(){
    this.http.get("http://localhost:8080/publishers/getAllPublishers")
    .subscribe(resp =>{
      this.publishers = resp;
      console.log('Publishers retrieved successfully:', this.publishers)
    }, error => {
      console.error('Error retrieving publishers:', error);
    });
  }

  deletePublisher(publisherId:Number){
    
    const url = 'http://localhost:8080/publishers/deletePublishers/' +publisherId
    console.log(url)
    this.http.delete(url)
    .subscribe(resp => {
      console.log('Publisher deleted successfully');
      this.fetchAllPublishers()
    }, error => {
      console.error('Error deleting publisher:', error);
    });
  }

}