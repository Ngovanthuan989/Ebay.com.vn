package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import ebay.com.UI.CommandLineTable;
import ebay.com.dal.Category_ProductDAL;
import ebay.com.persistance.Category_Product;
import ebay.com.persistance.application;
import ebay.com.validate.Validate;

public class Category_ProductBL{
    static List<Category_Product> CAP = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);


    public static void add_category_product() throws SQLException{
        Category_Product cp = new Category_Product();

        Category_ProductDAL cad = new Category_ProductDAL();
        System.out.println("Enter Category_Name:");
        String category_name = new Validate().checkEmpty();
        cp.setCategory_Name(category_name);
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        // return value 0->11;
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        cp.setCategory_date(""+year+"-"+(month+1)+"-"+day);


        CAP.add(cp);
        cad.insert_category(cp);
        System.out.println("----------------------------------------------------");



    }

    public static void Show_Category_Product() throws SQLException{
        CAP = new Category_ProductDAL().Select_Category_Product();
        CommandLineTable CT = new CommandLineTable();
        CT.setShowVerticalLines(true);
        CT.setHeaders("Category_ID","Category_Name","Category_Date");

        for (int i = 0; i < CAP.size(); i++) {
           application.id_category=CAP.get(i).getCategory_id();
           CT.addRow(String.valueOf(CAP.get(i).getCategory_id()),String.valueOf(CAP.get(i).getCategory_Name()),String.valueOf(CAP.get(i).getCategory_date()));
        }
        CT.print();
    }


    public static void Edit_Category_Product() throws SQLException{
        Category_Product cp = new Category_Product();

        Category_ProductDAL cad = new Category_ProductDAL();
         boolean check = true;
         while (check) {
            System.out.println("Enter Category_Id:");
            int id = Integer.parseInt(new Validate().checkINT());
            CAP = new Category_ProductDAL().Select_Category_Product();
            int kt=0;
            for (int i = 0; i < CAP.size(); i++) {
                if (CAP.get(i).getCategory_id()==id) {
                    kt=1;

                }

            }
            if (kt==1) {
                System.out.println("Category_ID tồn tại!");
                check=false;
                cp.setCategory_id(id);
                System.out.println("Update Category_Name:");
                String category_name = new Validate().checkEmpty();
                cp.setCategory_Name(category_name);

                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                // return value 0->11;
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                cp.setCategory_date(""+year+"-"+(month+1)+"-"+day);

                CAP.add(cp);

                cad.update_category(cp, id);
            }
            else{
                System.out.println("Category_ID không tồn tại! Mời Nhập Lại");
                check=true;
            }
         }



    }

}
