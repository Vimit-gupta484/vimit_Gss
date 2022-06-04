package GssInterfaces.com;

import GssException.com.customerException;
import Model.gss.com.CustomerDetails;

import java.sql.SQLException;
import java.util.List;

public interface Icustomer {
    List<CustomerDetails> retriveCustomerData() throws customerException, SQLException,ClassNotFoundException;
    void AddingcustomerDetail() throws customerException,SQLException,ClassNotFoundException;
    void UpdateCustomerdetail() throws customerException,SQLException,ClassNotFoundException;
}
