package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import ebay.com.UI.CommandLineTable;
import ebay.com.dal.ShippingmentDAL;
import ebay.com.persistance.Shippingment;

public class ShippingmentBL {

    static List<Shippingment> SH = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void add_shippingment()throws SQLException{
        Shippingment sh = new Shippingment();
        ShippingmentDAL shd = new ShippingmentDAL();
        System.out.println("Enter Shipping_Name:");
        String shipping_name = sc.nextLine();
        sh.setShipment_name(shipping_name);

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        // return value 0->11;
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        sh.setShipment_date(""+year+"-"+(month+1)+"-"+day);

        SH.add(sh);
        shd.insert_shipment(sh);

    }
    public static void update_shippingment()throws SQLException{
        Shippingment sh = new Shippingment();
        ShippingmentDAL shd = new ShippingmentDAL();

        System.out.println("Enter Shipping_ID:");
        int shipment_id = Integer.parseInt(sc.nextLine());
        sh.setShipment_id(shipment_id);
        System.out.println("Update Shipping_Name");
        String shipping_name = sc.nextLine();
        sh.setShipment_name(shipping_name);

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        // return value 0->11;
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        sh.setShipment_date(""+year+"-"+(month+1)+"-"+day);

        SH.add(sh);
        shd.update_shipment(sh, shipment_id);;

    }

    public static void show_shippinment()throws SQLException{
        SH = new ShippingmentDAL().select_shippingment();

        CommandLineTable CT = new CommandLineTable();

        CT.setShowVerticalLines(true);
        CT.setHeaders("Shipping_ID","Shipping_Name","Shipping_Date");
        for (int i = 0; i < SH.size(); i++) {

            CT.addRow(String.valueOf(SH.get(i).getShipment_id()),String.valueOf(SH.get(i).getShipment_name()),String.valueOf(SH.get(i).getShipment_date()));
        }
        CT.print();
    }
}

