package ebay.com.persistance;

public class Product_Options_Details {
    private int product_id;
    private String product_code;
    private String product_name;
    private String tbl_options_name;
    private String options_name;


    public Product_Options_Details(){


    }

    public Product_Options_Details(int product_id,String product_code,String product_name,String tbl_options_name,String options_name){

        this.product_id = product_id;
        this.product_code = product_code;
        this.product_name = product_name;
        this.tbl_options_name = tbl_options_name;
        this.options_name = options_name;
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
    public String getTbl_options_name() {
        return tbl_options_name;
    }
    public void setTbl_options_name(String tbl_options_name) {
        this.tbl_options_name = tbl_options_name;
    }
    public String getOptions_name() {
        return options_name;
    }
    public void setOptions_name(String options_name) {
        this.options_name = options_name;
    }
}
