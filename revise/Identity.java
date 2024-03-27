package revise;

import javax.swing.JOptionPane;

public class Identity {

    private String name;
    private String account;
    private String code;
    private int quantity;
    private static String[] list = new String[5];
    private String m_record = "";
    private int m_fine;
    public static int i = 0;

    public Identity(String n, String a, String c, int q) {
        setname(n);
        setaccount(a);
        setcode(c);
        set_quantity(q);
        set_record("");
        set_fine(0);
    }

    public Identity(String name, String account, String code) {
        setname(name);
        setaccount(account);
        setcode(code);
    }

    public void setname(String n) {
        name = n;
    }

    public void setaccount(String a) {
        account = a;
    }

    public void setcode(String c) {
        code = c;
    }

    public String getname() {
        return name;
    }

    public String getaccount() {
        return account;
    }

    public String getcode() {
        return code;
    }

    public void set_quantity(int q) {
        quantity = q;
    }

    public void borrow_quantity(int q) // 借書時
    {
        quantity -= q;
    }

    public void return_quantity(int q) // 還書後
    {
        quantity += q;
    }

    public int get_quantity() {
        return quantity;
    }

    public static String[] get_list() {
        return list;
    }

    public void set_record(String in) {
        while (in != null) {
            m_record += in + "\n";
            in = null;
        }
    }

    public void get_record() {
        JOptionPane.showMessageDialog(null, m_record);
    }

    public void set_fine(long l) {
        m_fine += l;
    }

    public int get_fine() {
        return m_fine;
    }

}
