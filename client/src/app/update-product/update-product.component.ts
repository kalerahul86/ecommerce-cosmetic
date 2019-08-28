import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CosmeticMaster } from '../model/cosmetic-master.model';
import { Product } from '../model/product.model';
import { FormBuilder, Validators, FormGroup, FormControl } from '@angular/forms';
import { SettingsService } from '../service/settings.service';
import { ProductService } from '../service/product-service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.scss']
})
export class UpdateProductComponent implements OnInit {

  productId: string;
  categories: Promise<CosmeticMaster[]>;
  companies: Promise<CosmeticMaster[]>;
  category: CosmeticMaster;
  company: CosmeticMaster;
  currentFileUpload: File;
  imageUrl: string = "http://localhost:8080/product/download?imagename=";
  image: string; 
  form: FormGroup;

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
    private route: ActivatedRoute,
    private router: Router) {
  }

  ngOnInit() {
    this.allTags = this.getSettingsForTag();
    this.categories = this.masterService.getSettingsForCategory();
    this.companies = this.masterService.getSettingsForCompany();
    this.editProduct();

    this.form = new FormGroup({
      id: new FormControl(),
      code: new FormControl(),
      name: new FormControl(),
      description: new FormControl(),
      category: new FormControl(),
      company: new FormControl(),
      images: new FormControl(),
      tags: new FormControl()
    });
  }

  public getSettingsForTag(){
    this.masterService.getSettingsForTag().then((tags) => {
      this.allTags = tags;
    });
    return this.allTags;
  }

  public editProduct() {
    this.route.paramMap.subscribe((param) => {
      let productId = param.get("id");
      this.productService.getProduct(productId).subscribe((_product: Product) => {
        this.populateProduct(_product);
      })
    })
  }

  public populateProduct(product: Product) {
    this.image = this.imageUrl + product.images[0];
    this.form.patchValue({
      id: product.id,
      code: product.code,
      name: product.name,
      description: product.description,
      images: product.images,
      category: this.searchCategory(product.category),
      company: this.searchCompany(product.company),
      tags: product.tags,
      selectedTags: this.populateSelectedTags(product.tags)
    }) 
  }

  public populateSelectedTags(tags: String[]): string[] {
    for (let i = 0; i < tags.length; i++) {
      this.selectedTags.push(this.allTags.find(tag => tag.code === tags[i]).code);
    }
    return this.selectedTags;
  }

  public searchCategory(categoryToSearch: CosmeticMaster) : CosmeticMaster{
    
    this.categories.then((categoryList: CosmeticMaster[]) => {
      this.category = categoryList.find(cat => cat.code == categoryToSearch.code);
    })
    return this.category;
  }

  public searchCompany(companyToSearch: CosmeticMaster) {
    this.companies.then((companyList: CosmeticMaster[]) => {
      this.company = companyList.find(comp => comp.code == companyToSearch.code);
    })
    return this.company;
  }

  selectFile(event) {  
    this.currentFileUpload = event.target.files[0];
  }

  onFormSubmit(){
    let product = new Product();
    if(this.selectedTags != null && this.selectedTags.length > 0){
      this.form.patchValue({
        tags: this.selectedTags
      })  
    }
    this.productService.updateProduct(JSON.stringify(this.form.value), this.currentFileUpload);
    this.toAllProducts();
  }

  public toAllProducts(){
    this.router.navigateByUrl('/products');
  }
}
