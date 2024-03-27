package Book_store;

public class Book {
    private String bookname;
    private String author;
    private String press;
    private String type;
    private boolean borrowed;
    private int count;

    public Book(String bookname, String author, String press, String type, boolean borrowed, int count) {
        setBookname(bookname);
        setAuthor(author);
        setPress(press);
        setType(type);
        setborrowed(borrowed);
        setcount(count);
    }

    public void setBookname(String b) {
        bookname = b;
    }

    public String getBookname() {
        return bookname;
    }

    public void setAuthor(String a) {
        author = a;
    }

    public String getAuthor() {
        return author;
    }

    public void setPress(String p) {
        press = p;
    }

    public String getPress() {
        return press;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setborrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public boolean getborrowed() {
        return borrowed;
    }

    public void setcount(int c) {
        count += c;
    }

    public int getcount() {
        return count;
    }

    public String toString() {
        String output = "";
        if (getborrowed() == true) {
            output += String.format("書名: %s作者: %s 出版社: %s 類別: %s 借閱狀態: 已借出\n", getBookname(), getAuthor(),
                    getPress(), getType());
        } else {
            output += String.format("書名: %s 作者: %s 出版社: %s 類別: %s 借閱狀態: 在館內\n", getBookname(), getAuthor(),
                    getPress(), getType());
        }

        return output;
    }
}
