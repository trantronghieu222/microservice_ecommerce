import { Button, Col, Row, Space, Table, TableProps, Tag } from 'antd';
import Search from 'antd/es/transfer/search';
import { OrderModelType } from '../../models/OrderModelType';

type Props = {
    arrOrder: OrderModelType[]
    showStatusModal: (order: OrderModelType) => void
}

const AdminOrdersTable = (props: Props) => {
    const { arrOrder, showStatusModal } = props;
    // console.log("arrOrder: ", arrOrder)

    const columns: TableProps<OrderModelType>['columns'] = [
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
                let color = 'gray'; // Mặc định

                switch (orderStatus.toLowerCase()) {
                    case 'pending':
                        color = 'orange'; // Đang chờ xử lý
                        break;
                    case 'processing':
                        color = 'blue'; // Đang xử lý
                        break;
                    case 'shipped':
                        color = 'purple'; // Đã vận chuyển
                        break;
                    case 'delivered':
                        color = 'green'; // Đã giao hàng
                        break;
                    case 'cancelled':
                        color = 'red'; // Đã hủy
                        break;
                    default:
                        color = 'gray'; // Trạng thái không xác định
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
                    {/* Detail */}
                    <Button
                        type='dashed'
                    >
                        <i className="fa fa-file-alt"></i>
                    </Button>
                    {/* Edit */}
                    <Button
                        type='primary'
                        onClick={() => showStatusModal(record)}
                    >
                        <i className="fa fa-edit"></i>
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
                        placeholder="Nhập mã đơn hàng"
                    />
                </Col>
            </Row>

            <Table<OrderModelType> columns={columns} dataSource={arrOrder} />
        </div>
    )
}

export default AdminOrdersTable