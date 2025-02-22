import { Card, Input, Button, Form } from "antd";

const ProfilePage = () => {
  return (
    <div style={{ padding: "20px", maxWidth: "600px", margin: "auto" }}>
      <Card title="Profile Information">
        <Form layout="vertical">
          <Form.Item label="Full Name" name="fullname" rules={[{ required: true, message: "Please enter your full name!" }]}>
            <Input placeholder="Enter your full name" />
          </Form.Item>

          <Form.Item label="Email" name="email" rules={[{ required: true, type: "email", message: "Please enter a valid email!" }]}>
            <Input placeholder="Enter your email" />
          </Form.Item>

          <Form.Item label="Phone" name="phone" rules={[{ required: true, message: "Please enter your phone number!" }]}>
            <Input placeholder="Enter your phone number" />
          </Form.Item>

          <Form.Item label="Address" name="address" rules={[{ required: true, message: "Please enter your address!" }]}>
            <Input placeholder="Enter your address" />
          </Form.Item>

          <Form.Item>
            <Button type="primary" style={{ marginRight: "10px" }}>
              Save
            </Button>
            <Button type="default">Change Password</Button>
          </Form.Item>
        </Form>
      </Card>
    </div>
  );
};

export default ProfilePage;
