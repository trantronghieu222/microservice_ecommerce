import React from 'react'
import { LockOutlined, UserOutlined, MailOutlined, IdcardOutlined, PhoneOutlined } from '@ant-design/icons';
import {
    Button,
    Form,
    Input,
} from 'antd';
import { NavLink } from 'react-router-dom';
type Props = {}

const RegisterPage = (props: Props) => {
    return (
        <Form
            className="loginForm"
            // form={form}
            name="register"
            // onFinish={userRegister}
            scrollToFirstError
        >
            <p className="formTitle">ĐĂNG KÝ</p>

            <Form.Item
                name="taiKhoan"
                rules={[{ required: true, message: 'Không được để trống tài khoản!' }]}
            >
                <Input prefix={<UserOutlined />} placeholder="Tài khoản" className="antInput" />
            </Form.Item>

            <Form.Item
                name="matKhau"
                rules={[
                    { required: true, message: 'Không được để trống mật khẩu!' },
                    { min: 6, max: 20, message: 'Mật khẩu phải từ 6 đến 20 ký tự!' },
                ]}
                hasFeedback
            >
                <Input.Password prefix={<LockOutlined />} placeholder='Mật khẩu' className="antInput" />
            </Form.Item>

            <Form.Item
                name="xacNhanMatKhau"
                dependencies={['matKhau']}
                hasFeedback
                rules={[
                    { required: true, message: 'Không được để trống mật khẩu!' },
                    ({ getFieldValue }) => ({
                        validator(_, value) {
                            if (!value || getFieldValue('matKhau') === value) {
                                return Promise.resolve();
                            }
                            return Promise.reject(new Error('Mật khẩu không trùng khớp!'));
                        },
                    }),
                ]}
            >
                <Input.Password prefix={<LockOutlined />} placeholder='Nhập lại mật khẩu' className="antInput" />
            </Form.Item>

            <Form.Item
                name="hoTen"
                rules={[{ required: true, message: 'Không được để trống họ tên!', whitespace: true }]}
            >
                <Input placeholder='Họ tên' prefix={<IdcardOutlined />} className="antInput" />
            </Form.Item>

            <Form.Item
                name="email"
                rules={[
                    { type: 'email', message: 'Email không chính xác!' },
                    { required: true, message: 'Email không được để trống!' },
                ]}
            >
                <Input placeholder='Email' prefix={<MailOutlined />} className="antInput" />
            </Form.Item>

            <Form.Item
                name="soDT"
                rules={[
                    { required: true, message: 'Số điện thoại không được để trống!' },
                    // { pattern: /^[0-9]+$/, message: 'Số điện thoại không hợp lệ!' },
                    {
                        validator: (_, value) => {
                            if (!value) {
                                return Promise.resolve();
                            }
                            if (!/^[0-9]+$/.test(value)) {
                                return Promise.reject(new Error('Số điện thoại không hợp lệ!'));
                            }
                            if (value.length < 7 || value.length > 11) {
                                return Promise.reject(new Error('Số điện thoại phải từ 7 - 11 chữ số!'));
                            }
                            return Promise.resolve();
                        }
                    }
                ]}
            >
                <Input placeholder='Số điện thoại' prefix={<PhoneOutlined />} className="antInput" />
            </Form.Item>

            <Form.Item>
                <Button type="primary" htmlType="submit" className="loginFormButton antBtn">
                    ĐĂNG KÝ
                </Button>
            </Form.Item>
            Đã có tài khoản? <NavLink to="/auth/login" className="loginRegis">Đăng nhập</NavLink>
        </Form>
    )
}

export default RegisterPage