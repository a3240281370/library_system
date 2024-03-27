package Frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.FontUIResource;

import Book_store.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class JTable1 {
  JFrame f;

  public static void main(String argv[]) {

    BookList.ini();
    new JTable1();

  }

  public JTable1() {

    ArrayList<Book> books = BookList.getBookList();
    ;

    // Setup JFrame
    JFrame.setDefaultLookAndFeelDecorated(true);
    JDialog.setDefaultLookAndFeelDecorated(true);
    f = new JFrame("JTable Test");
    f.setSize(600, 600);
    f.setLocationRelativeTo(null);
    Container cp = f.getContentPane();

    setUIFont(new FontUIResource("微軟正黑體", Font.ITALIC, 15));

    // Build Elements
    String data[][] = new String[books.size()][5];

    for (int i = 0; i < books.size(); i++) {

      data[i][0] = books.get(i).getBookname();
      data[i][1] = books.get(i).getAuthor();
      data[i][2] = books.get(i).getPress();
      data[i][3] = books.get(i).getType();
      data[i][4] = String.valueOf(books.get(i).getborrowed());
    }

    String[] columns = { "書名", "作者", "出版社", "類型", "借閱狀態" };
    JTable jt = new JTable(data, columns);
    jt.setPreferredScrollableViewportSize(new Dimension(400, 300));
    cp.add(new JScrollPane(jt), BorderLayout.CENTER);
    cp.add(jt, BorderLayout.CENTER);
    f.setVisible(true);

    // Close JFrame
    f.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    f.addWindowListener(new WindowHandler(f));

  }

  private void setUIFont(FontUIResource fui) {
    Enumeration keys = UIManager.getDefaults().keys();
    while (keys.hasMoreElements()) {
      Object key = keys.nextElement();
      Object value = UIManager.get(key);
      if (value != null && value instanceof FontUIResource) {
        UIManager.put(key, fui);
      }
    }
  }
}

class WindowHandler extends WindowAdapter {
  JFrame f;

  public WindowHandler(JFrame f) {
    this.f = f;
  }

  public void windowClosing(WindowEvent e) {
    int result = JOptionPane.showConfirmDialog(f,
        "確定要結束程式嗎?",
        "確認訊息",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.WARNING_MESSAGE);
    if (result == JOptionPane.YES_OPTION) {
      System.exit(0);
    }
  }

}