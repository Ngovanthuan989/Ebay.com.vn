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
           System.out.println("---------------------------------------------");
           System.out.println("=>>>>>Tổng Tiền: "+BTT.get(j).getTt());
           System.out.println("---------------------------------------------");
        }
    }
}
