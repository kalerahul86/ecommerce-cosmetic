import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatCardModule, MatButtonModule, MatSelectModule, MatTableModule, MatToolbarModule, MatCardContent, MatDialogModule, MatDialog, MatDialogRef, MatPaginatorModule, MatSortModule, MatChipsModule, MatIconModule, MatSidenavModule, MatListModule, MatFormFieldModule, MatNativeDateModule, MatDatepickerModule, MatCheckboxModule, MatInputModule, MatRadioModule, MatAutocompleteModule, MatFormFieldControl } from '@angular/material';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductComponent } from './product/product.component';
import { FormsModule, FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { ProductService } from './service/product.service';
import { HttpClientModule } from '@angular/common/http';
import { SettingsComponent } from './settings/settings.component';
import { SettingsService } from './service/settings.service';
import { RouterModule, Routes } from '@angular/router';
import { AddProductComponent } from './add-product/add-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { TransactionComponent } from './transaction/transaction.component';
import { TransactionService } from './service/transaction.service';
import { AddTransactionComponent } from './add-transaction/add-transaction.component';
import { UserComponent } from './user/user.component';
import { UserService } from './service/user.service';
import { AddUserComponent } from './add-user/add-user.component';

const appRoutes: Routes = [
  { path: 'products', component: ProductComponent },
  { path: 'settings',      component: SettingsComponent },
  { path: 'add-product',      component: AddProductComponent },
  { path: 'update-product/:id',      component: UpdateProductComponent },
  { path: 'transactions',      component: TransactionComponent },
  { path: 'add-transaction',      component: AddTransactionComponent },
  { path: 'users',      component: UserComponent },
  { path: 'add-user',      component: AddUserComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    SettingsComponent,
    AddProductComponent,
    UpdateProductComponent,
    TransactionComponent,
    AddTransactionComponent,
    UserComponent,
    AddUserComponent
  ],
  imports: [
    BrowserModule,  
    FormsModule,  
    ReactiveFormsModule,  
    HttpClientModule,   
    AppRoutingModule,
    MatCardModule, 
    MatButtonModule, 
    MatSelectModule,
    MatTableModule,
    FormsModule,
    ReactiveFormsModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    MatDialogModule,
    MatChipsModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule,
    RouterModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatCheckboxModule,
    MatCardModule,
    MatInputModule,
    MatRadioModule,
    MatSelectModule,
    MatAutocompleteModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    )
  ],
  providers: [HttpClientModule, ProductService, SettingsService, TransactionService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
