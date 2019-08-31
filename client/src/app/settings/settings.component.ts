import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CosmeticMaster } from '../model/cosmetic-master.model';
import { FormBuilder, Validators } from '@angular/forms';
import { SettingsService } from '../service/settings.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.scss']
})
export class SettingsComponent implements OnInit {

  displayedColumns: string[] = ['type', 'code', 'value'];
  allSettings: Observable<CosmeticMaster[]>;
  
  constructor(private formbulider: FormBuilder, private settingsService: SettingsService,
    private router: Router) { 
  }

  public populateAllSettings(){
    this.allSettings = this.settingsService.getAllSettings();
  }
  
  public redirectToSetting(){
    this.router.navigateByUrl('/settings');
  }

  public refreshCache(){
    this.settingsService.refreshCache();
    this.redirectToSetting();
  }

  ngOnInit() {
    this.populateAllSettings();
  }
}
