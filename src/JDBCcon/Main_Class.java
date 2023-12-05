package JDBCcon;

import Author.AuthorDB;
import Book.book;
import Book.bookDB;
import Customer.customer;
import Customer.customerDB;
import Order.Order;
import Order.OrderDB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main_Class {
    public static void main(String[] args) throws IOException, SQLException {
        jdbcConn jd=new jdbcConn();
        jd.createConnection();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        AuthorDB AU=new AuthorDB();
        /*AU.createTableAuthor();
        AU.InsertRecordAuthor("JATIN","J.COM");
        AU.InsertRecordAuthor("SWARAJ","S.COM");*/

        bookDB BK=new bookDB();
        /*BK.createTableBook();
        BK.InsertRecordBook("LIFE",800,"JATIN");
        BK.InsertRecordBook("DEADLIFE",700,"SWARAJ");*/

        customerDB cus=new customerDB();
        /*cus.createTableCustomer();
        cus.InsertRecordCus("J",23,78965);
        cus.InsertRecordCus("S",18,74562);*/

        OrderDB OB=new OrderDB();
        /*OB.createTableOrder();
        OB.InsertRecordOrder(1,"J","LIFE");
        OB.InsertRecordOrder(2,"S","DEADLIFE");*/

        System.out.println("Chose one option");
        System.out.println("1 for register customer");
        System.out.println("2 for view book list");
        System.out.println("3 for place order");
        System.out.println("4 for view order");
        System.out.println("5 for search order");

        int opr=Integer.parseInt(br.readLine());
        switch (opr){
            case 1:
                System.out.println("Enter a customer name");
                String N1= br.readLine();
                System.out.println("Enter a customer age");
                int n2=Integer.parseInt(br.readLine());
                System.out.println("enter a customer phone number");
                int n3=Integer.parseInt(br.readLine());

                cus.InsertRecordCus(N1,n2,n3);
                ArrayList<customer> cu=new ArrayList<>();
                Iterator<customer> It1=cu.iterator();
                while (It1.hasNext()){
                    System.out.println(It1.next());
                }

                break;
            case 2:
                System.out.println("Available books are");
                ArrayList<book> od=BK.getRecords("select * from Book1");
                Iterator<book> it= od.iterator();
                while (it.hasNext()){
                    System.out.println(it.next().getBName());
                }
                break;
            case 3:
                System.out.println("Place order started");
                ArrayList<book> od1=BK.getRecords("select* from Book1");
                Iterator<book> it1= od1.iterator();
                System.out.println("This books are available");
                while (it1.hasNext()){
                    System.out.println(it1.next());
                }
                System.out.println("Which book want to be order");
                String A1= br.readLine();
                System.out.println("Enter your name");
                String A2= br.readLine();
                System.out.println("enter a order Id");
                int A3=Integer.parseInt(br.readLine());
                OB.InsertRecordOrder(A3,A2,A1);
                System.out.println("Your order successful place");
                break;
            case 4:
                System.out.println("View order");
                ArrayList<Order> ord=OB.getRecords("select * from Orders");
                Iterator<Order> itO= ord.iterator();
                while (itO.hasNext()){
                    System.out.println(itO.next());
                }
                break;
            case 5:
                System.out.println("View your order");
                System.out.println("Enter your order id");
                int O1=Integer.parseInt(br.readLine());
                boolean found=false;
                ArrayList<Order> Od=OB.getRecords("select * from Orders");
                for(Order o:Od){
                    if(o.getOid()==O1){
                        found=true;
                        System.out.println("This is your order :"+o);
                        break;
                    }
                    break;
                }
                if(!found){
                    System.out.println("Your enter wrong order id");
                }
                break;
            default:
                System.out.println("Your chose invalid number");
        }

    }
}
