"use client"
import AdminOrdersTable from '@/components/AdminOrdersTable/AdminOrdersTable';
import { Button, Modal } from 'antd';
import React, { useState } from 'react';

type Props = {}

const OrdersManagement = (props: Props) => {
  const [isModalOpen, setIsModalOpen] = useState(false);

  const showModal = () => {
    setIsModalOpen(true);
  };

  const handleOk = () => {
    setIsModalOpen(false);
  };

  const handleCancel = () => {
    setIsModalOpen(false);
  };

  return (
    <>
      {/* Title */}
      <div className='py-3'>
        <h3>Order Management</h3>
      </div>

      {/* Body */}
      <AdminOrdersTable></AdminOrdersTable>

      <Modal title="Basic Modal" open={isModalOpen} onOk={handleOk} onCancel={handleCancel}>
        <p>Some contents...</p>
        <p>Some contents...</p>
        <p>Some contents...</p>
      </Modal>
    </>
  )
}

export default OrdersManagement