package GssAppRun.com;

import GssException.com.OrderException;
import GssException.com.customerException;
import GssImplemention.com.OrderImplemention;
import GssImplemention.com.customerImplemention;
import Model.gss.com.CustomerDetails;
import Model.gss.com.orderDetails;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, customerException, OrderException {
        customerImplemention cus =new customerImplemention();
        OrderImplemention ord=new OrderImplemention();

            System.out.println("Press 1 for Customer ---------------------------- Press 2 For Order");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Press 1 for View Customer Details"+"\n"+"Press 2 For Add Data In Customer Table"+"\n"+"Press 3 for Update in Customer table");
                    int choice1= scanner.nextInt();
                    if(choice1==1) {
                        List<CustomerDetails> customerList = cus.retriveCustomerData();
                        System.out.println("All CustomerDetails in Gss");
                        System.out.format("%-30s%-30s%-30s%-30s%-30s\n", "CustomerID", "CustomerName", "Location", "EmailId", "MobileNumber");
                        System.out.println("*********************************************************************************************************************************************************************************");
                        for (CustomerDetails c : customerList) {
                            System.out.format("%-30s%-30s%-30s%-30s%-30s\n", c.getCustomerId(), c.getCustomerName(), c.getLocation(), c.getEmailid(), c.getMobNumber());
                        }
                    }
                    else if(choice1==2){

                        cus.AddingcustomerDetail();
                    }
                    else if(choice1==3){
                        cus.UpdateCustomerdetail();

                }
                    case 2:
                        System.out.println("Press 1 for View Order Details"+"\n"+"Press 2 For Add Data In Order Table"+"\n"+"Press 3 for Update in Order table");
                        int choice2=scanner.nextInt();
                        if(choice2==1){
                            List<orderDetails> orderList=ord.retriveOrderData();
                            System.out.format("%-30s%-30s%-30s%-30s\n", "OrderID", "Quantity", "DateOforder", "CustomerId");
                            System.out.println("*************************************************************************************");
                            for(orderDetails o:orderList){
                                System.out.format("%-30s%-30s%-30s%-30s\n", o.getOrderId(), o.getQuantity(), o.getOrderDate(),o.getCustId());
                            }
                        }
                        else if(choice2==2){
                            ord.AddingOrderDetail();

                    }
                        else if(choice2==3){
                            ord.UpdateOrderdetail();
                        }


            }
        }




    }

