import { UploadOutlined } from '@ant-design/icons';
import {
    Button,
    Modal,
    DatePicker,
    Form,
    Input,
    InputNumber,
    Col,
    Row,
    Select,
    Upload,
    message,
} from 'antd';
import ReactQuill from 'react-quill';
import 'react-quill/dist/quill.snow.css';
import { ProductTypeModel } from '../../models/ProductTypeModel';
import { SupplierModelType } from '../../models/SupplierModelType';
import { createProductApi, getAllProductApi, updateProductApi, uploadProductImageApi } from '../../redux/reducers/ProductReducer';
import { DispatchType } from '../../redux/store';
import { useDispatch } from 'react-redux';
import moment from "moment";
import { ProductModelType } from '../../models/ProductModelType';
import { useEffect } from 'react';

type Props = {
    isOpen: boolean,
    setIsOpen: (open: boolean) => void,
    selectedProduct: ProductModelType | null;
    arrProductType: ProductTypeModel[],
    arrSupplier: SupplierModelType[],
};



const ProductModal = (props: Props) => {
    const dispatch: DispatchType = useDispatch();
    const [formAddProd] = Form.useForm();
    const { isOpen, setIsOpen, selectedProduct, arrProductType, arrSupplier } = props;

    const normFile = (e: any) => {
        console.log('Upload event:', e);
        if (Array.isArray(e)) {
            return e;
        }
        return e?.fileList;
    };

    const onFinish = async (values: any) => {
        try {
            const { productId, productImage, ...initialValues } = {
                ...values,
                productWarranty: moment(values.productWarranty).format("DD-MM-YYYY"),
            }
            // Update
            if (selectedProduct) {
                const resProd = await dispatch(updateProductApi({ ...initialValues, productId, deleted: false, productImage: selectedProduct.productImage }));
                dispatch(getAllProductApi());

                if (resProd && resProd?.content?.productId && productImage) {
                    const formData = new FormData();
                    formData.append("file", productImage[0].originFileObj);
                    const uploadImg = await dispatch(uploadProductImageApi(productId, formData));
                    // message.success(uploadImg.message)
                }

                message.success(resProd.message);
            } // Thêm SP
            else {
                const resProd = await dispatch(createProductApi(initialValues));
                dispatch(getAllProductApi());

                if (resProd && resProd?.content?.productId && productImage) {
                    const formData = new FormData();
                    formData.append("file", productImage[0].originFileObj);
                    const uploadImg = await dispatch(uploadProductImageApi(resProd.content.productId, formData));
                    // message.success(uploadImg.message)
                }
                console.log(initialValues)
                message.success(resProd.message);
            }
        } catch (error) {
            message.error("Lỗi!");
        }
    };

    useEffect(() => {
        if (selectedProduct) {
            formAddProd.setFieldsValue({
                productId: selectedProduct.productId,
                productName: selectedProduct.productName,
                productInventory: selectedProduct.productInventory,
                productWarranty: moment(selectedProduct.productWarranty, "DD-MM-YYYY"),
                productInprice: selectedProduct.productInprice,
                productSaleprice: selectedProduct.productSaleprice,
                supplierId: selectedProduct.supplierId,
                productTypeId: selectedProduct.productTypeId,
                productDescription: selectedProduct.productDescription,
            });
        } else {
            formAddProd.resetFields(); // Xóa dữ liệu khi thêm mới
        }
    }, [selectedProduct]);


    const handleOk = () => {
        setIsOpen(false);
    };

    const handleCancel = () => {
        setIsOpen(false);
    };

    const onSupplierChange = (value: string) => {
        console.log(`selected ${value}`);
    };

    const onSupplierSearch = (value: string) => {
        console.log('search:', value);
    };

    const onTypeChange = (value: string) => {
        console.log(`selected ${value}`);
    };

    const onTypeSearch = (value: string) => {
        console.log('search:', value);
    };
    return (
        <Modal
            // title="ADD PRODUCT"
            title={selectedProduct ? "Update Product" : "Add Product"}
            open={isOpen}
            onOk={handleOk}
            onCancel={handleCancel}
            footer={[
                <Button key="cancel" type='primary' danger ghost onClick={() => setIsOpen(false)}>
                    Cancel
                </Button>,
                <Button key="ok" type='primary' onClick={() => formAddProd.submit()}>
                    {selectedProduct ? "Update" : "Add"}
                </Button>
            ]}
        >
            <Form
                form={formAddProd}
                name="addProd"
                onFinish={onFinish}
                layout="vertical"
            >
                <Row gutter={[16, 0]}>
                    {/* Mã sản phẩm */}
                    <Col xs={24} sm={12} style={{ display: "none" }}>
                        <Form.Item name="productId">
                            <Input />
                        </Form.Item>
                    </Col>
                    {/* Tên sản phẩm */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            label="Product name"
                            name="productName"
                            rules={[{ required: true, message: "Product name can not be blank" }]}
                        >
                            <Input />
                        </Form.Item>
                    </Col>
                    {/* Tồn kho */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            label="Product inventory"
                            name="productInventory"
                            rules={[{ required: true, message: "Product inventory can not be blank" }]}
                        >
                            <InputNumber style={{ width: '100%' }} />
                        </Form.Item>
                    </Col>
                    {/* Bảo hành */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            label="Warranty"
                            name="productWarranty"
                            rules={[{ required: true, message: "Warrent Warranty can not be blank" }]}
                        >
                            <DatePicker style={{ width: '100%' }} />
                        </Form.Item>
                    </Col>
                    {/* Inprice */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            label="Product inprice"
                            name="productInprice"
                            rules={[{ required: true, message: "Product in price can not be blank" }]}
                        >
                            <Input />
                        </Form.Item>
                    </Col>
                    {/* sale price */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            label="Product saleprice"
                            name="productSaleprice"
                            rules={[{ required: true, message: "Product sale price can not be blank" }]}
                        >
                            <Input />
                        </Form.Item>
                    </Col>
                    {/* Supplier */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            label="Supplier"
                            name="supplierId"
                            rules={[{ required: true, message: "Supplier can not be blank" }]}
                        >
                            <Select
                                showSearch
                                placeholder="Select supplier"
                                optionFilterProp="label"
                                onChange={onSupplierChange}
                                onSearch={onSupplierSearch}
                                options={
                                    arrSupplier?.map(supplier => ({
                                        value: supplier.supplierId,
                                        label: supplier.supllierName
                                    }))
                                }
                            />
                        </Form.Item>
                    </Col>
                    {/* Supplier */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            label="Product type"
                            name="productTypeId"
                            rules={[{ required: true, message: "Product type cannot be blank" }]}
                        >
                            <Select
                                showSearch
                                placeholder="Select a type"
                                optionFilterProp="label"
                                onChange={onTypeChange}
                                onSearch={onTypeSearch}
                                options={
                                    arrProductType.map(productType => ({
                                        value: productType.productTypeId,
                                        label: productType.productTypeName
                                    }))
                                }
                            />
                        </Form.Item>
                    </Col>
                    {/* Hình ảnh */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            name="productImage"
                            label="Product image"
                            valuePropName="fileList"
                            getValueFromEvent={normFile}
                        // rules={[{ required: true, message: "Image cannot be blank" }]}
                        >
                            <Upload name="logo" beforeUpload={() => false} listType="picture">
                                <Button icon={<UploadOutlined />}>Choose image</Button>
                            </Upload>
                        </Form.Item>
                        {/* {selectedProduct ? <img src={`http://localhost:8080/product-service/images/${selectedProduct.productImage}`} alt="Product" style={{ width: 100, height: 100, objectFit: 'cover' }}></img> : ""} */}
                        {selectedProduct ? <img src={selectedProduct.productImage} alt="Product" style={{ width: 100, height: 100, objectFit: 'cover' }}></img> : ""}
                    </Col>
                    {/* Description */}
                    <Col xs={24} sm={24}>
                        <Form.Item
                            label="Description"
                            name="productDescription"
                            rules={[{ required: true, message: 'Description cannot be blank' }]}
                        >
                            <ReactQuill style={{ height: '200px' }} />
                        </Form.Item>
                    </Col>
                </Row>
            </Form>
        </Modal>
    )
}

export default ProductModal