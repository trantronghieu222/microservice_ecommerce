import { useState } from 'react';
import { Button } from 'antd';
import { PlusOutlined } from '@ant-design/icons';
import AdminUserTable from '../../components/AdminUserTable/AdminUserTable';
import AccountModel from '../../components/AccountModel/AccountModel';
type Props = {}

const EmployeeManagement = (props: Props) => {
  const [isModalOpen, setIsModalOpen] = useState(false);

  const showModal = () => {
    setIsModalOpen(true);
  };

  return (
    <>
      {/* Title */}
      <div className='d-flex justify-content-between py-3'>
        <h3>Employee Management</h3>
        <Button type="primary" onClick={showModal}>
          <PlusOutlined /> Add Employee
        </Button>
      </div>

      {/* Body */}
      <AdminUserTable></AdminUserTable>

      {/* Modal */}
      <AccountModel
        isOpen={isModalOpen}
        setIsOpen={setIsModalOpen}
        role={"Employee"}
        titleModal={"Add employee"}
      ></AccountModel>
    </>
  )
}

export default EmployeeManagement