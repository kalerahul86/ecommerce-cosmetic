import { Component, OnInit } from '@angular/core';
import { Transaction } from '../model/transaction.model';
import { FormBuilder, Validators } from '@angular/forms';
import { TransactionService } from '../service/transaction.service';
import { Router } from '@angular/router';
import { Product } from '../model/product.model';
import { CosmeticMaster } from '../model/cosmetic-master.model';

@Component({
  selector: 'add-transaction',
  templateUrl: './add-transaction.component.html',
  styleUrls: ['./add-transaction.component.scss']
})
export class AddTransactionComponent implements OnInit {

  private transaction = new Transaction();
  private product = new Product();
  private catalog = new CosmeticMaster();
  form: any;

  constructor(private formbulider: FormBuilder,
    private transactionService: TransactionService,
    private router: Router) {
  }

  ngOnInit() {
  }

  onFormSubmit(){
    this.transaction.setProduct(this.product);
    this.transaction.setCatalog(this.catalog);
    console.log("WWWWW"+JSON.stringify(this.transaction));
    this.transactionService.addTransaction(this.transaction);
    this.toAllTransactions();
  }

  public toAllTransactions(){
    this.router.navigateByUrl('/transactions');
  }
}
