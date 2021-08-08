import { Component, OnInit } from '@angular/core';
import {  
  FormBuilder,  
  FormGroup  
} from '@angular/forms';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {

  constructor(
    public accountHolderName:String,
    public mobile:String
  ) { }

  ngOnInit(): void {
  }

}
