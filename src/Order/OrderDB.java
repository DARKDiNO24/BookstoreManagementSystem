package Order;

import Book.book;
import Customer.customer;
import JDBCcon.jdbcConn;
import org.ietf.jgss.Oid;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static JDBCcon.jdbcConn.con;

public class OrderDB {
    Statement st;
    ResultSet rs;


    public OrderDB(){
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
    public void createTableOrder() {
        try (Statement stmt = con.createStatement()) {
            String query = "CREATE TABLE Orders("
                    + "Oid NUMBER (20) PRIMARY KEY, "
                    + "Name VARCHAR (20), "
                    + "BName VARCHAR (20), "
                    + "FOREIGN KEY (Name) REFERENCES Cus(Name), "
                    + "FOREIGN KEY (BName) REFERENCES Book1(BName))";
            stmt.execute(query);
            System.out.println("Order Table Created.");
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
    }
    public void InsertRecordOrder(int Oid,String Name,String BName) throws SQLException {
            st = jdbcConn.con.createStatement();
            String query = "INSERT INTO Orders (Oid,Name,BName ) VALUES ('" + Oid + "', '" + Name + "','"+BName+"')";
            st.executeUpdate(query);
            System.out.println("Record inserted successfully into Author table.");
    }

    public ArrayList<Order> getRecords(String qry) throws SQLException {
        st=jdbcConn.con.createStatement();
        rs=st.executeQuery(qry);
        ArrayList<Order> ae=new ArrayList<>();
        while (rs.next()){
            int Oid=rs.getInt("Oid");
            String Name=rs.getString("Name");
            String BName= rs.getString("BName");
            ae.add(new Order(Oid,Name,BName));
        }
        return ae;
    }


}
