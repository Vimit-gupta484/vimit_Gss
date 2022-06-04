package GssImplemention.com;

import GssException.com.customerException;
import GssInterfaces.com.Icustomer;
import Model.gss.com.CustomerDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static connection.com.utilityconnection.getConnection;

public class customerImplemention implements Icustomer {

    @Override
    public List<CustomerDetails> retriveCustomerData() throws customerException, SQLException, ClassNotFoundException {
       List<CustomerDetails> customerList=new ArrayList<>();
       try{
           getConnection();//establish the connection
           Statement stmt=getConnection().createStatement();//
           ResultSet rs=stmt.executeQuery("select * from customerdetail");
           while(rs.next()){
               int customerId=rs.getInt(1);
               String Name=rs.getString(2);
               String loc=rs.getString(3);
               String Emailid= rs.getString(4);
               Long MobNum=rs.getLong(5);
               CustomerDetails cust=new CustomerDetails(customerId,Name,loc,Emailid,MobNum);
               customerList.add(cust);
           }
       }
       catch (Exception e){
           e.printStackTrace();
       }
       return customerList;
    }

    @Override
    public void AddingcustomerDetail() throws customerException, SQLException, ClassNotFoundException {
        try{
            getConnection();
            System.out.println("Add the Data in Customer Detail Table");
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter THe Customer Name");
            String Name= scanner.next();
            System.out.println("Enter the Customer Location");
            String Location= scanner.next();
            System.out.println("Enter the customer EmailId");
            String EmailId= scanner.next();
            System.out.println("Enter the Customer Contact number");
            long MobNumber= scanner.nextLong();
            PreparedStatement ps =getConnection().prepareStatement("insert into customerdetail (customerName,location,Emailid,Mobnumber) value (?,?,?,?)");
            ps.setString(1,Name);
            ps.setString(2,Location);
            ps.setString(3,EmailId);
            ps.setLong(4,MobNumber);
            int rowAff=ps.executeUpdate();
            if(rowAff>0){
                System.out.println("Details Added Successfully");
            }
            else{
                System.out.println("Oops their is Error in data updation");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateCustomerdetail() throws customerException, SQLException, ClassNotFoundException {
        try{
            getConnection();
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter the CustomerId");
            int customerId= scanner.nextInt();
            System.out.println("enter the Updated MobileNumber");
            long MobileNo=scanner.nextLong();
            PreparedStatement ps=getConnection().prepareStatement("update customerdetail set MobNumber=? where customerId=?");
            ps.setLong(1,MobileNo);
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
