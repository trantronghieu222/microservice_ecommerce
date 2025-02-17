"use client"
import React, { useState } from 'react';
import { Button, Modal } from 'antd';
import AdminUserTable from '@/components/AdminUserTable/AdminUserTable';
import { PlusOutlined } from '@ant-design/icons';
type Props = {}

const UserManagement = (props: Props) => {
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
        <h3>User Management</h3>
        <Button type="primary" onClick={showModal}>
          <PlusOutlined /> Add User
        </Button>
      </div>

      {/* Body */}
      <AdminUserTable></AdminUserTable>

      <Modal title="Basic Modal" open={isModalOpen} onOk={handleOk} onCancel={handleCancel}>
        <p>Some contents...</p>
        <p>Some contents...</p>
        <p>Some contents...</p>
      </Modal>
    </>
  )
}

export default UserManagement