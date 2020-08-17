package ebay.com.persistance;


public class Brand_Product {
   private int brand_id;
   private int category_id;
   private String brand_name;
   private String brand_date;


   public Brand_Product(){

   }
   public Brand_Product(int brand_id, int category_id, String brand_name, String brand_date){
      this.brand_id = brand_id;
      this.category_id = category_id;
      this.brand_name = brand_name;
      this.brand_date = brand_date;
   }

   public int getBrand_id() {
       return brand_id;
   }
   public void setBrand_id(int brand_id) {
       this.brand_id = brand_id;
   }
   public int getCategory_id() {
       return category_id;
   }
   public void setCategory_id(int category_id) {
       this.category_id = category_id;
   }
   public String getBrand_name() {
       return brand_name;
   }
   public void setBrand_name(String brand_name) {
       this.brand_name = brand_name;
   }
   public String getBrand_date() {
       return brand_date;
   }
   public void setBrand_date(String brand_date) {
       this.brand_date = brand_date;
   }

}
