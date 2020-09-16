package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ebay.com.UI.CommandLineTable;
import ebay.com.dal.BillDAL;
import ebay.com.persistance.Bill;
import ebay.com.persistance.application;

public class BillBl {
    static List<Bill>BII= new ArrayList<>();
    public static void show_bill()throws SQLException{
        BII= new BillDAL().select_bill(application.order_id, application.id_customer);
        CommandLineTable CT = new CommandLineTable();
        CT.setShowVerticalLines(true);
        System.out.println("|                                  4.Item                                     |");
        CT.setHeaders("Product_ID","Product_Name             ","Promotion_Price","Amount","Total");
        for (int i = 0; i < BII.size(); i++) {
            CT.addRow(String.valueOf(BII.get(i).getProduct_id()),String.valueOf(BII.get(i).getProduct_name()),
            String.valueOf(BII.get(i).getPromotion_price()),String.valueOf(BII.get(i).getAmount()),String.valueOf(BII.get(i).getTotal()));
        }
        CT.print();

    }

    public static void show_bill2()throws SQLException{
        BII= new BillDAL().select_bill2(application.id_supplier);
        CommandLineTable CT = new CommandLineTable();
        CT.setShowVerticalLines(true);
        CT.setHeaders("Order_ID","Customer_Name","Customer_Phone","Product_ID","Product_Name","Promotion_Price","SL","Payment_Method","Address_Name","Order_Date","Shipping_Name","Shipping_Price","Total");
        for (int i = 0; i < BII.size(); i++) {
            CT.addRow(String.valueOf(BII.get(i).getOrder_id()),String.valueOf(BII.get(i).getCustomer_name()),
            String.valueOf(BII.get(i).getCustomer_phone()),String.valueOf(BII.get(i).getProduct_id()),String.valueOf(BII.get(i).getProduct_name()),
            String.valueOf(BII.get(i).getPromotion_price()),String.valueOf(BII.get(i).getAmount()),String.valueOf(BII.get(i).getPayment_method()),String.valueOf(BII.get(i).getAddress_name()),String.valueOf(BII.get(i).getOrder_date()),
            String.valueOf(BII.get(i).getShipping_name()),String.valueOf(BII.get(i).getShipping_price()),String.valueOf(BII.get(i).getTotal()));
        }
        CT.print();

    }


}
