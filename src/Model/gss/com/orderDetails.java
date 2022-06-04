package Model.gss.com;

public class orderDetails {
    int orderId;
    int Quantity;
    String orderDate;
    int custId;

    public orderDetails(int orderId, int quantity, String orderDate, int custId) {
        this.orderId = orderId;
        Quantity = quantity;
        this.orderDate = orderDate;
        this.custId = custId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    @Override
    public String toString() {
        return "orderDetails{" +
                "orderId=" + orderId +
                ", Quantity=" + Quantity +
                ", orderDate='" + orderDate + '\'' +
                ", custId=" + custId +
                '}';
    }
}
