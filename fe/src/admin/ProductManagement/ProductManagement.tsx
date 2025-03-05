import { useEffect, useState } from 'react';
import { PlusOutlined } from '@ant-design/icons';
import { Button } from 'antd';
import AdminProductTable from '../../components/AdminProductTable/AdminProductTable';
import 'react-quill/dist/quill.snow.css';
import ProductModal from '../../components/ProductModal/ProductModal';
import { useDispatch, useSelector } from 'react-redux';
import { DispatchType, RootState } from '../../redux/store';
import { getAllProductApi, getAllProductTypeApi, getAllSupplierApi } from '../../redux/reducers/ProductReducer';
import { ProductModelType } from '../../models/ProductModelType';


const ProductManagement = () => {
  const dispatch: DispatchType = useDispatch();
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [selectedProduct, setSelectedProduct] = useState<ProductModelType | null>(null);
  const { arrProduct } = useSelector((state: RootState) => state.productReducer);
  const { arrProductType } = useSelector((state: RootState) => state.productReducer);
  const { arrSupplier } = useSelector((state: RootState) => state.productReducer);

  useEffect(() => {
    dispatch(getAllSupplierApi());
  }, [])

  useEffect(() => {
    dispatch(getAllProductTypeApi());
  }, [])

  useEffect(() => {
    dispatch(getAllProductApi())
  }, [])

  // console.log("type", arrProductType);
  // console.log("supplier", arrSupplier);

  const showModalAddProd = () => {
    setSelectedProduct(null);
    setIsModalOpen(true);
  };

  const showModalUpdate = (product: ProductModelType) => {
    // console.log("Product to update:", product);
    setSelectedProduct(product);
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
      <AdminProductTable
        arrProduct={arrProduct}
        showModalUpdate={showModalUpdate}
      >
      </AdminProductTable>

      <ProductModal
        isOpen={isModalOpen}
        setIsOpen={setIsModalOpen}
        selectedProduct={selectedProduct}
        arrProductType={arrProductType}
        arrSupplier={arrSupplier}
      />

    </>
  )
}

export default ProductManagement