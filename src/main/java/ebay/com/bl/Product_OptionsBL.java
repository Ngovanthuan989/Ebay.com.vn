package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ebay.com.dal.Product_OptionsDAL;
import ebay.com.persistance.Product_Options;

public class Product_OptionsBL {
    static List<Product_Options> PO = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void add_product_options()throws SQLException{
        Product_Options po = new Product_Options();
        Product_OptionsDAL pod = new Product_OptionsDAL();

        System.out.println("Enter Product_ID");
        int product_id = Integer.parseInt(sc.nextLine());
        po.setProduct_id(product_id);
        System.out.println("Enter tbl_option_id");
        int tbl_options_id = Integer.parseInt(sc.nextLine());
        po.setTbl_options_id(tbl_options_id);
        System.out.println("Enter Options_Name:");
        String options_name = sc.nextLine();
        po.setOptions_name(options_name);

        PO.add(po);
        pod.insert_product_options(po);


    }

    public static void update_product_options()throws SQLException{
        Product_Options po = new Product_Options();
        Product_OptionsDAL pod = new Product_OptionsDAL();

        System.out.println("Enter Product_Options_ID:");
        int product_options_id = Integer.parseInt(sc.nextLine());
        po.setOptions_id(product_options_id);
        System.out.println("Update Product_ID:");
        int product_id = Integer.parseInt(sc.nextLine());
        po.setProduct_id(product_id);
        System.out.println("Update tbl_options_ID:");
        int tbl_options_id = Integer.parseInt(sc.nextLine());
        po.setTbl_options_id(tbl_options_id);
        System.out.println("Update Options_Name:");
        String options_name = sc.nextLine();
        po.setOptions_name(options_name);


        PO.add(po);

        pod.update_product_options(po, product_options_id);
    }
}
