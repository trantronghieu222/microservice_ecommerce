import React from "react";
import { Row, Col, Card, Input, Button, Typography, Form, Select } from "antd";

const { Title, Text } = Typography;
const { Option } = Select;

const CheckoutPage = () => {
  return (
    <div style={{ padding: "20px" }}>
      <Row gutter={[32, 32]}>
        {/* Thông tin thanh toán */}
        <Col xs={24} md={12}>
          <Card title="Thông tin thanh toán">
            <Form layout="vertical">
              <Form.Item label="Họ và Tên" name="name" rules={[{ required: true, message: "Vui lòng nhập họ và tên!" }]}> 
                <Input placeholder="Nhập họ và tên" />
              </Form.Item>
              <Form.Item label="Số điện thoại" name="phone" rules={[{ required: true, message: "Vui lòng nhập số điện thoại!" }]}> 
                <Input placeholder="Nhập số điện thoại" />
              </Form.Item>
              <Form.Item label="Địa chỉ" name="address" rules={[{ required: true, message: "Vui lòng nhập địa chỉ!" }]}> 
                <Input placeholder="Nhập địa chỉ" />
              </Form.Item>
              <Form.Item label="Email" name="email" rules={[{ required: true, type: "email", message: "Vui lòng nhập email hợp lệ!" }]}> 
                <Input placeholder="Nhập email" />
              </Form.Item>
              <Form.Item label="Phương thức thanh toán" name="paymentMethod" rules={[{ required: true, message: "Vui lòng chọn phương thức thanh toán!" }]}> 
                <Select placeholder="Chọn phương thức thanh toán">
                  <Option value="credit_card">Thẻ tín dụng</Option>
                  <Option value="bank_transfer">Chuyển khoản ngân hàng</Option>
                  <Option value="cash_on_delivery">Thanh toán khi nhận hàng</Option>
                </Select>
              </Form.Item>
            </Form>
          </Card>
        </Col>
        
        {/* Thông tin đơn hàng */}
        <Col xs={24} md={12}>
          <Card title="Đơn hàng của bạn">
            <div style={{ marginBottom: "10px" }}>
              <Text>Watch 1 x1</Text> <Text strong style={{ float: "right" }}>129000</Text>
            </div>
            <div style={{ marginBottom: "10px" }}>
              <Text>Watch 2 x3</Text> <Text strong style={{ float: "right" }}>120000</Text>
            </div>
            <div style={{ marginBottom: "10px", borderTop: "1px solid #ddd", paddingTop: "10px" }}>
              <Text strong>Tổng cộng:</Text> <Text strong style={{ float: "right", fontSize: "16px" }}>249000</Text>
            </div>
            <Button type="primary" block>
              Tiến hành đặt hàng
            </Button>
          </Card>
        </Col>
      </Row>
    </div>
  );
};

export default CheckoutPage;