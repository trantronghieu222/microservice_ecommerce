import React, { useEffect, useState } from "react";
import { Table, Button, InputNumber, Typography, Space, message } from "antd";
import { DeleteOutlined, ShoppingCartOutlined, ArrowRightOutlined } from "@ant-design/icons";
import { getDataJsonStorage, setDataJsonStorage } from "../../util/utilMethod";

const { Title, Text } = Typography;

interface CartItem {
  productId: number;
  productName: string;
  productImage: string;
  productSaleprice: number;
  quantity: number;
}

const CartPage: React.FC = () => {
  const [cart, setCart] = useState<CartItem[]>([]);

  useEffect(() => {
    const storedCart = getDataJsonStorage("cart");
    if (storedCart) {
      setCart(storedCart);
    }
  }, []);

  const updateQuantity = (productId: number, value: number) => {
    if (value < 1) return;
    const updatedCart = cart.map((item) =>
      item.productId === productId ? { ...item, quantity: value } : item
    );
    setCart(updatedCart);
    setDataJsonStorage("cart", updatedCart);
  };

  const removeItem = (productId: number) => {
    const updatedCart = cart.filter((item) => item.productId !== productId);
    setCart(updatedCart);
    setDataJsonStorage("cart", updatedCart);
    message.success("Sản phẩm đã được xóa khỏi giỏ hàng");
  };

  const getTotal = (): number => {
    return cart.reduce((sum, item) => sum + item.productSaleprice * item.quantity, 0);
  };

  const columns = [
    {
      title: "Sản phẩm",
      dataIndex: "productName",
      key: "productName",
    },
    {
      title: "Giá",
      dataIndex: "productSaleprice",
      key: "productSaleprice",
      render: (price: number) => <Text strong>${price}</Text>,
    },
    {
      title: "Số lượng",
      dataIndex: "quantity",
      key: "quantity",
      render: (text: number, record: CartItem) => (
        <InputNumber
          min={1}
          value={text}
          onChange={(value) => updateQuantity(record.productId, value!)}
        />
      ),
    },
    {
      title: "Tổng",
      key: "total",
      render: (_: any, record: CartItem) => <Text>${record.productSaleprice * record.quantity}</Text>,
    },
    {
      title: "Hành động",
      key: "action",
      render: (_: any, record: CartItem) => (
        <Button danger icon={<DeleteOutlined />} onClick={() => removeItem(record.productId)} />
      ),
    },
  ];

  return (
    <div className="cart-page">
      <Title level={2} className="cart-title">
        <ShoppingCartOutlined /> Giỏ hàng
      </Title>

      <Table columns={columns} dataSource={cart} rowKey="productId" pagination={false} />

      <div style={{ textAlign: "right", marginTop: "20px" }}>
        <Title level={4}>
          Tổng: <Text type="success">${getTotal()}</Text>
        </Title>
      </div>

      <Space style={{ marginTop: "20px", display: "flex", justifyContent: "space-between" }}>
        <Button type="default" size="large" icon={<ArrowRightOutlined />}>
          Tiếp tục mua sắm
        </Button>
        <Button
          type="primary"
          size="large"
          icon={<ShoppingCartOutlined />}
          onClick={() => message.success("Tiến hành thanh toán")}
        >
          Thanh toán
        </Button>
      </Space>
    </div>
  );
};

export default CartPage;