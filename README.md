## **Accessing the H2 Console**

Once your Spring Boot application is running, you can access the **H2 Console** to interact with the database through a web-based interface. Follow these steps:

1. Open your browser and go to: http://localhost:8080/h2-console/

2. On the login page, enter the necessary credentials to connect to your H2 database:
- **JDBC URL**: `jdbc:h2:mem:testdb` (for in-memory) or `jdbc:h2:file:~/test` (for file-based)
- **Username**: `sa`
- **Password**: `sa`

3. Once logged in, you can run SQL queries, inspect tables, and interact with the H2 database directly.
