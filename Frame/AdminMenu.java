package Frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.plaf.FontUIResource;

import Book_store.BookList;
import Visit.Admin;

public class AdminMenu {
    JFrame f;
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    public AdminMenu() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        f = new JFrame("管理員系統");
        f.setBounds(500, 100, 450, 450);
        f.setVisible(true);
        f.setResizable(false);
        ImageIcon i3 = new ImageIcon("picture/manager.png");
        f.setIconImage(i3.getImage());
        Container cp = f.getContentPane();
        cp.setLayout(null);

        setUIFont(new FontUIResource("微軟正黑體", Font.ITALIC, 15));

        JLabel ja1 = new JLabel();
        ja1.setText("管理員您好 !");
        ja1.setBounds(100, 20, 200, 20);

        cp.add(ja1);

        JLabel ja2 = new JLabel();
        ja2.setText("新增書籍");
        ja2.setBounds(40, 80, 65, 20);
        cp.add(ja2);

        ImageIcon ic1 = new ImageIcon("picture/book.png");
        JButton b1 = new JButton(ic1);
        b1.setBounds(130, 70, 50, 50);
        cp.add(b1);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addbook_Comfirm();
            }
        });

        JLabel ja3 = new JLabel();
        ja3.setText("刪除書籍");
        ja3.setBounds(40, 150, 65, 20);
        cp.add(ja3);

        ImageIcon ic2 = new ImageIcon("picture/book1.png");
        JButton b2 = new JButton(ic2);
        b2.setBounds(130, 140, 50, 50);
        cp.add(b2);

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookList.deleteBook();
            }
        });

        JLabel ja4 = new JLabel();
        ja4.setText("修改書籍");
        ja4.setBounds(40, 220, 65, 20);
        cp.add(ja4);

        ImageIcon ic3 = new ImageIcon("picture/book2.png");
        JButton b3 = new JButton(ic3);
        b3.setBounds(130, 210, 50, 50);
        cp.add(b3);

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookList.edit();
            }
        });

        JLabel ja5 = new JLabel();
        ja5.setText("新增公告");
        ja5.setBounds(40, 290, 65, 20);
        cp.add(ja5);

        ImageIcon ic4 = new ImageIcon("picture/billboard.png");
        JButton b4 = new JButton(ic4);
        b4.setBounds(130, 280, 50, 50);
        cp.add(b4);

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookList.announcement();
            }
        });

        JLabel ja6 = new JLabel();
        ja6.setText("查看留言");
        ja6.setBounds(240, 80, 65, 20);
        cp.add(ja6);

        ImageIcon ic5 = new ImageIcon("picture/messages.png");
        JButton b5 = new JButton(ic5);
        b5.setBounds(330, 70, 50, 50);
        cp.add(b5);

        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.look_speak();
            }
        });

        JLabel ja7 = new JLabel();
        ja7.setText("所有書籍");
        ja7.setBounds(240, 150, 65, 20);
        cp.add(ja7);

        ImageIcon ic6 = new ImageIcon("picture/books.png");
        JButton b6 = new JButton(ic6);
        b6.setBounds(330, 140, 50, 50);
        cp.add(b6);

        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookList.print();
            }
        });

        JLabel ja8 = new JLabel();
        ja8.setText("講座名單");
        ja8.setBounds(240, 220, 65, 20);
        cp.add(ja8);

        ImageIcon ic7 = new ImageIcon("picture/customer.png");
        JButton b7 = new JButton(ic7);
        b7.setBounds(330, 210, 50, 50);
        cp.add(b7);

        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.l_look();
            }
        });

        JLabel ja9 = new JLabel();
        ja9.setText("推薦書單");
        ja9.setBounds(240, 290, 65, 20);
        cp.add(ja9);

        ImageIcon ic8 = new ImageIcon("picture/quality.png");
        JButton b8 = new JButton(ic8);
        b8.setBounds(330, 280, 50, 50);
        cp.add(b8);

        b8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.recommend();
            }
        });

    }

    public static void addbook_Comfirm() {
        int result = JOptionPane.showConfirmDialog(null,
                "請問要新增書籍嗎?",
                "確認訊息",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            BookList.addBook();
        }
    }

    public void setUIFont(FontUIResource fui) {
        Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value != null && value instanceof FontUIResource) {
                UIManager.put(key, fui);
            }
        }
    }

    java.net.URL resourse1 = classLoader.getResource("picture");
    ImageIcon i3 = new ImageIcon(resourse1);
    ImageIcon ic1 = new ImageIcon(resourse1);
    ImageIcon ic2 = new ImageIcon(resourse1);
    ImageIcon ic3 = new ImageIcon(resourse1);
    ImageIcon ic4 = new ImageIcon(resourse1);
    ImageIcon ic5 = new ImageIcon(resourse1);
    ImageIcon ic6 = new ImageIcon(resourse1);
    ImageIcon ic7 = new ImageIcon(resourse1);
    ImageIcon ic8 = new ImageIcon(resourse1);
}
