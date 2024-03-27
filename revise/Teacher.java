/*
預設借喻時間21天
借書量15本
罰金5
*/
package revise;

import javax.swing.JOptionPane;

import Frame.Initial;
import Frame.TeacherMenu;

public class Teacher extends Member {
    int days = 21;
    boolean fine = false;
    static int f1 = 0;
    static String str;
    static String function1[] = { "借書", "還書", "查詢個人資料", "修改個人資料", "紀錄", "查詢書籍", "登出" };
    static String revise[] = { "姓名", "帳號", "密碼", "返回" };
    private static String te_name, te_account, te_code;

    public Teacher(String name, String account, String code, int quantity) {
        super(name, account, code, quantity);
    }

    public static void login() {
        String cf_account = JOptionPane.showInputDialog(null, "輸入帳號:");
        int x = 0;
        if (te.size() == 0) {
            JOptionPane.showMessageDialog(null, "目前無人註冊!");
        } else {
            if (cf_account != null) {
                for (int i = 0; i < te.size(); i++) {
                    if (cf_account.equals(te.get(i).getaccount())) {
                        String confirm_code = JOptionPane.showInputDialog(null, "輸入密碼:");
                        // 確認密碼
                        if (confirm_code.equals(te.get(i).getcode()))// 登入成功
                        {
                            te.get(i).set_fine(5);
                            new TeacherMenu(te.get(i));
                            x = 2;
                            break;
                        } else {
                            x = 1;
                        }
                    } else {
                        x = 3;
                    }
                }
                if (x == 3) {
                    JOptionPane.showMessageDialog(null, "無此帳號!");
                    login();
                } else if (x == 1) {
                    JOptionPane.showMessageDialog(null, "密碼錯誤!");
                    login();
                }
            }
        }
    }

    static String print = "";

    public static void borrow_record(Teacher te) // 查看借的書 getList
    {

        for (int i = 0; i < te.get_list().length; i++) {
            if (te.get_list()[i] != null && te.get_list()[i] != "") {
                print += "書名: " + ((Identity) te).get_list()[i] + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, "已借的書:\n" + print);
    }

    public static void identity_find(Teacher te) // 拉出來外面 登入才不會看起來一大串//
    {
        String other = "\n身分別: 老師\n借閱期限：21天 借閱上限：15本 逾期罰金： " + te.get_fine() + " 元";
        JOptionPane.showMessageDialog(null,
                "姓名：" + te.getname() + " \n帳號：" + te.getaccount() + "\n密碼：" + te.getcode() + other);
    }

    public static void identity_revise(Teacher te) {
        int r = JOptionPane.showOptionDialog(null, "請選擇想要修改的資料", "個人資料", 1, 1, null, revise, null);
        if (r == 0) {
            String name = "";
            name = JOptionPane.showInputDialog(null, "請問想要修改成什麼名字？");
            if (name != null) {
                if (name.equals("") != true) {
                    te.setname(name);
                    JOptionPane.showMessageDialog(null, "已成功更改為 " + te.getname());
                } else {
                    JOptionPane.showMessageDialog(null, "未成功輸入名字");
                }
            }
        } else if (r == 1) {
            String account = "";
            account = JOptionPane.showInputDialog(null, "請問想要修改成什麼帳號？");
            if (account != null) {
                if (account.equals("") != true) {
                    te.setaccount(account);
                    JOptionPane.showMessageDialog(null, "已成功更改為 " + te.getaccount());
                } else {
                    JOptionPane.showMessageDialog(null, "未成功輸入帳號");
                }
            }
        } else if (r == 2) {
            String code = "";
            code = JOptionPane.showInputDialog(null, "請問想要修改成什麼密碼？");
            if (code != null) {
                if (code.equals("") != true) {
                    te.setcode(code);
                    JOptionPane.showMessageDialog(null, "已成功更改為 " + te.getcode());
                } else {
                    JOptionPane.showMessageDialog(null, "未成功輸入密碼");
                }
            }
        }
    }

    public static void register() {
        te_name = JOptionPane.showInputDialog(null, "請輸入您的姓名:");
        input_error(te_name);
        while (te_name != null) {
            te_account = JOptionPane.showInputDialog(null, "Hi, " + te_name + "\n創建帳號:");
            input_error(te_account);
            account_error(te_account);
            while (te_account != null) {
                te_code = JOptionPane.showInputDialog(null, "Hi, " + te_name + "\n輸入密碼:");
                input_error(te_code);
                while (te_code != null) {
                    Teacher ter = new Teacher(te_name, te_account, te_code, 5);
                    te.add(ter);
                    JOptionPane.showMessageDialog(null, te.get(tech).toString());
                    Initial.te_log_Comfirm();
                    tech++;
                    break;
                }
                break;
            }
            break;
        }
    }

    public static String input_error(String s) {
        if (s == null) {
            te_name = null;
            te_account = null;
            te_code = null;
            Initial.te_reg_Comfirm();
        } else if (s.equals("")) {
            JOptionPane.showMessageDialog(null, "請重新輸入", "error", 1);
            register();
        }
        return s;
    }

    public static String account_error(String s) {
        for (int i = 0; i < te.size(); i++) {
            if (s.equals(te.get(i).getaccount())) {
                JOptionPane.showMessageDialog(null, "帳號名已被使用", "error", 1);
                register();
            }
        }
        return s;
    }

    public String toString() {
        return "恭喜註冊成功\n" + "名稱: " + super.getname() + "\n帳號: " + super.getaccount() + "\n密碼: " + super.getcode();
    }

}
