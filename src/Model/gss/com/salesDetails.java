package Model.gss.com;

public class salesDetails {
    int salesId;
    float rating;
    int commisionRate;
    String salespersonName;
    String Address;
    String trackId;
   public  salesDetails(int salesId,float rating,int commisionRate,String salespersonName,String Address,String trackId)
    {
        this.salesId=salesId;
        this.rating=rating;
        this.commisionRate=commisionRate;
        this.salespersonName=salespersonName;
        this.Address=Address;
        this.trackId=trackId;
    }
    public void setSalesId(int salesId){
       this.salesId=salesId;
    }
    public int getSalesId(){
       return salesId;
    }
    public void setRating(float rating){
       this.rating=rating;
    }
    public float getRating(){
       return rating;
    }

    public int getCommisionRate() {
        return commisionRate;
    }

    public void setCommisionRate(int commisionRate) {
        this.commisionRate = commisionRate;
    }

    public String getSalespersonName() {
        return salespersonName;
    }

    public void setSalespersonName(String salespersonName) {
        this.salespersonName = salespersonName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }
}
