/*
預設借喻時間14天
借書量10本
罰金5
*/
package revise;

import javax.swing.JOptionPane;

import Frame.Initial;
import Frame.StaffMenu;

public class Staff extends Member {
    int days = 14;
    boolean fine = false;
    static int f1 = 0;
    static String str;
    static String function1[] = { "借書", "還書", "查詢個人資料", "修改個人資料", "紀錄", "查詢書籍", "登出" };
    static String revise[] = { "姓名", "帳號", "密碼", "返回" };
    private static String sf_name, sf_account, sf_code;

    public Staff(String name, String account, String code, int quantity) {
        super(name, account, code, quantity);
    }

    public static void login() {
        String cf_account = JOptionPane.showInputDialog(null, "輸入帳號:");
        int x = 0;
        if (sf.size() == 0) {
            JOptionPane.showMessageDialog(null, "目前無人註冊!");
        } else {

            if (cf_account != null) {
                for (int i = 0; i < sf.size(); i++) {
                    if (cf_account.equals(sf.get(i).getaccount())) {
                        String confirm_code = JOptionPane.showInputDialog(null, "輸入密碼:");
                        // 確認密碼
                        if (confirm_code.equals(sf.get(i).getcode()))// 登入成功
                        {
                            sf.get(i).set_fine(5);
                            new StaffMenu(sf.get(i));
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

    public static void borrow_record(Staff sf) // 查看借的書 getList
    {

        for (int i = 0; i < sf.get_list().length; i++) {
            if (sf.get_list()[i] != null && sf.get_list()[i] != "") {
                print += "書名: " + ((Identity) sf).get_list()[i] + "\n";
            }

        }
        JOptionPane.showMessageDialog(null, "已借的書:\n" + print);
    }

    public static void identity_find(Staff sf) // 拉出來外面 登入才不會看起來一大串//
    {
        String other = "\n身分別: 職員\n借閱期限：14天 借閱上限：10本 逾期罰金： " + sf.get_fine() + " 元";
        JOptionPane.showMessageDialog(null,
                "姓名：" + sf.getname() + " \n帳號：" + sf.getaccount() + "\n密碼：" + sf.getcode() + other);
    }

    public static void identity_revise(Staff sf) {
        int r = JOptionPane.showOptionDialog(null, "請選擇想要修改的資料", "個人資料", 1, 1, null, revise, null);
        if (r == 0) {
            String name = "";
            name = JOptionPane.showInputDialog(null, "請問想要修改成什麼名字？");
            if (name != null) {
                if (name.equals("") != true) {
                    sf.setname(name);
                    JOptionPane.showMessageDialog(null, "已成功更改為 " + sf.getname());
                } else {
                    JOptionPane.showMessageDialog(null, "未成功輸入名字");
                }
            }
        } else if (r == 1) {
            String account = "";
            account = JOptionPane.showInputDialog(null, "請問想要修改成什麼帳號？");
            if (account != null) {
                if (account.equals("") != true) {
                    sf.setaccount(account);
                    JOptionPane.showMessageDialog(null, "已成功更改為 " + sf.getaccount());
                } else {
                    JOptionPane.showMessageDialog(null, "未成功輸入帳號");
                }
            }
        } else if (r == 2) {
            String code = "";
            code = JOptionPane.showInputDialog(null, "請問想要修改成什麼密碼？");
            if (code != null) {
                if (code.equals("") != true) {
                    sf.setcode(code);
                    JOptionPane.showMessageDialog(null, "已成功更改為 " + sf.getcode());
                } else {
                    JOptionPane.showMessageDialog(null, "未成功輸入密碼");
                }
            }
        }
    }

    public String toString() {
        return "恭喜註冊成功\n" + "名稱: " + super.getname() + "\n帳號: " + super.getaccount() + "\n密碼: " + super.getcode();
    }

    public static void register() {
        sf_name = JOptionPane.showInputDialog(null, "請輸入您的姓名:");
        input_error(sf_name);
        while (sf_name != null) {
            sf_account = JOptionPane.showInputDialog(null, "Hi, " + sf_name + "\n創建帳號:");
            input_error(sf_account);
            account_error(sf_account);
            while (sf_account != null) {
                sf_code = JOptionPane.showInputDialog(null, "Hi, " + sf_name + "\n輸入密碼:");
                input_error(sf_code);
                while (sf_code != null) {
                    Staff stf = new Staff(sf_name, sf_account, sf_code, 10);
                    sf.add(stf);
                    JOptionPane.showMessageDialog(null, sf.get(staf).toString());
                    Initial.sf_log_Comfirm();
                    staf++;
                    break;
                }
                break;
            }
            break;
        }
    }

    public static String input_error(String s) {
        if (s == null) {
            sf_name = null;
            sf_account = null;
            sf_code = null;
            Initial.sf_reg_Comfirm();
        } else if (s.equals("")) {
            JOptionPane.showMessageDialog(null, "請重新輸入", "error", 1);
            register();
        }
        return s;
    }

    public static String account_error(String s) {
        for (int i = 0; i < sf.size(); i++) {
            if (s.equals(sf.get(i).getaccount())) {
                JOptionPane.showMessageDialog(null, "帳號名已被使用", "error", 1);
                register();
            }
        }
        return s;
    }

}
