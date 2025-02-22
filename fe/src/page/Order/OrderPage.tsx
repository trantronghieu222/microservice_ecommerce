import React from 'react';
import { Table, Button, Tag } from 'antd';
import type { ColumnsType } from 'antd/es/table';

interface OrderRecord {
  id: number;
  products: string;
  quantity: number;
  total: number;
  date: string;
  condition: string;
}

const orders: OrderRecord[] = [
  { id: 1, products: 'Đồng hồ Rolex', quantity: 1, total: 5000, date: '2024-02-20', condition: 'Shipped' },
  { id: 2, products: 'Apple Watch', quantity: 2, total: 800, date: '2024-02-18', condition: 'Processing' },
  { id: 3, products: 'Casio G-Shock', quantity: 1, total: 150, date: '2024-02-15', condition: 'Delivered' },
];

const columns: ColumnsType<OrderRecord> = [
  { title: 'ID', dataIndex: 'id', key: 'id' },
  { title: 'Products', dataIndex: 'products', key: 'products' },
  { title: 'Quantity', dataIndex: 'quantity', key: 'quantity' },
  { title: 'Total ($)', dataIndex: 'total', key: 'total' },
  { title: 'Date', dataIndex: 'date', key: 'date' },
  {
    title: 'Condition',
    dataIndex: 'condition',
    key: 'condition',
    render: (condition: string) => {
      let color = condition === 'Shipped' ? 'blue' : condition === 'Delivered' ? 'green' : 'orange';
      return <Tag color={color}>{condition}</Tag>;
    },
  },
  {
    title: 'Details',
    key: 'details',
    render: (_, record) => <Button type="link" onClick={() => handleDetails(record.id)}>View</Button>,
  },
];

const handleDetails = (id: number) => {
  console.log(`Viewing details for order ID: ${id}`);
};

const OrderPage: React.FC = () => {
  return (
    <div className='text-center' style={{ padding: 20 }}>
      <h2>Order History</h2>
      <Table columns={columns} dataSource={orders} rowKey="id" />
    </div>
  );
};

export default OrderPage;