import java.io.Serializable;

public class ListLoanBook implements Serializable {
    private Book book;
    private int count;

    public ListLoanBook() {
    }

    public ListLoanBook(Book book, int count) {
        this.book = book;
        this.count = count;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
