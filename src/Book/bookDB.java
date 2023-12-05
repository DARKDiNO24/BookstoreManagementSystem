package Book;

import Author.Author;
import JDBCcon.jdbcConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static JDBCcon.jdbcConn.con;

public class bookDB {
    Statement st;
    ResultSet rs;


    public bookDB(){
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

    public void createTableBook() throws SQLException {
        st = con.createStatement();
        {
            String qry = "CREATE TABLE Book1("
                    + "BName VARCHAR (20) PRIMARY KEY, "
                    + "price NUMBER (20), "
                    + "AName VARCHAR(20) REFERENCES Author(AName))";
            st.executeQuery(qry);
            System.out.println("Book Table Created.");
        }
    }
    public void InsertRecordBook(String BName, int price,String AName) throws SQLException {
            st = jdbcConn.con.createStatement() ;
            String qry = "INSERT INTO Book1(BName,price,AName) VALUES ('" + BName + "', '" + price + "','"+AName+"')";
            st.executeUpdate(qry);
            System.out.println("Record inserted successfully into Author table.");

    }
    public ArrayList<book> getRecords(String qry) throws SQLException {
        st = jdbcConn.con.createStatement();
        rs = st.executeQuery(qry);
        ArrayList<book> ae = new ArrayList<>();
        while (rs.next()) {
            String BName = rs.getString("BName");
            int price = rs.getInt("price");
            String AName = rs.getString("AName");
            ae.add(new book(BName,price,AName));

        }
        rs.close();
        return ae;
    }


}
