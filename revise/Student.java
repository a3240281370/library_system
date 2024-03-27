/*
預設借喻時間7天
借書量5本
罰金10
*/
package revise;

import javax.swing.JOptionPane;

import Book_store.BookList;
import Frame.Initial;
import Frame.StudentMenu;

public class Student extends Member {
    int days = 7;
    boolean fine = false;
    static int f1 = 0;
    static String str;
    static String revise[] = { "姓名", "帳號", "密碼", "返回" };
    private static String st_name, st_account, st_code;

    public Student(String name, String account, String code, int quantity) {
        super(name, account, code, quantity);
    }

    public static void login() {
        String cf_account = JOptionPane.showInputDialog(null, "輸入帳號:");
        int x = 0;
        if (st.size() == 0) {
            JOptionPane.showMessageDialog(null, "目前無人註冊!");
        } else {

            if (cf_account != null) {
                for (int i = 0; i < st.size(); i++) {
                    if (cf_account.equals(st.get(i).getaccount())) {
                        String confirm_code = JOptionPane.showInputDialog(null, "輸入密碼:");
                        // 確認密碼
                        if (confirm_code.equals(st.get(i).getcode()))// 登入成功
                        {
                            st.get(i).set_fine(10); // 這是幹嘛的？ --->這是設定他的書架為空借閱 因為不能放null值
                            new StudentMenu(st.get(i));
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

    public static void borrow_record(Student st) // 查看借的書 getList
    {

        for (int i = 0; i < st.get_list().length; i++) {
            if (st.get_list()[i] != null && st.get_list()[i] != "") {
                print += "書名: " + ((Identity) st).get_list()[i] + "\n";
            }

        }
        JOptionPane.showMessageDialog(null, "已借的書:\n" + print);
    }

    public static void identity_find(Student st) // 拉出來外面 登入才不會看起來一大串//
    {
        String other = "\n身分別: 學生\n借閱期限：7天 借閱上限：5本 逾期罰金： " + st.get_fine() + " 元";
        JOptionPane.showMessageDialog(null,
                "姓名：" + st.getname() + " \n帳號：" + st.getaccount() + "\n密碼：" + st.getcode() + other);
    }

    public static void identity_revise(Student st) {
        int r = JOptionPane.showOptionDialog(null, "請選擇想要修改的資料", "個人資料", 1, 1, null, revise, null);
        if (r == 0) {
            String name = "";
            name = JOptionPane.showInputDialog(null, "請問想要修改成什麼名字？");
            if (name != null) {
                if (name.equals("") != true) {
                    st.setname(name);
                    JOptionPane.showMessageDialog(null, "已成功更改為 " + st.getname());
                } else {
                    JOptionPane.showMessageDialog(null, "未成功輸入名字");
                }
            }
        } else if (r == 1) {
            String account = "";
            account = JOptionPane.showInputDialog(null, "請問想要修改成什麼帳號？");
            if (account != null) {
                if (account.equals("") != true) {
                    st.setaccount(account);
                    JOptionPane.showMessageDialog(null, "已成功更改為 " + st.getaccount());
                } else {
                    JOptionPane.showMessageDialog(null, "未成功輸入帳號");
                }
            }
        } else if (r == 2) {
            String code = "";
            code = JOptionPane.showInputDialog(null, "請問想要修改成什麼密碼？");
            if (code != null) {
                if (code.equals("") != true) {
                    st.setcode(code);
                    JOptionPane.showMessageDialog(null, "已成功更改為 " + st.getcode());
                } else {
                    JOptionPane.showMessageDialog(null, "未成功輸入密碼");
                }
            }
        }
    }

    public static void return_book(String bookname) // 還書
    {
        recordlist += "歸還 ";
    } // book.toString ;

    public static void record(Student st) // 查看紀錄
    {
        JOptionPane.showMessageDialog(null, "借閱紀錄由舊至新\n" + st.get_list());
    }

    public static void register() {
        st_name = JOptionPane.showInputDialog(null, "請輸入您的姓名:");
        input_error(st_name);
        while (st_name != null) {
            st_account = JOptionPane.showInputDialog(null, "Hi, " + st_name + "\n創建帳號:");
            input_error(st_account);
            account_error(st_account);
            while (st_account != null) {
                st_code = JOptionPane.showInputDialog(null, "Hi, " + st_name + "\n輸入密碼:");
                input_error(st_code);
                while (st_code != null) {
                    Student m = new Student(st_name, st_account, st_code, 5);
                    st.add(m);
                    JOptionPane.showMessageDialog(null, st.get(stud).toString());
                    Initial.st_log_Comfirm();
                    stud++;
                    break;
                }
                break;
            }
            break;
        }
    }

    public static String input_error(String s) {
        if (s == null) {
            st_name = null;
            st_account = null;
            st_code = null;
            Initial.st_reg_Comfirm();
        } else if (s.equals("")) {
            JOptionPane.showMessageDialog(null, "請重新輸入", "error", 1);
            register();
        }
        return s;
    }

    public static String account_error(String s) {
        for (int i = 0; i < st.size(); i++) {
            if (s.equals(st.get(i).getaccount())) {
                JOptionPane.showMessageDialog(null, "帳號名已被使用", "error", 1);
                register();
            }
        }
        return s;
    }

    @Override
    public String toString() {
        return "恭喜註冊成功\n" + "名稱: " + super.getname() + "\n帳號: " + super.getaccount() + "\n密碼: " + super.getcode();
    }

}
