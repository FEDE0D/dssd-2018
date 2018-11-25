import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../model/Product';
import { ProductType } from '../model/ProductType';
import { OrderService } from '../service/order.service';
import { Order } from '../model/Order';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  public products:Array<Product> = [];
  public cart:{[key:number]:number} = {};

  constructor(private router:Router, private orderService: OrderService) { }

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
    let items:Array<{product:Product, count:number}> = [];
    Object.keys(this.cart).forEach(key => {
      items.push({
        product: this.products.filter(p => p.id == Number(key))[0],
        count: this.cart[key]
      });
      items = items.filter(i => i.count > 0);
    });

    this.orderService.saveUserOrder(new Order(items, this.getTotal()));

    this.router.navigate(['/order']);
  }

}
