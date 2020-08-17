package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ebay.com.dal.CustomerDAL;
import ebay.com.encrypt.EncodeAndDecode;
import ebay.com.persistance.Customer;
public class CustomerBL {
    static List<Customer> CM = new ArrayList<>();

    static Scanner sc =  new Scanner(System.in);

    public static void RegisterCustomer() throws SQLException{
       Customer cm = new Customer();
       CustomerDAL CUD = new CustomerDAL();
       System.out.println("Enter Customer_Name:");
       String name = sc .nextLine();
       cm.setCustomer_name(name);
       System.out.println("Enter Customer_Address:");
       String address = sc.nextLine();
       cm.setCustomer_address(address);
       System.out.println("Enter Customer_Email:");
       String email = sc.nextLine();
       cm.setCustomer_email(email);
       System.out.println("Enter Customer_pass");
       String pass = sc.nextLine();
       String encode = EncodeAndDecode.encode(pass);
       cm.setCustomer_pass(encode);
       System.out.println("Enter Phone_Number");
       String phone = sc.nextLine();
       cm.setCustomer_phone(phone);
       CM.add(cm);

       CUD.insert_customer(cm);
       System.err.println("---------------------------------------");
    }

    public static void LoginCustomer() throws SQLException{
       Customer cm = new Customer();
       boolean check = true;
       while (check) {
            System.out.println("Enter Email:");
            String email = sc.nextLine();
            cm.setCustomer_email(email);
            System.out.println("Enter Password:");
            String pass = sc.nextLine();
            String decode = EncodeAndDecode.encode(pass);
            cm.setCustomer_pass(decode);


            CM = new CustomerDAL().SelectCustomer(email, decode);

                 int kt = 0;
            for (int i = 0; i < CM.size(); i++) {
                if (CM.get(i).getCustomer_email().equals(email) && CM.get(i).getCustomer_pass().equals(decode)) {
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
