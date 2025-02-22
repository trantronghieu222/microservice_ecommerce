import React from 'react'
import { Col, Row, Space, Table, Tag } from 'antd';
import type { TableProps } from 'antd';
import Search from 'antd/es/transfer/search';

type Props = {}

interface DataType {
    key: string;
    name: string;
    age: number;
    address: string;
    tags: string[];
}

const columns: TableProps<DataType>['columns'] = [
    {
        title: 'Id',
        dataIndex: 'id',
        key: 'id',
    },
    {
        title: 'Product name',
        dataIndex: 'product_name',
        key: 'product_name',
    },
    {
        title: 'Image',
        dataIndex: 'image',
        key: 'image',
    },
    {
        title: 'Product inventory',
        dataIndex: 'product_inventory',
        key: 'product_inventory',
    },
    {
        title: 'Supplier name',
        key: 'supplier_name',
        dataIndex: 'supplier_name',
        render: (_, { tags }) => (
            <>
                {tags.map((tag) => {
                    let color = tag.length > 5 ? 'geekblue' : 'green';
                    if (tag === 'loser') {
                        color = 'volcano';
                    }
                    return (
                        <Tag color={color} key={tag}>
                            {tag.toUpperCase()}
                        </Tag>
                    );
                })}
            </>
        ),
    },
    {
        title: 'Action',
        key: 'action',
        render: (_, record) => (
            <Space size="middle">
                <a>Invite {record.name}</a>
                <a>Delete</a>
            </Space>
        ),
    },
];

const AdminProductTable = (props: Props) => {
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

            <Table<DataType> columns={columns} />
        </div>
    )
}

export default AdminProductTable