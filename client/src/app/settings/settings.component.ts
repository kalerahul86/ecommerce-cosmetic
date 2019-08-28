import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CosmeticMaster } from '../model/cosmetic-master.model';
import { FormBuilder, Validators } from '@angular/forms';
import { SettingsService } from '../service/settings.service';

@Component({
  selector: 'settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.scss']
})
export class SettingsComponent implements OnInit {

  displayedColumns: string[] = ['type', 'code', 'value'];
  allSettings: Observable<CosmeticMaster[]>;
  
  constructor(private formbulider: FormBuilder, private settingsService: SettingsService) { 
  }

  public populateAllSettings(){
    this.allSettings = this.settingsService.getAllSettings();
  }
  
  public refreshCache(){
    this.settingsService.refreshCache();
  }

  ngOnInit() {
    this.populateAllSettings();
  }
}
