package GssImplemention.com;

import GssException.com.OrderException;
import GssException.com.customerException;
import GssInterfaces.com.Iorder;
import Model.gss.com.CustomerDetails;
import Model.gss.com.orderDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static connection.com.utilityconnection.getConnection;

public class OrderImplemention implements Iorder{
    @Override
    public List<orderDetails> retriveOrderData() throws OrderException, SQLException, ClassNotFoundException {
        List<orderDetails> orderList=new ArrayList<>();
        try{
            getConnection();
            Statement stmt=getConnection().createStatement();
            ResultSet rs=stmt.executeQuery("select * from orderdetails");
            while(rs.next()){
                int orderId=rs.getInt(1);
                int Quant=rs.getInt(2);
                String DateofOrder=rs.getString(3);
                int custid= rs.getInt(4);
                orderDetails ord=new orderDetails(orderId,Quant,DateofOrder,custid);
                orderList.add(ord);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return orderList;
    }
    public static int generateOrderID() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(random.nextInt(9) + 1);
        for (int i = 0; i < 3; i++) {
            sb.append(random.nextInt(10));
        }
        return Integer.valueOf(sb.toString()).intValue();
    }

    @Override
    public void AddingOrderDetail() throws customerException, SQLException, ClassNotFoundException {
        try {

            getConnection();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Customer Name , Where to Add the data in order Table");
            String custName = scanner.next();
            int orderId = generateOrderID();
            System.out.println("Enter The Quantity");
            int Quant = scanner.nextInt();
            System.out.println("Enter the Order Date");
            String Date = scanner.next();
            PreparedStatement ps1 = getConnection().prepareStatement("select customerId from CustomerDetail where customerName=?");
            ps1.setString(1, custName);
            ResultSet rs = ps1.executeQuery();
            int custId = 0;
            if (rs.next()) {
                custId = rs.getInt("customerId");
            }
            System.out.println(custId);

            PreparedStatement ps = getConnection().prepareStatement("insert into orderdetails value(?,?,?,?)");
            ps.setInt(1, orderId);
            ps.setInt(2, Quant);
            ps.setString(3, Date);
            ps.setInt(4, custId);
            int rowAffe = ps.executeUpdate();
            if (rowAffe > 0) {
                System.out.println("Data Added in Order table");
            } else {
                System.out.println("Error in data Added");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateOrderdetail() throws customerException, SQLException, ClassNotFoundException {
        try{
            getConnection();
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter the CustomerId");
            int customerId= scanner.nextInt();
            System.out.println("enter the Updated Quantity");
            int quantity=scanner.nextInt();
            PreparedStatement ps=getConnection().prepareStatement("update orderdetails set Quantity=? where custId=?");
            ps.setInt(1,quantity);
            ps.setInt(2,customerId);
            int rowAff=ps.executeUpdate();
            if(rowAff>0){
                System.out.println("Details Updated Successfully");
            }
            else{
                System.out.println("oops their is Error in updation");
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


    }

