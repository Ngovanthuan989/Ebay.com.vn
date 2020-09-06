package ebay.com.persistance;

public class Bill {
   private int order_id;
   private int customer_id;
   private String customer_name;
   private String customer_phone;
   private int product_id;
   private String product_name;
   private double promotion_price;
   private int amount;
   private String payment_method;
   private String address_name;
   private String order_date;
   private String shipping_name;
   private double shipping_price;
   private double total;
   private String order_status;

   public Bill(){

   }
   public Bill(int order_id,int customer_id,String customer_name, String customer_phone,int product_id,String product_name,double promotion_price,int amount, String payment_method, String address_name,String order_date,String shipping_name,double shipping_price,double total,String order_status){
        this.order_id=order_id;
        this.customer_id=customer_id;
        this.customer_name=customer_name;
        this.customer_phone=customer_phone;
        this.product_id=product_id;
        this.product_name=product_name;
        this.promotion_price=promotion_price;
        this.amount=amount;
        this.payment_method=payment_method;
        this.address_name=address_name;
        this.order_date=order_date;
        this.shipping_name=shipping_name;
        this.shipping_price=shipping_price;
        this.total=total;
        this.order_status=order_status;
   }

   public int getOrder_id() {
       return order_id;
   }
   public void setOrder_id(int order_id) {
       this.order_id = order_id;
   }
   public int getCustomer_id() {
       return customer_id;
   }
   public void setCustomer_id(int customer_id) {
       this.customer_id = customer_id;
   }
   public String getCustomer_name() {
       return customer_name;
   }
   public void setCustomer_name(String customer_name) {
       this.customer_name = customer_name;
   }
   public String getCustomer_phone() {
       return customer_phone;
   }
   public void setCustomer_phone(String customer_phone) {
       this.customer_phone = customer_phone;
   }
   public int getProduct_id() {
       return product_id;
   }
   public void setProduct_id(int product_id) {
       this.product_id = product_id;
   }
   public String getProduct_name() {
       return product_name;
   }
   public void setProduct_name(String product_name) {
       this.product_name = product_name;
   }
   public double getPromotion_price() {
       return promotion_price;
   }
   public void setPromotion_price(double promotion_price) {
       this.promotion_price = promotion_price;
   }
   public int getAmount() {
       return amount;
   }
   public void setAmount(int amount) {
       this.amount = amount;
   }
   public String getPayment_method() {
       return payment_method;
   }
   public void setPayment_method(String payment_method) {
       this.payment_method = payment_method;
   }
   public String getAddress_name() {
       return address_name;
   }
   public void setAddress_name(String address_name) {
       this.address_name = address_name;
   }
   public String getOrder_date() {
       return order_date;
   }
   public void setOrder_date(String order_date) {
       this.order_date = order_date;
   }
   public String getShipping_name() {
       return shipping_name;
   }
   public void setShipping_name(String shipping_name) {
       this.shipping_name = shipping_name;
   }
   public double getShipping_price() {
       return shipping_price;
   }
   public void setShipping_price(double shipping_price) {
       this.shipping_price = shipping_price;
   }
   public String getOrder_status() {
       return order_status;
   }
   public void setOrder_status(String order_status) {
       this.order_status = order_status;
   }
   public double getTotal() {
       return total;
   }
   public void setTotal(double total) {
       this.total = total;
   }

}
