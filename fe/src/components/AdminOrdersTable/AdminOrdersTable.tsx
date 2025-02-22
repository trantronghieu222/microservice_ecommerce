import React from 'react'
import { Col, Row, Space, Table, TableProps, Tag } from 'antd';
import Search from 'antd/es/transfer/search';

type Props = {}

interface DataType {
    orderId: number;
    customerId: number;
    orderDate: string;
    totalAmount: number;
    orderStatus: string;
}

const columns: TableProps<DataType>['columns'] = [
    {
        title: 'Order Id',
        dataIndex: 'orderId',
        key: 'orderId',
    },
    {
        title: 'Customer Id',
        dataIndex: 'customerId',
        key: 'customerId',
    },
    {
        title: 'Order Date',
        dataIndex: 'orderDate',
        key: 'orderDate',
    },
    {
        title: 'Total Amount',
        dataIndex: 'totalAmount',
        key: 'totalAmount',
    },
    {
        title: 'Order Status',
        key: 'orderStatus',
        dataIndex: 'orderStatus',
        render: (_, { orderStatus }) => {
            let color = 'green';

            if (orderStatus === 'loser') {
                color = 'volcano';
            } else if (orderStatus === 'pending') {
                color = 'orange';
            } else if (orderStatus === 'completed') {
                color = 'blue';
            }

            return (
                <Tag color={color} key={orderStatus}>
                    {orderStatus.toUpperCase()}
                </Tag>
            );
        },
    },
    {
        title: 'Action',
        key: 'action',
        render: (_, record) => (
            <Space size="middle">
                <a>View</a>
            </Space>
        ),
    },
];


const AdminOrdersTable = (props: Props) => {
    return (
        <div>
            {/* Search */}
            <Row style={{ marginBottom: 16 }}>
                <Col xs={24}>
                    <Search
                        placeholder="Nhập mã đơn hàng"
                    />
                </Col>
            </Row>

            <Table<DataType> columns={columns}/>
        </div>
    )
}

export default AdminOrdersTable