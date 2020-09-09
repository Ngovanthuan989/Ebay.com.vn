package ebay.com.persistance;

/**
 * Product_Details
 */
public class Product_Details {


    private int product_id;
    private String product_code;
    private String product_name;
    private String category_name;
    private String brand_name;
    private double product_price;
    private double promotion_price;
    private String product_desc;
    private int product_amount;
    private String product_status;

    public Product_Details(){

    }
    public Product_Details(int product_id,String product_code, String product_name, String category_name, String brand_name, double product_price, double promotion_price, String product_desc, int product_amount, String product_status){

        this.product_id = product_id;
        this.product_code = product_code;
        this.product_name = product_name;
        this.category_name = category_name;
        this.brand_name = brand_name;
        this.product_price = product_price;
        this.promotion_price = promotion_price;
        this.product_desc = product_desc;
        this.product_amount = product_amount;
        this.product_status = product_status;
    }

    public int getProduct_id() {
        return product_id;
    }
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    public String getProduct_code() {
        return product_code;
    }
    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }
    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public String getBrand_name() {
        return brand_name;
    }
    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }
    public String getCategory_name() {
        return category_name;
    }
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    public double getProduct_price() {
        return product_price;
    }
    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }
    public double getPromotion_price() {
        return promotion_price;
    }
    public void setPromotion_price(double promotion_price) {
        this.promotion_price = promotion_price;
    }
    public int getProduct_amount() {
        return product_amount;
    }
    public void setProduct_amount(int product_amount) {
        this.product_amount = product_amount;
    }
    public String getProduct_desc() {
        return product_desc;
    }
    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }
    public String getProduct_status() {
        return product_status;
    }
    public void setProduct_status(String product_status) {
        this.product_status = product_status;
    }
}
