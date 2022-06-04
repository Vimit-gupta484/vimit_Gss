package GssInterfaces.com;

import GssException.com.OrderException;
import GssException.com.customerException;
import Model.gss.com.orderDetails;

import java.sql.SQLException;
import java.util.List;

public interface Iorder {
    List<orderDetails> retriveOrderData() throws OrderException, SQLException,ClassNotFoundException;
    void AddingOrderDetail() throws customerException,SQLException,ClassNotFoundException;
    void UpdateOrderdetail() throws customerException,SQLException,ClassNotFoundException;
}
