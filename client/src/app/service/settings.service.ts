
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from 'rxjs';
import { Product } from '../model/product.model';
import { CosmeticMaster } from '../model/cosmetic-master.model';
import { Injectable } from '@angular/core';
import { AttachSession } from 'protractor/built/driverProviders';
import { resolve } from 'url';

@Injectable()
export class SettingsService {
    
    rootURL = "http://localhost:8080/master/";
    
    constructor(private http : HttpClient){
    }

    getAllSettings(): Observable<CosmeticMaster[]>{ 
        return this.http.get<CosmeticMaster[]>(this.rootURL+"get",{
            headers: {'content-type':'application/json'}
         });
    }
    
    async getSettingsForType(type: string): Promise<CosmeticMaster[]> {
        return await this.http.get<CosmeticMaster[]>(this.rootURL+"get/"+type,{
            headers: {'content-type':'application/json'}
         }).toPromise();
    }

    refreshCache(): Observable<boolean> {
        return this.http.get<boolean>(this.rootURL+"refresh");
    }

    getSettingsForCategory(): Promise<CosmeticMaster[]> {
        return this.getSettingsForType("Category");
    }

    getSettingsForCompany(): Promise<CosmeticMaster[]> {
    return this.getSettingsForType("Company");
    }

    getSettingsForTag(): Promise<CosmeticMaster[]> {
        return this.getSettingsForType("Tag");
    }
}