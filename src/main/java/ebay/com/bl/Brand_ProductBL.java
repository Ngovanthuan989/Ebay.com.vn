package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import ebay.com.UI.CommandLineTable;
import ebay.com.dal.Brand_ProductDAL;
import ebay.com.dal.Category_ProductDAL;
import ebay.com.persistance.Brand_Product;
import ebay.com.persistance.Category_Product;
import ebay.com.validate.Validate;

public class Brand_ProductBL {

    static List<Brand_Product> BP = new ArrayList<>();
    static List<Category_Product> CAP = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void add_brand_product()throws SQLException{

        Brand_Product bp = new Brand_Product();
        Brand_ProductDAL brd = new Brand_ProductDAL();
        boolean check = true;
        while (check) {
            System.out.println("Enter Category_ID:");
            int category_id = Integer.parseInt(new Validate().checkINT());
            bp.setCategory_id(category_id);
            CAP = new Category_ProductDAL().Select_Category_Product();
            int kt=0;
            for (int i = 0; i < CAP.size(); i++) {
            if (CAP.get(i).getCategory_id()==category_id) {
                kt=1;

            }
        }
            if (kt==1) {
                System.out.println("Category_ID tồn tại");
                check=false;
                System.out.println("Enter Brand_Name:");
                String brand_name = new Validate().checkEmpty();
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
            else{
                System.out.println("Category_ID không tồn tại! Mời Nhập Lại!");
                check=true;
            }
        }


    }

    public static void edit_brand_product()throws SQLException{

        Brand_Product bp = new Brand_Product();
        Brand_ProductDAL brd = new Brand_ProductDAL();

        boolean check = true;
        while (check) {
            System.out.println("Enter Brand_ID:");
            int brand_id = Integer.parseInt(new Validate().checkINT());
            bp.setBrand_id(brand_id);
            BP = new Brand_ProductDAL().select_brand_product();
            int kt = 0;

            for (int i = 0; i < BP.size(); i++) {
                if (BP.get(i).getBrand_id()==brand_id) {
                    kt = 1;

                }
            }
            if (kt == 1) {
                System.out.println("ID Tồn Tại!");
                check = false;
                boolean k = true;
                while (k) {
                    System.out.println("Update Category_Id:");
                    int category_id = Integer.parseInt(new Validate().checkINT());
                    bp.setCategory_id(category_id);
                     CAP = new Category_ProductDAL().Select_Category_Product();
                     int tt=0;
                     for (int i = 0; i < CAP.size(); i++) {
                        if (CAP.get(i).getCategory_id()==category_id) {
                            tt=1;

                     }


                }
                if (tt==1) {
                    System.out.println("Category_ID tồn tại");
                    k=false;
                    System.out.println("Update Brand_Name:");
                    String brand_name =  new Validate().checkEmpty();
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
                else{
                    System.out.println("Category_ID không tồn tại! Mời Nhập Lại");
                    k=true;
                }

            }



            } else {
                System.out.println("ID không tồn tại! Mời Nhập lại");
                check = true;

            }
        }



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
