export interface ProductModelType {
    productId:          number;
    productName:        string;
    productInventory:   number;
    productWarranty:    Date;
    productImage:       string;
    supplierId:         number;
    productSaleprice:   number;
    productInprice:     number;
    productDescription: string;
    productTypeId:      number;
    deleted:            boolean;
}