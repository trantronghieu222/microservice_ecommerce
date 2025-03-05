import {
    Button,
    Modal,
    Form
} from 'antd';
import 'react-quill/dist/quill.snow.css';
import { OrderModelType } from '../../models/OrderModelType';

type Props = {
    isOpen: boolean,
    setIsOpen: (open: boolean) => void,
    selectedOrder: OrderModelType | null
};

const OrderStatusModal = (props: Props) => {
    const [formUpdateStatus] = Form.useForm();
    const { isOpen, setIsOpen, selectedOrder } = props;
    console.log("aa", selectedOrder)
    const onFinish = async (values: any) => {
        const initialValues = {
            ...values,
        }
        console.log(initialValues)
    };


    const handleOk = () => {
        setIsOpen(false);
    };

    const handleCancel = () => {
        setIsOpen(false);
    };

    return (
        <Modal
            title="Update Status"
            open={isOpen}
            onOk={handleOk}
            onCancel={handleCancel}
            footer={[
                <Button key="cancel" type='primary' danger ghost onClick={() => setIsOpen(false)}>
                    Cancel
                </Button>,
                <Button key="ok" type='primary' onClick={() => formUpdateStatus.submit()}>
                    Update
                </Button>
            ]}
        >
            <Form
                form={formUpdateStatus}
                name="addProd"
                onFinish={onFinish}
                layout="vertical"
            >
                
            </Form>
        </Modal>
    )
}

export default OrderStatusModal