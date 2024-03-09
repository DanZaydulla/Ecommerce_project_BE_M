DROP TABLE IF EXISTS favorite;
DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS customer;


CREATE TABLE customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(20),
    address_country VARCHAR(255),
    address_city VARCHAR(255),
    password VARCHAR(255) NOT NULL
);


CREATE TABLE item (
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    photo_url VARCHAR(255),
    price DECIMAL(15, 2) NOT NULL,
    quantity INT NOT NULL DEFAULT 0
);


CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    order_date DATE NOT NULL,
    shipping_address VARCHAR(255) NOT NULL,
    total_price DECIMAL(15, 2) NOT NULL,
    status VARCHAR(20) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);


CREATE TABLE order_items (
    order_id INT,
    item_id INT,
    quantity INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (item_id) REFERENCES item(item_id),
    PRIMARY KEY (order_id, item_id)
);


CREATE TABLE favorite (
    customer_id INT NOT NULL,
    item_id INT NOT NULL,
    PRIMARY KEY (customer_id, item_id),
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    FOREIGN KEY (item_id) REFERENCES item(item_id)
);


INSERT INTO customer (username, first_name, last_name, email, phone, address_country, address_city, password)
VALUES
('jdoe', 'John', 'Doe', 'johndoe@example.com', '555-1234', 'CountryX', 'CityY', 'hashed_password1'),
('msmith', 'Mary', 'Smith', 'marysmith@example.com', '555-5678', 'CountryZ', 'CityA', 'hashed_password2');


INSERT INTO item (title, photo_url, price, quantity)
VALUES
('Laptop', 'https://media.istockphoto.com/id/1457961412/photo/laptop-isolated-on-white-background-with-two-clipping-paths-included-realistic-3d-render.jpg?s=2048x2048&w=is&k=20&c=5OA6gx3Wv6dkepWxsuO_HXpyJ207t3Wvmo31CyqkOEw=', 999.00, 10),
('Smartphone', 'https://images.unsplash.com/photo-1598327105666-5b89351aff97?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8U21hcnRwaG9uZXxlbnwwfHwwfHx8MA%3D%3D', 599.00, 15),
('Headphones', 'https://images.unsplash.com/photo-1484704849700-f032a568e944?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8SGVhZHBob25lc3xlbnwwfHwwfHx8MA%3D%3D', 199.00, 20),
('Watch', 'https://images.unsplash.com/photo-1524805444758-089113d48a6d?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8V2F0Y2h8ZW58MHx8MHx8fDA%3D', 249.00, 5),
('Tablet', 'https://media.istockphoto.com/id/1378688632/photo/mockup-image-of-a-woman-holding-digital-tablet-with-blank-white-desktop-screen-in-cafe.webp?b=1&s=170667a&w=0&k=20&c=uXHOw2hEzFkKDTueVETaGbMRexZHmaTtsSg6VxLq-co=', 450.00, 8),
('Camera', 'https://images.unsplash.com/photo-1612815154858-60aa4c59eaa6?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cHJpbnRlcnxlbnwwfHwwfHx8MA%3D%3D', 780.00, 10),
('Printer', 'https://images.unsplash.com/photo-1586210579191-33b45e38fa2c?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fG1vbml0b3J8ZW58MHx8MHx8fDA%3D', 150.00, 7),
('Monitor', 'https://images.unsplash.com/photo-1586210579191-33b45e38fa2c?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fG1vbml0b3J8ZW58MHx8MHx8fDA%3D', 300.00, 12),
('Keyboard', 'https://images.unsplash.com/photo-1587829741301-dc798b83add3?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8a2V5Ym9hcmR8ZW58MHx8MHx8fDA%3D', 100.00, 20),
('Mouse', 'https://images.unsplash.com/photo-1615663245857-ac93bb7c39e7?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8bW91c2V8ZW58MHx8MHx8fDA%3D', 50.00, 25);
