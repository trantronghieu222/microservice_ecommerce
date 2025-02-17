"use client"
import React, { useState } from 'react';
import { Button, Modal } from 'antd';
import { PlusOutlined } from '@ant-design/icons';
import AdminProductTable from '@/components/AdminProductTable/AdminProductTable';
type Props = {}

const ProductManagement = (props: Props) => {
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
      <div className='d-flex justify-content-between py-3'>
        <h3>Product Management</h3>
        <Button type="primary" onClick={showModal}>
          <PlusOutlined /> Add Product
        </Button>
      </div>

      {/* Body */}
      <AdminProductTable></AdminProductTable>

      <Modal title="Basic Modal" open={isModalOpen} onOk={handleOk} onCancel={handleCancel}>
        <p>Some contents...</p>
        <p>Some contents...</p>
        <p>Some contents...</p>
      </Modal>
    </>
  )
}

export default ProductManagement