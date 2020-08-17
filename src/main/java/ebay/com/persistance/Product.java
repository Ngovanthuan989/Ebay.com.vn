package ebay.com.persistance;

public class Product {

    private int product_id;
    private String product_code;
    private String product_name;
    private int supplier_id;
    private int category_id;
    private int brand_id;
    private double product_price;
    private double promotion_price;
    private String product_desc;
    private int product_amount;
    private String product_status;
    private String product_date;

    public Product(){

    }
    public Product(int product_id,String product_code, String product_name, int supplier_id, int category_id, int brand_id, double product_price, double promotion_price, String product_desc, int product_amount, String product_status, String product_date){

        this.product_id = product_id;
        this.product_code = product_code;
        this.product_name = product_name;
        this.supplier_id = supplier_id;
        this.category_id = category_id;
        this.brand_id = brand_id;
        this.product_price = product_price;
        this.promotion_price = promotion_price;
        this.product_desc = product_desc;
        this.product_amount = product_amount;
        this.product_status = product_status;
        this.product_date = product_date;
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
    public int getSupplier_id() {
        return supplier_id;
    }
    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }
    public int getCategory_id() {
        return category_id;
    }
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    public int getBrand_id() {
        return brand_id;
    }
    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
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
    public String getProduct_date() {
        return product_date;
    }
    public void setProduct_date(String product_date) {
        this.product_date = product_date;
    }
    public String getProduct_status() {
        return product_status;
    }
    public void setProduct_status(String product_status) {
        this.product_status = product_status;
    }
}
