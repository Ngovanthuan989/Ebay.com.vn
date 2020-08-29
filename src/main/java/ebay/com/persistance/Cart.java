package ebay.com.persistance;

public class Cart {
    private int order_id;
    private int product_id;
    private String product_code;
    private String product_name;
    private double promotion_price;
    private int amount;
    private String unit_price;



    public Cart(){

    }
    public Cart(int order_id,int product_id,String product_code,String product_name,double promotion_price,int amount,String unit_price){
        this.order_id=order_id;
        this.product_id=product_id;
        this.product_code=product_code;
        this.product_name=product_name;
        this.promotion_price=promotion_price;
        this.amount=amount;
        this.unit_price=unit_price;

    }

    public int getOrder_id() {
        return order_id;
    }
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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
    public int getProduct_id() {
        return product_id;
    }
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public double getPromotion_price() {
        return promotion_price;
    }
    public void setPromotion_price(double promotion_price) {
        this.promotion_price = promotion_price;
    }
    public String getUnit_price() {
        return unit_price;
    }
    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }
}
