import { createSlice, PayloadAction } from '@reduxjs/toolkit'
import { ProductModelType } from '../../models/ProductModelType';
import { DispatchType } from '../store';
import axios from 'axios';
import { ProductTypeModel } from '../../models/ProductTypeModel';
import { SupplierModelType } from '../../models/SupplierModelType';

export interface ProductStateType {
    arrProduct: ProductModelType[],
    arrProductType: ProductTypeModel[],
    arrSupplier: SupplierModelType[],
    productDetail: ProductModelType | null,
}

const initialState: ProductStateType = {
    arrProduct: [],
    arrProductType: [],
    arrSupplier: [],
    productDetail: null 
}

const ProductReducer = createSlice({
    name: "ProductReducer",
    initialState,
    reducers: {
        setArrProductAction(state: ProductStateType, action: PayloadAction<ProductModelType[]>) {
            state.arrProduct = action.payload;
        },

        setArrProductTypeAction(state: ProductStateType, action: PayloadAction<ProductTypeModel[]>) {
            state.arrProductType = action.payload;
        },

        setProductDetailAction(state: ProductStateType, action: PayloadAction<ProductModelType>){
            state.productDetail = action.payload;
        },

        setArrSupplierAction(state: ProductStateType, action: PayloadAction<SupplierModelType[]>) {
            state.arrSupplier = action.payload;
        }
    }
});

export const { setArrProductAction, setArrProductTypeAction, setArrSupplierAction, setProductDetailAction } = ProductReducer.actions

export default ProductReducer.reducer

/* -------------------------------------------------------------------------------------------------------- */
// Product --
export const getAllProductApi = () => {
    return async (dispatch: DispatchType) => {
        const res = await axios.get("http://localhost:8080/product-service/product");
        const action: PayloadAction<ProductModelType[]> = setArrProductAction(res.data.content);
        dispatch(action);
    }
}

export const getAllProductPagingApi = (pageIndex: number, pageSize: number) => {
    return async (dispatch: DispatchType) => {
        const res = await axios.get(`http://localhost:8080/product-service/product/search-paging?pageIndex=${pageIndex}&pageSize=${pageSize}`);
        
        const { content } = res.data;
        
        // Dispatch danh sách sản phẩm
        const action: PayloadAction<ProductModelType[]> = setArrProductAction(content.content);
        dispatch(action);

        return {
            totalItems: content.totalItems,
            totalPages: content.totalPages,
            currentPage: content.currentPage
        };
    };
};

export const getProductByIdApi = (id: number) => {
    return async (dispatch: DispatchType) => {
        const res = await axios.get(`http://localhost:8080/product-service/product/${id}`);
        const action: PayloadAction<ProductModelType> = setProductDetailAction(res.data.content)
        dispatch(action);
    }
}

export const createProductApi = (product: Object) => {
    return async (dispatch: DispatchType) => {
        const res = await axios.post("http://localhost:8080/product-service/product", product);
        return res.data;
    }
}

export const updateProductApi = (product: Object) => {
    return async (dispatch: DispatchType) => {
        const res = await axios.put("http://localhost:8080/product-service/product", product);
        return res.data;
    }
}

export const deleteProductApi = (productId: number) => {
    return async (dispatch: DispatchType) => {
        try {
            const res = await axios.delete(`http://localhost:8080/product-service/product/${productId}`);
            // const productRes = await axios.get("http://localhost:8080/product-service/product");
            // dispatch(setArrProductAction(productRes.data.content));
            return res.data.message;
        } catch (error) {
            console.error("Lỗi khi xóa sản phẩm:", error);
            throw error;
        }
    }
}

export const uploadProductImageApi = (id: number, formData: FormData) => {
    return async (dispatch: DispatchType) => {
        try {
            const res = await axios.post(`http://localhost:8080/product-service/product/upload-image-cloud/${id}`, formData, {
                headers: { "Content-Type": "multipart/form-data" },
            });
            return res.data;
        } catch (error) {
            console.error("Lỗi khi upload ảnh!", error);
        }
    }
}



// Product type
export const getAllProductTypeApi = () => {
    return async (dispatch: DispatchType) => {
        const res = await axios.get("http://localhost:8080/product-service/productType");
        const action: PayloadAction<ProductTypeModel[]> = setArrProductTypeAction(res.data.content);
        dispatch(action);
    }
}

// Supplier
export const getAllSupplierApi = () => {
    return async (dispatch: DispatchType) => {
        const res = await axios.get("http://localhost:8080/product-service/supplier");
        const action: PayloadAction<SupplierModelType[]> = setArrSupplierAction(res.data.content);
        dispatch(action);
    }
}