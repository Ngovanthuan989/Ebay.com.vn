package ebay.com.persistance;

public class Address_Details {

    private int address_id;
    private int customer_id;
    private String address_name;

    public Address_Details(){

    }
    public Address_Details(int address_id, int customer_id, String address_name){

        this.address_id = address_id;
        this.customer_id = customer_id;
        this.address_name = address_name;
    }
    public int getAddress_id() {
        return address_id;
    }
    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }
    public int getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
    public String getAddress_name() {
        return address_name;
    }
    public void setAddress_name(String address_name) {
        this.address_name = address_name;
    }
}
