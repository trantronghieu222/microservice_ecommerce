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
} from 'antd';
import ReactQuill from 'react-quill';
import 'react-quill/dist/quill.snow.css';

type Props = {
    isOpen: boolean;
    setIsOpen: (open: boolean) => void;
};

const normFile = (e: any) => {
    console.log('Upload event:', e);
    if (Array.isArray(e)) {
        return e;
    }
    return e?.fileList;
};

const onFinish = (values: any) => {
    const initialValues = {
        ...values,
        productImage: values.productImage[0]
    }
    console.log(initialValues)
};
const ProductModal = ({ isOpen, setIsOpen }: Props) => {
    const [formAddProd] = Form.useForm();

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
            title="ADD PRODUCT"
            open={isOpen}
            onOk={handleOk}
            onCancel={handleCancel}
            footer={[
                <Button key="cancel" type='primary' danger ghost onClick={() => setIsOpen(false)}>
                    Cancel
                </Button>,
                <Button key="ok" type='primary' onClick={() => formAddProd.submit()}>
                    Add Product
                </Button>,
            ]}
        >
            <Form
                form={formAddProd}
                name="addProd"
                onFinish={onFinish}
                layout="vertical"
            >
                <Row gutter={[16, 0]}>
                    {/* Tên sản phẩm */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            label="Product name"
                            name="productName"
                            rules={[{required: true, message: "Product name can not be blank"}]}
                        >
                            <Input />
                        </Form.Item>
                    </Col>
                    {/* Tồn kho */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            label="Product inventory"
                            name="productInventory"
                            rules={[{required: true, message: "Product inventory can not be blank"}]}
                        >
                            <InputNumber style={{ width: '100%' }} />
                        </Form.Item>
                    </Col>
                    {/* Bảo hành */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            label="Warranty"
                            name="productWarranty"
                            rules={[{required: true, message: "Warrent Warranty can not be blank"}]}
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
                                options={[
                                    {
                                        value: 'jack',
                                        label: 'Jack',
                                    },
                                    {
                                        value: 'lucy',
                                        label: 'Lucy',
                                    },
                                    {
                                        value: 'tom',
                                        label: 'Tom',
                                    },
                                ]}
                            />
                        </Form.Item>
                    </Col>
                    {/* Supplier */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            label="Product type"
                            name="typeId"
                            rules={[{ required: true, message: "Product type cannot be blank" }]}
                        >
                            <Select
                                showSearch
                                placeholder="Select a type"
                                optionFilterProp="label"
                                onChange={onTypeChange}
                                onSearch={onTypeSearch}
                                options={[
                                    {
                                        value: 'jack',
                                        label: 'Jack',
                                    },
                                    {
                                        value: 'lucy',
                                        label: 'Lucy',
                                    },
                                    {
                                        value: 'tom',
                                        label: 'Tom',
                                    },
                                ]}
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
                            rules={[{ required: true, message: "Image cannot be blank" }]}
                        >
                            <Upload name="logo" beforeUpload={() => false} listType="picture">
                                <Button icon={<UploadOutlined />}>Choose image</Button>
                            </Upload>
                        </Form.Item>
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