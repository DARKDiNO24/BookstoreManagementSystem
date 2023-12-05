package JDBCcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcConn {

    public static Connection con;
    static {
        con=null;
    }

    public void createConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jatin","2408");
            System.out.println("done");

        }catch(ClassNotFoundException ce) {
            System.out.println(ce.getMessage());

        }catch(SQLException se) {
            System.out.println(se.getMessage());
        }
    }

}
