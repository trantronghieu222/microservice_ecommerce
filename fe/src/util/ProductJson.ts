export type Product = {
    id: number;
    name: string;
    price: number;
    originalPrice: number;
    image: string;
    description: string;
};

export const products: Product[] = [
    { id: 1, name: "Watch 1", price: 150, originalPrice: 200, image: "/image/watch1.jpg", description: "Luxury watch with leather strap." },
    { id: 2, name: "Watch 2", price: 180, originalPrice: 220, image: "/image/watch2.jpg", description: "Stylish stainless steel watch." },
    { id: 3, name: "Watch 3", price: 220, originalPrice: 250, image: "/image/watch3.jpg", description: "Elegant automatic movement watch." },
    { id: 4, name: "Watch 4", price: 130, originalPrice: 180, image: "/image/watch4.jpg", description: "Minimalist design watch." },
    { id: 5, name: "Watch 5", price: 200, originalPrice: 240, image: "/image/watch5.jpg", description: "Classic chronograph watch." },
    { id: 6, name: "Watch 6", price: 170, originalPrice: 210, image: "/image/watch6.jpg", description: "Waterproof sports watch." },
    { id: 7, name: "Watch 7", price: 250, originalPrice: 300, image: "/image/watch7.jpg", description: "High-end smart watch." },
    { id: 8, name: "Watch 8", price: 140, originalPrice: 190, image: "/image/watch8.jpg", description: "Vintage style pocket watch." },
    { id: 9, name: "Watch 9", price: 190, originalPrice: 230, image: "/image/watch9.jpg", description: "Sleek modern wristwatch." },
    { id: 10, name: "Watch 10", price: 160, originalPrice: 200, image: "/image/watch10.jpg", description: "Lightweight titanium watch." },
];
