import { Injectable } from '@angular/core';
import { Order } from '../model/Order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor() { }

  public saveUserOrder(order:Order) {
    localStorage.setItem("order", JSON.stringify(order));
  }

  public getUserOrder():Order {
    return JSON.parse(localStorage.getItem("order"));
  }

}
