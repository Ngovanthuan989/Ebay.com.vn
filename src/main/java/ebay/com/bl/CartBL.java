package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ebay.com.UI.CommandLineTable;
import ebay.com.dal.CartDAL;
import ebay.com.persistance.Cart;
import ebay.com.persistance.application;

public class CartBL {
    static List<Cart> CART= new ArrayList<>();
    static Scanner sc = new Scanner(System.in);


    public static void show_cart()throws SQLException{
        CART = new CartDAL().select_cart(application.id_customer, application.order_id);
        CommandLineTable CT = new CommandLineTable();
        CT.setShowVerticalLines(true);
        CT.setHeaders("Order_id","Product_id","Product_code","Product_Name","Price","Amount","Unit_Price");
        for (int i = 0; i < CART.size(); i++) {
           CT.addRow(String.valueOf(CART.get(i).getOrder_id()),String.valueOf(CART.get(i).getProduct_id()),
           String.valueOf(CART.get(i).getProduct_code()),String.valueOf(CART.get(i).getProduct_name()),
           String.valueOf(CART.get(i).getPromotion_price()),String.valueOf(CART.get(i).getAmount()),
           String.valueOf(CART.get(i).getUnit_price()));
        }
        CT.print();
    }
}
