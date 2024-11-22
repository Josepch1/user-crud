# User Management Service 🚀

This project is a User Management Service built with **Spring Boot**. It provides functionalities to create, retrieve, update, and delete user information in a database.

## Features ✨

- **Create User**: Add a new user to the database.
- **Retrieve Users**: Fetch all users or a specific user by username or ID.
- **Update User**: Modify existing user details.
- **Delete User**: Remove a user from the database.

## Technologies Used 🛠️

- **Java 23**
- **Spring Boot 3.3.5**
- **JUnit 5** for testing
- **Mockito** for mocking dependencies

## Getting Started 🏁

### Prerequisites

- Java 23 or higher
- Maven 4.0.0 or higher

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/Josepch1/user-crud.git
    ```
2. Navigate to the project directory:
    ```sh
    cd user-crud
    ```
3. Build the project:
    ```sh
    ./mvnw clean package
    ```

### Running the Application

To run the application, use the following command:
```sh
java -jar target/user-0.0.1-SNAPSHOT.jar
```

### Running Tests

To execute the tests, use the following command:
```sh
./mvnw test
```

## Usage 📖

### Creating a User

To create a user, send a POST request to `/users` with the user details in the request body.

### Retrieving Users

- To get all users, send a GET request to `/users`.
- To get a user by username, send a GET request to `/users/username/{username}`.
- To get a user by ID, send a GET request to `/users/{id}`.

### Updating a User

To update a user, send a PUT request to `/users/{id}` with the updated user details in the request body.

### Deleting a User

To delete a user, send a DELETE request to `/users/{id}`.

## Contributing 🤝

Contributions are welcome! Please fork the repository and submit a pull request for review.


## Acknowledgements 🙏

- Thanks to the open-source community for their valuable contributions.
- Special thanks to the developers and maintainers of the libraries and frameworks used in this project.

Feel free to reach out if you have any questions or suggestions! 😊