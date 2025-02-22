import { useDispatch, useSelector } from 'react-redux';
import AdminOrdersTable from '../../components/AdminOrdersTable/AdminOrdersTable';
import { DispatchType, RootState } from '../../redux/store';
import { useEffect } from 'react';
import { getAllOrderApi } from '../../redux/reducers/OrderReducer';

type Props = {}

const OrdersManagement = (props: Props) => {
  const dispatch: DispatchType = useDispatch()
  const {arrOrder} = useSelector((state: RootState) => state.orderReducer);
  
  useEffect(() => {
    dispatch(getAllOrderApi())
  })

  console.log(arrOrder)

  return (
    <>
      {/* Title */}
      <div className='py-3'>
        <h3>Order Management</h3>
      </div>

      {/* Body */}
      <AdminOrdersTable></AdminOrdersTable>
    </>
  )
}

export default OrdersManagement