import { Component, OnInit } from '@angular/core';
import { Homeservice } from '../service/home.service';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  teachers: Array<any>;
  rooms: Array<any>;
  subjects: Array<any>;
stt: any = {
    teacherSelect: '',
    RoomSelect: '',
    SubjectSelect: ''
  };

  constructor(private homeservice: Homeservice , private httpClient: HttpClient) { }

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
  }



  save() {
    if (this.stt.teacherSelect === '' || this.stt.RoomSelect === '' || this.stt.SubjectSelect === '' ) {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.post('http://localhost:8080/stt/add/' + this.stt.teacherSelect + ',' + this.stt.RoomSelect + ',' +this.stt.SubjectSelect, this.stt)
      .subscribe(
          data => {
              console.log('PUT Request is successful', data);
          },
          error => {
              console.log('Rrror', error);
          }
      );
    }
  }





}
