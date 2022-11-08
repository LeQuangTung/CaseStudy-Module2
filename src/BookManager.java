import File.IOFile;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class BookManager {
    public static ArrayList<Book> books;

    public BookManager() {
        books = ioFile.readFile("src/File/book.txt");
    }

    public static IOFile ioFile = new IOFile();

    public void addBook(Scanner scanner) {
        try {
            System.out.println("Enter name: ");
            String name = scanner.nextLine();
            for (int i = 0; i < books.size(); i++) {
                if (!books.get(i).getName().equals(name)) {
                    System.out.println("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.println("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.println("Enter amount: ");
                    int amount = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter location: ");
                    String location = scanner.nextLine();
                    Book book = new Book(name, author, category, amount, location);
                    if (books.size() > 0) {
                        book.setId( books.get(books.size()-1).getId()+1);
                    }
                    books.add(book);
                } else {
                    System.out.println("Enter amount: ");
                    int newAmount = Integer.parseInt(scanner.nextLine());
                    books.get(i).setAmount(books.get(i).getAmount() + newAmount);
                }
                System.out.println("Successful added book!");
                break;
            }
            ioFile.writeFile(books, "src/File/book.txt");
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateBookById(Scanner scanner) {
        try {
            System.out.println("Enter the id of the book you want to update:");
            Long id = Long.parseLong(scanner.nextLine());
            Book bookUpdate;
            if ((bookUpdate = checkExist(id)) != null){
                System.out.println("Enter new name: ");
                String name = scanner.nextLine();
                if (!name.equals("")) {
                    bookUpdate.setName(name);
                }
                System.out.println("Enter new author: ");
                String author = scanner.nextLine();
                if (!author.equals("")) {
                    bookUpdate.setAuthor(author);
                }
                System.out.println("Enter new category: ");
                String category = scanner.nextLine();
                if (!category.equals("")) {
                    bookUpdate.setCategory(category);
                }
                System.out.println("Enter new amount: ");
                String amount = scanner.nextLine();
                if (!amount.equals("")){
                    bookUpdate.setAmount(Integer.parseInt(amount));
                }
                System.out.println("Enter new location: ");
                String location = scanner.nextLine();
                if (!location.equals("")) {
                    bookUpdate.setLocation(location);
                }
                System.out.println("Successful update!");
                ioFile.writeFile(books, "src/File/book.txt");
            } else {
                System.err.println("Not exist book have id");
            }

        } catch (NumberFormatException | InputMismatchException e) {
            System.err.println(e.getMessage());
        }
    }


    public void deleteBookById(Scanner scanner) {
        try {
            System.out.println("Enter the id of the book you want to delete: ");
            Long id = Long.parseLong(scanner.nextLine());
            Book bookDelete;
            if ((bookDelete = checkExist(id)) != null) {
                books.remove(bookDelete);
                ioFile.writeFile(books, "src/File/book.txt");
                System.out.println("Successful delete!");
            } else {
                System.err.println("Not exist product have id!");
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.err.println(e.getMessage());
        }
    }

    public void display() {
        System.out.printf("%-10s%-20s%-20s%-20s%-15s%s", "ID", "Name", "Author", "Category", "Amount", "Location\n");
        for (Book book : books) {
            book.display();
        }
    }

    public void displayBookByCategory(Scanner scanner) {
        System.out.println("Enter the category: ");
        String categorySearch = scanner.nextLine();
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(categorySearch)) {
                System.out.println(book);
            } else {
                System.out.println("Don't have!");
            }
        }
    }

    public void displayBookByNameContaining(Scanner scanner) {
        System.out.println("Enter character you want search: ");
        String search = scanner.nextLine();
        System.out.println("List book have name contains" + search + ": ");
        for (Book book : books) {
            if (book.getName().toLowerCase().contains(search.toLowerCase())) {
                System.out.println(book);
            }
        }
    }

    private Book checkExist(Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }
}
