package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ebay.com.dal.Bill_TTDAL;
import ebay.com.persistance.Bill_TT;
import ebay.com.persistance.application;

public class Bi_TTBL {
    static List<Bill_TT>BTT = new ArrayList<>();

    public static void show_bil_tt()throws SQLException{
        BTT = new Bill_TTDAL().select_bill_t(application.order_id, application.id_customer);
        for (int j = 0; j < BTT.size(); j++) {
           System.out.println("|------------------------------------------------------------------------------|");
           System.out.println("|=>>>>>Tổng Tiền: "+BTT.get(j).getTt());
           System.out.println("|-------------------------------------------- ---------------------------------|");
        }
    }
    public static void show_bill_details()throws SQLException{
        BTT = new Bill_TTDAL().select_bill_t(application.order_id, application.id_customer);
        for (int j = 0; j < BTT.size(); j++) {
            System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~INVOICE~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
            System.out.println("|Code:"+BTT.get(j).getOrder_id()+"                                                                    |");
            System.out.println("|Date:"+BTT.get(j).getOrder_date()+"                                                             |");
            System.out.println("|-----------------------------------------------------------------------------|");
            System.out.println("|                                 1.BILL TO                                   |");
            System.out.println("|-----------------------------------------------------------------------------|");
            System.out.println("|*CustomerName:" +BTT.get(j).getCustomer_name()+"                                              |");
            System.out.println("|-----------------------------------------------------------------------------|");
            System.out.println("|                                 2.SHIP TO                                   |");
            System.out.println("|-----------------------------------------------------------------------------|");
            System.out.println("|*Shipment:"+BTT.get(j).getShipping_name()+"                                                      |");
            System.out.println("|-----------------------------------------------------------------------------|");
            System.out.println("|*Address:"+BTT.get(j).getAddress_name()+"                                                        |");
            System.out.println("|-----------------------------------------------------------------------------|");
            System.out.println("|*Phone:"+BTT.get(j).getCustomer_phone()+"                                                           |");
            System.out.println("|-----------------------------------------------------------------------------|");
            System.out.println("|*Ship_Price:"+BTT.get(j).getShipping_price()+"                                                         |");
            System.out.println("|-----------------------------------------------------------------------------|");
            System.out.println("|                                 3.Pay                                       |");
            System.out.println("|-----------------------------------------------------------------------------|");
            System.out.println("|*Payment:"+BTT.get(j).getPayment_method()+"                                                             |");
            System.out.println("|-----------------------------------------------------------------------------|");

         }
    }
}
