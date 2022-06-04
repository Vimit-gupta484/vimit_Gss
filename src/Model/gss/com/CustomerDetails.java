package Model.gss.com;

public class CustomerDetails {
    int customerId;
    String CustomerName;
    String location;
    String Emailid;
    Long MobNumber;
    public CustomerDetails(int customerId, String customerName, String location, String emailid, Long mobNumber) {
        this.customerId = customerId;
        CustomerName = customerName;
        this.location = location;
        Emailid = emailid;
        MobNumber = mobNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmailid() {
        return Emailid;
    }

    public void setEmailid(String emailid) {
        Emailid = emailid;
    }

    public Long getMobNumber() {
        return MobNumber;
    }

    public void setMobNumber(Long mobNumber) {
        MobNumber = mobNumber;
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "customerId=" + customerId +
                ", CustomerName='" + CustomerName + '\'' +
                ", location='" + location + '\'' +
                ", Emailid='" + Emailid + '\'' +
                ", MobNumber=" + MobNumber +
                '}';
    }
}
