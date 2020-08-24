package ebay.com.persistance;

public class Order {
   private int order_id;
   private int address_id;
   private int payment_id;
   private int shipment_id;
   private String customer_notes;
   private String order_status;
   private String order_date;


   public Order(){

   }
   public Order(int order_id,int address_id,int payment_id,int shipment_id,String customer_notes,String order_status,String order_date){
       this.order_id = order_id;
       this.address_id = address_id;
       this.payment_id = payment_id;
       this.shipment_id = shipment_id;
       this.customer_notes = customer_notes;
       this.order_status = order_status;
       this.order_date = order_date;
   }

   public int getOrder_id() {
       return order_id;
   }
   public void setOrder_id(int order_id) {
       this.order_id = order_id;
   }
   public int getAddress_id() {
       return address_id;
   }
   public void setAddress_id(int address_id) {
       this.address_id = address_id;
   }
   public int getPayment_id() {
       return payment_id;
   }
   public void setPayment_id(int payment_id) {
       this.payment_id = payment_id;
   }
   public int getShipment_id() {
       return shipment_id;
   }
   public void setShipment_id(int shipment_id) {
       this.shipment_id = shipment_id;
   }
   public String getCustomer_notes() {
       return customer_notes;
   }
   public void setCustomer_notes(String customer_notes) {
       this.customer_notes = customer_notes;
   }
   public String getOrder_status() {
       return order_status;
   }
   public void setOrder_status(String order_status) {
       this.order_status = order_status;
   }
   public String getOrder_date() {
       return order_date;
   }
   public void setOrder_date(String order_date) {
       this.order_date = order_date;
   }

}
