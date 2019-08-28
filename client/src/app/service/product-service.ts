
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from 'rxjs';
import { Product } from '../model/product.model';

export class ProductService {
    
    rootURL = "http://localhost:8080/product/";
    formData  : Product;
    headers: HttpHeaders;

    constructor(private http : HttpClient){
        let headers = new HttpHeaders();
        this.headers = headers.append('content-type', 'application/json');
    }

    getAllProducts(): Observable<Product[]>{ 
        return this.http.get<Product[]>(this.rootURL);
    }
    
    getProduct(productId: string): Observable<Product>{
        return this.http.get<Product>(this.rootURL+productId, 
            {
                headers: {'content-type':'application/json'}
            });
    }
    
    addProduct(product: Product, image: File){
        
        let formData = new FormData(); 
        formData.append("images", image);
        formData.append("request", JSON.stringify(product));
        this.http.post(this.rootURL, formData).subscribe();
    }
    
    updateProduct(product: string, image: File){
        
        let formData = new FormData(); 
        formData.append("images", image);
        formData.append("request", product);
        this.http.put(this.rootURL, formData).subscribe();
    }
    
    deleteProduct(productId: string){
        this.http.delete(this.rootURL+productId).subscribe();
    }
    
    getProductByCode(productCode: string){
        // ...
    }
}