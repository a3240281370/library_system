package Frame;

import java.awt.*;
import java.awt.event.*;
//import java.lang.reflect.Member;

import javax.swing.*;

import java.util.*;
import javax.swing.plaf.FontUIResource;

import Book_store.BookList;
import revise.Member;
import revise.Student;

public class StudentMenu {
    JFrame f;
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    public StudentMenu(Student st) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        f = new JFrame("學生系統");
        f.setBounds(500, 100, 450, 380);
        f.setVisible(true);
        f.setResizable(false);
        ImageIcon i3 = new ImageIcon("picture/students.png");
        f.setIconImage(i3.getImage());
        Container cp = f.getContentPane();
        cp.setLayout(null);

        setUIFont(new FontUIResource("微軟正黑體", Font.ITALIC, 15));

        JLabel ja1 = new JLabel();
        ja1.setText("同學你好 ~");
        ja1.setBounds(100, 20, 200, 20);

        cp.add(ja1);

        JLabel ja2 = new JLabel();
        ja2.setText("借閱書籍");
        ja2.setBounds(40, 80, 65, 20);
        cp.add(ja2);

        ImageIcon ic1 = new ImageIcon("picture/bb.png");
        JButton b1 = new JButton(ic1);
        b1.setBounds(130, 70, 50, 50);
        cp.add(b1);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Member.M_borrrowbook(st);
            }
        });

        JLabel ja3 = new JLabel();
        ja3.setText("歸還書籍");
        ja3.setBounds(40, 150, 65, 20);
        cp.add(ja3);

        ImageIcon ic2 = new ImageIcon("picture/return.png");
        JButton b2 = new JButton(ic2);
        b2.setBounds(130, 140, 50, 50);
        cp.add(b2);

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Member.M_returnbook(st);
            }
        });

        JLabel ja4 = new JLabel();
        ja4.setText("查詢個資");
        ja4.setBounds(40, 220, 65, 20);
        cp.add(ja4);

        ImageIcon ic3 = new ImageIcon("picture/search.png");
        JButton b3 = new JButton(ic3);
        b3.setBounds(130, 210, 50, 50);
        cp.add(b3);

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student.identity_find(st);
            }
        });

        JLabel ja6 = new JLabel();
        ja6.setText("修改個資");
        ja6.setBounds(240, 80, 65, 20);
        cp.add(ja6);

        ImageIcon ic5 = new ImageIcon("picture/resume.png");
        JButton b5 = new JButton(ic5);
        b5.setBounds(330, 70, 50, 50);
        cp.add(b5);

        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student.identity_revise(st);
            }
        });

        JLabel ja7 = new JLabel();
        ja7.setText("借閱紀錄");
        ja7.setBounds(240, 150, 65, 20);
        cp.add(ja7);

        ImageIcon ic6 = new ImageIcon("picture/notes.png");
        JButton b6 = new JButton(ic6);
        b6.setBounds(330, 140, 50, 50);
        cp.add(b6);

        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                st.get_record();
            }
        });

        JLabel ja8 = new JLabel();
        ja8.setText("查詢書籍");
        ja8.setBounds(240, 220, 65, 20);
        cp.add(ja8);

        ImageIcon ic7 = new ImageIcon("picture/sb.png");
        JButton b7 = new JButton(ic7);
        b7.setBounds(330, 210, 50, 50);
        cp.add(b7);

        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookList.Findbook();
            }
        });

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

    java.net.URL resourse3 = classLoader.getResource("picture");
    ImageIcon i3 = new ImageIcon(resourse3);
    ImageIcon ic1 = new ImageIcon(resourse3);
    ImageIcon ic2 = new ImageIcon(resourse3);
    ImageIcon ic3 = new ImageIcon(resourse3);
    ImageIcon ic4 = new ImageIcon(resourse3);
    ImageIcon ic5 = new ImageIcon(resourse3);
    ImageIcon ic6 = new ImageIcon(resourse3);
    ImageIcon ic7 = new ImageIcon(resourse3);

}
