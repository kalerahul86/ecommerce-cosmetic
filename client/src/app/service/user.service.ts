import { OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user.model';
import { Observable } from 'rxjs';

export class UserService implements OnInit{

    rootUrl: string = "http://localhost:8080/user/";

    constructor(private httpClient: HttpClient){}

    ngOnInit(){}

    public addUser(user: User){
        console.log("AAAA"+JSON.stringify(user))
        this.httpClient.post(this.rootUrl, user, {
            headers: {"content-type":"application/json"}
        }).subscribe();
    }

    public getUsers(): Observable<User[]> {
        return this.httpClient.get<User[]>(this.rootUrl, {
            headers: {"content-type":"application/json"}
        });
    }

    public getUser(id: string): Observable<User> {
        return this.httpClient.get<User>(this.rootUrl+id, {
            headers: {"content-type":"application/json"}
        });
    }

}