import { Col, Row, Space, Table, TableProps, Tag } from 'antd';
import Search from 'antd/es/transfer/search';

type Props = {}

interface DataType {
    accountId: number;
    username: string;
    customerEmail: string;
    customerPhone: string;
    customerAddress: string;
}

const columns: TableProps<DataType>['columns'] = [
    {
        title: 'Id',
        dataIndex: 'accountId',
        key: 'accountId',
    },
    {
        title: 'Username',
        dataIndex: 'username',
        key: 'username',
    },
    {
        title: 'Email',
        dataIndex: 'customerEmail',
        key: 'customerEmail',
    },
    {
        title: 'Phone',
        dataIndex: 'customerPhone',
        key: 'customerPhone',
    },
    {
        title: 'Address',
        dataIndex: 'customerAddress',
        key: 'customerAddress',
    },
    {
        title: 'Action',
        key: 'action',
        render: () => (
            <Space size="middle">
                <a>Invite</a>
                <a>Delete</a>
            </Space>
        ),
    },
];

const AdminUserTable = (props: Props) => {
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

            <Table<DataType> columns={columns} />
        </div>
    )
}

export default AdminUserTable