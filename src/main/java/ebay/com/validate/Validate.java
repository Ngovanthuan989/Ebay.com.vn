package ebay.com.validate;

import java.util.Scanner;

public class Validate {

    static Scanner sc = new Scanner(System.in);

         public String checkEmpty() {

             while (true) {
                 String input = sc.nextLine().trim();
                 if (input.isEmpty()) {
                     System.out.println("Không Được Để Trống.Mời Nhập Lại!");
                     continue;
                 }
                 return input;
             }
         }


     public String checkEMail() {
         while (true) {
             String email = new Validate().checkEmpty();
             if (email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {

                 return email;
             } else {
                 System.out.println(" Email Không Đúng!Mời Nhập Lại:");
             }

         }

     }
     public String check_PassWord(){
         while (true) {
             String pass = new Validate().checkEmpty();
             if (pass.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20}")) {

                 return pass;
             } else {
                 System.out.println("PASS Phải chứa ít nhất 1 ký tự số từ 0 – 9. Phải chứa ít nhất 1 ký tự chữ thường. Phải chứa ít nhất 1 ký tự chữ hoa");
             }

         }
     }
     public String check_SĐT(){
         while (true) {
             String pass = new Validate().checkEmpty();
             if (pass.matches("(09|01[2|6|8|9])+([0-9]{8})")) {

                 return pass;
             } else {
                 System.out.println("SĐT Không Đúng.MỜi Nhập Lại:");
             }

         }
     }

     public String checkString() {
         while (true) {
             // name nafy chi bien tam thoi de kiem tra
             String name = new Validate().checkEmpty();
             if (name.matches("[a-z A-Z]+")) {

                 return name;
             } else {
                 System.out.println("Không Được Nhập Số Hay Kí Tự Đặc Biệt ! Mời Nhập Lại:");
             }

         }

     }

     public String checkINT() {
         while (true) {
             // name nafy chi bien tam thoi de kiem tra
             String name = new Validate().checkEmpty();
             if (name.matches("-?\\d+(\\.\\d+)?")) {

                 return name;
             } else {
                 System.out.println("Không được có chữ với kí tự đặc biệt ! Mời Nhập Lại:");
             }

         }

     }

 }
