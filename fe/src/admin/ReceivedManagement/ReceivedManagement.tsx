import React, { useState } from 'react';
import { Button, Modal } from 'antd';
import { PlusOutlined } from '@ant-design/icons';
import AdminReceivedTable from '../../components/AdminReceivedTable/AdminReceivedTable';
type Props = {}

const ReceivedManagement = (props: Props) => {
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
        <h3>Received Management</h3>
        <Button type="primary" onClick={showModal}>
          <PlusOutlined /> Add Supplier
        </Button>
      </div>

      {/* Body */}
      <AdminReceivedTable></AdminReceivedTable>

      <Modal title="Basic Modal" open={isModalOpen} onOk={handleOk} onCancel={handleCancel}>
        <p>Some contents...</p>
        <p>Some contents...</p>
        <p>Some contents...</p>
      </Modal>
    </>
  )
}

export default ReceivedManagement