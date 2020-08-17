package ebay.com.persistance;

public class Product_Options {
    private int options_id ;
    private int product_id;
    private int tbl_options_id;
    private String options_name;

    public Product_Options(){

    }
    public Product_Options(int options_id, int product_id, int tbl_options_id, String options_name){
        this.options_id = options_id;
        this.product_id = product_id;
        this.tbl_options_id = tbl_options_id;
        this.options_name = options_name;

    }

    public int getOptions_id() {
        return options_id;
    }
    public void setOptions_id(int options_id) {
        this.options_id = options_id;
    }
    public int getProduct_id() {
        return product_id;
    }
    public void setOptions_name(String options_name) {
        this.options_name = options_name;
    }
    public int getTbl_options_id() {
        return tbl_options_id;
    }
    public void setTbl_options_id(int tbl_options_id) {
        this.tbl_options_id = tbl_options_id;
    }
    public String getOptions_name() {
        return options_name;
    }
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
