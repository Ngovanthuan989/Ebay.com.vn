package ebay.com.persistance;

public class Order_Details {
   private int products_id;
   private int order_id;
   private int amount;


   public Order_Details(){

   }
   public Order_Details(int product_id,int order_id,int amount){
      this.products_id = product_id;
      this.order_id =order_id;
      this.amount = amount;
   }
   public int getProducts_id() {
       return products_id;
   }
   public void setProducts_id(int products_id) {
       this.products_id = products_id;
   }
   public int getOrder_id() {
       return order_id;
   }
   public void setOrder_id(int order_id) {
       this.order_id = order_id;
   }
   public int getAmount() {
       return amount;
   }
   public void setAmount(int amount) {
       this.amount = amount;
   }
}
