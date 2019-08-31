import { Component, OnInit } from '@angular/core';
import { Transaction } from '../model/transaction.model';
import { FormBuilder, Validators, FormControl } from '@angular/forms';
import { TransactionService } from '../service/transaction.service';
import { Router } from '@angular/router';
import { Product } from '../model/product.model';
import { CosmeticMaster } from '../model/cosmetic-master.model';
import { ProductService } from '../service/product.service';
import { Observable } from 'rxjs';
import { startWith, map } from 'rxjs/operators';
import { User } from '../model/user.model';
import { UserService } from '../service/user.service';

@Component({
  selector: 'add-transaction',
  templateUrl: './add-transaction.component.html',
  styleUrls: ['./add-transaction.component.scss']
})
export class AddTransactionComponent implements OnInit {

  imageUrl: string = "http://localhost:8080/product/download?imagename=";
  private transaction = new Transaction();
  private catalog = new CosmeticMaster();
  form: any;

  productCtrl = new FormControl();
  userCtrl = new FormControl();
  filteredProducts: Observable<Product[]>;  
  products: Product[];
  filteredUsers: Observable<User[]>;
  users: User[];

  constructor(private formbulider: FormBuilder,
    private transactionService: TransactionService,
    private router: Router,
    private productService: ProductService,
    private userService: UserService) {
  }

  ngOnInit() {
  
    this.userService.getUsers().subscribe(userValue => {
      this.users = userValue;
      
      this.filteredUsers = this.userCtrl.valueChanges
      .pipe(
        startWith(''),
        map(user => user ? this._filterUsers(user) : this.users.slice())
      );
    });
  
    this.productService.getAllProducts().subscribe(productValue => {
      this.products = productValue;
      console.log(JSON.stringify(this.products));
      this.filteredProducts = this.productCtrl.valueChanges
      .pipe(
        startWith(''),
        map(product => product ? this._filterProducts(product) : this.products.slice())
      );
    });

  }

  private _filterProducts(value: string): Product[] {
    const filterValue = value.toLowerCase();
    return this.products.filter(product => product.name.toLowerCase().indexOf(filterValue) === 0);
  }

  private _filterUsers(value: string): User[] {
    console.log(JSON.stringify(this.users));
    const filterValue = value.toLowerCase();
    return this.users.filter(user => user.fullName.toLowerCase().indexOf(filterValue) === 0);
  }

  onFormSubmit(){
   
    this.transaction.setCatalog(this.catalog);
    this.transactionService.addTransaction(this.transaction);
    this.toAllTransactions();
  }

  onSelectProduct(id: string){
    let pr = new Product();
    pr.setId(id);
    this.transaction.setProduct(pr);
  }

  onSelectUser(id: string) {
    let usr = new User();
    usr.setId(id);
    this.transaction.setBuyer(usr);
  }

  valueChangeForPerItemPrice(perItemPrice: number){
    if(this.transaction.quantity){
      let totalAmount = this.transaction.quantity * perItemPrice;
      this.transaction.setTotalAmount(totalAmount);
    }
  }

  valueChangeForQuantity(quantity: number) {
    if(this.transaction.perItemPrice){
      let totalAmount = this.transaction.perItemPrice * quantity;
      this.transaction.setTotalAmount(totalAmount);
    }
  }

  public toAllTransactions(){
    this.router.navigateByUrl('/transactions');
  }
}
