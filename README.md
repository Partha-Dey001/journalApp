# JournalApp - Spring Boot Application

![Java](https://img.shields.io/badge/Java-17-blue) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen) ![MongoDB](https://img.shields.io/badge/MongoDB-4.x-green) ![JWT](https://img.shields.io/badge/JWT-Authentication-orange)

This repository contains the backend for **JournalApp**, a secure and robust journaling application. It is designed to showcase proficiency in modern backend development practices, including REST API design, JWT-based security, and data persistence with a NoSQL database.

---

## 🚀 Key Features

* **Secure User Authentication**: Implemented end-to-end security using **Spring Security** and **JSON Web Tokens (JWT)** for user registration and stateless API authentication.
* **Full CRUD Functionality**: Robust RESTful APIs for creating, reading, updating, and deleting journal entries, with data persisted in a **MongoDB** database.
* **Scalable and Maintainable Code**: Built with a layered architecture (Controller, Service, Repository) to ensure separation of concerns and maintainability.
* **Centralized Exception Handling**: Provides consistent and meaningful error responses across the API for a better developer experience.

---

## 🏛️ Architecture Overview

The application follows a modern, layered architecture designed for scalability and clear separation of concerns.

1.  **REST API Layer**: The entry point is a set of RESTful controllers that handle all incoming HTTP requests from the client.
2.  **Security Layer**: **Spring Security** intercepts requests to protected endpoints, validating the JWT provided in the `Authorization` header to authenticate and authorize the user.
3.  **Service Layer**: Business logic is encapsulated within service classes, which orchestrate data flow and interact with the data access layer.
4.  **Data Access Layer**: Repositories, built using **Spring Data MongoDB**, handle all database interactions, abstracting away the boilerplate code for MongoDB operations.

This design ensures that the application is modular, easy to test, and simple to maintain as new features are added.

---

## 🛠️ Tech Stack

| Category     | Technology                               |
| :----------- | :--------------------------------------- |
| **Language** | Java 17                                  |
| **Framework**| Spring Boot                              |
| **Database** | MongoDB (with Spring Data MongoDB)       |
| **Security** | Spring Security, JWT                     |
| **Build Tool** | Maven                                    |
| **API** | RESTful APIs                             |
| **Libraries**| Lombok, JJWT                             |

---

## 📖 API Endpoints

The following are the primary API endpoints exposed by the application:

| Method   | Endpoint             | Description                                          |
| :------- | :------------------- | :--------------------------------------------------- |
| **POST** | `/api/auth/register` | Registers a new user account.                        |
| **POST** | `/api/auth/login`    | Authenticates a user and returns a JWT.              |
| **GET** | `/api/journals`      | **(Protected)** Fetches all entries for the logged-in user. |
| **POST** | `/api/journals`      | **(Protected)** Creates a new journal entry.         |
| **GET** | `/api/journals/{id}` | **(Protected)** Retrieves a single journal entry by its ID. |
| **PUT** | `/api/journals/{id}` | **(Protected)** Updates an existing journal entry.   |
| **DELETE** | `/api/journals/{id}` | **(Protected)** Deletes a journal entry.             |

---

## 📬 Contact

Partha Dey

Project Link: [https://github.com/Partha-Dey001/journalApp](https://github.com/Partha-Dey001/journalApp)
