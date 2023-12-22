# Expense Tracker Microservices Project

This project consists of 5 microservices built with Spring Boot:

- Config Service (Port: 8888)
- Eureka Service Registry (Port: 8761)
- Gateway Service (Port: 8080)
- Expenses Service (Port: 8090)
- Categories Service (Port: 9090)

The microservices use H2 database and are interconnected for managing expenses and categories.

## Starting the Microservices

To start the project:

1. Start the **Config Service** on port `8888`.
2. Start the **Eureka Service Registry** on port `8761`.
3. Start the **Expenses Service** on port `8090` and **Categories Service** on port `9090`.
4. Finally, start the **Gateway Service** on port `8080`.

Ensure the services are started in the specified order for proper functioning due to service discovery and routing configurations.

## Microservices Endpoints

### Expenses Service

#### Routes:
- **POST** `localhost:8080/api/expenses/create`: Create a new expense.
- **GET** `localhost:8080/api/expenses/all`: Get all expenses.
- **GET** `localhost:8080/api/expenses/search/{id}`: Find expense by ID.
- **GET** `localhost:8080/api/expenses/search-by-category/{idCategory}`: Find expenses by category ID.
- **DELETE** `localhost:8080/api/expenses/delete/{id}`: Delete expense by ID.

### Categories Service

#### Routes:
- **POST** `localhost:8080/api/categories/create`: Create a new category.
- **GET** `localhost:8080/api/categories/all`: Get all categories.
- **GET** `localhost:8080/api/categories/search/{id}`: Find category by ID.
- **GET** `localhost:8080/api/categories/search/expenses_by_id_category/{id}`: Find expenses by category ID.

## Gateway Service Configuration

The Gateway Service is configured to run on port 8080 at localhost and acts as an entry point to the microservices. It handles routing and directing requests to the appropriate services based on defined routes.

### Initial Data Population

When the microservices are started, initial data is automatically inserted to demonstrate the usage. This includes sample expenses and categories to showcase functionality.

## Usage Order

To use the services effectively:

1. Access the Config Service on port `8888`.
2. Utilize the Eureka Service Registry on port `8761`.
3. Interact with the Expenses and Categories Services on ports `8090` and `9090`.
4. Use the Gateway Service on port `8080` for external requests and routing.

Each microservice endpoint can be used in sequence to experience the functionality of the Expense Tracker application.
