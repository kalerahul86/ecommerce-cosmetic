import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { Observable } from 'rxjs';
import { User } from '../model/user.model';

@Component({
  selector: 'user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  users: Observable<User[]>;
  displayedColumns: string[] = ['userName','mobileNumber'];

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.populateUsers();
  }

  populateUsers(){
    this.users = this.userService.getUsers();
  }

}
