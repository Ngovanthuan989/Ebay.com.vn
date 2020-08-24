package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ebay.com.dal.AdminDAL;
import ebay.com.encrypt.PasswordField;
import ebay.com.persistance.Admin;
import ebay.com.persistance.application;

public class AdminBL {
    static List<Admin> AD = new ArrayList<>();
    static Scanner sc =  new Scanner(System.in);

    public static void AdminLogin() throws SQLException{
        Admin ad = new Admin();

        boolean check = true;

        while (check) {
            System.out.println("----------------------------Admin Login--------------------------");
            System.out.print(" 1.Enter Admin Email:");
            String email = sc .nextLine();
            ad.setAdmin_email(email);
            System.out.println("-----------------------------------------------------");
            String password = PasswordField.readPassword("Enter Admin password: ");
            // System.out.println("The password entered is: "+password);
            ad.setAdmin_password(password);

            AD = new AdminDAL().SelectAdmin(email, password);
            int kt = 0;

            for (int i = 0; i < AD.size(); i++) {
                if (AD.get(i).getAdmin_email().equals(email) && AD.get(i).getAdmin_password().equals(password)) {
                    kt = 1;
                    application.id_admin=AD.get(i).getAdmin_id();
                    application.name_admin=AD.get(i).getAdmin_name();
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
