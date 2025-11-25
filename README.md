# Task-Tracker-App (API)

A backend REST API for managing tasks and task-lists, built with Spring Boot and microservices-ready architecture.

---

## 🧩 Overview  
This application lets users create, manage and organize tasks into lists. Built using Spring Boot, it supports features like:
- User-defined task-lists  
- CRUD operations on tasks and lists  
- Task priority & status tracking via enums  
- Clean layered architecture (controllers, services, repositories)  
- MySQL (or any relational DB) as persistence  
- Docker support via `docker-compose.yml`

---

## 🧑‍💻 Tech Stack  
- Java & Spring Boot  
- Spring Data JPA & MySQL  
- RESTful APIs  
- Docker & Docker Compose  
- Maven build system  
- Enum types for TaskStatus, TaskPriority  

---

## 🚀 Getting Started

**Prerequisites**:  
- Java (11 or later)  
- Maven  
- MySQL (or compatible)  
- Docker and Docker Compose (optional)

**Steps**:  
1. Clone this repo:  
   ```bash
   git clone https://github.com/Debasish3209/Task-Tracker-App.git
   cd Task-Tracker-App/Task-Tracker-API
   ```
2. Configure `src/main/resources/application.properties` for your DB (username, password, URL).  
3. Run the application:  
   ```bash
   mvn spring-boot:run
   ```
   Or build & run jar:  
   ```bash
   mvn clean package
   java -jar target/TaskTrackerApplication.jar
   ```
4. *(Optional)* With Docker:  
   ```bash
   docker-compose up
   ```
   Ensure `docker-compose.yml` DB service credentials match `application.properties`.

---

## 📋 Key Features & API Endpoints

### Task Lists  
- Create a list: `POST /task-lists`  
- Get lists: `GET /task-lists`  
- Get by ID: `GET /task-lists/{id}`  
- Update: `PUT /task-lists/{id}`  
- Delete: `DELETE /task-lists/{id}`  

### Tasks  
- Create a task in a list: `POST /tasks`  
- Get tasks: `GET /tasks`  
- Get by ID: `GET /tasks/{id}`  
- Update: `PUT /tasks/{id}`  
- Delete: `DELETE /tasks/{id}`  

**Enums used**:  
- `TaskStatus`: e.g., NEW, IN_PROGRESS, COMPLETED  
- `TaskPriority`: e.g., LOW, MEDIUM, HIGH  

---

## 🔧 Architecture & Structure  
```
src/
  main/
    java/com/debasish/
      controller/
      service/
      repository/
      dto/
      entity/
      enums/
    resources/
      application.properties
```

- Controllers: handle HTTP requests  
- Services: business logic  
- Repositories: data access using Spring Data JPA  
- DTOs: data transfer between layers  
- Entities: JPA-mapped domain objects  
- Enums: fixed constant types for status & priority  

---

## ✅ Why This Project?  
- Clean code/style with layered architecture  
- Type safety via enums instead of magic strings  
- Scalability: Suitable for microservices / cloud deployment  
- Container-friendly via Docker support  

---

## 🛠 Future Improvements  
- Add authentication & authorization (e.g., Spring Security + JWT)  
- Add user management & multi-user support  
- Write integration tests & API documentation (Swagger)  
- Add pagination, filtering, search for tasks  
- Add UI frontend (React/Angular) with this backend  

---

## 📝 Author  
**Debasish Nayak**  
- Email: debasishnayak3209@gmail.com  
- Languages: Hindi, English, Odia  
- Skills: Core Java, Advanced Java, Spring Boot, MySQL, HTML/CSS/JS, Microservices, Docker, AWS  

---

Thank you for exploring this project!  
Feel free to open issues or pull requests for improvements.
