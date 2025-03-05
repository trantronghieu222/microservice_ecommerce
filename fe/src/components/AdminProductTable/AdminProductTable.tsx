import React, { useEffect, useState } from 'react'
import { Button, Col, Modal, Row, Space, Table, message } from 'antd';
import type { TableProps } from 'antd';
import Search from 'antd/es/transfer/search';
import { ProductModelType } from '../../models/ProductModelType';
import { DispatchType } from '../../redux/store';
import { useDispatch } from 'react-redux';
import { deleteProductApi, getAllProductApi } from '../../redux/reducers/ProductReducer';

type Props = {
    arrProduct: ProductModelType[],
    showModalUpdate: (product: ProductModelType) => void
}

const AdminProductTable = (props: Props) => {
    const dispatch: DispatchType = useDispatch();
    const { arrProduct, showModalUpdate } = props;

    const handleDelete = async (productId: number) => {
        try {
            const messageRes = await dispatch(deleteProductApi(productId));
            dispatch(getAllProductApi());
            message.success(messageRes); // Hiển thị thông báo từ server
        } catch (error) {
            alert("Xóa sản phẩm thất bại!");
        }
    };
    // http://localhost:8080/product-service/images/1741018013017_rolex.png
    const columns: TableProps<ProductModelType>['columns'] = [
        {
            title: 'Id',
            dataIndex: 'productId',
            key: 'productId',
        },
        {
            title: 'Product name',
            dataIndex: 'productName',
            key: 'productName',
        },
        {
            title: 'Image',
            dataIndex: 'productImage',
            key: 'productImage',
            // render: (text) => <img src={`http://localhost:8080/product-service/images/${text}`} alt="Product" style={{ width: 100, height: 100, objectFit: 'cover' }} />
            render: (text) => <img src={text} alt="Product" style={{ width: 100, height: 100, objectFit: 'cover' }} />
        },
        {
            title: 'Product inventory',
            dataIndex: 'productInventory',
            key: 'productInventory',
        },
        {
            title: 'Action',
            key: 'action',
            render: (_, record) => (
                <Space size="middle">
                    {/* Edit */}
                    <Button
                        type='primary'
                        onClick={() => showModalUpdate(record)}
                    >
                        <i className="fa fa-edit"></i>
                    </Button>

                    {/* Delete */}
                    <Button
                        type="primary"
                        danger
                        onClick={() => {
                            Modal.confirm({
                                title: "Xác nhận xóa",
                                content: "Bạn có chắc chắn muốn xóa sản phẩm này?",
                                okText: "Xóa",
                                cancelText: "Hủy",
                                onOk: () => handleDelete(record.productId),
                            });
                        }}
                    >
                        <i className="fa fa-trash"></i>
                    </Button>
                </Space>
            ),
        },
    ];

    return (
        <div>
            {/* Search */}
            <Row style={{ marginBottom: 16 }}>
                <Col xs={24}>
                    <Search
                        placeholder="Nhập tên sản phẩm cần tìm"
                    />
                </Col>
            </Row>

            <Table<ProductModelType> columns={columns} dataSource={arrProduct} />
        </div>
    )
}

export default AdminProductTable