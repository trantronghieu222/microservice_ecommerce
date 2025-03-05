import { Button, Col, Row, Space, Table, TableProps, Tag } from 'antd';
import Search from 'antd/es/transfer/search';
import { AccountModelType } from '../../models/AccountModelType';

type Props = {
    arrAccount: AccountModelType[],
    showUpdateModel: (account: AccountModelType) => void
}

const AdminUserTable = (props: Props) => {
    const { arrAccount, showUpdateModel } = props;

    const columns: TableProps<AccountModelType>['columns'] = [
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
            render: (_, record) => (
                <Space size="middle">
                    <Button
                        type='primary'
                        onClick={() => showUpdateModel(record)}
                    ><i className="fa fa-edit"></i></Button>

                    <Button
                        type='primary'
                        danger
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
                        placeholder="Nhập mã đơn hàng"
                    />
                </Col>
            </Row>

            <Table<AccountModelType> columns={columns} dataSource={arrAccount} />
        </div>
    )
}

export default AdminUserTable