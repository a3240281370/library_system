package Visit;

import revise.*;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
import Book_store.*;
import Frame.AdminMenu;

public class Admin {
    ArrayList<Book> book_db = new ArrayList<Book>();
    static ArrayList<Identity> ad = new ArrayList<Identity>();

    public Admin() {
        ad.add(new Identity("早安", "你好", "順心"));
        ad.add(new Identity("現在", "我有", "冰淇淋"));
        ad.add(new Identity("nn", "aa", "cc"));
    }

    public void a_login() {
        String cf_account = JOptionPane.showInputDialog(null, "輸入帳號:");
        int x = 0;

        for (int i = 0; i < ad.size(); i++) {
            if (cf_account != null) {
                if (cf_account.equals(ad.get(i).getaccount())) {
                    String confirm_code = JOptionPane.showInputDialog(null, "輸入密碼:");
                    if (confirm_code.equals(ad.get(i).getcode())) {
                        AdminMenu am = new AdminMenu();
                        x = 2;
                        break;
                    } else {
                        x = 1;

                    }
                } else {
                    x = 3;
                }
            }

        }
        if (x == 3) {
            JOptionPane.showMessageDialog(null, "無此帳號!");
            a_login();
        } else if (x == 1) {
            JOptionPane.showMessageDialog(null, "密碼錯誤!");
            a_login();
        }

    }

    public static void look_speak() {
        String a = "";
        for (int i = 3; i >= 0; i--) {
            a = a + BookList.speak1[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, a);

    }

    public static String recommend1[] = { "", "", "", "" };

    public static void recommend() {
        boolean a = true;

        String announce = JOptionPane.showInputDialog(null, "推薦書單 ");
        for (int i = 0; i < recommend1.length; i++) {
            if (recommend1[i].equals("")) {
                a = true;
                recommend1[i] = announce;
                break;
            } else {
                a = false;
            }
        }
        if (a == false) {
            recommend1[0] = recommend1[1];
            recommend1[1] = recommend1[2];
            recommend1[2] = recommend1[3];
            recommend1[3] = announce;
        }
        Arrays.sort(recommend1);
        JOptionPane.showMessageDialog(null, "完成新增推薦書籍");
    }

    public static void l_look() {
        JOptionPane.showMessageDialog(null, "講座參加名單：\n" + Guest.result);
    }

}
