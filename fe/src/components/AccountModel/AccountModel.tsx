import { Button, Col, Form, Input, Modal, Row } from "antd"
import { useForm } from "antd/es/form/Form";

type Props = {
    isOpen: boolean,
    setIsOpen: (open: boolean) => void,
    role: string;
    titleModal: string;
} 

const AccountModel = ({ isOpen, setIsOpen, role, titleModal }: Props) => {
    const [formAddUser] = useForm()

    const handleOk = () => {
        formAddUser.resetFields();
    };

    const handleCancel = () => {
        setIsOpen(false);
    };

    const onFinish = (values: any) => {
        const initialValues = {
            ...values,
            role: role,
        }
        console.log(initialValues)
    }

    return (
        <Modal
            title={titleModal}
            open={isOpen}
            onOk={handleOk}
            onCancel={handleCancel}
            footer={[
                <Button key="cancel" type='primary' danger ghost onClick={() => setIsOpen(false)}>
                    Cancel
                </Button>,
                <Button key="ok" type='primary' onClick={() => formAddUser.submit()}>
                    {titleModal}
                </Button>,
            ]}
        >
            <Form
                form={formAddUser}
                name="addProd"
                onFinish={onFinish}
                layout="vertical"
            >
                <Row gutter={[16, 0]}>
                    {/* Username */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            label="Username"
                            name="username"
                            rules={[{required: true, message: "Username can not be blank"}]}
                        >
                            <Input />
                        </Form.Item>
                    </Col>
                    {/* Password */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            label="Password"
                            name="password"
                            rules={[{required: true, message: "Password can not be blank"}]}
                        >
                            <Input.Password />
                        </Form.Item>
                    </Col>
                    {/* Name */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            label="Fullname"
                            name="customerName"
                            rules={[{required: true, message: "fullname can not be blank"}]}
                        >
                            <Input />
                        </Form.Item>
                    </Col>
                    {/* Phone */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            label="Phone number"
                            name="customerPhone"
                            rules={[{required: true, message: "Phone number can not be blank"}]}
                        >
                            <Input />
                        </Form.Item>
                    </Col>
                    {/* Address */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            label="Address"
                            name="customerAddress"
                            rules={[{ required: true, message: "Address can not be blank" }]}
                        >
                            <Input />
                        </Form.Item>
                    </Col>
                    {/* Email */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            label="Email"
                            name="customerEmail"
                            rules={[{ required: true, message: "Email can not be blank" }]}
                        >
                            <Input />
                        </Form.Item>
                    </Col> 
                </Row>
            </Form>
        </Modal>
    )
}

export default AccountModel