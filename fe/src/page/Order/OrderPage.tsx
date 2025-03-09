import React, { useEffect, useState } from "react";
import { Table, Button, Tag, Modal, List } from "antd";
import type { ColumnsType } from "antd/es/table";
import { useDispatch, useSelector } from "react-redux";
import { DispatchType, RootState } from "../../redux/store";
import { OrderModelType, OrderDetail } from "../../models/OrderModelType";
import { getOrderByCustomerId } from "../../redux/reducers/OrderReducer";

const OrderPage: React.FC = () => {
  const dispatch: DispatchType = useDispatch();
  const { arrOrder } = useSelector((state: RootState) => state.orderReducer);
  const [selectedOrder, setSelectedOrder] = useState<OrderModelType | null>(null);
  const [isModalVisible, setIsModalVisible] = useState(false);

  useEffect(() => {
    dispatch(getOrderByCustomerId(1));
  }, [])

  // Hàm mở modal xem chi tiết đơn hàng
  const handleDetails = (order: OrderModelType) => {
    setSelectedOrder(order);
    setIsModalVisible(true);
  };

  // Hàm đóng modal
  const handleCloseModal = () => {
    setIsModalVisible(false);
  };

  // Cấu hình cột bảng
  const columns: ColumnsType<OrderModelType> = [
    {
      title: "STT",
      key: "stt",
      render: (_: any, __: OrderModelType, index: number) => index + 1
    },
    {
      title: "Date",
      dataIndex: "orderDate",
      key: "orderDate"
    },
    {
      title: "Total ($)",
      dataIndex: "totalAmount",
      key: "totalAmount"
    },
    {
      title: "Status",
      dataIndex: "orderStatus",
      key: "orderStatus",
      render: (status: string) => {
        let color = status === "Pending" ? "orange" : status === "Shipped" ? "blue" : "green";
        return <Tag color={color}>{status}</Tag>;
      },
    },
    {
      title: "Details",
      key: "details",
      render: (_, record) => (
        <Button type="link" onClick={() => handleDetails(record)}>View</Button>
      ),
    },
  ];

  return (
    <div className="text-center" style={{ padding: 20 }}>
      <h2>Order History</h2>
      <Table columns={columns} dataSource={arrOrder} rowKey="orderId" />

      {/* Modal xem chi tiết đơn hàng */}
      <Modal
        title="Order Details"
        visible={isModalVisible}
        onCancel={handleCloseModal}
        footer={null}
      >
        {selectedOrder && (
          <div>
            <p><strong>Order ID:</strong> {selectedOrder.orderId}</p>
            <p><strong>Customer ID:</strong> {selectedOrder.customerId}</p>
            <p><strong>Date:</strong> {selectedOrder.orderDate.toString()}</p>
            <p><strong>Status:</strong> {selectedOrder.orderStatus}</p>
            <p><strong>Total Amount:</strong> ${selectedOrder.totalAmount}</p>

            <h3>Order Items:</h3>
            <List
              dataSource={selectedOrder.orderDetails}
              renderItem={(item: OrderDetail) => (
                <List.Item>
                  <strong>Product ID:</strong> {item.productId} |
                  <strong> Quantity:</strong> {item.productQuantity}
                </List.Item>
              )}
            />
          </div>
        )}
      </Modal>
    </div>
  );
};

export default OrderPage;