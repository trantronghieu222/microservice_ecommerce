import { createSlice, PayloadAction } from '@reduxjs/toolkit'
import { CartModelType } from '../../models/CartModelType';
import { DispatchType } from '../store';
import { getDataJsonStorage } from '../../util/utilMethod';

export interface CartStateType {
    arrCart: CartModelType[]
}

const initialState: CartStateType = {
    arrCart: []
}

const CartReducer = createSlice({
    name: "CartReducer",
    initialState,
    reducers: {
        setArrCartAction(state: CartStateType, action: PayloadAction<CartModelType[]>) {
            state.arrCart = action.payload;
        }
    }
});

export const { setArrCartAction } = CartReducer.actions

export default CartReducer.reducer

// ---
export const getAllCart = () => {
    return (dispatch: DispatchType) => {
        // Lấy dữ liệu giỏ hàng từ localStorage
        const cart = (getDataJsonStorage("cart") || "[]");
        // Cập nhật vào Redux store
        const action: PayloadAction<CartModelType[]> = setArrCartAction(cart);
        dispatch(action);
    };
};
