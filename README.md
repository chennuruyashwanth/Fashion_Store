# 👗 Fashion Store - E-Commerce Application

> A comprehensive Java-based e-commerce platform for fashion retail with a complete MVC architecture, built using Jakarta Servlet, MySQL, and JSTL.

![Java](https://img.shields.io/badge/Java-21-orange?logo=java)
![Maven](https://img.shields.io/badge/Maven-3.11.0-red)
![MySQL](https://img.shields.io/badge/MySQL-9.3.0-blue)
![Jakarta Servlet](https://img.shields.io/badge/Jakarta%20Servlet-6.0.0-green)
![License](https://img.shields.io/badge/License-Open%20Source-brightgreen)

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Architecture](#project-architecture)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [UML Diagrams](#uml-diagrams)
- [Database Schema](#database-schema)
- [Installation & Setup](#installation--setup)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Module Documentation](#module-documentation)
- [Contributing](#contributing)

---

## 📖 Overview

**Fashion Store** is a full-stack e-commerce application designed to manage online fashion retail operations. The application provides a seamless shopping experience with product browsing, cart management, order processing, and user authentication. It follows the **MVC (Model-View-Controller)** architectural pattern with a clear separation of concerns.

**Version:** 0.0.1-SNAPSHOT  
**Package:** `com.fashionStore`  
**Build Type:** WAR (Web Archive)

---

## ✨ Features

### User Management
- ✅ User Registration with validation
- ✅ Secure Login/Logout
- ✅ User Profile Management
- ✅ Address Management (City, State, Pincode, Country)
- ✅ Password Security

### Product Catalog
- ✅ Product Browsing by Category
- ✅ Product Variants (Size, Color, etc.)
- ✅ Advanced Product Filtering
- ✅ Product Details Page
- ✅ Stock Management
- ✅ Image Support

### Shopping Cart
- ✅ Add/Remove Items from Cart
- ✅ Update Quantity
- ✅ Real-time Cart Updates
- ✅ Cart Persistence

### Order Management
- ✅ Checkout Process
- ✅ Order Placement
- ✅ Order Confirmation
- ✅ Order History
- ✅ Order Item Tracking

### Category Management
- ✅ Product Organization
- ✅ Category Browsing
- ✅ Category-wise Filtering

---

## 🏗️ Project Architecture

The project follows a **3-Tier Architecture** pattern:

```
┌─────────────────────────────────────────────────────────┐
│            PRESENTATION LAYER (JSP/HTML/CSS)            │
│                 (View Components)                        │
└─────────────────────────────────────────────────────────┘
                           ↓
┌─────────────────────────────────────────────────────────┐
│         BUSINESS LOGIC LAYER (Servlets)                 │
│              (Controller Components)                     │
└─────────────────────────────────────────────────────────┘
                           ↓
┌─────────────────────────────────────────────────────────┐
│        DATA ACCESS LAYER (DAO/Repository)               │
│           (Persistence Components)                      │
└─────────────────────────────────────────────────────────┘
                           ↓
┌─────────────────────────────────────────────────────────┐
│              DATABASE LAYER (MySQL)                     │
│            (Data Storage & Retrieval)                   │
└─────────────────────────────────────────────────────────┘
```

---

## 💻 Technology Stack

| Category | Technology | Version |
|----------|-----------|---------|
| **Language** | Java | 21 |
| **Build Tool** | Maven | 3.11.0 |
| **Web Framework** | Jakarta Servlet API | 6.0.0 |
| **Template Engine** | JSTL | 3.0.0 |
| **Database** | MySQL | 9.3.0 |
| **JDBC Driver** | MySQL Connector/J | 9.3.0 |
| **Packaging** | WAR | - |

### Dependencies

```xml
<!-- Jakarta Servlet API -->
<dependency>
    <groupId>jakarta.servlet</groupId>
    <artifactId>jakarta.servlet-api</artifactId>
    <version>6.0.0</version>
    <scope>provided</scope>
</dependency>

<!-- MySQL JDBC Driver -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.3.0</version>
    <scope>compile</scope>
</dependency>

<!-- JSTL -->
<dependency>
    <groupId>jakarta.servlet.jsp.jstl</groupId>
    <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
    <version>3.0.0</version>
</dependency>
```

---

## 📁 Project Structure

```
Fashion_Store/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/fashionStore/
│       │       ├── controller/          # Servlet Controllers
│       │       │   ├── HomeServlet.java
│       │       │   ├── LoginServlet.java
│       │       │   ├── RegisterServlet.java
│       │       │   ├── ProductServlet.java
│       │       │   ├── ProductDetailsServlet.java
│       │       │   ├── CartItemServlet.java
│       │       │   ├── CheckoutServlet.java
│       │       │   ├── PlaceOrderServlet.java
│       │       │   ├── OrderConfirmationServlet.java
│       │       │   ├── ProfileServlet.java
│       │       │   └── LogoutServlet.java
│       │       │
│       │       ├── model/               # Entity Models
│       │       │   ├── User.java
│       │       │   ├── Product.java
│       │       │   ├── ProductVariant.java
│       │       │   ├── Category.java
│       │       │   ├── Cart.java
│       │       │   ├── CartItem.java
│       │       │   ├── Order.java
│       │       │   └── OrderItem.java
│       │       │
│       │       ├── dao/                 # DAO Interfaces
│       │       │   ├── UserDAO.java
│       │       │   ├── ProductDAO.java
│       │       │   ├── ProductVariantDAO.java
│       │       │   ├── CategoryDAO.java
│       │       │   ├── CartDAO.java
│       │       │   ├── CartItemDAO.java
│       │       │   ├── OrderDAO.java
│       │       │   └── OrderItemDAO.java
│       │       │
│       │       ├── daoImpl/              # DAO Implementations
│       │       │   ├── UserDAOImpl.java
│       │       │   ├── ProductDAOImpl.java
│       │       │   ├── ProductVariantDAOImpl.java
│       │       │   ├── CategoryDAOImpl.java
│       │       │   ├── CartDAOImpl.java
│       │       │   ├── CartItemDAOImpl.java
│       │       │   ├── OrderDAOImpl.java
│       │       │   └── OrderItemDAOImpl.java
│       │       │
│       │       └── utility/             # Utility Classes
│       │           ├── DBConnection.java
│       │           ├── ConnectionTest.java
│       │           └── DAOTestRunner.java
│       │
│       └── webapp/                      # Web Resources
│           ├── WEB-INF/
│           │   ├── web.xml
│           │   └── jsp files
│           ├── assets/
│           │   ├── css/
│           │   ├── js/
│           │   └── images/
│           └── index.html
│
├── pom.xml                              # Maven Configuration
├── .project                             # Eclipse Project File
├── .classpath                           # Eclipse Classpath File
└── README.md                            # Documentation

```

---

## 🎨 UML Diagrams

### 1. Class Diagram - Model Layer

```
┌────────────────────────────────┐
│          User                  │
├────────────────────────────────┤
│ - userId: int                  │
│ - name: String                 │
│ - email: String                │
│ - phone: String                │
│ - password: String             │
│ - address: String              │
│ - city: String                 │
│ - state: String                │
│ - pincode: String              │
│ - country: String              │
│ - created_at: Timestamp        │
├────────────────────────────────┤
│ + getUserId(): int             │
│ + setUserId(int): void         │
│ + getEmail(): String           │
│ + setEmail(String): void       │
│ ... (getters/setters)          │
└────────────────────────────────┘
         │
         │ 1
         │ creates
         │
         ▼
┌────────────────────────────────┐
│         Cart                   │
├────────────────────────────────┤
│ - cartId: int                  │
│ - userId: int                  │
│ - totalPrice: BigDecimal       │
├────────────────────────────────┤
│ + getCartId(): int             │
│ + setCartId(int): void         │
└────────────────────────────────┘
         │
         │ 1
         │ contains
         │
         ▼
┌────────────────────────────────┐
│       CartItem                 │
├────────────────────────────────┤
│ - cartItemId: int              │
│ - cartId: int                  │
│ - productId: int               │
│ - quantity: int                │
│ - price: BigDecimal            │
├────────────────────────────────┤
│ + getCartItemId(): int         │
│ + setCartItemId(int): void     │
│ ... (getters/setters)          │
└────────────────────────────────┘
         │
         │ references
         │
         ▼
┌────────────────────────────────┐
│       Product                  │
├────────────────────────────────┤
│ - productId: int               │
│ - categoryId: int              │
│ - name: String                 │
│ - description: String          │
│ - brand: String                │
│ - size: String                 │
│ - price: BigDecimal            │
│ - stock: int                   │
│ - imagePath: String            │
│ - createdAt: Timestamp         │
├────────────────────────────────┤
│ + getProductId(): int          │
│ + setProductId(int): void      │
│ ... (getters/setters)          │
└────────────────────────────────┘
         │
         │ belongs to
         │
         ▼
┌────────────────────────────────┐
│       Category                 │
├────────────────────────────────┤
│ - categoryId: int              │
│ - name: String                 │
│ - description: String          │
├────────────────────────────────┤
│ + getCategoryId(): int         │
│ + setCategoryId(int): void     │
│ + getName(): String            │
│ + setName(String): void        │
└────────────────────────────────┘

┌────────────────────────────────┐
│     ProductVariant             │
├────────────────────────────────┤
│ - variantId: int               │
│ - productId: int               │
│ - size: String                 │
│ - color: String                │
│ - stock: int                   │
├────────────────────────────────┤
│ + getVariantId(): int          │
│ + setVariantId(int): void      │
│ ... (getters/setters)          │
└────────────────────────────────┘

┌────────────────────────────────┐
│        Order                   │
├────────────────────────────────┤
│ - orderId: int                 │
│ - userId: int                  │
│ - totalPrice: BigDecimal       │
│ - status: String               │
│ - created_at: Timestamp        │
├────────────────────────────────┤
│ + getOrderId(): int            │
│ + setOrderId(int): void        │
│ ... (getters/setters)          │
└────────────────────────────────┘
         │
         │ 1
         │ contains
         │
         ▼
┌────────────────────────────────┐
│       OrderItem                │
├────────────────────────────────┤
│ - orderItemId: int             │
│ - orderId: int                 │
│ - productId: int               │
│ - quantity: int                │
│ - price: BigDecimal            │
├────────────────────────────────┤
│ + getOrderItemId(): int        │
│ + setOrderItemId(int): void    │
│ ... (getters/setters)          │
└────────────────────────────────┘
```

### 2. DAO Pattern Architecture

```
                    ┌─────────────────────────────┐
                    │   Controller (Servlet)      │
                    └─────────────────────────────┘
                                ↓
                    ┌─────────────────────────────┐
                    │    DAO Interface            │
                    │  (Contract Definition)      │
                    └─────────────────────────────┘
                                ↓
                    ┌─────────────────────────────┐
                    │   DAO Implementation        │
                    │  (Business Logic)           │
                    └─────────────────────────────┘
                                ↓
                    ┌─────────────────────────────┐
                    │   DBConnection              │
                    │  (Connection Management)    │
                    └─────────────────────────────┘
                                ↓
                    ┌─────────────────────────────┐
                    │      MySQL Database         │
                    │  (Data Persistence)         │
                    └─────────────────────────────┘
```

### 3. MVC Request-Response Flow

```
┌──────────────────────────────────────────────────────────────────┐
│                        USER REQUEST                              │
└──────────────────────────────────────────────────────────────────┘
                            ↓
┌──────────────────────────────────────────────────────────────────┐
│                    CONTROLLER LAYER                              │
│              (Servlet Components)                                │
│  ├─ HomeServlet                                                  │
│  ├─ LoginServlet                                                 │
│  ├─ RegisterServlet                                              │
│  ├─ ProductServlet                                               │
│  ├─ CartItemServlet                                              │
│  ├─ CheckoutServlet                                              │
│  ├─ PlaceOrderServlet                                            │
│  └─ OrderConfirmationServlet                                     │
└──────────────────────────────────────────────────────────────────┘
                            ↓
┌──────────────────────────────────────────────────────────────────┐
│                      MODEL LAYER                                 │
│            (DAO Interfaces & Implementations)                    │
│  ├─ UserDAO/UserDAOImpl                                           │
│  ├─ ProductDAO/ProductDAOImpl                                     │
│  ├─ CartDAO/CartDAOImpl                                           │
│  ├─ CartItemDAO/CartItemDAOImpl                                   │
│  ├─ OrderDAO/OrderDAOImpl                                         │
│  ├─ OrderItemDAO/OrderItemDAOImpl                                 │
│  ├─ CategoryDAO/CategoryDAOImpl                                   │
│  └─ ProductVariantDAO/ProductVariantDAOImpl                       │
└──────────────────────────────────────────────────────────────────┘
                            ↓
┌──────────────────────────────────────────────────────────────────┐
│                    DATABASE LAYER                                │
│                   (MySQL Database)                               │
│  Tables: users, products, categories, carts, orders, etc.        │
└──────────────────────────────────────────────────────────────────┘
                            ↓
┌──────────────────────────────────────────────────────────────────┐
│                    VIEW LAYER                                    │
│              (JSP Pages / HTML Response)                         │
│  ├─ home.jsp                                                     │
│  ├─ products.jsp                                                 │
│  ├─ cart.jsp                                                     │
│  ├─ checkout.jsp                                                 │
│  └─ order-confirmation.jsp                                       │
└──────────────────────────────────────────────────────────────────┘
                            ↓
┌──────────────────────────────────────────────────────────────────┐
│                    USER RESPONSE                                 │
└──────────────────────────────────────────────────────────────────┘
```

### 4. User Registration & Login Flow

```
                    START
                      ↓
            ┌─────────────────────┐
            │  User Registration  │
            └─────────────────────┘
                      ↓
        ┌─────────────────────────────┐
        │ Validate Input Parameters   │
        └─────────────────────────────┘
                      ↓
        ┌─────────────────────────────┐
        │ Check Email Availability    │
        └─────────────────────────────┘
                      ↓
              ┌───────┴───────┐
              │               │
        Exists        Not Exists
              │               │
              ▼               ▼
      ┌─────────────┐  ┌─────────────┐
      │ Error Page  │  │ Hash Pwd    │
      └─────────────┘  └─────────────┘
                              ↓
                    ┌──────────────────┐
                    │ Insert into DB   │
                    └──────────────────┘
                              ↓
                    ┌──────────────────┐
                    │ Login Page       │
                    └──────────────────┘
                              ↓
                    ┌──────────────────┐
                    │ Enter Credentials│
                    └──────────────────┘
                              ↓
                    ┌──────────────────┐
                    │ Verify in DB     │
                    └──────────────────┘
                              ↓
                      ┌───────┴───────┐
                      │               │
                   Valid          Invalid
                      │               │
                      ▼               ▼
                ┌──────────┐   ┌────────────┐
                │ Home Page│   │ Error Page │
                └──────────┘   └────────────┘
```

### 5. Shopping Cart & Order Flow

```
                    PRODUCT PAGE
                         ↓
            ┌─────────────────────────┐
            │ Add Product to Cart     │
            └─────────────────────────┘
                         ↓
            ┌─────────────────────────┐
            │ CartItemServlet         │
            └─────────────────────────┘
                         ↓
            ┌─────────────────────────┐
            │ Update Cart in DB       │
            └─────────────────────────┘
                         ↓
            ┌─────────────────────────┐
            │ View Cart               │
            └─────────────────────────┘
                         ↓
            ┌─────────────────────────┐
            │ Modify Quantities       │
            └─────────────────────────┘
                         ↓
            ┌─────────────────────────┐
            │ Proceed to Checkout     │
            └─────────────────────────┘
                         ↓
            ┌─────────────────────────┐
            │ CheckoutServlet         │
            └─────────────────────────┘
                         ↓
            ┌─────────────────────────┐
            │ Enter Shipping Details  │
            └─────────────────────────┘
                         ↓
            ┌─────────────────────────┐
            │ PlaceOrderServlet       │
            └─────────────────────────┘
                         ↓
            ┌─────────────────────────┐
            │ Create Order in DB      │
            └─────────────────────────┘
                         ↓
            ┌─────────────────────────┐
            │ Add Order Items         │
            └─────────────────────────┘
                         ↓
            ┌─────────────────────────┐
            │ Clear Cart              │
            └─────────────────────────┘
                         ↓
            ┌─────────────────────────┐
            │ OrderConfirmationServlet│
            └─────────────────────────┘
                         ↓
            ┌─────────────────────────┐
            │ Display Confirmation    │
            └─────────────────────────┘
```

---

## 🗄️ Database Schema

### Entity Relationship Diagram (ERD)

```
┌──────────────────┐                    ┌──────────────────┐
│    USERS         │                    │   CATEGORIES     │
├──────────────────┤                    ├──────────────────┤
│ user_id (PK)     │                    │ category_id (PK) │
│ name             │                    │ name             │
│ email (UNIQUE)   │                    │ description      │
│ phone            │                    └──────────────────┘
│ password         │                             △
│ address          │                             │
│ city             │                             │
│ state            │                             │
│ pincode          │                             │
│ country          │                             │
│ created_at       │                             │
└──────────────────┘                             │
        △                                        │
        │                                        │ 1:N
        │                                        │
        │ 1:N                            ┌──────────────────┐
        │                                │   PRODUCTS       │
        │                                ├──────────────────┤
        │                                │ product_id (PK)  │
        │                                │ category_id (FK) │
        │                                │ name             │
        │                                │ description      │
        │                                │ brand            │
        │                                │ size             │
        │                                │ price            │
        │                                │ stock            │
        │                                │ image_path       │
        │                                │ created_at       │
        │                                └──────────────────┘
        │                                        △
        │                                        │
        │                                        │ 1:N
        │                                        │
        │                                ┌──────────────────────┐
        │                                │ PRODUCT_VARIANTS     │
        │                                ├──────────────────────┤
        │                                │ variant_id (PK)      │
        │                                │ product_id (FK)      │
        │                                │ size                 │
        │                                │ color                │
        │                                │ stock                │
        │                                └──────────────────────┘
        │
        │
        │
        ▼
┌──────────────────┐                    ┌──────────────────┐
│     CARTS        │                    │   CART_ITEMS     │
├──────────────────┤                    ├──────────────────┤
│ cart_id (PK)     │                    │ cart_item_id(PK) │
│ user_id (FK)     │───1:1──────────────│ cart_id (FK)     │
│ total_price      │                    │ product_id (FK)  │
│ created_at       │                    │ quantity         │
└──────────────────┘                    │ price            │
                                        │ created_at       │
                                        └──────────────────┘

        ┌──────────────────┐                    ┌──────────────────┐
        │     ORDERS       │                    │  ORDER_ITEMS     │
        ├──────────────────┤                    ├──────────────────┤
        │ order_id (PK)    │                    │ order_item_id(PK)│
        │ user_id (FK)     │───1:N─────────────│ order_id (FK)    │
        │ total_price      │                    │ product_id (FK)  │
        │ status           │                    │ quantity         │
        │ created_at       │                    │ price            │
        └──────────────────┘                    └──────────────────┘
```

### Core Tables

#### Users Table
```sql
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) NOT NULL,
    password VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    city VARCHAR(50),
    state VARCHAR(50),
    pincode VARCHAR(10),
    country VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

#### Products Table
```sql
CREATE TABLE products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    category_id INT NOT NULL,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    brand VARCHAR(100),
    size VARCHAR(20),
    price DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    image_path VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES categories(category_id)
);
```

#### Orders Table
```sql
CREATE TABLE orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    status VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
```

---

## ⚙️ Installation & Setup

### Prerequisites
- Java JDK 21 or higher
- MySQL 5.7 or higher
- Maven 3.6+
- Apache Tomcat 10.0+ (Jakarta)
- Git

### Step 1: Clone the Repository

```bash
git clone https://github.com/chennuruyashwanth/Fashion_Store.git
cd Fashion_Store
```

### Step 2: Database Setup

```bash
# Create database
mysql -u root -p
CREATE DATABASE fashion_store;
USE fashion_store;

# Import schema (if provided)
source database/schema.sql
```

### Step 3: Update Database Configuration

Edit `src/main/java/com/fashionStore/utility/DBConnection.java`:

```java
private static final String URL = "jdbc:mysql://localhost:3306/fashion_store";
private static final String USERNAME = "root";
private static final String PASSWORD = "your_password";
```

### Step 4: Build with Maven

```bash
mvn clean install
```

### Step 5: Deploy to Tomcat

```bash
# Copy WAR file to Tomcat
cp target/fashionStore.war $CATALINA_HOME/webapps/

# Start Tomcat
$CATALINA_HOME/bin/startup.sh
```

### Step 6: Access Application

Open browser and navigate to:
```
http://localhost:8080/fashionStore/
```

---

## 🚀 Usage

### User Registration
1. Navigate to `/register` page
2. Fill in registration form with required details
3. Password will be hashed before storage
4. Submit and receive confirmation

### User Login
1. Navigate to `/login` page
2. Enter email and password
3. Session will be created upon successful authentication
4. Redirected to home page

### Browse Products
1. Visit home page to view all products
2. Use category filter to narrow down
3. Click on product to view details
4. Check available variants and stock

### Add to Cart
1. On product details page, select quantity
2. Click "Add to Cart"
3. Product will be added to user's cart
4. View cart to see all items

### Checkout
1. Navigate to cart
2. Review items and quantities
3. Click "Proceed to Checkout"
4. Enter/confirm shipping details
5. Click "Place Order"
6. Order confirmation page will be displayed

---

## 🔌 API Endpoints

### Authentication
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/register` | Register new user |
| POST | `/login` | User login |
| GET | `/logout` | User logout |

### Products
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/products` | Get all products |
| GET | `/products?category={id}` | Get products by category |
| GET | `/product/{id}` | Get product details |

### Cart
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/addToCart` | Add item to cart |
| GET | `/cart` | View cart |
| POST | `/updateCart` | Update cart items |
| POST | `/removeFromCart` | Remove item from cart |

### Orders
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/checkout` | Proceed to checkout |
| POST | `/placeOrder` | Place order |
| GET | `/orderConfirmation` | View order confirmation |

### Profile
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/profile` | View user profile |
| POST | `/profile/update` | Update profile |

---

## 📚 Module Documentation

### Controller Layer

#### HomeServlet
- **Purpose**: Handles home page requests
- **Methods**: `doGet()`, `doPost()`
- **Functionality**: Fetches and displays all products/categories

#### LoginServlet
- **Purpose**: Handles user authentication
- **Methods**: `doGet()`, `doPost()`
- **Functionality**: Validates credentials, creates session

#### ProductServlet
- **Purpose**: Displays products with filters
- **Methods**: `doGet()`, `doPost()`
- **Functionality**: Fetches products by category, applies filters

#### CartItemServlet
- **Purpose**: Manages shopping cart operations
- **Methods**: `doGet()`, `doPost()`
- **Functionality**: Add/remove/update cart items

#### OrderServlet
- **Purpose**: Manages order operations
- **Methods**: `doGet()`, `doPost()`
- **Functionality**: Place orders, retrieve order history

### Model Layer

#### User Model
- Represents user entity
- Attributes: name, email, phone, address, etc.
- Used for authentication and profile management

#### Product Model
- Represents product entity
- Attributes: name, price, stock, category, etc.
- Used for product catalog

#### Order Model
- Represents order entity
- Attributes: userId, totalPrice, status, date
- Used for order management

### DAO Layer

#### UserDAO Interface & UserDAOImpl
- `register(User)`: Create new user
- `findByEmail(String)`: Get user by email
- `update(User)`: Update user info
- `findById(int)`: Get user by ID

#### ProductDAO Interface & ProductDAOImpl
- `getAll()`: Get all products
- `getById(int)`: Get product by ID
- `getByCategory(int)`: Get products by category
- `search(String)`: Search products

#### CartDAO Interface & CartDAOImpl
- `create(Cart)`: Create new cart
- `getByUserId(int)`: Get user's cart
- `update(Cart)`: Update cart
- `clear(int)`: Clear cart

#### OrderDAO Interface & OrderDAOImpl
- `create(Order)`: Create new order
- `getById(int)`: Get order by ID
- `getByUserId(int)`: Get user's orders
- `updateStatus(int, String)`: Update order status

### Utility Layer

#### DBConnection
- Singleton pattern for database connection
- JDBC MySQL driver integration
- Connection pooling support

#### ConnectionTest
- Tests database connectivity
- Verifies credentials

#### DAOTestRunner
- Unit testing for DAO layer
- Tests CRUD operations

---

## 🛠️ Development Guidelines

### Code Structure
- Follow **Single Responsibility Principle**
- Use **DAO Pattern** for data access
- Implement **MVC architecture** strictly
- Write **meaningful method names**

### Naming Conventions
- **Classes**: PascalCase (e.g., `UserDAO`, `ProductServlet`)
- **Variables**: camelCase (e.g., `userId`, `productName`)
- **Constants**: UPPER_SNAKE_CASE (e.g., `MAX_ATTEMPTS`)

### Error Handling
- Use try-catch blocks for database operations
- Log exceptions appropriately
- Return user-friendly error messages

### Security
- Hash passwords using secure algorithms
- Validate all user inputs
- Use parameterized queries to prevent SQL injection
- Implement session management

---

## 🤝 Contributing

Contributions are welcome! Please follow these guidelines:

1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/AmazingFeature`)
3. **Commit** your changes (`git commit -m 'Add some AmazingFeature'`)
4. **Push** to the branch (`git push origin feature/AmazingFeature`)
5. **Open** a Pull Request

### Contribution Areas
- Bug fixes
- Feature enhancements
- Documentation improvements
- Performance optimization
- UI/UX improvements

---

## 📄 License

This project is open source and available under the MIT License.

---

## 📞 Support & Contact

For questions, issues, or suggestions:
- **Author**: Yashwanth Chenna
- **GitHub**: [@chennuruyashwanth](https://github.com/chennuruyashwanth)
- **Email**: Contact via GitHub profile
- **Repository**: [Fashion_Store](https://github.com/chennuruyashwanth/Fashion_Store)

---

## 🔄 Version History

| Version | Date | Changes |
|---------|------|---------|
| 0.0.1-SNAPSHOT | 2026-06-30 | Initial Release |

---

## 🎯 Roadmap

### Phase 2
- [ ] Payment gateway integration
- [ ] Email notifications
- [ ] Admin dashboard
- [ ] Product reviews and ratings
- [ ] Wishlist functionality

### Phase 3
- [ ] Mobile app integration
- [ ] Advanced search with Elasticsearch
- [ ] Recommendation engine
- [ ] Analytics dashboard
- [ ] API documentation (Swagger)

---

## 📊 Language Composition

```
Java      - 85.9%
CSS       - 14.0%
HTML      - 0.1%
```

---

**Made with ❤️ by Yashwanth Chenna**
