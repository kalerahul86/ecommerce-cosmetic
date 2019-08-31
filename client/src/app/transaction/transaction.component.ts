import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Transaction } from '../model/transaction.model';
import { TransactionService } from '../service/transaction.service';
import { Router } from '@angular/router';
import { ProductService } from '../service/product.service';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.scss']
})
export class TransactionComponent implements OnInit {

  displayedColumns: string[] = ['productImage', 'productCode', 
  'productName', 'catalog', 'quantity', 'totalAmount', 
'businessPoint', 'buyerName'];
  transactions: Observable<Transaction[]>;
  
  constructor(private transactionService: TransactionService,
    private router: Router) { 
  }

  public populateAllTransactions(){
    this.transactions = this.transactionService.getAllTransactions();
  }
  
  ngOnInit() {
    this.populateAllTransactions();
  }

}
