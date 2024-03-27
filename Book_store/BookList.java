package Book_store;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import Frame.AdminMenu;
import Visit.Admin;
import revise.Identity;

public class BookList {
    static ArrayList<Book> books = new ArrayList<Book>();
    public static String a, b, c;
    static String back[] = { "返回前一頁", "登出" };
    static String[] news = new String[10];
    static String result;
    public static Object reserve[][] = new Object[10][2];
    public static int reservenum = 0;

    public BookList() {
        ini();
    }

    public static void ini() {
        books.add(new Book("偽魚販指南", "林楷倫", "寶瓶文化", "小說", false, 0));
        books.add(new Book("周大帥的日常", "周大帥", "中央大學", "課外書", false, 0));
        books.add(new Book("周小帥時尚指南", "周小帥", "花蓮地區", "雜誌", false, 0));
        books.add(new Book("周教授傳", "周教授", "恩傑大學", "教科書", false, 0));
        books.add(new Book("aaaa", "bbbb", "cccc", "dddd", false, 0));
        books.add(new Book("java", "let", "me", "die", false, 0));
        books.add(new Book("庫拉皮卡", "好想", "下船", "沒可能", false, 0));
        books.add(new Book("恩傑", "沒空", "讀會計", "爆掉", false, 0));
        books.add(new Book("亦鴻", "管數", "放水流", "完蛋", false, 0));
        books.add(new Book("準備", "放暑假", "去玩水了", "耶～", false, 0));
    }

    public static String add_error(String s) {
        if (s == null) {
            AdminMenu.addbook_Comfirm();
            return s;
        } else if (s.equals("")) {
            JOptionPane.showMessageDialog(null, "請重新輸入", "error", 1);
            addBook();
            return s;
        }
        return s;
    }

    public static String edit_error(String s) {
        if (s == null) {
            new AdminMenu();
        } else if (s.equals("")) {
            JOptionPane.showMessageDialog(null, "請重新輸入", "error", 1);
            b_edit_input();
        }
        return s;
    }

    public static void addBook() {
        int count = 0;
        int x = 0;
        do {
            String b_name = JOptionPane.showInputDialog(null, "輸入書名");
            add_error(b_name);
            if (b_name != null & !b_name.equals("")) {
                String b_author = JOptionPane.showInputDialog(null, "輸入作者:");
                add_error(b_author);
                if (b_author != null & !b_author.equals("")) {
                    String b_press = JOptionPane.showInputDialog(null, "輸入出版社:");
                    add_error(b_press);
                    if (b_press != null & !b_press.equals("")) {
                        String b_type = JOptionPane.showInputDialog(null, "輸入類型:");
                        add_error(b_type);
                        if (b_type != null & !b_type.equals("")) {
                            books.add(new Book(b_name, b_author, b_press, b_type, false, 0));
                            for (int i = 0; i < books.size(); i++) {
                                if (books.get(i) != null) {
                                    x++;
                                }
                            }
                            News(books.get(x - 1));
                            count = JOptionPane.showConfirmDialog(null, "添加書籍完成，是否繼續添加?");
                        }
                    }
                }
            } else {
                break;
            }
        } while (count == 0);

    }

    public static void News(Book book) {
        for (int i = 0; i < news.length; i++) {
            if (news[i] == null) {
                news[i] = book.getBookname();
                break;
            }
        }
    }

    public static void news_print() {
        String output = "";
        for (int i = 0; i < news.length; i++) {
            if (news[i] != null) {
                output += news[i] + "\n";

            }
        }
        JOptionPane.showMessageDialog(null, "新書快報~~\n" + "書名 : " + output + "\n歡迎借閱!");
    }

    /////// 編輯 //////

    public static void deleteBook() {
        int count = 0;
        int x = 0;
        do {
            String want_find_name = JOptionPane.showInputDialog(null, "輸入要刪除的書名");
            if (want_find_name != null) {
                if (want_find_name.equals("")) {
                    JOptionPane.showMessageDialog(null, "請重新輸入!");
                    deleteBook();
                }
                x = searchBook(want_find_name);
                if (x == -1) {
                    JOptionPane.showMessageDialog(null, "沒有這本書!");
                    deleteBook();
                } else {
                    books.remove(x);
                    count = JOptionPane.showConfirmDialog(null, "刪除完成，是否繼續刪除?");
                }
            } else {
                break;
            }

        } while (count == 0);
    }

    /////// 編輯 //////
    public static int searchBook(String want_find_name) {
        int x = -1;
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getBookname().equals(want_find_name)) {
                x = i;
                return x;
            }

        }
        return x;
    }

    /////// 這個功能的作用?! (寫書庫有幾本書?) //////
    public int getBooksum() {
        return (books.size() + 1);
    }

    public static void print() {
        String all_book_list = "";
        for (int i = 0; i < books.size(); i++) {
            all_book_list += books.get(i).toString() + "\n";

        }
        JOptionPane.showMessageDialog(null, all_book_list);

    }

    public static void b_edit_input() {
        String want_find_name = JOptionPane.showInputDialog(null, "輸入要編輯的書名");
        if (want_find_name != null) {
            if (want_find_name.equals("")) {
                JOptionPane.showMessageDialog(null, "沒輸入!");
                edit();
            }
            int x = searchBook(want_find_name);
            if (x == -1) {
                JOptionPane.showMessageDialog(null, "沒有這本書!");
            } else {
                bedit(x);
            }
        }
    }

    public static void bedit(int x) {
        String[] op1 = { "書名", "作者", "出版社", "類別", "取消" };
        Book book = books.get(x);
        int option = JOptionPane.showOptionDialog(null, "選擇要編輯的部分", "編輯書庫", 1, 1, null, op1, null);
        switch (option) {
            case 0:
                String want_edit_name = JOptionPane.showInputDialog(null,
                        "書名: " + book.getBookname() + "要改成什麼?");
                edit_error(want_edit_name);
                book.setBookname(want_edit_name);
                break;
            case 1:
                String want_edit_author = JOptionPane.showInputDialog(null,
                        "作者: " + book.getAuthor() + "要改成什麼?");
                edit_error(want_edit_author);
                book.setAuthor(want_edit_author);
                break;
            case 2:
                String want_edit_press = JOptionPane.showInputDialog(null,
                        "出版社: " + book.getPress() + "要改成什麼?");
                edit_error(want_edit_press);
                book.setPress(want_edit_press);
                break;
            case 3:
                String want_edit_type = JOptionPane.showInputDialog(null,
                        "類別: " + book.getType() + "要改成什麼?");
                edit_error(want_edit_type);
                book.setType(want_edit_type);
                break;
            default:
                break;
        }
    }

    public static void edit() {
        int count = 0;
        b_edit_input();
        count = JOptionPane.showConfirmDialog(null, "是否繼續編輯?");
        if (count == 0) {
            edit();
        }
    }

    public static void Findbook() {
        String want_find_name = JOptionPane.showInputDialog(null, "輸入要查詢的書名");
        if (want_find_name != null) {
            if (want_find_name.equals("")) {
                JOptionPane.showMessageDialog(null, "請重新輸入!");
                Findbook();
            } else {
                int x = searchBook(want_find_name);
                if (x == -1) {
                    JOptionPane.showMessageDialog(null, "沒有這本書!");
                    Findbook();
                } else {
                    JOptionPane.showMessageDialog(null, books.get(x).toString());
                }
            }
        }
    }

    public static int borrow_fc(String bookname, Object r) // 改書籍狀態
    {
        int t = 1, m = 0;
        if (bookname != null) {
            for (Book i : books) {
                if (i.getBookname().equals(bookname)) //////// 成功借書 //////
                {
                    if (i.getborrowed() == false) {
                        t = 1;
                        i.setborrowed(true);
                        a = i.getBookname();
                        b = i.getAuthor();
                        c = i.getPress();
                        i.setcount(1);
                        return t;
                    } else if (i.getborrowed() == true) //////// 書被借走 //////
                    {
                        /// 有bug 若是一個人重複輸入自己書單內的書 則無法呈現效果
                        t = 0;
                        int choose = JOptionPane.showConfirmDialog(null, "有需要預約嗎?");
                        switch (choose) {
                            case 0:

                                for (int f = 0; f < reserve.length; f++) {
                                    if (reserve[f][0] == i) {
                                        JOptionPane.showMessageDialog(null, "已被預約，不能再被預約了!");
                                    }
                                }

                                for (int w = 0; w < reserve.length; w++) {
                                    if (reserve[w][0] == null) {
                                        reserve[w][0] = i;
                                        reserve[w][1] = ((Identity) r);
                                        reservenum++;
                                        break;
                                    }
                                }

                                break;
                            case 1:
                                JOptionPane.showMessageDialog(null, "好的!");
                                break;
                        }
                        t = 0;
                        m = 1;
                    }
                } else {
                    t = 0;
                }
            }
        } else {
            t = 0;
        }
        if (t == 0 && m != 1) {
            JOptionPane.showMessageDialog(null, "輸入錯誤");
        }
        return 0;

    }

    public static int return_fc(String bookname) {
        int t = 1;
        if (bookname != null) {
            for (Book i : books) {
                
                if (i.getBookname().equals(bookname)) {
                    t = 1;
                    a = i.getBookname();
                    b = i.getAuthor();
                    c = i.getPress();
                    i.setborrowed(false);
                    break;
                } else {
                    t = 0;
                }
            }
        } else {
            t = 0;
        }
        return 0;
    }

    public static String announce1[] = { "", "", "", "" };

    public static void announcement() {
        boolean a = true;

        String announce = JOptionPane.showInputDialog(null, "加入公告 : ");
        for (int i = 0; i < announce1.length; i++) {
            if (announce1[i].equals("")) {
                a = true;
                announce1[i] = announce;
                break;
            } else {
                a = false;
            }
        }
        if (a == false) {
            announce1[0] = announce1[1];
            announce1[1] = announce1[2];
            announce1[2] = announce1[3];
            announce1[3] = announce;
        }
        Arrays.sort(announce1);
        JOptionPane.showMessageDialog(null, "完成新增公告");
    }

    public static String speak1[] = { "", "", "", "" };

    public static void speak() {
        boolean a = true;
        String speak2 = "";
        speak2 = JOptionPane.showInputDialog(null, "想對管理員說的話 : ");
        if (speak2 != null) {
            if (speak2.equals("") != true) {
                for (int i = 0; i < speak1.length; i++) {
                    if (speak1[i].equals("")) {
                        a = true;
                        speak1[i] = speak2;
                        break;
                    } else {
                        a = false;
                    }
                }
                if (a == false) {
                    speak1[0] = speak1[1];
                    speak1[1] = speak1[2];
                    speak1[2] = speak1[3];
                    speak1[3] = speak2;
                }
                Arrays.sort(speak1);
                JOptionPane.showMessageDialog(null, "完成新增留言");
            } else {
                JOptionPane.showMessageDialog(null, "不可輸入空白");

            }
        }
    }

    public static void hot() // here
    {
        String bname1 = "";
        String bname2 = "";

        int b1 = 0;
        int b2 = 0;
        for (Book i : books) {
            if (i.getcount() > b2) {
                if (i.getcount() > b1) {
                    b1 = i.getcount();
                    bname1 = i.getBookname();
                } else {
                    b2 = i.getcount();
                    bname2 = i.getBookname();
                }
            }
        }
        JOptionPane.showMessageDialog(null,
                "借閱排行榜\n第一名：  借閱次數:" + b1 + " 次\n書名: " + bname1 + "\n第二名：  借閱次數:" + b2 + " 次\n書名: " + bname2);

    }

    public static ArrayList<Book> getBookList() {
        return books;
    }
}
