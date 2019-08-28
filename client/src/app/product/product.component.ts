import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../model/product.model';
import { FormBuilder, Validators } from '@angular/forms';
import { ProductService } from '../service/product.service';
import { MatTableDataSource } from '@angular/material';
import { Router } from '@angular/router';

@Component({
  selector: 'product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {
  
  displayedColumns: string[] = ['image', 'code', 'name', 'category', 'company', 'tags', 'action'];
  products: Observable<Product[]>;
  
  constructor(private productService: ProductService,
    private router: Router) { 
  }

  public populateAllProducts(){
    this.products = this.productService.getAllProducts();
  }
  
  ngOnInit() {
    this.populateAllProducts();
  }

  public editProduct(productId: string){
    this.router.navigate(['/update-product', productId]);
  }

  public deleteProduct(productId: string){
    this.productService.deleteProduct(productId);
    this.router.navigateByUrl('/products');
  }
}
