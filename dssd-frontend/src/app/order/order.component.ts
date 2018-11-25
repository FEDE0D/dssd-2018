import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  constructor(private route:ActivatedRoute, private router: Router) { }

  ngOnInit() {
    let order = JSON.parse(localStorage.getItem("order"));
    console.log(order);
  }


}
