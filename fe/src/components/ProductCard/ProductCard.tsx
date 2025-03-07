import React from "react";
import { Card, Typography } from "antd";
import { NavLink } from "react-router-dom";
import { ProductModelType } from "../../models/ProductModelType";

const { Title, Text, Paragraph } = Typography;

type Props = {
    product: ProductModelType;
};

const ProductCard = (props: Props) => {
    const { product } = props;

    return (
        <NavLink to={`/detail/${product.productId}`} style={{ textDecoration: "none" }}>
            <Card
                hoverable
                cover={
                    <img
                        src={product.productImage}
                        alt={product.productName}
                        style={{ height: "200px", objectFit: "cover" }}
                    />
                }
                style={{ width: 300 }}
            >
                <Title level={5}>{product.productName}</Title>
                {/* <Paragraph style={{ fontWeight: "normal" }}>
                    <span dangerouslySetInnerHTML={{ __html: product.productDescription }} />
                </Paragraph> */}
                <Text delete style={{ marginRight: 10, color: "#888" }}>
                    ${product.productSaleprice}
                </Text>
                <Text strong style={{ color: "#e63946" }}>
                    ${product.productInprice}
                </Text>
            </Card>
        </NavLink>
    );
};

export default ProductCard;
