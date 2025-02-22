export interface OrderModelType {
    orderId:      number;
    customerId:   number;
    orderDate:    Date;
    orderStatus:  string;
    totalAmount:  number;
    orderDetails: OrderDetail[];
}

export interface OrderDetail {
    productId:       number;
    productQuantity: number;
    productPrice:    number;
}