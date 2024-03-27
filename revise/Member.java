package revise;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import Book_store.*;
import Frame.Initial;

import javax.swing.JOptionPane;

public abstract class Member extends Identity {
    static int i = 0, stud = 0, staf = 0, tech = 0; // 類型要哪一種?
    public static ArrayList<Student> st = new ArrayList<Student>();
    public static ArrayList<Teacher> te = new ArrayList<Teacher>();
    public static ArrayList<Staff> sf = new ArrayList<Staff>();
    static String recordlist = "";

    public Member(String name, String account, String code, int quantity) {
        super(name, account, code, quantity);
    }

    static Random r = new Random();
    static int random_num = r.nextInt(30) + 1;
    static SimpleDateFormat fm1 = new SimpleDateFormat("yyyy-MM-dd");

    static Calendar now_Time = Calendar.getInstance();
    static Calendar after_Time = Calendar.getInstance();
    static Calendar back_Time = Calendar.getInstance();

    static TimeUnit time = TimeUnit.DAYS;

    static Object any;

    public static void M_borrrowbook(Object m) // 通用的借書功能
    {
        Date now = (Date) now_Time.getTime();
        if (m instanceof Student) {
            if (((Student) m).get_quantity() > 0) // 有額度 可借
            {

                after_Time.add(Calendar.DATE, 7); // 預計歸還日
                Date after = (Date) after_Time.getTime();
                String p = "";
                p = JOptionPane.showInputDialog(null, "輸入借閱書本名稱:");
                if (BookList.borrow_fc(p, m) == 1) {
                    ((Student) m).set_record("已借閱:  " + BookList.a + "時間:  " + fm1.format(now));
                    ((Student) m).get_list()[i] = BookList.a;
                    ((Student) m).borrow_quantity(1);
                    String result = "書名:  " + BookList.a + " 作者:  " + BookList.b + " 出版社:  " + BookList.c + "\n"
                            + "借閱時間: " + fm1.format(now);
                    result += "\n到期時間: " + fm1.format(after) + "\n請在到期日前歸還 否則將有罰金處分。";
                    JOptionPane.showMessageDialog(null, "已成功借閱\n" + result);
                    after_Time.add(Calendar.DATE, -7);
                }

            } else // 沒有額度 不可借
            {
                JOptionPane.showMessageDialog(null, "借閱已達上限");
            }
        }

        else if (m instanceof Teacher) {
            if (((Teacher) m).get_quantity() > 0) // 有額度 可借
            {
                if (BookList.borrow_fc(JOptionPane.showInputDialog(null, "輸入借閱書本名稱:"), m) == 1) {

                    after_Time.add(Calendar.DATE, 21); // 預計歸還日
                    Date after = (Date) after_Time.getTime();
                    ((Teacher) m).set_record("已借閱:  " + BookList.a + "時間:  " + fm1.format(now));
                    ((Teacher) m).get_list()[i] = BookList.a;
                    ((Teacher) m).borrow_quantity(1);
                    String result = "書名:  " + BookList.a + " 作者:  " + BookList.b + " 出版社:  " + BookList.c + "\n"
                            + "借閱時間: " + fm1.format(now);
                    result += "\n到期時間: " + fm1.format(after) + "\n請在到期日前歸還 否則將有罰金處分。";
                    JOptionPane.showMessageDialog(null, "已成功借閱\n" + result);
                    after_Time.add(Calendar.DATE, -21);
                }

            } else // 沒有額度 不可借
            {
                JOptionPane.showMessageDialog(null, "借閱已達上限");
            }
        } else if (m instanceof Staff) {
            if (((Staff) m).get_quantity() > 0) // 有額度 可借
            {

                after_Time.add(Calendar.DATE, 14); // 預計歸還日
                Date after = (Date) after_Time.getTime();
                if (BookList.borrow_fc(JOptionPane.showInputDialog(null, "輸入借閱書本名稱:"), m) == 1) {
                    ((Staff) m).set_record("已借閱:  " + BookList.a + "時間:  " + fm1.format(now));
                    ((Staff) m).get_list()[i] = BookList.a;
                    ((Staff) m).borrow_quantity(1);
                    String result = "書名:  " + BookList.a + " 作者:  " + BookList.b + " 出版社:  " + BookList.c + "\n"
                            + "借閱時間: " + fm1.format(now);
                    result += "\n到期時間: " + fm1.format(after) + "\n請在到期日前歸還 否則將有罰金處分。";
                    JOptionPane.showMessageDialog(null, "已成功借閱\n" + result);
                    after_Time.add(Calendar.DATE, -14);
                }

            } else // 沒有額度 不可借
            {
                JOptionPane.showMessageDialog(null, "借閱已達上限");
            }
        }

        BookList.a = "";
        BookList.b = "";
        BookList.c = "";
    }

    public static void M_returnbook(Object m) // 還書
    {

        Date now = (Date) now_Time.getTime();
        back_Time.add(Calendar.DATE, random_num); // 歸還日
        Date back = (Date) back_Time.getTime();
        long diff = back.getTime() - now.getTime();
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);

        String r_book = JOptionPane.showInputDialog(null, "輸入歸還書本名稱:");

        boolean j = false;
        for (int i = 0; i < ((Identity) m).get_list().length; i++) {
            if (Arrays.asList(((Identity) m).get_list()).contains(r_book)) {
                BookList.return_fc(r_book);
                j = true;
                break;
            }

        }
        if (j) // 存在使用者的借閱裡面
        {
            if (diffrence > 7) // 超出時間歸還
            {
                if (m instanceof Student) {
                    M_reserve(r_book, back);
                    ((Identity) m).set_record("逾期歸還:  " + BookList.a + "時間:  " + fm1.format(back));
                    ((Student) m).get_list()[i] = null;
                    ((Identity) m).return_quantity(1);

                    if (diffrence > 7) {
                        int a = Integer.parseInt(String.valueOf(diffrence - 7));
                        ((Identity) m).set_fine(10 * a);

                        String result = "書名:  " + BookList.a + "\n" + "借閱時間:  " + fm1.format(now) + "\n" + "歸還時間:  "
                                + fm1.format(back);
                        result += "\n已逾期天數:  " + (diffrence - 7) + "天 累計罰金:  " + ((Identity) m).get_fine() + "  元";

                        JOptionPane.showMessageDialog(null, result);
                    }

                }

                else if (m instanceof Teacher) {
                    M_reserve(r_book, back);
                    ((Identity) m).set_record("逾期歸還:  " + BookList.a + "時間:  " + fm1.format(back));
                    ((Teacher) m).get_list()[i] = null;
                    ((Identity) m).return_quantity(1);

                    if (diffrence > 21) {
                        int a = Integer.parseInt(String.valueOf(diffrence - 21));
                        ((Identity) m).set_fine(10 * a);

                        String result = "書名:  " + BookList.a + "\n" + "借閱時間:  " + fm1.format(now) + "\n" + "歸還時間:  "
                                + fm1.format(back);
                        result += "\n已逾期天數:  " + (diffrence - 21) + "天 累計罰金:  " + ((Identity) m).get_fine() + "  元";

                        JOptionPane.showMessageDialog(null, result);
                    }
                }

                else if (m instanceof Staff) {
                    M_reserve(r_book, back);
                    ((Identity) m).set_record("逾期歸還:  " + BookList.a + "時間:  " + fm1.format(back));
                    ((Staff) m).get_list()[i] = null;
                    ((Identity) m).return_quantity(1);

                    if (diffrence > 14) {
                        int a = Integer.parseInt(String.valueOf(diffrence - 14));
                        ((Identity) m).set_fine(10 * a);

                        String result = "書名:  " + BookList.a + "\n" + "借閱時間:  " + fm1.format(now) + "\n" + "歸還時間:  "
                                + fm1.format(back);
                        result += "\n已逾期天數:  " + (diffrence - 14) + "天 累計罰金:  " + ((Identity) m).get_fine() + "  元";

                        JOptionPane.showMessageDialog(null, result);
                    }
                }

            }

            else // 時間內歸還
            {
                if (m instanceof Student) {
                    M_reserve(r_book, back);
                    ((Identity) m).set_fine(0);
                    String result = "書名:  " + BookList.a + "\n" + "借閱時間: " + fm1.format(now) + "\n" + "歸還時間: "
                            + fm1.format(back);
                    result += "\n此次歸還無罰金產生。\n累計罰金:  " + ((Identity) m).get_fine() + "  元";
                    JOptionPane.showMessageDialog(null, result);

                    ((Identity) m).set_record("無逾期歸還:  " + BookList.a + "時間:  " + fm1.format(back));
                    ((Student) m).get_list()[i] = null;
                    ((Identity) m).return_quantity(1);

                }

                else if (m instanceof Teacher) {
                    M_reserve(r_book, back);
                    ((Identity) m).set_fine(0);
                    String result = "書名:  " + BookList.a + "\n" + "借閱時間: " + fm1.format(now) + "\n" + "歸還時間: "
                            + fm1.format(back);
                    result += "\n此次歸還無罰金產生。\n累計罰金:  " + ((Identity) m).get_fine() + "  元";
                    JOptionPane.showMessageDialog(null, result);

                    ((Identity) m).set_record("無逾期歸還:  " + BookList.a + "時間:  " + fm1.format(back));
                    ((Teacher) m).get_list()[i] = null;
                    ((Identity) m).return_quantity(1);
                }

                else if (m instanceof Staff) {
                    M_reserve(r_book, back);
                    ((Identity) m).set_fine(0);
                    String result = "書名:  " + BookList.a + "\n" + "借閱時間: " + fm1.format(now) + "\n" + "歸還時間: "
                            + fm1.format(back);
                    result += "\n此次歸還無罰金產生。\n累計罰金:  " + ((Identity) m).get_fine() + "  元";
                    JOptionPane.showMessageDialog(null, result);

                    ((Identity) m).set_record("無逾期歸還:  " + BookList.a + "時間:  " + fm1.format(back));
                    ((Teacher) m).get_list()[i] = null;
                    ((Identity) m).return_quantity(1);
                }
            }

        }

        else if (!j & r_book.equals("")) // Ok==null
        {
            JOptionPane.showMessageDialog(null, "輸入錯誤");
        }

        else if (!j) // 不存在使用者的借閱內
        {
            JOptionPane.showMessageDialog(null, "您的借閱列表當中沒有" + r_book + "此書的存在");
        }

    }

    public abstract String toString();

    public static void M_reserve(String r_book, Date back) {

        for (int i = 0; i < BookList.reservenum; i++) {
            Book b = (Book) BookList.reserve[i][0];
            Identity d = (Identity) BookList.reserve[i][1];
            String n = b.getBookname();

            if (n.equals(r_book)) {
                System.out.println(n);
                System.out.println("1 " + ((Book) BookList.reserve[i][0]));
                System.out.println("2 " + ((Book) BookList.reserve[i][0]).getBookname());

                ((Book) BookList.reserve[i][0]).setborrowed(true);

                Date now = (Date) now_Time.getTime();
                if (d instanceof Student) {
                    if (((Student) d).get_quantity() > 0) // 有額度 可借
                    {
                        after_Time.add(Calendar.DATE, 7); // 預計歸還日
                        ((Student) d).set_record("預約書:  " + BookList.a + "時間:  " + fm1.format(back));
                        ((Student) d).get_list()[i] = n;
                        ((Student) d).borrow_quantity(1);
                        after_Time.add(Calendar.DATE, -7);
                        BookList.reserve[i][0] = new Book(" ", " ", " ", " ", false, 0);
                        BookList.reserve[i][1] = new Identity(" ", " ", " ", 3);

                        break;

                    }

                    else // 沒有額度 不可借
                    {
                        JOptionPane.showMessageDialog(null, "借閱已達上限");
                    }

                } else if (d instanceof Teacher) {
                    if (((Teacher) d).get_quantity() > 0) // 有額度 可借
                    {
                        after_Time.add(Calendar.DATE, 21); // 預計歸還日
                        Date after = (Date) after_Time.getTime();
                        ((Teacher) d).set_record("預約書:  " + BookList.a + "時間:  " + fm1.format(now));
                        ((Teacher) d).get_list()[i] = n;
                        ((Teacher) d).borrow_quantity(1);
                        after_Time.add(Calendar.DATE, -21);
                        break;
                    } else // 沒有額度 不可借
                    {
                        JOptionPane.showMessageDialog(null, "借閱已達上限");
                    }
                } else if (d instanceof Staff) {
                    if (((Staff) d).get_quantity() > 0) // 有額度 可借
                    {
                        after_Time.add(Calendar.DATE, 14); // 預計歸還日
                        Date after = (Date) after_Time.getTime();

                        ((Staff) d).set_record("預約書:  " + BookList.a + "時間:  " + fm1.format(now));
                        ((Staff) d).get_list()[i] = n;
                        ((Staff) d).borrow_quantity(1);
                        after_Time.add(Calendar.DATE, -14);
                        break;
                    } else // 沒有額度 不可借
                    {
                        JOptionPane.showMessageDialog(null, "借閱已達上限");
                    }
                }

                break;

            }
        }

    }

    public static void register() {
    }

    public static void Register_option(int i3_choise) {
        switch (i3_choise) {
            case 0:
                Student.register();
                Initial.st_log_Comfirm();
                break;
            case 1:
                Staff.register();
                Initial.sf_log_Comfirm();
                break;
            case 2:
                Teacher.register();
                Initial.te_log_Comfirm();
                break;
        }

    }

    public static void login(int a) {

    }

}
