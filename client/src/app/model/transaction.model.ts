import { Product } from './product.model';
import { CosmeticMaster } from './cosmetic-master.model';
import { User } from './user.model';

export class Transaction {

    public id: string;
    public type: string;
    public quantity: number;
    public perItemPrice: number;
    public totalAmount: number;
    public businessPoint: string;
    public buyer: User;
    public product: Product;
    public catelog: CosmeticMaster;
    
    getId(): string {
        return this.id;
    }

    getType(): string {
        return this.type;
    }

    getQuantity(): number {
        return this.quantity;
    }

    getTotalAmount(): number {
        return this.totalAmount;
    }

    getBusinessPoint(): string {
        return this.businessPoint;
    }

    getBuyer(): User {
        return this.buyer;
    }

    getProduct(): Product {
        return this.product;
    }

    getCatalog(): CosmeticMaster {
        return this.catelog;
    }

    setId(id: string) {
        this.id = id;
    }

    setType(type: string) {
        this.type = type;
    }

    setQuantity(quantity: number) {
        this.quantity = quantity;
    }

    setTotalAmount(totalAmount: number) {
        this.totalAmount = totalAmount;
    }

    setBusinessPoint(businessPoint: string) {
        this.businessPoint = businessPoint;
    }

    setBuyer(buyer: User) {
        this.buyer = buyer;
    }

    setProduct(product: Product) {
        this.product = product;
    }

    setCatalog(catalog: CosmeticMaster) {
        this.catelog = catalog;
    }
}
