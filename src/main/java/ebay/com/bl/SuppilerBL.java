package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ebay.com.UI.ClearTheScreen;
import ebay.com.UI.CommandLineTable;
import ebay.com.dal.SuppilerDAL;
import ebay.com.encrypt.EncodeAndDecode;
import ebay.com.encrypt.PasswordField;
import ebay.com.persistance.Suppiler;
import ebay.com.persistance.application;

public class SuppilerBL {
    static List<Suppiler> SP = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void RegisterSuppiler() throws SQLException{
       Suppiler sp = new Suppiler();
       SuppilerDAL SPD = new SuppilerDAL();
       System.out.println("---------------------------------Register Supplier----------------------------");
       System.out.print(" 1.Enter Suppiler_Name:");
       String suppiler_name = sc.nextLine();
       sp.setSuppiler_name(suppiler_name);
       System.out.println("---------------------------------------------------------------");
       System.out.print(" 2.Enter Supplier_Address:");
       String suppiler_address = sc.nextLine();
       sp.setSuppiler_address(suppiler_address);
       System.out.println("---------------------------------------------------------------");
       System.out.print(" 3.Enter Suppiler_Email:");
       String suppiler_email = sc.nextLine();
       sp.setSuppiler_email(suppiler_email);
       System.out.println("---------------------------------------------------------------");
       String password = PasswordField.readPassword("Enter Suppiler_Password: ");
        // System.out.println("The password entered is: "+password);
       String endcode = EncodeAndDecode.encode(password);
       sp.setSuppiler_pass(endcode);
       System.out.println("---------------------------------------------------------------");
       System.out.print(" 6.Enter Suppiler_Phone:");
       String suppiler_phone = sc.nextLine();
       sp.setSuppiler_phone(suppiler_phone);
       sp.setSuppiler_status("Đang xử lí");

       SP.add(sp);
       SPD.insert_suppiler(sp);
       ClearTheScreen.clrscr();
       System.out.println("  /---------------------------------------------------/");
       System.out.println(" /                 Register Success                  /");
       System.out.println("/---------------------------------------------------/");
       System.out.println("--Press enter to continue.............");
       String enter=sc.nextLine();
    }

    public static void LoginSuppiler() throws SQLException{
        Suppiler sp = new Suppiler();
        boolean check = true;

        while (check) {
            System.out.println("-----------------------------Login Supplier-------------------------------");
            System.out.println(" 1.Enter Suppiler_Email:");
            String email = sc.nextLine();
            sp.setSuppiler_email(email);
            System.out.println("------------------------------------------------------------");
            String password = PasswordField.readPassword("Enter password: ");
        // System.out.println("The password entered is: "+password);
            String decode = EncodeAndDecode.encode(password);
            sp.setSuppiler_pass(password);



            SP = new SuppilerDAL().SelectSuppiler(email, decode);

                 int kt = 0;
            for (int i = 0; i < SP.size(); i++) {
                if (SP.get(i).getSuppiler_email().equals(email) && SP.get(i).getSuppiler_pass().equals(decode)) {
                    kt = 1;
                    application.id_supplier=SP.get(i).getSuppiler_id();
                    application.name_supplier=SP.get(i).getSuppiler_name();
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
    public static void opening_question()throws SQLException{
        Boolean check = true;
        while (check) {
            System.out.println("  /-----------------------------------/");
            System.out.println(" / Do you have an account yet?(y/n)? /");
            System.out.println("/-----------------------------------/");
            String yn =sc.nextLine();
            switch (yn) {
                case "y":
                    ClearTheScreen.clrscr();
                    LoginSuppiler();
                    check=false;
                    break;
                case "n":
                    ClearTheScreen.clrscr();
                    RegisterSuppiler();
                    ClearTheScreen.clrscr();
                    LoginSuppiler();
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
    public static void show_supplier()throws SQLException{
        SP = new SuppilerDAL().SelectSuppilerID(application.id_supplier);
        CommandLineTable CT = new CommandLineTable();
        CT.setShowVerticalLines(true);
        CT.setHeaders("Supplier_ID","Supplier_Name","Supplier_Address","Supplier_Email","Supplier_Phone","Supplier_Status");
        for (int i = 0; i < SP.size(); i++) {
           CT.addRow(String.valueOf(SP.get(i).getSuppiler_id()),String.valueOf(SP.get(i).getSuppiler_name()),
           String.valueOf(SP.get(i).getSuppiler_address()),String.valueOf(SP.get(i).getSuppiler_email()),
           String.valueOf(SP.get(i).getSuppiler_phone()),String.valueOf(SP.get(i).getSuppiler_status()));
        }
        CT.print();
    }
}
