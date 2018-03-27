package example.action;

import example.iinterface.DatabaseAction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreation implements DatabaseAction {
    public TableCreation() {

    }

    @Override
    public void actionActivityDatabase(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("use test");
            statement.execute("CREATE TABLE IF NOT EXISTS PERSON(ID int," +
                    "NAME VARCHAR (255)," +
                    "ADDRESS VARCHAR (20)," +
                    "phone int UNIQUE," +
                    "PRIMARY KEY (ID))");
            statement.execute("CREATE TABLE IF NOT EXISTS PHONE(ID int," +
                    "Phone CHAR(20)," +
                    "PRIMARY KEY (ID)," +
                    "FOREIGN KEY (ID) REFERENCES PERSON(ID))");

        } catch (IllegalAccessError error) {

        }

    }
}
