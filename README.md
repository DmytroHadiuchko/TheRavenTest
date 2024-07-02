# Customer Management API
This project is a Spring Boot application that provides a RESTful API
for managing customer data. It includes basic CRUD operations 
(Create, Read, Update, Delete) for the Customer entity.
The application uses a relational database to persist customer data.

## ️Technologies and Tools
### Backend:
- **Java**: The primary programming language used for the backend services.
- **Spring Boot**: A powerful framework for building production-ready applications quickly, providing features such as dependency injection, web frameworks, and data access.
- **Spring Data JPA**: Simplifies data access and management using the Java Persistence API.
### Database:
- **MySQL**: A widely-used open-source relational database system, 
chosen for its reliability, ease of use, and support for complex queries 
and transactions.

### Development Environment:
- **IntelliJ IDEA**: An integrated development environment for Java development.
- **Postman: A tool** for testing APIs by sending requests and receiving responses.

## Features and Functionality:
1. **Create Customer** 
   ```bash
   POST /api/customers
   ``` 
   Request Body:
   ```bash
   {
   "fullName": "John Doe",
   "email": "john.doe@example.com",
   "phone": "+1234567890"
   }
   ```
   Response Body:
   ```bash
   {
   "id": 1,
   "fullName": "John Doe",
   "email": "john.doe@example.com",
   "phone": "+1234567890"
   }
   ```
2. **Get All Customers**:
   ```bash
   GET /api/customers
   ```
   Response Body:
   ```bash
   {
   "id": 1,
   "fullName": "John Doe",
   "email": "john.doe@example.com",
   "phone": "+1234567890"
   }
   ```
3. **Get Customer By Id**:
   ```bash
   GET /api/customers/{id}
   ```
   Response Body:
   ```bash
   {
   "id": 1,
   "fullName": "John Doe",
   "email": "john.doe@example.com",
   "phone": "+1234567890"
   }
   ```
4. **Update Customer**:
   ```bash
   PUT /api/customers/{id}
   ```
   Request Body:
   ```bash
   {
   "id": 1,
   "fullName": "John Doe Updated",
   "phone": "+1234567891"
   }
   ```
   Response Body:
   ```bash
   {
   "id": 1,
   "fullName": "John Doe Updated",
   "email": "john.doe@example.com",
   "phone": "+1234567891"
   }
   ```
5. **Delete Customer**
   ```bash
   DELETE /api/customers/{id}
   ```
- This will mark a customer as deleted but leave their data in the database. The related DB column is is_active.

## Author
[Hadiuchko Dmytro](https://github.com/DmytroHadiuchko)