import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../../model/Product';
import { ProductType } from '../../model/ProductType';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  public products:Array<Product> = [];
  public cart:{[key:number]:number} = {};

  constructor(private router:Router) { }

  ngOnInit() {
    this.products.push(new Product(1, "Leche", 18, 23, ProductType.CommonType));
    this.products.push(new Product(2, "Pan", 15, 23, ProductType.CommonType));
    this.products.push(new Product(3, "Huevos", 32, 35, ProductType.CommonType));
    this.products.forEach(p => this.cart[p.id] = 0);
  }

  public getTotal():number {
    let total = 0;

    Object.keys(this.cart).forEach(productId => {
      total += this.products.filter(p => p.id == Number(productId))[0].salePrice * this.cart[Number(productId)];
    });

    return total;
  }

  public shop() {
    localStorage.setItem("order", JSON.stringify(this.cart));
    this.router.navigate(['/order']);
  }

}
