// import React from "react";
// import { Card, Typography } from "antd";
// import { NavLink } from "react-router-dom";

// const { Title, Text, Paragraph } = Typography;

// type Props = {}

// const ProductCard = (props: Props) => {
//   return (
//     <NavLink to="/detail/1" style={{ textDecoration: "none" }}>
//       <Card
//         hoverable
//         cover={
//           <img
//             src="/image/watch1.jpg"
//             alt="Watch"
//             style={{ height: "200px", objectFit: "cover" }}
//           />
//         }
//         style={{ width: 300 }}
//       >
//         <Title level={5}>Card Title</Title>
//         <Paragraph>
//           Some quick example text to build on the card title and make up the
//           bulk of the card's content.
//         </Paragraph>
//         <Text delete style={{ marginRight: 10, color: "#888" }}>
//           $200
//         </Text>
//         <Text strong style={{ color: "#e63946" }}>
//           $150
//         </Text>
//       </Card>
//     </NavLink>
//   );
// };

// export default ProductCard;


import React from "react";
import { Card, Typography } from "antd";
import { NavLink } from "react-router-dom";

const { Title, Text, Paragraph } = Typography;

interface Product {
    id: number;
    name: string;
    price: number;
    originalPrice: number;
    image: string;
    description: string;
}

type Props = {
    product: Product;
};

const ProductCard = (props: Props) => {
    const { product } = props;

    return (
        <NavLink to={`/detail/${product.id}`} style={{ textDecoration: "none" }}>
            <Card
                hoverable
                cover={
                    <img
                        src={product.image}
                        alt={product.name}
                        style={{ height: "200px", objectFit: "cover" }}
                    />
                }
                style={{ width: 300 }}
            >
                <Title level={5}>{product.name}</Title>
                <Paragraph>{product.description}</Paragraph>
                <Text delete style={{ marginRight: 10, color: "#888" }}>
                    ${product.originalPrice}
                </Text>
                <Text strong style={{ color: "#e63946" }}>
                    ${product.price}
                </Text>
            </Card>
        </NavLink>
    );
};

export default ProductCard;
