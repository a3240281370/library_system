package Visit;

import javax.swing.JOptionPane;
import Book_store.*;

public class Guest {

    public static String result = "";

    public static void look_announce() {
        String a = "";
        for (int i = 3; i >= 0; i--) {
            a = a + BookList.announce1[i] + "\n";
            System.out.println(a);
        }
        JOptionPane.showMessageDialog(null, "哈囉 !\n 最新公告 : " + a);
    }

    public static void look_recommend() {
        String a = "";
        for (int i = 3; i >= 0; i--) {
            a = a + Admin.recommend1[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, a);
    }

    static int number = 0;

    public static void lecture() {
        int a = JOptionPane.showConfirmDialog(null,
                "活動名稱：「周大帥的日常」 書籍深入分析講座\n活動日期：6/15 10:00-12:00\n講者：周大帥本人\n人數限制：5人 \n是否要參加？");
        switch (a) {
            case 0:

                if (number <= 5) {
                    String name = "";
                    name = JOptionPane.showInputDialog(null, "請輸入參加者的姓名");
                    if (name != null) {
                        if (name.equals("") != true) {
                            int cnt = 0;
                            String z = JOptionPane.showInputDialog(null, "參加人數");
                            if (z != null) {
                                cnt = Integer.parseInt(z);
                                number += cnt;
                                if (cnt <= 0) {
                                    JOptionPane.showMessageDialog(null, "參加人數至少一人");
                                    number -= cnt;
                                    // function();
                                    break;
                                } else if (cnt > 5) {
                                    JOptionPane.showMessageDialog(null, "報名人數超過限制");
                                    number -= cnt;
                                    System.out.println(number);
                                    // function();
                                    break;
                                } else {
                                    if (number >= 6) {
                                        System.out.print(number);
                                        System.out.print(cnt);
                                        JOptionPane.showMessageDialog(null,
                                                "目前剩餘名額：" + (5 - number + cnt) + "\n報名人數超過限制");
                                        number -= cnt;
                                    } else {
                                        String phone = "";
                                        phone = JOptionPane.showInputDialog(null, "聯絡電話");
                                        if (phone != null) {
                                            if (phone.equals("") != true) {
                                                result += "姓名：" + name + "  人數：" + cnt + "  電話：" + phone + "\n";
                                                JOptionPane.showMessageDialog(null,
                                                        "姓名:" + name + "  參加人數:" + cnt + "  聯絡電話:" + phone);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "請勿輸入空值");
                                                // function();
                                                break;
                                            }
                                        }

                                        else {// function();
                                            break;
                                        }
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "請勿輸入空值");
                                // function();
                                break;
                            }
                        } else {// function();
                            break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "報名人數已滿，下次請早");
                        // function();
                        break;
                    }
                }
                break;
            case 1:
                // function();
                break;
            case 2:
                // function();
                break;
        }
    }

}
