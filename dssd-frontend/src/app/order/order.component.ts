import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { OrderService } from '../service/order.service';
import { Order } from '../model/Order';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  private order:Order;

  constructor(private route:ActivatedRoute, private router: Router, private orderService:OrderService) { }

  ngOnInit() {
    this.order = this.orderService.getUserOrder();
  }

  public shop() {
    alert(`La compra fue realizada exitosamente`);
    this.router.navigate(['/home']);
  }


}
