package ebay.com.persistance;

public class Category_Product {
    private int category_id ;
    private String category_Name;
    private String category_date;


    public Category_Product(){

    }
    public Category_Product(int category_id, String category_name, String category_date){
       this.category_id= category_id;
       this.category_Name = category_name;
       this.category_date = category_date;
    }

    public int getCategory_id() {
        return category_id;
    }
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    public String getCategory_Name() {
        return category_Name;
    }
    public void setCategory_Name(String category_Name) {
        this.category_Name = category_Name;
    }
    public String getCategory_date() {
        return category_date;
    }
    public void setCategory_date(String category_date) {
        this.category_date = category_date;
    }
}
