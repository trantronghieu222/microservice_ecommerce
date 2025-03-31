# Watch Shop Microservice Project

## Overview
The **Watch Shop Microservice Project** is a microservice-based e-commerce platform for selling watches. Built using **Spring Boot**, it leverages **Spring Cloud** and other modern technologies to ensure a **scalable**, **robust**, and **secure** architecture.

## Microservices
The system is composed of multiple microservices, each responsible for a specific function:

- **config-service**: Centralized configuration management for all microservices.
- **discovery-service**: Service registry using **Eureka** for service discovery.
- **gateway-service**: API Gateway for routing requests to the appropriate services.
- **account-service**: Manages user accounts and profiles.
- **auth-service**: Handles user authentication and authorization.
- **order-service**: Manages order processing and fulfillment.
- **product-service**: Manages the product catalog and inventory.
- **received-service**: Handles the import of new products.

## Technologies Used
The project utilizes the following technologies:

- **Spring Boot** - For building the microservices.
- **Spring Cloud** - Includes **Eureka**, **Config Service**, and **API Gateway**.
- **Spring Security** - For authentication and authorization.
- **JPA (Java Persistence API)** - For database interactions.
- **MySQL** - As the primary database.
- **Docker** - For containerization.
- **ReactTS (React with TypeScript)** - For the frontend application.

## Setup & Deployment

### Backend Setup
#### Option 1: Using Docker (Recommended)
1. **Clone the repository**:
   ```sh
   git clone <repository_url>
   ```
2. **Run Docker Compose**:
   ```sh
   docker-compose up --build
   ```

#### Option 2: Running Services Individually
1. **Start MySQL Server** and ensure it is running.
2. **Start the Config Service**:
   ```sh
   cd config-service
   mvn spring-boot:run
   ```
3. **Start the Discovery Service**:
   ```sh
   cd discovery-service
   mvn spring-boot:run
   ```
4. **Start the API Gateway**:
   ```sh
   cd gateway-service
   mvn spring-boot:run
   ```
5. **Start the remaining services** (account-service, auth-service, order-service, product-service, received-service) individually:
   ```sh
   cd <service-name>
   mvn spring-boot:run
   ```

### Frontend Setup
1. **Navigate to the frontend directory**:
   ```sh
   cd fe
   ```
2. **Install dependencies**:
   ```sh
   yarn
   ```
3. **Start the development server**:
   ```sh
   yarn run dev
   ```

## Additional Notes
- **Ensure that MySQL is running** and accessible to the backend services.
- The **config-service** contains the configuration files for all the microservices.
- The **discovery-service (Eureka)** enables service registration and discovery.
- The **gateway-service** acts as a single entry point for all API requests.
- **Spring Security** is used for authentication and authorization.
- **JPA** is used for handling database interactions.
- The frontend application is built with **ReactTS** for a modern user experience.

## Contribution
Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open a pull request.