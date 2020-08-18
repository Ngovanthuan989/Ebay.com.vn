package ebay.com.persistance;

public class Shippingment {
    private int shipment_id;
    private String shipment_name;
    private String shipment_date;


    public Shippingment(){

    }
    public Shippingment(int shipment_id, String shipment_name,String shipment_date){

        this.shipment_id = shipment_id;
        this.shipment_name = shipment_name;
        this.shipment_date = shipment_date;

    }
    public int getShipment_id() {
        return shipment_id;
    }
    public void setShipment_id(int shipment_id) {
        this.shipment_id = shipment_id;
    }
    public String getShipment_name() {
        return shipment_name;
    }
    public void setShipment_name(String shipment_name) {
        this.shipment_name = shipment_name;
    }
    public String getShipment_date() {
        return shipment_date;
    }
    public void setShipment_date(String shipment_date) {
        this.shipment_date = shipment_date;
    }
}
