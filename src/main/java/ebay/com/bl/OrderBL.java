package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import ebay.com.UI.ClearTheScreen;
import ebay.com.dal.OrderDAL;
import ebay.com.persistance.Order;
import ebay.com.persistance.application;
import ebay.com.validate.Validate;

public class OrderBL {

    static List<Order>OD=new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void add_order()throws SQLException{
        Order od = new Order();
        OrderDAL odd = new OrderDAL();
        od.setAddress_id(2);
        od.setCustomer_id(application.id_customer);
        od.setPayment_id(1);
        od.setShipment_id(1);
        od.setCustomer_notes("Chưa có phản hồi!");
        od.setOrder_status("Đang chờ xử lí");

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        // return value 0->11;
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        od.setOrder_date(""+year+"-"+(month+1)+"-"+day);
        OD.add(od);
        odd.insert_order(od);

        OD = odd.select_order(application.id_customer);
        for (int i = 0; i < OD.size(); i++) {
            application.order_id=OD.get(i).getOrder_id();
        }
    }

    public static void update_order()throws SQLException{
        Order od = new Order();
        OrderDAL odd = new OrderDAL();
        System.out.println("-------------------------------Check Out--------------------------");
        System.out.print("   1.Enter Address_ID:");
        int address_id = Integer.parseInt(new Validate().checkINT());
        od.setAddress_id(address_id);
        System.out.println("----------------------------------------------------");
        System.out.print("   2.Enter Payment_ID:");
        int payment_id = Integer.parseInt(new Validate().checkINT());
        od.setPayment_id(payment_id);
        System.out.println("----------------------------------------------------");
        System.out.print("   3.Enter Shipment_ID:");
        int shipment_id =Integer.parseInt(new Validate().checkINT());
        od.setShipment_id(shipment_id);
        System.out.println("----------------------------------------------------");
        System.out.print("   4.Enter Customer_Notes:");
        String customer_notes=new Validate().checkEmpty();
        od.setCustomer_notes(customer_notes);
        od.setOrder_status("Dang Cho Xu Li");

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        // return value 0->11;
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        od.setOrder_date(""+year+"-"+(month+1)+"-"+day);
        OD.add(od);
        odd.update_order(od, application.order_id,application.id_customer);

    }

    public static void update_order_status()throws SQLException{
        Order od = new Order();
        OrderDAL odd = new OrderDAL();
        od.setOrder_status("Đang chờ lấy hàng");
        OD.add(od);
        odd.update_order_status(od, application.order_id, application.id_customer);
        System.out.println("  /-------------------------------------------/");
        System.out.println(" /        Thank you for your purchase!       /");
        System.out.println("/-------------------------------------------/");

    }


    public static void remove_order() throws SQLException{
       Order od = new Order();
       OrderDAL odd = new OrderDAL();
       od.setOrder_id(application.order_id);
       OD.add(od);
       odd.delete_order(od, application.id_customer);
       System.out.println("  /-------------------------------------------/");
       System.out.println(" /        Your order has been canceled!      /");
       System.out.println("/-------------------------------------------/");
    }



    public static void ask_customer()throws SQLException{
        Boolean check = true;
        while (check) {
            System.out.println("  /----------------------------------------/");
            System.out.println(" / Are you sure you want to buy not(y/n)? /");
            System.out.println("/----------------------------------------/");
            String yn =sc.nextLine();
            switch (yn) {
                case "y":
                    ClearTheScreen.clrscr();
                    update_order_status();
                    check=false;
                    break;
                case "n":
                    ClearTheScreen.clrscr();
                    remove_order();
                    check=false;
                    break;
                default:
                    ClearTheScreen.clrscr();
                    System.out.println("There is no function for this .Re-Enter:");
                    check=true;
                    break;
            }
        }


    }
}
