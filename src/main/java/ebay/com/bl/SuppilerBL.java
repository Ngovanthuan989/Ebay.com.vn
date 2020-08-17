package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ebay.com.dal.SuppilerDAL;
import ebay.com.encrypt.EncodeAndDecode;
import ebay.com.persistance.Suppiler;

public class SuppilerBL {
    static List<Suppiler> SP = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void RegisterSuppiler() throws SQLException{
       Suppiler sp = new Suppiler();
       SuppilerDAL SPD = new SuppilerDAL();
       System.out.println("Enter Suppiler_Name:");
       String suppiler_name = sc.nextLine();
       sp.setSuppiler_name(suppiler_name);
       System.out.println("Enter Supplier_Address:");
       String suppiler_address = sc.nextLine();
       sp.setSuppiler_address(suppiler_address);
       System.out.println("Enter Suppiler_Email:");
       String suppiler_email = sc.nextLine();
       sp.setSuppiler_email(suppiler_email);
       System.out.println("Enter Suppiler_Pass:");
       String suppiler_pass = sc.nextLine();
       String endcode = EncodeAndDecode.encode(suppiler_pass);
       sp.setSuppiler_pass(endcode);
       System.out.println("Enter Suppiler_Phone:");
       String suppiler_phone = sc.nextLine();
       sp.setSuppiler_phone(suppiler_phone);
       sp.setSuppiler_status("Đang xử lí");

       SP.add(sp);
       SPD.insert_suppiler(sp);

       System.out.println("--------------------------------------------------------");
    }

    public static void LoginSuppiler() throws SQLException{
        Suppiler sp = new Suppiler();
        boolean check = true;

        while (check) {
            System.out.println("Enter Suppiler_Email:");
            String email = sc.nextLine();
            sp.setSuppiler_email(email);
            System.out.println("Enter Suppiler_Pass:");
            String pass = sc.nextLine();
            String decode = EncodeAndDecode.encode(pass);
            sp.setSuppiler_pass(pass);



            SP = new SuppilerDAL().SelectSuppiler(email, decode);

                 int kt = 0;
            for (int i = 0; i < SP.size(); i++) {
                if (SP.get(i).getSuppiler_email().equals(email) && SP.get(i).getSuppiler_pass().equals(decode)) {
                    kt = 1;
                }
            }
            if (kt == 1) {
                System.out.println("Email and Password is correct!");
                check = false;

            } else {
                System.out.println("Email or Password is wrong!");
                check = true;

            }

        }
    }
}
