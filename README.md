# Wild-API

A simple **RESTful API** for managing animal data, built with Spring Boot and designed for easy data retrieval and manipulation.

---

## Installation

To run this project, you'll need the following:

* **Java Development Kit (JDK) 21** or higher
* **Apache Maven 3.x**
* A **PostgreSQL** or **Neon** database configured.

### Steps to Run:

1.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/Olme-xD/Wild-API.git](https://github.com/Olme-xD/Wild-API.git)
    ```
2.  **Configure Database:**
    Navigate to the project directory and update your database connection settings (URL, username, password) in the `src/main/resources/application.properties` file.
3.  **Start the Application:**
    Run the application using the Spring Boot Maven plugin:
    ```bash
    mvn spring-boot:run
    ```
The API will start on `http://localhost:8080`.

---

## API Endpoints

All endpoints use `http://localhost:8080` as the base URL.

| Method | Endpoint | Description | Request Body | URL Parameters |
| :--- | :--- | :--- | :--- | :--- |
| **GET** | `/wild` | Retrieves a list of all wild animals. | None | None |
| **POST** | `/wild/new` | Creates a new animal record. | `Wild` object (JSON) | None |
| **PUT** | `/wild/update` | Updates an existing animal. | `Wild` object (JSON) | `id` (long) |
| **DELETE** | `/wild/delete` | Deletes a wild animal by ID. | None | `id` (long) |
| **GET** | `/wild/id` | Retrieves a wild animal by its ID. | None | `id` (long) |
| **GET** | `/wild/name` | Searches for animals by a partial name match. | None | `name` (String) |
| **GET** | `/wild/habitat` | Retrieves an animal by its habitat. | None | `habitat` (String) |

### JSON Request Body Example (`POST /wild/new`):
```json
{
  "name": "Tiger",
  "description": "A large striped cat.",
  "habitat": "forest",
  "age": 12.5
}


## Demo

A visual demonstration of how to test these API endpoints using a client tool is available here: [API Testing Demo Video](https://uncg-my.sharepoint.com/:v:/g/personal/o_matiasmol_uncg_edu/EdvH1kfvdEVKtAcBfmGp-fQBzWFJTq959hQZCWR71u0lng?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJPbmVEcml2ZUZvckJ1c2luZXNzIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXciLCJyZWZlcnJhbFZpZXciOiJNeUZpbGVzTGlua0NvcHkifX0&e=6b292q)