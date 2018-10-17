import { Component, OnInit } from '@angular/core';
import {Tile} from '../grid-list-dynamic-example/grid-list-dynamic-example.component';
import {FormControl, Validators} from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Homeservice } from '../service/home.service';
import { HttpClient} from '@angular/common/http';
export interface Day {
value: string;
show: string;
}
export interface Time {
value2: string;
time: string;
}
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})


export class TableComponent implements OnInit {
id: number;
 teachers: Array<any>;
  rooms: Array<any>;
  subjects: Array<any>;
  No:Array<any>;
stt: any = {
    teacherSelect: '',
    RoomSelect: '',
    SubjectSelect: '',
    timeSelect:'',
    daySelect:'',
    deleteSelect:''
  };

  constructor(private homeservice: Homeservice ,
  private httpClient: HttpClient,
  private route: ActivatedRoute,
   private router: Router  ) {

     // override the route reuse strategy
     this.router.routeReuseStrategy.shouldReuseRoute = function(){
        return false;
     }


   }

  ngOnInit() {

        this.homeservice.getTeacher().subscribe(data => {
         this.teachers = data;
           console.log(this.teachers);
    });
         this.homeservice.getRoom().subscribe(data => {
           this.rooms = data;
             console.log(this.rooms);
    });
        this.homeservice.getSubject().subscribe(data => {
           this.subjects = data;
             console.log(this.subjects);
    });
        this.homeservice.getStudyTimeTable().subscribe(data => {
           this.No = data;
             console.log(this.No);
    });
  }

  tiles: Tile[] = [
    {text: 'One', cols: 3, rows: 1, color: '#f5d76e'},
    {text: 'Two', cols: 1, rows: 1, color: 'lightgreen'},
    {text: 'Three', cols: 1, rows: 1, color: 'lightpink'},
    {text: 'Four', cols: 2, rows: 1, color: '#DDBDF1'},
  ];
  selectedValue: string;

  dates: Day[] = [

    {value: 'Monday', show: 'Monday'},
    {value: 'Tuesday', show: 'Tuesday'},
    {value: 'Wednesday', show: 'Wednesday'},
    {value: 'Thursday', show: 'Thursday'},
    {value: 'Friday', show: 'Friday'}
  ];

 times: Time[]= [
    {value2: '0', time: '08.00-10.00'},
    {value2: '1', time: '10.00-12.00'},
    {value2: '2', time: '13.00-15.00'}
  ];


cancel(){
this.router.navigated = false;
        this.router.navigate([this.router.url]);
}
  save() {
    if (this.stt.teacherSelect === '' || this.stt.RoomSelect === '' || this.stt.SubjectSelect === '' || this.stt.timeSelect === ''|| this.stt.daySelect === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.post('http://localhost:8080/stt/add/'+ this.stt.daySelect + ','+ this.stt.timeSelect + ','  + this.stt.teacherSelect + ',' + this.stt.RoomSelect + ',' +this.stt.SubjectSelect, this.stt)
      .subscribe(
          data => {
              console.log('PUT Request is successful', data);
              alert('บันทึกเรียบร้อย');
this.router.navigated = false;
        this.router.navigate([this.router.url]);
          },
          error => {
              console.log('Rrror', error);
          }
      );
    }
  }
    Delete(){
      this.httpClient.post('http://localhost:8080/delete/'+ this.stt.deleteSelect, this.stt)
      .subscribe(
          data => {
              console.log('Delete Request is successful', data);
this.router.navigated = false;
        this.router.navigate([this.router.url]);
          },
          error => {
              console.log('Rrror', error);
          }
      );
    }

}
