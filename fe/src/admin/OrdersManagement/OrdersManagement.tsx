import { useDispatch, useSelector } from 'react-redux';
import AdminOrdersTable from '../../components/AdminOrdersTable/AdminOrdersTable';
import { DispatchType, RootState } from '../../redux/store';
import { useEffect, useState } from 'react';
import { getAllOrderApi } from '../../redux/reducers/OrderReducer';
import OrderStatusModal from '../../components/OrderModal/OrderStatusModal';
import { OrderModelType } from '../../models/OrderModelType';

type Props = {}

const OrdersManagement = (props: Props) => {
  const dispatch: DispatchType = useDispatch();
  const { arrOrder } = useSelector((state: RootState) => state.orderReducer);
  const [isStatusModalOpen, setIsStatusModalOpen] = useState(false);
  const [selectedOrder, setSelectedOrder] = useState<OrderModelType | null>(null);


  useEffect(() => {
    dispatch(getAllOrderApi())
  }, [])

  const showStatusModal = (order: OrderModelType) => {
    setSelectedOrder(order);
    setIsStatusModalOpen(true);
  };


  return (
    <>
      {/* Title */}
      <div className='py-3'>
        <h3>Order Management</h3>
      </div>

      {/* Body */}
      <AdminOrdersTable
        arrOrder={arrOrder}
        showStatusModal={showStatusModal}
      >
      </AdminOrdersTable>

      {/* Update modal */}
      <OrderStatusModal
        isOpen={isStatusModalOpen}
        setIsOpen={setIsStatusModalOpen}
        selectedOrder={selectedOrder}
      >
      </OrderStatusModal>
    </>
  )
}

export default OrdersManagement