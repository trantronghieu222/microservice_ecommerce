import { Row, Col, Card, Typography, Image } from "antd";

const { Title, Paragraph } = Typography;

const AboutPage = () => {
  return (
    <div style={{ padding: "20px" }}>
      <Row gutter={[32, 32]} align="middle">
        {/* Phần hình ảnh */}
        <Col xs={24} md={12}>
          <Image
            src="/image/about1.png"
            alt="Watch Shop"
            style={{ width: "100%", borderRadius: "10px" }}
          />
        </Col>

        {/* Phần nội dung giới thiệu */}
        <Col xs={24} md={12}>
          <Card>
            <Title level={1}>About Our Watch Shop</Title>
            <Paragraph>
              Welcome to our premium watch shop! We take pride in offering high-quality timepieces that blend luxury and functionality. Our collection includes a variety of styles, from classic mechanical watches to modern smartwatches.
            </Paragraph>
            <Paragraph>
              Established in 2020, we have been dedicated to providing our customers with the best service and finest watches. Whether you're looking for a timeless gift or a personal statement piece, we have the perfect watch for you.
            </Paragraph>
            <Paragraph>
              We believe that a watch is more than just a timepiece – it’s a
              statement. That’s why we offer only the finest watches, ensuring
              durability, precision, and style for every customer.
            </Paragraph>
          </Card>
        </Col>
      </Row>
    </div>
  );
};

export default AboutPage;