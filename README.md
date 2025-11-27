
# Backend Internship Assignment – Spring Boot (RAGIR)

## Overview
This project is developed as part of the Backend Internship assignment at RAGIR.  
The goal is to implement backend APIs in Spring Boot for managing organizers and providing a searchable dropdown for super admin to switch organizations.

Tech Stack:
 - Java 17
- Spring Boot (3.x preferred)
- Spring Web, Spring Data JPA
- MySQL
- Maven/Gradle

  
 Data Model (Organization):
- id
- organizerCode (auto-generated e.g., ORG00001)
- name
- email
- phone
- businessType
- status (ACTIVE/INACTIVE)
- createdAt, updatedAt



## APIs Implemented

### 1. Create New Organizer
*POST* /api/organizers  
- Creates a new organizer  
- Validates required fields  
- Auto-generates organizerCode  
- Status Codes: 201 (Created), 400 (Bad Request), 409 (Conflict)

### 2. Fetch Single Organizer
*GET* /api/organizers/{id}  
- Fetch a single organizer by id  

### 3. Search Organizers
*GET* /api/organizers/search?q=...  
- Partial search by name, email, or phone  
- Returns lightweight list of organizers  
- Supports pagination


### Database connections in application.properties file
-spring.datasource.url=jdbc:mysql://localhost:3306/[database_name]
-spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
-spring.datasource.username=[user_name]
-spring.datasource.password=[password]
-spring.jpa.hibernate.ddl-auto=update
-spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
-spring.jpa.show-sql=true

# Instructions to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/Kathera-chandraiah/backend_assesment.git

2. Navigate to the project directory:
```
cd <project_directory>
```
 
3. Build the project using Maven:
```
mvn clean install
```

4. Run the Spring Boot application:

```
mvn spring-boot:run
```


5. Application runs at: ```http://localhost:8080```

### Postmapping sample data for create new organizer:

## http://localhost:8080/api/organizers
```
{
    "name":"tharun",
    "email":"tharun@gmail.com",
    "phone":"9955678956",
    "businessType":"E_COMMERCE"
}
```
```
##Response:
{
    "name": "tharun",
    "email": "tharun@gmail.com",
    "phone": "9955678956",
    "businessType": "E_COMMERCE",
    "organizerCode": "ORG00006"
}
```
### Getmapping for get organizer by id

 ## http://localhost:8080/api/organizer/6
 ```
 #Response
{
    "name": "tharun",
    "email": "tharun@gmail.com",
    "phone": "9955678956",
    "businessType": "E_COMMERCE",
    "organizerCode": "ORG00006"
}
```
### Getmapping for seach
## http://localhost:8080/api/organizer/search?q=cha
```
{
    "content": [
        {
            "id": 2,
            "organizerCode": "ORG00002",
            "name": "chandu",
            "email": "chandu@gmail.com",
            "phone": "9988776655",
            "businessType": "EDUCATION",
            "status": "ACTIVE",
            "createdAt": "2025-11-27T14:10:24.340169",
            "updatedAt": "2025-11-27T14:10:24.340169"
        },
        {
            "id": 3,
            "organizerCode": "ORG00003",
            "name": "chandramouli",
            "email": "chandramouli@gmail.com",
            "phone": "9988657577",
            "businessType": "AGRICULTURE",
            "status": "ACTIVE",
            "createdAt": "2025-11-27T14:11:41.117979",
            "updatedAt": "2025-11-27T14:11:41.117979"
        },
        {
            "id": 4,
            "organizerCode": "ORG00004",
            "name": "chandrashekar",
            "email": "chandrashekar@gmail.com",
            "phone": "9988657577",
            "businessType": "TRANSPORTATION",
            "status": "ACTIVE",
            "createdAt": "2025-11-27T14:12:25.346014",
            "updatedAt": "2025-11-27T14:12:25.346014"
        },
        {
            "id": 5,
            "organizerCode": "ORG00005",
            "name": "chandrakanth",
            "email": "chandrakanth@gmail.com",
            "phone": "9955677485",
            "businessType": "E_COMMERCE",
            "status": "ACTIVE",
            "createdAt": "2025-11-27T14:14:18.272276",
            "updatedAt": "2025-11-27T14:14:18.272276"
        }
    ],
    "empty": false,
    "first": true,
    "last": true,
    "number": 0,
    "numberOfElements": 4,
    "pageable": {
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 10,
        "paged": true,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "unpaged": false
    },
    "size": 10,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "totalElements": 4,
    "totalPages": 1
}
```


