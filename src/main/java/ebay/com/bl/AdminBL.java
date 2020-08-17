package ebay.com.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ebay.com.dal.AdminDAL;
import ebay.com.persistance.Admin;

public class AdminBL {
    static List<Admin> AD = new ArrayList<>();
    static Scanner sc =  new Scanner(System.in);

    public static void AdminLogin() throws SQLException{
        Admin ad = new Admin();

        boolean check = true;

        while (check) {
            System.out.println("Enter Admin Email:");
            String email = sc .nextLine();
            ad.setAdmin_email(email);
            System.out.println("Enter Admin Password:");
            String pass = sc.nextLine();
            ad.setAdmin_password(pass);

            AD = new AdminDAL().SelectAdmin(email, pass);
            int kt = 0;

            for (int i = 0; i < AD.size(); i++) {
                if (AD.get(i).getAdmin_email().equals(email) && AD.get(i).getAdmin_password().equals(pass)) {
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
