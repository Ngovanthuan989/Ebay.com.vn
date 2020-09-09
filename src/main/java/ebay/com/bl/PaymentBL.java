package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ebay.com.UI.CommandLineTable;
import ebay.com.dal.PaymentDAL;
import ebay.com.persistance.Payment;
import ebay.com.validate.Validate;

public class PaymentBL {
    static List<Payment>PAY = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void add_payment()throws SQLException{
       Payment pay = new Payment();
       PaymentDAL payd=new PaymentDAL();
       System.out.println("------------------Add_New_Payment-------------------");
       System.out.print("Enter Payment_Method:");
       String payment_method=new Validate().checkEmpty();
       pay.setPayment_method(payment_method);
       pay.setPayment_status("Hiển Thị");


       PAY.add(pay);
       payd.insert_payment(pay);

    }
    public static void edit_payment()throws SQLException{
       Payment pay = new Payment();
       PaymentDAL paydal= new PaymentDAL();
       System.out.println("--------------------Update_Payment---------------------");
       System.out.print("|1.Enter Payment_ID:");
       int payment_id=Integer.parseInt(new Validate().checkINT());
       pay.setPayment_id(payment_id);
       System.out.println("------------------------------------------------------");
       System.out.print("|2.Update Payment_Method:");
       String payment_method = new Validate().checkEmpty();
       pay.setPayment_method(payment_method);
       System.out.println("-------------------------------------------------------");
       System.out.print("|3.Update Payment_Status:");
       String payment_status= new Validate().checkEmpty();
       pay.setPayment_status(payment_status);

       PAY.add(pay);
       paydal.update_payment(pay, payment_id);
    }

    public static void show_payment()throws SQLException{
        PAY = new PaymentDAL().select_payment();
        CommandLineTable CT = new CommandLineTable();
        CT.setShowVerticalLines(true);
        CT.setHeaders("Payment_ID","Payment_Method","Payment_Status");
        for (int i = 0; i < PAY.size(); i++) {
            CT.addRow(String.valueOf(PAY.get(i).getPayment_id()),String.valueOf(PAY.get(i).getPayment_method()),String.valueOf(PAY.get(i).getPayment_status()));
        }
        CT.print();


    }
}
