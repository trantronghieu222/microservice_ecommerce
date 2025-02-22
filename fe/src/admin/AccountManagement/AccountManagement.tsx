import React, { useState } from 'react';
import { Button, Modal } from 'antd';
import { PlusOutlined } from '@ant-design/icons';
import AdminUserTable from '../../components/AdminUserTable/AdminUserTable';
import AccountModel from '../../components/AccountModel/AccountModel';
type Props = {}

const AccountManagement = (props: Props) => {
  const [isModalOpen, setIsModalOpen] = useState(false);

  const showModal = () => {
    setIsModalOpen(true);
  };

  return (
    <>
      {/* Title */}
      <div className='d-flex justify-content-between py-3'>
        <h3>Account Management</h3>
        <Button type="primary" onClick={showModal}>
          <PlusOutlined /> Add User
        </Button>
      </div>

      {/* Body */}
      <AdminUserTable></AdminUserTable>

      {/* Modal */}
      <AccountModel
        isOpen={isModalOpen}
        setIsOpen={setIsModalOpen}
        role={"User"}
        titleModal={"Add Account"}
      ></AccountModel>
    </>
  )
}

export default AccountManagement