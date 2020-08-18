package ebay.com.UI;

import java.sql.SQLException;
import java.util.Scanner;

import ebay.com.bl.Address_DetailsBL;
import ebay.com.bl.AdminBL;
import ebay.com.bl.Brand_ProductBL;
import ebay.com.bl.Category_ProductBL;
import ebay.com.bl.CustomerBL;
import ebay.com.bl.OptionsBL;
import ebay.com.bl.ProductBL;
import ebay.com.bl.Product_OptionsBL;
import ebay.com.bl.Product_Options_DetailsBL;
import ebay.com.bl.ShippingmentBL;
import ebay.com.bl.SuppilerBL;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    public static void ShowMenu() throws SQLException{
        String choice;

        while (true) {
            System.out.println("    ~~~~~~~~~~~~~~~~~~~~~~~~~~Welcome to our EBAY~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("═════════════════════════════════════════════════════════════════════════════");
            System.out.println("|1.Home Page                                                                |");
            System.out.println("|---------------------------------------------------------------------------|");
            System.out.println("|2.Product Details                                                          |");
            System.out.println("|---------------------------------------------------------------------------|");
            System.out.println("|3.Search                                                                   |");
            System.out.println("|---------------------------------------------------------------------------|");
            System.out.println("|4.Customer                                                                 |");
            System.out.println("|---------------------------------------------------------------------------|");
            System.out.println("|5.Suppiler channel                                                         |");
            System.out.println("|---------------------------------------------------------------------------|");
            System.out.println("|6.Dasboard(Admin)                                                          |");
            System.out.println("|---------------------------------------------------------------------------|");
            System.out.println("|0.Exit The Program                                                         |");
            System.out.println("|---------------------------------------------------------------------------|");
            System.out.println("═════════════════════════════════════════════════════════════════════════════");
            System.out.println("   ==>>Inviting You To Choose:            ");

            choice = sc.nextLine();
            switch (choice) {
                case "1":

                    break;
                case "2":


                    break;
                case "3":


                    break;
                case "4":
                    ClearTheScreen.clrscr();
                    CustomerBL.LoginCustomer();
                    Customer();

                    break;
                case "5":
                    ClearTheScreen.clrscr();
                    SuppilerBL.LoginSuppiler();
                    Seller();
                    break;
                case "6":

                    ClearTheScreen.clrscr();
                    AdminBL.AdminLogin();
                    Admin();

                    break;
                case "0":
                    ClearTheScreen.clrscr();
                    System.out.println("Bye. See You Again!");
                    System.exit(0);

                    break;

                default:
                    ClearTheScreen.clrscr();
                    System.out.println("There is no function for this .Re-Enter:");
                    break;
            }
        }
    }
    public static void Admin() throws SQLException{

        String choice;
        while (true) {
            System.out.println("=======================Admin Dashboard=====================");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|1.Seller Management                                      |");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|2.Customer Management                                    |");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|3.Product Management                                     |");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|4.ShippingMethod Management                              |");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|0.Return To The Previous Page                            |");
            System.out.println("-----------------------------------------------------------");
            System.out.println("   ==>>Inviting You To Choose:            ");

            choice = sc.nextLine();

            switch (choice) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":
                    ClearTheScreen.clrscr();
                    ShippingMethod_Management();

                    break;
                case "0":
                    ClearTheScreen.clrscr();
                    ShowMenu();
                    break;

                default:
                    ClearTheScreen.clrscr();
                    System.out.println("There is no function for this .Re-Enter:");
                    break;
            }

        }


    }
    public static void ShippingMethod_Management() throws SQLException{
        String choice;
        while (true) {
            System.out.println("==========================ShippingMethod_Management==========================");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("|1.Add New ShippingMethod                                                   |");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("|2.Update ShippingMethod                                                    |");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("|3.List ShippingMethod                                                      |");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("|0.Return To The Previous Page                                              |");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("   ==>>Inviting You To Choose:            ");
            choice =sc.nextLine();

            switch (choice) {
                case "1":
                   ClearTheScreen.clrscr();
                    ShippingmentBL.add_shippingment();
                    break;
                case "2":
                    ClearTheScreen.clrscr();
                    ShippingmentBL.update_shippingment();
                    break;
                case "3":
                    ClearTheScreen.clrscr();
                    ShippingmentBL.show_shippinment();
                    break;


                case "0":

                    ClearTheScreen.clrscr();
                    Admin();

                    break;

                default:
                    ClearTheScreen.clrscr();
                    System.out.println("There is no function for this .Re-Enter:");
                    break;
            }
        }

    }

    public static void Seller() throws SQLException{
        String choice;
        while (true) {
            System.out.println("=========================Seller========================");
            System.out.println("-------------------------------------------------------");
            System.out.println("|1.Product Management                                 |");
            System.out.println("-------------------------------------------------------");
            System.out.println("|2.Category Management                                |");
            System.out.println("-------------------------------------------------------");
            System.out.println("|3.Brand Management                                   |");
            System.out.println("-------------------------------------------------------");
            System.out.println("|4.Options Management                                 |");
            System.out.println("-------------------------------------------------------");
            System.out.println("|5.Order Management                                   |");
            System.out.println("-------------------------------------------------------");
            System.out.println("|6.Product_Options Management                         |");
            System.out.println("-------------------------------------------------------");
            System.out.println("|7.Revenue Management                                 |");
            System.out.println("-------------------------------------------------------");
            System.out.println("|0.Return To The Previous Page                        |");
            System.out.println("-------------------------------------------------------");
            System.out.println("   ==>>Inviting You To Choose:            ");
            choice = sc .nextLine();

            switch (choice) {
                case "1":
                    ClearTheScreen.clrscr();
                    Product_Management();
                    break;
                case "2":
                    ClearTheScreen.clrscr();
                    Category_Management();
                    break;
                case "3":
                    ClearTheScreen.clrscr();
                    Brand_Management();
                    break;
                case "4":
                    ClearTheScreen.clrscr();
                    Options_Management();


                    break;
                case "5":

                    break;
                case "6":
                   ClearTheScreen.clrscr();
                   Product_Options_Management();


                    break;
                case "7":

                    break;

                case "0":
                    ClearTheScreen.clrscr();
                    ShowMenu();
                    break;

                default:
                    ClearTheScreen.clrscr();
                    System.out.println("There is no function for this .Re-Enter:");
                    break;
            }
        }

    }

    public static void Product_Options_Management() throws SQLException{
        String choice;
        while (true) {
            System.out.println("==========================Product_Options Management=========================");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("|1.Add New Product_Options                                                  |");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("|2.Update Product_Options                                                   |");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("|3.List Product_Options                                                     |");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("|0.Return To The Previous Page                                              |");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("   ==>>Inviting You To Choose:            ");
            choice =sc.nextLine();

            switch (choice) {
                case "1":
                   ClearTheScreen.clrscr();
                   Product_OptionsBL.add_product_options();

                    break;
                case "2":
                    ClearTheScreen.clrscr();
                    Product_OptionsBL.update_product_options();

                    break;
                case "3":
                    ClearTheScreen.clrscr();
                    Product_Options_DetailsBL.show_options_details();
                    break;


                case "0":

                    ClearTheScreen.clrscr();
                    Seller();

                    break;

                default:
                    ClearTheScreen.clrscr();
                    System.out.println("There is no function for this .Re-Enter:");
                    break;
            }
        }

    }
    public static void Customer() throws SQLException{
        String choice;
        while (true) {
            System.out.println("==========================Customer=========================");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|1.Xem thông tin tài khoản                                |");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|2.Lịch sử mua hàng                                       |");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|3.Address_Shipping Management                            |");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|4.Giỏ Hàng                                               |");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|0.Return To The Previous Page                            |");
            System.out.println("-----------------------------------------------------------");
            System.out.println("   ==>>Inviting You To Choose:            ");
            choice =sc.nextLine();

            switch (choice) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":
                    ClearTheScreen.clrscr();
                    Address_Shipping();

                    break;
                case "4":

                    break;

                case "0":

                    ClearTheScreen.clrscr();
                    ShowMenu();

                    break;

                default:
                    ClearTheScreen.clrscr();
                    System.out.println("There is no function for this .Re-Enter:");
                    break;
            }
        }

    }
    public static void Address_Shipping()throws SQLException{
        String choice;
        while (true) {

            System.out.println("====================Address_Shipping_Management===================");
            System.out.println("------------------------------------------------------------------");
            System.out.println("|1.Add New Address_Details                                       |");
            System.out.println("------------------------------------------------------------------");
            System.out.println("|2.Update Address_Details                                        |");
            System.out.println("------------------------------------------------------------------");
            System.out.println("|3.List Address_Details                                          |");
            System.out.println("------------------------------------------------------------------");
            System.out.println("|0.Return To The Previous Page                                   |");
            System.out.println("------------------------------------------------------------------");
            System.out.println("   ==>>Inviting You To Choose:            ");
            choice =sc.nextLine();

            switch (choice) {
                case "1":
                ClearTheScreen.clrscr();
                Address_DetailsBL.add_address_details();
                    break;

                case "2":
                ClearTheScreen.clrscr();
                Address_DetailsBL.update_address_details();

                    break;

                case "3":
                ClearTheScreen.clrscr();
                Address_DetailsBL.show_address_details();

                    break;

                case "0":
                ClearTheScreen.clrscr();
                Customer();

                    break;

                default:
                ClearTheScreen.clrscr();
                System.out.println("There is no function for this .Re-Enter:");
                    break;
            }
        }
    }
    public static void Category_Management() throws SQLException{
        String choice;
        while (true) {
            System.out.println("====================Category_Management===================");
            System.out.println("----------------------------------------------------------");
            System.out.println("|1.Add New Category_Product                              |");
            System.out.println("----------------------------------------------------------");
            System.out.println("|2.Update Category_Product                               |");
            System.out.println("----------------------------------------------------------");
            System.out.println("|3.List Category_Product                                 |");
            System.out.println("----------------------------------------------------------");
            System.out.println("|0.Return To The Previous Page                           |");
            System.out.println("----------------------------------------------------------");
            System.out.println("   ==>>Inviting You To Choose:            ");
            choice =sc.nextLine();

            switch (choice) {
                case "1":
                    ClearTheScreen.clrscr();
                    Category_ProductBL.add_category_product();
                    break;
                case "2":
                  ClearTheScreen.clrscr();
                  Category_ProductBL.Edit_Category_Product();
                    break;
                case "3":
                   ClearTheScreen.clrscr();
                   Category_ProductBL.Show_Category_Product();
                    break;
                case "0":
                    ClearTheScreen.clrscr();
                    Seller();

                    break;


                default:
                ClearTheScreen.clrscr();
                System.out.println("There is no function for this .Re-Enter:");
                    break;
            }
        }


    }
    public static void Brand_Management() throws SQLException{
        String choice;
        while (true) {
            System.out.println(" ====================Brand_Management===================");
            System.out.println("----------------------------------------------------------");
            System.out.println("|1.Add New Brand_Product                                 |");
            System.out.println("----------------------------------------------------------");
            System.out.println("|2.Update Brand_Product                                  |");
            System.out.println("----------------------------------------------------------");
            System.out.println("|3.List Brand_Product                                    |");
            System.out.println("----------------------------------------------------------");
            System.out.println("|0.Return To The Previous Page                           |");
            System.out.println("----------------------------------------------------------");
            System.out.println("   ==>>Inviting You To Choose:            ");
            choice =sc.nextLine();

            switch (choice) {
                case "1":
                    ClearTheScreen.clrscr();
                    Brand_ProductBL.add_brand_product();
                    break;
                case "2":
                    ClearTheScreen.clrscr();
                    Brand_ProductBL.edit_brand_product();
                    break;
                case "3":
                    ClearTheScreen.clrscr();
                    Brand_ProductBL.show_brand_product();
                    break;
                case "0":
                    ClearTheScreen.clrscr();
                    Seller();
                    break;


                default:
                ClearTheScreen.clrscr();
                System.out.println("There is no function for this .Re-Enter:");
                    break;
            }
        }


    }
    public static void Product_Management() throws SQLException{
        String choice;
        while (true) {
            System.out.println(" ====================Product_Management===================");
            System.out.println("----------------------------------------------------------");
            System.out.println("|1.Add New Product                                       |");
            System.out.println("----------------------------------------------------------");
            System.out.println("|2.Update Product                                        |");
            System.out.println("----------------------------------------------------------");
            System.out.println("|3.List Product                                          |");
            System.out.println("----------------------------------------------------------");
            System.out.println("|0.Return To The Previous Page                           |");
            System.out.println("----------------------------------------------------------");
            System.out.println("   ==>>Inviting You To Choose:            ");
            choice =sc.nextLine();

            switch (choice) {
                case "1":
                    ClearTheScreen.clrscr();
                    ProductBL.add_product();
                    break;
                case "2":
                    ClearTheScreen.clrscr();
                    ProductBL.update_product();
                    break;
                case "3":
                   ClearTheScreen.clrscr();
                   ProductBL.show_product_supplier();

                    break;
                case "0":
                    ClearTheScreen.clrscr();
                    Seller();
                    break;


                default:
                    ClearTheScreen.clrscr();
                    System.out.println("There is no function for this .Re-Enter:");
                    break;
            }
        }


    }
    public static void Options_Management() throws SQLException{
        String choice;
        while (true) {
            System.out.println(" ====================Options_Management===================");
            System.out.println("----------------------------------------------------------");
            System.out.println("|1.Add New Options                                       |");
            System.out.println("----------------------------------------------------------");
            System.out.println("|2.List Options                                          |");
            System.out.println("----------------------------------------------------------");
            System.out.println("|0.Return To The Previous Page                           |");
            System.out.println("----------------------------------------------------------");
            System.out.println("   ==>>Inviting You To Choose:            ");
            choice =sc.nextLine();

            switch (choice) {
                case "1":
                    ClearTheScreen.clrscr();
                    OptionsBL.add_new_options();
                    break;
                case "2":
                    ClearTheScreen.clrscr();
                    OptionsBL.show_options();
                    break;

                case "0":
                    ClearTheScreen.clrscr();
                    Seller();
                    break;


                default:
                    ClearTheScreen.clrscr();
                    System.out.println("There is no function for this .Re-Enter:");
                    break;
            }
        }


    }
}
