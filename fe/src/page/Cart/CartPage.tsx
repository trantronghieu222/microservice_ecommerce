import React, { useState } from "react";
import { Table, Button, InputNumber, Typography, Space, message } from "antd";
import { DeleteOutlined, ShoppingCartOutlined, ArrowRightOutlined } from "@ant-design/icons";

const { Title, Text } = Typography;

interface CartItem {
  id: number;
  name: string;
  price: number;
  quantity: number;
}

const CartPage: React.FC = () => {
  const [cart, setCart] = useState<CartItem[]>([
    { id: 1, name: "Product A", price: 20, quantity: 1 },
    { id: 2, name: "Product B", price: 15, quantity: 2 },
    { id: 3, name: "Product C", price: 30, quantity: 1 },
  ]);

  // Cập nhật số lượng sản phẩm
  const updateQuantity = (id: number, value: number) => {
    if (value < 1) return;
    setCart((prevCart) =>
      prevCart.map((item) => (item.id === id ? { ...item, quantity: value } : item))
    );
  };

  // Xóa sản phẩm khỏi giỏ hàng
  const removeItem = (id: number) => {
    setCart((prevCart) => prevCart.filter((item) => item.id !== id));
    message.success("Product removed from cart");
  };

  // Tính tổng tiền giỏ hàng
  const getTotal = (): number => {
    return cart.reduce((sum, item) => sum + item.price * item.quantity, 0);
  };

  // Cấu hình cột của bảng Ant Design
  const columns = [
    {
      title: "Product",
      dataIndex: "name",
      key: "name",
    },
    {
      title: "Price",
      dataIndex: "price",
      key: "price",
      render: (price: number) => <Text strong>${price}</Text>,
    },
    {
      title: "Quantity",
      dataIndex: "quantity",
      key: "quantity",
      render: (text: number, record: CartItem) => (
        <InputNumber min={1} value={text} onChange={(value) => updateQuantity(record.id, value!)} />
      ),
    },
    {
      title: "Total",
      key: "total",
      render: (_: any, record: CartItem) => <Text>${record.price * record.quantity}</Text>,
    },
    {
      title: "Action",
      key: "action",
      render: (_: any, record: CartItem) => (
        <Button danger icon={<DeleteOutlined />} onClick={() => removeItem(record.id)} />
      ),
    },
  ];

  return (
    <div className="cart-page">
      <Title level={2} className="cart-title">
        <ShoppingCartOutlined /> Shopping Cart
      </Title>

      <Table columns={columns} dataSource={cart} rowKey="id" pagination={false} />

      {/* Tổng tiền */}
      <div style={{ textAlign: "right", marginTop: "20px" }}>
        <Title level={4}>
          Total: <Text type="success">${getTotal()}</Text>
        </Title>
      </div>

      {/* Nút hành động */}
      <Space style={{ marginTop: "20px", display: "flex", justifyContent: "space-between" }}>
        <Button type="default" size="large" icon={<ArrowRightOutlined />}>
          Continue Shopping
        </Button>
        <Button type="primary" size="large" icon={<ShoppingCartOutlined />} onClick={() => message.success("Proceeding to checkout")}>
          Proceed to Checkout
        </Button>
      </Space>
    </div>
  );
};

export default CartPage;