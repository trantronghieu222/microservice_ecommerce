import { Row, Col, Card, Input, Button, Form } from "antd";
const { TextArea } = Input;

const ContactPage = () => {
  return (
    <div style={{ padding: "20px", maxWidth: "900px", margin: "auto" }}>
      <Row gutter={[32, 32]} align="middle">
        {/* Form nhập thông tin */}
        <Col xs={24} md={12}>
          <Card title="Contact Us">
            <Form layout="vertical">
              <Form.Item label="Email" name="email" rules={[{ required: true, type: "email", message: "Please enter a valid email!" }]}>
                <Input placeholder="Enter your email" />
              </Form.Item>

              <Form.Item label="Message" name="message" rules={[{ required: true, message: "Please enter your message!" }]}>
                <TextArea rows={5} placeholder="Enter your message" />
              </Form.Item>

              <Form.Item>
                <Button type="primary" block>
                  Send Message
                </Button>
              </Form.Item>
            </Form>
          </Card>
        </Col>

        {/* Hình ảnh bên phải */}
        <Col xs={24} md={12}>
          <img
            src="/image/contact1.jpg"
            alt="Contact"
            style={{ width: "100%", borderRadius: "8px", objectFit: "cover" }}
          />
        </Col>
      </Row>
    </div>
  );
};

export default ContactPage;