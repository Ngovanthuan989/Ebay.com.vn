package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ebay.com.UI.CommandLineTable;
import ebay.com.dal.Product_DetailsDAL;
import ebay.com.persistance.Product_Details;
import ebay.com.validate.Validate;

public class Product_DetailsBL {

    static List<Product_Details> PD = new ArrayList<>();

    public static void show_product_details() throws SQLException{

        System.out.println("Enter Product_ID:");
        int product_id =Integer.parseInt(new Validate().checkINT());


        PD = new Product_DetailsDAL().select_productID2(product_id);

        CommandLineTable CT = new CommandLineTable();
        CT.setShowVerticalLines(true);
        CT.setHeaders("Product_ID","Product_Code","Product_Name","Category_Name","Brand_Name","Product_Price","Promotion_Price","Product_desc","Product_Status");


        for (int i = 0; i < PD.size(); i++) {
           CT.addRow(String.valueOf(PD.get(i).getProduct_id()),String.valueOf(PD.get(i).getProduct_code()),String.valueOf(PD.get(i).getProduct_name()),String.valueOf(PD.get(i).getCategory_name()),
           String.valueOf(PD.get(i).getBrand_name()),String.valueOf(PD.get(i).getProduct_price()),String.valueOf(PD.get(i).getPromotion_price()),String.valueOf(PD.get(i).getProduct_desc()),
           String.valueOf(PD.get(i).getProduct_status()));
        }
        CT.print();
    }
}
