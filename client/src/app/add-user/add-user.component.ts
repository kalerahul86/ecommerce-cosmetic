import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.model';
import { HttpClient } from 'selenium-webdriver/http';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent implements OnInit {

  private user = new User();

  constructor(private userService: UserService,
    private router: Router) { }

  ngOnInit() {
  }

  public onFormSubmit(){
    this.userService.addUser(this.user);
    this.router.navigateByUrl('/users');
  }

}
