import { configureStore } from "@reduxjs/toolkit";
import orderReducer from "./reducers/OrderReducer";
export const store = configureStore({
    reducer:{
        orderReducer
    }
})

export type RootState = ReturnType<typeof store.getState>
export type DispatchType = typeof store.dispatch
export type GetStateMethodType = typeof store.getState