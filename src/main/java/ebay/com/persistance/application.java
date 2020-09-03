package ebay.com.persistance;

import java.sql.SQLException;
import java.util.ArrayList;

import ebay.com.dal.ProductDAL;


public class application {
    public static int id_customer;
    public static String name_customer;


    public static int id_supplier;
    public static String name_supplier;


    public static int id_admin;
    public static String name_admin;


    public static int order_id;


    public static int list_productId;

    static ArrayList<Product> PR = new ArrayList<>();

    public static void show()throws SQLException{
        PR = new ProductDAL().select_productID();

        for (int i = 0; i < PR.size(); i++) {
            list_productId=PR.get(i).getProduct_id();

        }
    }

}
