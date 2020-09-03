package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import ebay.com.UI.ClearTheScreen;
import ebay.com.UI.CommandLineTable;
import ebay.com.dal.ProductDAL;
import ebay.com.persistance.Product;
import ebay.com.persistance.application;

public class ProductBL {

    static List<Product> PR = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void add_product() throws SQLException{

        Product pr = new  Product();
        ProductDAL PRD = new ProductDAL();

        System.out.println("Enter Product_Code:");
        String product_code = sc.nextLine();
        pr.setProduct_code(product_code);
        System.out.println("Enter Product_Name:");
        String product_name = sc.nextLine();
        pr.setProduct_name(product_name);
        pr.setSupplier_id(application.id_supplier);
        System.out.println("Enter Category_ID:");
        int category_id = Integer.parseInt(sc.nextLine());
        pr.setCategory_id(category_id);
        System.out.println("Enter Brand_ID:");
        int brand_id = Integer.parseInt(sc.nextLine());
        pr.setBrand_id(brand_id);
        System.out.println("Enter Product_Price:");
        Double product_price = Double.parseDouble(sc.nextLine());
        pr.setProduct_price(product_price);
        System.out.println("Enter Promotion_Price:");
        Double promotion_price = Double.parseDouble(sc.nextLine());
        pr.setPromotion_price(promotion_price);
        System.out.println("Enter Product_Desc:");
        String product_desc = sc.nextLine();
        pr.setProduct_desc(product_desc);
        System.out.println("Enter Product_Amount:");
        int product_amount = Integer.parseInt(sc.nextLine());
        pr.setProduct_amount(product_amount);

        pr.setProduct_status("Hiển Thị");

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        // return value 0->11;
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        pr.setProduct_date(""+year+"-"+(month+1)+"-"+day);

        PR.add(pr);
        PRD.insert_product(pr);
    }

    public static void update_product() throws SQLException{

        Product pr = new Product();
        ProductDAL PRD = new ProductDAL();

        System.out.println("Enter Product_ID:");
        int product_id = Integer.parseInt(sc.nextLine());
        pr.setProduct_id(product_id);
        System.out.println("Update Product_Code:");
        String product_code = sc.nextLine();
        pr.setProduct_code(product_code);
        System.out.println("Update Product_Name:");
        String product_name = sc.nextLine();
        pr.setProduct_name(product_name);
        pr.setSupplier_id(application.id_supplier);
        System.out.println("Update Category_ID:");
        int category_id = Integer.parseInt(sc.nextLine());
        pr.setCategory_id(category_id);
        System.out.println("Update Brand_ID:");
        int brand_id = Integer.parseInt(sc.nextLine());
        pr.setBrand_id(brand_id);
        System.out.println("Update Product_Price:");
        Double product_price = Double.parseDouble(sc.nextLine());
        pr.setProduct_price(product_price);
        System.out.println("Update Promotion_Price:");
        Double promotion_price = Double.parseDouble(sc.nextLine());
        pr.setPromotion_price(promotion_price);
        System.out.println("Update Product_Desc:");
        String product_desc = sc.nextLine();
        pr.setProduct_desc(product_desc);
        System.out.println("Update Product_Amount:");
        int product_amount = Integer.parseInt(sc.nextLine());
        pr.setProduct_amount(product_amount);
        System.out.println("Update Product_Status:");
        String product_status = sc.nextLine();
        pr.setProduct_status(product_status);


        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        // return value 0->11;
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        pr.setProduct_date(""+year+"-"+(month+1)+"-"+day);

        PR.add(pr);

        PRD.update_product(pr, product_id);

    }

    public static void show_product_supplier() throws SQLException{

        PR = new ProductDAL().select_product(application.id_supplier);

        CommandLineTable CT = new CommandLineTable();
        CT.setShowVerticalLines(true);
        CT.setHeaders("Product_ID","Product_Code","Product_Name","Category_ID","Brand_ID","Product_Price","Promotion_Price","Product_desc","Product_Status","Product_Date");


        for (int i = 0; i < PR.size(); i++) {
           CT.addRow(String.valueOf(PR.get(i).getProduct_id()),String.valueOf(PR.get(i).getProduct_code()),String.valueOf(PR.get(i).getProduct_name()),String.valueOf(PR.get(i).getCategory_id()),
           String.valueOf(PR.get(i).getBrand_id()),String.valueOf(PR.get(i).getProduct_price()),String.valueOf(PR.get(i).getPromotion_price()),String.valueOf(PR.get(i).getProduct_desc()),
           String.valueOf(PR.get(i).getProduct_status()),String.valueOf(PR.get(i).getProduct_date()));
        }
        CT.print();
    }


    public static void show_product_home()throws SQLException{
        PR = new ProductDAL().select_productID();
        CommandLineTable CT= new CommandLineTable();
        CT.setShowVerticalLines(true);
        System.out.println("|------------------------------Home Page-----------------------------|");
        System.out.println("|--------------------------------------------------------------------|");
        CT.setHeaders("Product_ID","Product_Name","Product_price","Promotion_Price");
        for (int i = 0; i < PR.size(); i++) {
            CT.addRow(String.valueOf(PR.get(i).getProduct_id()),String.valueOf(PR.get(i).getProduct_name()),String.valueOf(PR.get(i).getProduct_price()+" "+"VND"),String.valueOf(PR.get(i).getPromotion_price()+" "+"VND"));
        }
        CT.print();
    }


    public static void ask()throws SQLException{
        boolean kt = true;
        while (kt) {
            System.out.print("----Enter Movie Page[1->4]------Enter [0] To Continue:.... ");
            String ask_customer= sc.nextLine();
            switch (ask_customer) {
                case "1":
                    kt=false;
                    break;
                case "2":
                    kt=false;
                    break;
                case "3":
                    kt=false;

                    break;
                case "4":
                     kt=false;
                    break;
                case "0":

                    Order_DetailsBL.ask_the_customer();
                    kt=false;
                    break;

                default:
                    ClearTheScreen.clrscr();
                    System.out.println("There is no function for this .Re-Enter:");
                    kt=true;

                    break;
            }
        }

    }
}
