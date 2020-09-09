package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ebay.com.UI.ClearTheScreen;
import ebay.com.UI.CommandLineTable;
import ebay.com.dal.CustomerDAL;
import ebay.com.encrypt.EncodeAndDecode;
import ebay.com.encrypt.PasswordField;
import ebay.com.persistance.Customer;
import ebay.com.persistance.application;
import ebay.com.validate.Validate;
public class CustomerBL {

    static List<Customer> CM = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);


    public static void RegisterCustomer() throws SQLException {
        Customer cm = new Customer();
        CustomerDAL CUD = new CustomerDAL();
        System.out.println("-----------------------------RegisterCustomer--------------------------");
        System.out.print("  1.Enter Customer_Name:");
        String name = new Validate().checkString();
        cm.setCustomer_name(name);
        System.out.println("--------------------------------------------------------");
        System.out.print("  2.Enter Customer_Address:");
        String address = new Validate().checkEmpty();
        cm.setCustomer_address(address);
        System.out.println("--------------------------------------------------------");
        System.out.print("  3.Enter Customer_Email:");
        String email = new Validate().checkEMail();
        cm.setCustomer_email(email);
        System.out.println("--------------------------------------------------------");
        String password = PasswordField.readPassword("4.Enter Customer_password: ");
        // System.out.println("The password entered is: "+password);
        String encode = EncodeAndDecode.encode(password);
        cm.setCustomer_pass(encode);
        System.out.println("--------------------------------------------------------");
        System.out.print("  5.Enter Phone_Number:");
        String phone = new Validate().check_SĐT();
        cm.setCustomer_phone(phone);
        CM.add(cm);

        CUD.insert_customer(cm);
        ClearTheScreen.clrscr();
        System.out.println("  /-------------------------------------/");
        System.err.println(" /           Register Success          /");
        System.out.println("/-------------------------------------/");
        System.out.println("--Press enter to continue.............");
        String enter=sc.nextLine();
    }

    public static void LoginCustomer() throws SQLException {
        Customer cm = new Customer();
        boolean check = true;
        while (check) {
            System.out.println("---------------------Login Customer---------------------");
            System.out.print(" 1.Enter Email:");
            String email = sc.nextLine();
            cm.setCustomer_email(email);
            System.out.println("--------------------------------------------------------");
            String password = PasswordField.readPassword("2.Enter password: ");
            String decode = EncodeAndDecode.encode(password);
            cm.setCustomer_pass(decode);


            CM = new CustomerDAL().SelectCustomer(email, decode);
                int kt = 0;
            for (int i = 0; i < CM.size(); i++) {
                if (CM.get(i).getCustomer_email().equals(email) && CM.get(i).getCustomer_pass().equals(decode)) {
                    kt = 1;
                    application.id_customer=CM.get(i).getCustomer_id();
                    application.name_customer=CM.get(i).getCustomer_name();
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
    public static void showCustomer()throws SQLException{
        int cu_id = application.id_customer;
        CM = new CustomerDAL().SelectCustomerID(cu_id);
        CommandLineTable CT = new CommandLineTable();
        CT.setShowVerticalLines(true);
        CT.setHeaders("Customer_id","Customer_Name","Customer_Address","Customer_Email","Customer_Phone");
        for (int i = 0; i < CM.size(); i++) {
           CT.addRow(String.valueOf(CM.get(i).getCustomer_id()),String.valueOf(CM.get(i).getCustomer_name()),
           String.valueOf(CM.get(i).getCustomer_address()),String.valueOf(CM.get(i).getCustomer_email()),
           String.valueOf(CM.get(i).getCustomer_phone()));
        }
        CT.print();
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
                    LoginCustomer();
                    check=false;
                    break;
                case "n":
                    ClearTheScreen.clrscr();
                    RegisterCustomer();
                    ClearTheScreen.clrscr();
                    LoginCustomer();
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
