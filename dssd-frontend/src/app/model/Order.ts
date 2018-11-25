import { Product } from '../model/Product';

export class Order {

    constructor(public items:Array<{product:Product, count:number}>, public total:number) {

    }

}