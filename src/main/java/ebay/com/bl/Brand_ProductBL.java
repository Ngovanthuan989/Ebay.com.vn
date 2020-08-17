package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import ebay.com.UI.CommandLineTable;
import ebay.com.dal.Brand_ProductDAL;
import ebay.com.persistance.Brand_Product;

public class Brand_ProductBL {

    static List<Brand_Product> BP = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void add_brand_product()throws SQLException{

        Brand_Product bp = new Brand_Product();
        Brand_ProductDAL brd = new Brand_ProductDAL();

        System.out.println("Enter Category_ID:");
        int category_id = Integer.parseInt(sc.nextLine());
        bp.setCategory_id(category_id);
        System.out.println("Enter Brand_Name:");
        String brand_name = sc.nextLine();
        bp.setBrand_name(brand_name);

        Calendar c = Calendar.getInstance();

        int year = c.get(Calendar.YEAR);
        // return value 0->11;
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        bp.setBrand_date(""+year+"-"+(month+1)+"-"+day);

        BP.add(bp);

        brd.insert_brand_product(bp);
    }

    public static void edit_brand_product()throws SQLException{

        Brand_Product bp = new Brand_Product();
        Brand_ProductDAL brd = new Brand_ProductDAL();

        System.out.println("Enter Brand_ID:");
        int brand_id = Integer.parseInt(sc.nextLine());
        bp.setBrand_id(brand_id);
        System.out.println("Update Category_Id:");
        int category_id = Integer.parseInt(sc.nextLine());
        bp.setCategory_id(category_id);
        System.out.println("Update Brand_Name:");
        String brand_name =  sc.nextLine();
        bp.setBrand_name(brand_name);

        Calendar c = Calendar.getInstance();

        int year = c.get(Calendar.YEAR);
        // return value 0->11;
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        bp.setBrand_date(""+year+"-"+(month+1)+"-"+day);

        BP.add(bp);

        brd.update_brand_product(bp, brand_id);

    }

    public static void show_brand_product() throws SQLException{

        BP = new Brand_ProductDAL().select_brand_product();
        CommandLineTable CT = new CommandLineTable();

        CT.setShowVerticalLines(true);
        CT.setHeaders("Brand_ID","Category_ID","Brand_Name","Brand_Date");
        for (int i = 0; i < BP.size(); i++) {

            CT.addRow(String.valueOf(BP.get(i).getBrand_id()),String.valueOf(BP.get(i).getCategory_id()),String.valueOf(BP.get(i).getBrand_name()),String.valueOf(BP.get(i).getBrand_date()));
        }
        CT.print();
    }
}
