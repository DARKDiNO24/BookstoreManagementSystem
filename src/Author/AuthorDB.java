package Author;

import JDBCcon.jdbcConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static JDBCcon.jdbcConn.con;

public class AuthorDB {

    public void createTableAuthor() {
        try (Statement stmt = con.createStatement()) {
            String query = "CREATE TABLE Author("
                    + "AName VARCHAR (20) PRIMARY KEY, "
                    + "Aemail VARCHAR (20))";
            stmt.execute(query);
            System.out.println("Author Table Created.");
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
    }
    public void InsertRecordAuthor(String AName, String AEmail) {
        try (Statement stmt = con.createStatement()) {
            String query = "INSERT INTO Author (AName, AEmail) VALUES ('" + AName + "', '" + AEmail + "')";
            stmt.executeUpdate(query);
            System.out.println("Record inserted successfully into Author table.");
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
    }



}
