package de.dbubenheim.learning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.assertj.core.api.Assertions.assertThat;

public class JdbcTest {

    private String username = "sa";
    private String password = "";
    private String url = "jdbc:h2:mem:test";

    @BeforeEach
    public void before() throws SQLException {
        try (var connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            statement.execute("create table customer(id integer, name varchar(10))");
            statement.execute("insert into customer values (1, 'Thomas')");
            statement.execute("insert into customer values (2, 'Dieter')");
            statement.execute("insert into customer values (3, 'Jane')");
            statement.execute("insert into customer values (4, 'Andy')");
        }
    }

    @Test
    public void testPreparedStatement() throws SQLException {

        var sql = "SELECT * FROM customer";
        try (var connection = DriverManager.getConnection(url, username, password)) {

            var preparedStatement = connection.prepareStatement(sql);
            var resultSet = preparedStatement.executeQuery();
            var metaData = resultSet.getMetaData();
            assertThat(metaData.getColumnCount()).isEqualTo(4);

//            while (resultSet.next()) {
//                var id = resultSet.getInt("id");
//                var name = resultSet.getString("name");
//            }
            //assertThat(resultSet.get);
        }

    }
}