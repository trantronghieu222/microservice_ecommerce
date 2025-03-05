import { Button, Col, Form, Input, message, Modal, Row, Select } from "antd"
import { useForm } from "antd/es/form/Form";
import { DispatchType } from "../../redux/store";
import { useDispatch } from "react-redux";
import { AccountModelType } from "../../models/AccountModelType";
import { useEffect } from "react";
import { addAccountApi, getAllAccountApi } from "../../redux/reducers/AccountReducer";

type Props = {
    isOpen: boolean,
    setIsOpen: (open: boolean) => void,
    selectedAccount: AccountModelType | null
}

const AccountModel = (props: Props) => {
    const { isOpen, setIsOpen, selectedAccount } = props;
    const dispatch: DispatchType = useDispatch();
    const [formAddAccount] = useForm()

    const handleOk = () => {
        formAddAccount.resetFields();
    };

    const handleCancel = () => {
        setIsOpen(false);
    };

    const onFinish = async (values: any) => {
        try {
            const {accountId, ...initialValues} = {
                ...values,
            }
            // console.log(initialValues)
            if (selectedAccount) {
                console.log({...initialValues, accountId})
            }
            else {
                const res = await dispatch(addAccountApi(initialValues));
                if (res) {
                    message.success(res.message);
                    dispatch(getAllAccountApi());
                }
            }
        } catch (error) {
            console.log("Error", error);
        }
    }

    useEffect(() => {
        if (selectedAccount) {
            formAddAccount.setFieldsValue({
                accountId: selectedAccount.accountId,
                username: selectedAccount.username,
                customerName: selectedAccount.customerName,
                customerPhone: selectedAccount.customerPhone,
                customerAddress: selectedAccount.customerAddress,
                customerEmail: selectedAccount.customerEmail,
                role: selectedAccount.role
            })
        }
    })

    return (
        <Modal
            title={selectedAccount ? "Update Account" : "Add Account"}
            open={isOpen}
            onOk={handleOk}
            onCancel={handleCancel}
            footer={[
                <Button key="cancel" type='primary' danger ghost onClick={() => setIsOpen(false)}>
                    Cancel
                </Button>,
                <Button key="ok" type='primary' onClick={() => formAddAccount.submit()}>
                    {selectedAccount ? "Update" : "Add"}
                </Button>,
            ]}
        >
            <Form
                form={formAddAccount}
                name="addProd"
                onFinish={onFinish}
                layout="vertical"
            >
                <Row gutter={[16, 0]}>
                    {/* Id */}
                    <Col xs={24} sm={12} style={{ display: "none" }}>
                        <Form.Item name="accountId">
                            <Input />
                        </Form.Item>
                    </Col>
                    {/* Username */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            label="Username"
                            name="username"
                            rules={[{ required: true, message: "Username can not be blank" }]}
                        >
                            <Input />
                        </Form.Item>
                    </Col>
                    {/* Password */}
                    {/* <Col xs={24} sm={12}>
                        <Form.Item
                            label="Password"
                            name="password"
                            rules={[{ required: true, message: "Password can not be blank" }]}
                        >
                            <Input.Password
                                style={{
                                    padding: "4px 11px",
                                }}
                            />
                        </Form.Item>
                    </Col> */}
                    {
                        selectedAccount ? ""
                            : <Col xs={24} sm={12}>
                                <Form.Item
                                    label="Password"
                                    name="password"
                                    rules={[{ required: true, message: "Password can not be blank" }]}
                                >
                                    <Input.Password
                                        style={{
                                            padding: "4px 11px",
                                        }}
                                    />
                                </Form.Item>
                            </Col>
                    }
                    {/* Name */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            label="Fullname"
                            name="customerName"
                            rules={[{ required: true, message: "fullname can not be blank" }]}
                        >
                            <Input />
                        </Form.Item>
                    </Col>
                    {/* Phone */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            label="Phone number"
                            name="customerPhone"
                            rules={[{ required: true, message: "Phone number can not be blank" }]}
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
                    {/* Supplier */}
                    <Col xs={24} sm={12}>
                        <Form.Item
                            label="Role"
                            name="role"
                            rules={[{ required: true, message: "Role can not be blank" }]}
                        >
                            <Select
                                placeholder="Select a role"
                                optionFilterProp="children"
                                options={[
                                    {
                                        value: "User",
                                        label: "User",
                                    },
                                    {
                                        value: "Admin",
                                        label: "Admin",
                                    }
                                ]}
                            />
                        </Form.Item>
                    </Col>
                </Row>
            </Form>
        </Modal>
    )
}

export default AccountModel