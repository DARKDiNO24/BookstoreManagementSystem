package Customer;

import Book.book;
import JDBCcon.jdbcConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static JDBCcon.jdbcConn.con;

public class customerDB {
    Statement st;
    ResultSet rs;


    public customerDB(){
        super();
        this.st=null;
        this.rs=null;

    }

    public ResultSet getData(String qry) throws SQLException {
        st = jdbcConn.con.createStatement();
        rs=st.executeQuery(qry);
        int cnt=st.executeUpdate(qry);
        return rs;
    }

    public void createTableCustomer() {
        try (Statement stmt = con.createStatement()) {
            String query = "CREATE TABLE Cus("
                    + "Name VARCHAR (20) PRIMARY KEY, "
                    + "age NUMBER (20) NOT NULL, "
                    + "Phone NUMBER (20) NOT NULL)";
            stmt.execute(query);
            System.out.println("Customer Table Created.");
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
    }
    public void InsertRecordCus(String Name, int age,int Phone) {
        try (Statement st = con.createStatement()) {
            String query = "INSERT INTO Cus (Name, age,Phone) VALUES ('" + Name + "', '" + age + "','"+Phone+"')";
            st.executeUpdate(query);
            System.out.println("Record inserted successfully into Author table.");
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
    }
    public ArrayList<customer> getRecords(String qry) throws SQLException {
        st = jdbcConn.con.createStatement();
        rs = st.executeQuery(qry);
        ArrayList<customer> ae = new ArrayList<>();
        while (rs.next()) {
            String Name = rs.getString("Name");
            int age = rs.getInt("age");
            int phone = rs.getInt("phone");
            ae.add(new customer(Name,age,phone));

        }
        rs.close();
        return ae;
    }

}
