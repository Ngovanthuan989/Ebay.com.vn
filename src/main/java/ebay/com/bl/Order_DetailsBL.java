package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ebay.com.UI.ClearTheScreen;
import ebay.com.UI.Menu;
import ebay.com.dal.Order_DetailsDAL;
import ebay.com.dal.ProductDAL;
import ebay.com.persistance.Order_Details;
import ebay.com.persistance.Product;
import ebay.com.persistance.application;
import ebay.com.validate.Validate;

public class Order_DetailsBL {

    static List<Order_Details>ODD = new ArrayList<>();
    static List<Product> PR = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void insert_order_details()throws SQLException{

        Order_Details odd = new Order_Details();
        Order_DetailsDAL oda= new Order_DetailsDAL();
        boolean check =true;
        while (check) {
            System.out.println("-----------------------------------------------------");
            boolean kiemtra=true;
            while (kiemtra) {
                System.out.print("  1.Enter Product_ID:");
                int product_id =Integer.parseInt(new Validate().checkINT());
                odd.setProducts_id(product_id);
                if (product_id==0) {
                    ProductBL.show_product_home();
                    ProductBL.ask();
                }
                else{
                    PR = new ProductDAL().select_productID();
                    int kt =0;
                    for (int i = 0; i < PR.size(); i++) {
                        if (PR.get(i).getProduct_id()==product_id) {
                            kt = 1;
                        }
                    }
                    if (kt==1) {
                        System.out.println("Product_ID tồn tại!");
                        kiemtra=false;
                        odd.setOrder_id(application.order_id);
                        System.out.println("-----------------------------------------------------");
                        System.out.print("  2.Enter Amount:");
                        int amount = Integer.parseInt(new Validate().checkINT());
                        odd.setAmount(amount);

                        ODD.add(odd);

                        oda.insert_order_details(odd);
                        System.out.print("Do You Want To Buy More(y/n)?.....");
                        String yn = sc.nextLine();
                        switch (yn) {
                            case "y":
                                ClearTheScreen.clrscr();
                                check=true;
                                break;
                            case "n":
                                    ClearTheScreen.clrscr();
                                    System.out.println("The Product You Purchased Above Has Been Added To Your Cart.Please go to cart to pay!...");
                                    check = false;
                                break;
                            default:
                                ClearTheScreen.clrscr();
                                System.out.println("There is no function for this .Re-Enter:");
                                check=true;
                                break;
                        }
                    }
                    else{
                        System.out.println("Product_ID không tồn tại! Mời Nhập Lại");
                        kiemtra=true;
                    }
                }

            }


        }

    }


    public static void update_order_details()throws SQLException{
        Order_Details odd = new Order_Details();
        Order_DetailsDAL oda= new Order_DetailsDAL();
        System.out.println("============================UPDATE CART============================");
        System.out.print(" 1.Update Product_ID:");
        int product_id =Integer.parseInt(new Validate().checkINT());
        odd.setProducts_id(product_id);
        System.out.println("-----------------------------------------------------");
        System.out.print(" 2.Update Amount:");
        int amount = Integer.parseInt(new Validate().checkINT());
        odd.setAmount(amount);
        System.out.println("-----------------------------------------------------");
        System.out.print("=>Enter Product_ID:");
        int produc_id=Integer.parseInt(new Validate().checkINT());



        ODD.add(odd);
        oda.update_order_details(odd, application.order_id,produc_id);
    }


    public static void ask_the_customer()throws SQLException{
        boolean check = true;
        while (check) {
            System.out.print("Do You Want To Buy The Product(y/n)?....");
            String yn=sc.nextLine();
            switch (yn) {
                case "y":
                    ClearTheScreen.clrscr();
                    CustomerBL.LoginCustomer();
                    ClearTheScreen.clrscr();
                    OrderBL.add_order();
                    insert_order_details();
                    check=false;
                    break;
                case "n":
                    ClearTheScreen.clrscr();
                    System.out.println("Thank you!");
                    Menu.ShowMenu();
                    check=true;
                    break;

                default:
                    ClearTheScreen.clrscr();
                    System.out.println("There is no function for this .Re-Enter:");
                    check=true;
                    break;
            }
        }

    }

    public static void remove_order_details()throws SQLException{
        Order_DetailsDAL odd = new Order_DetailsDAL();
        Order_Details od = new Order_Details();
        System.out.println("============================DELETE CART==========================");
        System.out.println("=>Enter Product_ID:");
        int product_id=Integer.parseInt(new Validate().checkINT());
        od.setProducts_id(product_id);
        odd.delete_order_details(od,application.order_id);

    }
}
