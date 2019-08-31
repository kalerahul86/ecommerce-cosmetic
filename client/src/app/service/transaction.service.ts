import { HttpClient } from '@angular/common/http';
import { Transaction } from '../model/transaction.model';
import { Observable } from 'rxjs';

export class TransactionService {

    rootUrl: string = "http://localhost:8081/transaction/";

    constructor(private httpClient: HttpClient){}

    addTransaction(transaction: Transaction){
        this.httpClient.post(this.rootUrl, transaction, {
            headers : {'content-type':'application/json'}
        }).subscribe();
        console.log("Added transaction");
    }

    getTransaction(id: string): Promise<Transaction> {
        return this.httpClient.get<Transaction>(this.rootUrl+id ,{
            headers: {'content-type':'application/json'}
         }).toPromise();
    }

    getAllTransactions(): Observable<Transaction[]> {
        return this.httpClient.get<Transaction[]>(this.rootUrl ,{
            headers: {'content-type':'application/json'}
         });
    }
 }