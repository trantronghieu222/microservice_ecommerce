import React, { useEffect, useState } from 'react';
import { Button, Modal } from 'antd';
import { PlusOutlined } from '@ant-design/icons';
import AdminUserTable from '../../components/AdminUserTable/AdminUserTable';
import AccountModel from '../../components/AccountModel/AccountModel';
import { DispatchType, RootState } from '../../redux/store';
import { useDispatch, useSelector } from 'react-redux';
import { getAllAccountApi } from '../../redux/reducers/AccountReducer';
import { AccountModelType } from '../../models/AccountModelType';
type Props = {}

const AccountManagement = (props: Props) => {
  const dispatch: DispatchType = useDispatch();
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [selectedAccount, setSelectedAccount] = useState<AccountModelType | null>(null);
  const { arrAccount } = useSelector((state: RootState) => state.accountReducer);

  useEffect(() => {
    dispatch(getAllAccountApi());
  }, [])

  // console.log(arrAccount)

  const showModal = () => {
    setSelectedAccount(null);
    setIsModalOpen(true);
  };

  const showUpdateModal = (account: AccountModelType) => {
    console.log("Product to update:", account);
    setSelectedAccount(account);
    setIsModalOpen(true);
  }

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
      <AdminUserTable
        arrAccount={arrAccount}
        showUpdateModel={showUpdateModal}
      ></AdminUserTable>

      {/* Modal */}
      <AccountModel
        isOpen={isModalOpen}
        setIsOpen={setIsModalOpen}
        selectedAccount={selectedAccount}
      ></AccountModel>
    </>
  )
}

export default AccountManagement