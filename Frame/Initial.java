package Frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Book_store.BookList;
import Visit.Admin;
import Visit.Guest;
import revise.Staff;
import revise.Student;
import revise.Teacher;

public class Initial implements ActionListener {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    public static Object sf_log_Comfirm;
    JFrame f;
    Container cp;
    Admin a = new Admin();

    public static void main(String argv[]) {
        new Initial();
        BookList.ini();

    }

    public Initial() {
        // JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        f = new JFrame("圖書館借閱系統");
        f.setBounds(500, 100, 512, 512);
        f.setVisible(true);
        ImageIcon i1 = new ImageIcon("picture/read.png");
        f.setIconImage(i1.getImage());
        f.setResizable(false);
        ImageIcon i2 = new ImageIcon("picture/lib.jpg");
        JLabel picture = new JLabel(i2);
        f.add(picture, BorderLayout.CENTER);

        JMenuBar menubar = new JMenuBar();

        JMenu menu1 = new JMenu("會員註冊");
        JMenu menu2 = new JMenu("登入");
        JMenu menu3 = new JMenu("最新消息");
        JMenu menu4 = new JMenu("圖書資訊");
        JMenu menu5 = new JMenu("其他功能");

        JMenuItem it1 = new JMenuItem("學生");
        JMenuItem it2 = new JMenuItem("教師");
        JMenuItem it3 = new JMenuItem("職員");
        menu1.add(it1);
        menu1.addSeparator();
        menu1.add(it2);
        menu1.addSeparator();
        menu1.add(it3);

        JMenuItem it4 = new JMenuItem("管理員");
        JMenu subm = new JMenu("會員");
        JMenuItem it5 = new JMenuItem("學生");
        JMenuItem it55 = new JMenuItem("教師");
        JMenuItem it555 = new JMenuItem("職員");
        subm.add(it5);
        subm.addSeparator();
        subm.add(it55);
        subm.addSeparator();
        subm.add(it555);
        menu2.add(it4);
        menu2.addSeparator();
        menu2.add(subm);

        JMenuItem it6 = new JMenuItem("最新公告");
        JMenuItem it12 = new JMenuItem("新書快訊");
        JMenuItem it7 = new JMenuItem("講座報名");
        menu3.add(it6);
        menu3.addSeparator();
        menu3.add(it7);
        menu3.addSeparator();
        menu3.add(it12);

        JMenuItem it8 = new JMenuItem("館藏書籍");
        JMenuItem it13 = new JMenuItem("推薦書單");
        JMenuItem it9 = new JMenuItem("熱門書籍");
        menu4.add(it8);
        menu4.addSeparator();
        menu4.add(it13);
        menu4.addSeparator();
        menu4.add(it9);

        JMenuItem it10 = new JMenuItem("書籍查詢");
        JMenuItem it11 = new JMenuItem("留言板");
        menu5.add(it10);
        menu5.addSeparator();
        menu5.add(it11);

        menubar.add(menu1);
        menubar.add(menu2);
        menubar.add(menu3);
        menubar.add(menu4);
        menubar.add(menu5);

        f.setJMenuBar(menubar); // 新增一個選單條

        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(f, // 或用 (Component)e.getSource() 亦可
                        "確定要結束程式嗎?",
                        "確認訊息",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        it1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                st_reg_Comfirm();
            }
        });

        it2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                te_reg_Comfirm();
            }
        });

        it3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sf_reg_Comfirm();
            }
        });

        it4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a.a_login();

            }
        });

        it5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                st_log_Comfirm();
            }
        });

        it55.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                te_log_Comfirm();
            }
        });

        it555.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sf_log_Comfirm();
            }
        });

        it6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Guest.look_announce();
            }
        });

        it7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Guest.lecture();
            }
        });

        it8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new JTable1();
            }
        });

        it9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookList.hot();
            }
        });

        it10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookList.Findbook();
            }
        });

        it11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookList.speak();
            }
        });

        it12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookList.news_print();
            }
        });

        it13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Guest.look_recommend();
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void st_reg_Comfirm() {
        int result = JOptionPane.showConfirmDialog(null,
                "請問要註冊為學生嗎?",
                "確認訊息",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            Student.register();
        }
    }

    public static void sf_reg_Comfirm() {
        int result = JOptionPane.showConfirmDialog(null,
                "請問要註冊為職員嗎?",
                "確認訊息",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            Staff.register();
        }
    }

    public static void te_reg_Comfirm() {
        int result = JOptionPane.showConfirmDialog(null,
                "請問要註冊為教師嗎?",
                "確認訊息",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            Teacher.register();
        }
    }

    public static void st_log_Comfirm() {
        int result = JOptionPane.showConfirmDialog(null,
                "請問要登入學生嗎?",
                "確認訊息",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            Student.login();
        }
    }

    public static void sf_log_Comfirm() {
        int result = JOptionPane.showConfirmDialog(null,
                "請問要登入職員嗎?",
                "確認訊息",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            Staff.login();
        }
    }

    public static void te_log_Comfirm() {
        int result = JOptionPane.showConfirmDialog(null,
                "請問要登入教師嗎?",
                "確認訊息",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            Teacher.login();
        }
    }

    java.net.URL resourse = classLoader.getResource("picture");
    ImageIcon i1 = new ImageIcon(resourse);
    ImageIcon i2 = new ImageIcon(resourse);
}
