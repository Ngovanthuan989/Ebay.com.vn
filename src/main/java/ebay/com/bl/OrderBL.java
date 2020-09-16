package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import ebay.com.UI.ClearTheScreen;
import ebay.com.dal.Address_DetailsDAL;
import ebay.com.dal.OrderDAL;
import ebay.com.dal.PaymentDAL;
import ebay.com.dal.ShippingmentDAL;
import ebay.com.persistance.Address_Details;
import ebay.com.persistance.Order;
import ebay.com.persistance.Payment;
import ebay.com.persistance.Shippingment;
import ebay.com.persistance.application;
import ebay.com.validate.Validate;

public class OrderBL {

    static List<Order>OD=new ArrayList<>();
    static List<Address_Details> ADT = new ArrayList<>();
    static List<Payment>PAY = new ArrayList<>();
    static List<Shippingment> SH = new ArrayList<>();
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
        Address_DetailsBL.show_address_details();
        boolean check = true;
        while (check) {
            System.out.print("   1.Enter Address_ID:");
            int address_id = Integer.parseInt(new Validate().checkINT());
            od.setAddress_id(address_id);
            ADT = new Address_DetailsDAL().select_address_details2();
            int kt = 0;

            for (int i = 0; i < ADT.size(); i++) {
                if (ADT.get(i).getAddress_id()==address_id) {
                    kt = 1;

                }
            }
            if (kt==1) {
                System.out.println("Address_ID tồn tại!");
                check=false;
            }
            else{
                System.out.println("Address_ID không tồn tại! Vui lòng nhập lại");
                check=true;
            }

       }

        System.out.println("----------------------------------------------------");
        PaymentBL.show_payment();
        boolean ch=true;
        while (ch) {
            System.out.print("   2.Enter Payment_ID:");
            int payment_id = Integer.parseInt(new Validate().checkINT());
            od.setPayment_id(payment_id);
            PAY = new PaymentDAL().select_payment();
            int tt =0;
            for (int i = 0; i < PAY.size(); i++) {
                if (PAY.get(i).getPayment_id()==payment_id) {
                    tt=1;
                }
            }
            if (tt==1) {
               System.out.println("Payment_ID tồn tại!");
               ch=false;
            }
            else{
                System.out.println("Payment_ID không tồn tại! Mời Nhập Lại!");
                ch=true;
            }
        }

        System.out.println("----------------------------------------------------");
        ShippingmentBL.show_shippinment();
        boolean che =true;
        while (che) {
            System.out.print("   3.Enter Shipment_ID:");
            int shipment_id =Integer.parseInt(new Validate().checkINT());
            od.setShipment_id(shipment_id);
            SH = new ShippingmentDAL().select_shippingment();
            int t=0;
            for (int i = 0; i < SH.size(); i++) {
               if (SH.get(i).getShipment_id()==shipment_id) {
                   t =1;
               }
            }
            if (t==1) {
                System.out.println("Shipment_ID tồn tại!");
                che=false;
            }
            else{
                System.out.println("Shipment_ID không tồn tại! Mời nhập lại!");
                che=true;
            }
        }


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
