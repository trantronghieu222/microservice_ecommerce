import { createSlice, PayloadAction } from '@reduxjs/toolkit'
import { OrderModelType } from '../../models/OrderModelType';
import { DispatchType } from '../store';
import axios from 'axios';

export interface OrderStateType {
  arrOrder: OrderModelType[]
}

const initialState: OrderStateType = {
  arrOrder: [],
}

const OrderReducer = createSlice({
  name: "OrderReducer",
  initialState,
  reducers: {
    setArrOrderAction: (state: OrderStateType, action: PayloadAction<OrderModelType[]>) => {
      state.arrOrder = action.payload
    }
  }
});

export const { setArrOrderAction } = OrderReducer.actions

export default OrderReducer.reducer


/* -------------------------------------------------------------------------------------------------------- */
export const getAllOrderApi = () => {
  return async(dispatch: DispatchType) => {
    const res = await axios.get("http://localhost:8080/order-service/orders");
    const action: PayloadAction<OrderModelType[]> = setArrOrderAction(res.data);
    dispatch(action);
  }
}