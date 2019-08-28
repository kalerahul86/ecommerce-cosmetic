import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FormBuilder, Validators, FormControl, FormGroup } from '@angular/forms';
import { CosmeticMaster } from '../model/cosmetic-master.model';
import { SettingsService } from '../service/settings.service';
import { Observable } from 'rxjs';
import { MatAutocomplete, MatChipInputEvent, MatAutocompleteSelectedEvent } from '@angular/material';
import {map, startWith} from 'rxjs/operators';
import {COMMA, ENTER} from '@angular/cdk/keycodes';
import { Product } from '../model/product.model';
import { ProductService } from '../service/product-service';
import { Router } from '@angular/router';

@Component({
  selector: 'add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.scss']
})
export class AddProductComponent implements OnInit {

  categories: Promise<CosmeticMaster[]>;
  companies: Promise<CosmeticMaster[]>; 
  private product = new Product();
  currentFileUpload: File;
  form: any;

  selectable: boolean = true;
  allTags: CosmeticMaster[]; 

  selectedTags: string[] = [];

  isSelected(tag: any): boolean {
    const index = this.selectedTags.indexOf(tag.code);
    return index >= 0;
  }

  toggleTag(tag: any): void {
    
    let index = this.selectedTags.indexOf(tag.code);
    if (index >= 0) {
      this.selectedTags.splice(index, 1);
    } else {
      this.selectedTags.push(tag.code);
    }
  }

  constructor(private formbulider: FormBuilder, private masterService: SettingsService,
    private productService: ProductService,
    private router: Router) {
  }

  ngOnInit() {
    
    this.getSettingsForTag();
    this.getSettingsForCategory();
    this.getSettingsForCompany();

    this.form = this.formbulider.group({
      file: [null, Validators.required]
    });
  }

  selectFile(event) {  
    this.currentFileUpload = event.target.files[0];
  }

  public getSettingsForCategory(){
    this.categories = this.masterService.getSettingsForType("Category");
  }

  public getSettingsForCompany(){
    this.companies = this.masterService.getSettingsForType("Company");
  }

  public getSettingsForTag(){
    this.masterService.getSettingsForType("Tag").then((tags) => {
      this.allTags = tags;
    });
  }

  onFormSubmit(){
    this.product.setTags(this.selectedTags);   
    this.productService.addProduct(this.product, this.currentFileUpload);
    this.toAllProducts();
  }

  public toAllProducts(){
    this.router.navigateByUrl('/products');
  }
}
