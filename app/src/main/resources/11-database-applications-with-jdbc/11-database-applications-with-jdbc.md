# JDBC (Java Database Connectivity)

Provides the API for accessing and processing data stored in a data source (usually a relational database) using the Java™ programming language.

## JDBC interfaces

- `java.sql.Driver`
- `java.sql.Connection`
- `java.sql.Statement`
- `java.sql.PreparedStatement`
- `java.sql.CallableStatement`
- `java.sql.ResultSet`
- `javax.sql.DataSource`

## JDBC urls

```
protocol:subprotocol://subname
```

```
jdbc:vendor://host:port/schema
```

### examples
```
jdbc:mysql://localhost:3306/myschema
jdbc:postgresql://localhost/myschema
jdbc:oracle:thin:@localhost:myschema
jdbc:derby:myschema
jdbc:h2:~/myschema
```

## connecting to a database

### Driver Manager
```java
Connection connection = DriverManager.getConnection("jdbc:derby:myschema")
// Connection connection = DriverManager.getConnection("jdbc:derby:myschema", "user", "password")
```

### Data Source

```java        
Context context = new InitialContext();
DataSource dataSource = (DataSource) context.lookup("jdbc/billingDB");
Connection connection = dataSource.getConnection();
// Connection connection = dataSource.getConnection(user, password);
```


## try-with-resources

```java

try (Connection connection = DriverManager.getConnection("jdbc:derby:myschema")) {
    Statement statement = connection.prepareStatement("SELECT * FROM table");
    ResultSet resultSet = statement.executeQuery();
    while (resultSet.next()) {
        System.out.println(resultSet.getString("column"));    
    }
}
```


## `PreparedStatement`


## `CallableStatement`


## JDBC exceptions

- `java.sql.SQLException` and it's subclasses