import { ProductType } from "./ProductType";

export class Product {

    constructor(public id:number, public name:string, public costPrice:number, public salePrice:number, public type: ProductType) {

    }

}