# Project Description and Purpose

The Car Rental application was created to provide users with a convenient and fast way to rent cars. The system offers an intuitive vehicle reservation process, displaying detailed information about available cars, such as the brand, vehicle number, and daily rental price.
A built-in wallet allows users to manage their funds, with the rental cost automatically calculated and deducted from the balance upon booking.
# Technologies and Tools Used in the Project
IntelliJ IDEA 2023.2.5 (Ultimate Edition) – An advanced IDE for Java, offering tools for development, debugging, Spring Boot integration, database management, and web technologies support.

Spring Boot 3.4.0 – A framework for building Java applications that simplifies configuration and the development of web applications and microservices.

Java 17 – The Java programming language version used for compiling and running the application.

Java Persistence (JPA) – A set of dependencies facilitating integration with the Java Persistence API (JPA) for database operations.

Liquibase Core – A tool for automated and controlled database schema versioning management.

H2 Database – A lightweight, embedded database used for testing and quick application deployment without external database configuration.

Lombok – A library that reduces boilerplate code in Java by automatically generating constructors, getters, setters, etc.

Spring Boot Starter Test – A testing toolkit for Spring Boot applications, including JUnit and Mockito.

Spring Boot Starter Web – A package that simplifies building web applications and REST APIs in Spring Boot.

Thymeleaf 3.4.0 – A modern, server-side Java template engine dedicated to web environments and independent projects.

Apache Commons Codec – A library providing encoding and decoding functions, such as hashing algorithms and Base64 encoding.

Spring Boot Maven Plugin – A plugin enabling the building and running of Spring Boot applications using Maven.

HyperText Markup Language (HTML) – A standard markup language used for structuring and presenting content on the web, allowing the organization of text, images, links, and multimedia elements.

Cascading Style Sheets (CSS) – A styling language used for describing the appearance and formatting of HTML elements, ensuring an aesthetically pleasing and consistent design for web pages.

# Application Features
### 1. User Registration and Login
Users can register and log in to the system.

During login, user data is validated, and the system verifies the user’s role and session.
### 2. Car Rental
Car Reservation View – Users can browse available cars and start the reservation process.

Car Details Display – Information such as brand, vehicle number, and daily rental price is presented.

Reservation Form – Users specify the rental duration, and the system automatically calculates the cost.

Car Return – Users can return rented cars.

Rented Cars Display – Users can check their rented cars.

Car Pricing – Rental cost depends on the car brand (e.g., BMW, Skoda, Opel) and the rental duration.

Total Cost Calculation – The system calculates the final price based on the number of days and daily rate, considering potential discounts for long-term rentals (e.g., 7 days, 30 days).

### 3. User Wallet Management
User Balance – Each user has an individual balance that can be used for car reservations.

Funds Deduction – After booking, the system automatically deducts the rental amount from the user’s balance.

Funds Availability Check – Before finalizing the reservation, the system verifies if the user has sufficient funds.

### 4. Car Availability Management

After a reservation is made, the vehicle’s status changes to “unavailable” to prevent double booking.

### 5. Cost Visualization
Dynamic Price Calculation – The system automatically calculates rental costs based on the rental duration, with different daily rates for different car brands.

Pricing Based on Rental Duration – Long-term rentals (e.g., monthly) have a lower per-day cost, and the system offers discounts for rentals exceeding 7 and 30 days.

### 6. User Session Management
The system stores user session information, including role and balance, allowing for dynamic interface customization and feature access.

### 7. Admin Panel

Adding new vehicles

Editing existing vehicles

Removing cars

Viewing available vehicles

Adding funds to user wallets

Changing vehicle availability status

Reviewing user reports

Assigning moderator roles

Restricted access to the admin panel

### 8. Moderator Panel

Adding new vehicles

Editing existing vehicles

Removing cars

Viewing available vehicles

Changing vehicle availability status

Reviewing user comments
#Login credentials
### Login: Admin2 Password: haslo Role: Admin
### Login: A Password: haslo Role: Moderator
### Login: Kozak Password: haslo Role: User
#Screenshots
![image](https://github.com/user-attachments/assets/465c04c9-2ec9-4df7-b457-d1a72cc458b1)
![image](https://github.com/user-attachments/assets/2d2a4faf-bc00-4f75-9d21-700bc534dbb1)
![image](https://github.com/user-attachments/assets/73b966b3-325a-41e7-841f-33c84d4751fd)
![image](https://github.com/user-attachments/assets/2c2fe417-66dc-42a8-9dd1-ffd1219299e6)
![image](https://github.com/user-attachments/assets/236df194-1c28-4f79-918f-952904cd9fd6)
![image](https://github.com/user-attachments/assets/afc225c3-55f0-49ce-b087-542e5ed0841c)
![image](https://github.com/user-attachments/assets/c24a11f1-0127-4e8d-9193-e9e38b154968)
![image](https://github.com/user-attachments/assets/f88ea2cf-7fae-4788-b0c3-89c2291e08c3)
![image](https://github.com/user-attachments/assets/125fb50c-5f8e-4716-bc30-bb369f0e19e6)
![image](https://github.com/user-attachments/assets/3a6de58e-bfa1-4805-9762-b556a52c8b81)
![image](https://github.com/user-attachments/assets/16bfc451-e6ca-407d-bced-0c281dbcfea7)





