import java.io.Serializable;

public class Book implements Serializable {
    private static int INDEX = 0;
    private Long id;
    private String name;
    private String author;
    private String category;
    private int amount;
    private String location;


    public Book(String name, String author, String category, int amount, String location) {
        this.id = Long.valueOf(++INDEX);
        this.name = name;
        this.author = author;
        this.category = category;
        this.amount = amount;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Book.Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", amount='" + amount + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public void display(){
        System.out.printf("%-10s%-20s%-20s%-20s%-15s%s", id, name, author, category, amount, location + "\n");
    }
}
