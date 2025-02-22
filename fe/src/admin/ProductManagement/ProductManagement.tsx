import { useState } from 'react';
import { PlusOutlined } from '@ant-design/icons';
import { Button } from 'antd';
import AdminProductTable from '../../components/AdminProductTable/AdminProductTable';
import 'react-quill/dist/quill.snow.css';
import ProductModal from '../../components/ProductModal/ProductModal';

const ProductManagement = () => {
  const [isModalOpen, setIsModalOpen] = useState(false);

  const showModalAddProd = () => {
    setIsModalOpen(true);
  };

  return (
    <>
      {/* Title */}
      <div className='d-flex justify-content-between py-3'>
        <h3>Product Management</h3>
        <Button type="primary" onClick={showModalAddProd}>
          <PlusOutlined /> Add Product
        </Button>
      </div>

      {/* Body */}
      <AdminProductTable></AdminProductTable>

      <ProductModal isOpen={isModalOpen} setIsOpen={setIsModalOpen}></ProductModal>
    </>
  )
}

export default ProductManagement