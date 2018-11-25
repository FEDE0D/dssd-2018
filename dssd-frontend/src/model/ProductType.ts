export class ProductType {

    public static CommonType : ProductType = new ProductType("COM", "Common product");

    public id:number;

    constructor(public initials:string, public description:string) {

    }

}