import java.util.ArrayList;
import java.util.Scanner;

public class ManagerSystem {
    private final BookManager bookManager;
    private final LoanSlipManager loanSlipManager;
    private final Scanner scanner;

    public ManagerSystem() {
        this.bookManager = new BookManager();
        this.loanSlipManager = new LoanSlipManager();
        this.scanner = new Scanner(System.in);
    }

    public void menuManagerSystem(){
        do {
            System.out.println("MENU LIBRARY MANAGEMENT");
            System.out.println("1. Book Manager");
            System.out.println("2. Loan Slip Manager");
            System.out.println("0. Exit");
            System.out.println("Enter the choice: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice < 0 || choice > 2) {
                    throw new RuntimeException();
                }
                switch (choice) {
                    case 1:
                        menuBook();
                        break;
                    case 2:
                        menuLoanSlip();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                }
            } catch (Exception e) {
                System.err.println("Please re-enter your selection!");
            }
        } while (true);
    }

    public void menuBook (){
        do {
            System.out.println("MENU BOOK");
            System.out.println("1. Add book");
            System.out.println("2. Update book by id");
            System.out.println("3. Delete book by id");
            System.out.println("4. Display all product");
            System.out.println("5. Display book by category");
            System.out.println("6. Display all book by search name");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) {
                    break;
                }
                if (choice < 0 || choice > 6) {
                    throw new RuntimeException();
                }
                switch (choice) {
                    case 1:
                        bookManager.addBook(scanner);
                        break;
                    case 2:
                        bookManager.updateBookById(scanner);
                        break;
                    case 3:
                        bookManager.deleteBookById(scanner);
                        break;
                    case 4:
                        bookManager.display();
                        break;
                    case 5:
                        bookManager.displayBookByCategory(scanner);
                        break;
                    case 6:
                        bookManager.displayBookByNameContaining(scanner);
                        break;
                }
            } catch (Exception e) {
                System.err.println("Please re-enter your selection!");
            }
        } while (true);
    }

    public void menuLoanSlip() {
        do {
            System.out.println("MENU LOAN SLIP");
            System.out.println("1. Add loan slip");
            System.out.println("2. Delete loan slip by id");
            System.out.println("3. Display all loan slip");
            System.out.println("4. Display loan slip by id");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) {
                    break;
                }
                if (choice < 0 || choice > 4) {
                    throw new RuntimeException();
                }
                switch (choice) {
                    case 1:
                        loanSlipManager.addSlip(BookManager.books,scanner);
                        break;
                    case 2:
                        loanSlipManager.deleteLoanSlip(scanner);
                        break;
                    case 3:
                        loanSlipManager.display();
                        break;
                    case 4:
                        loanSlipManager.displayLoanSlipById(scanner);
                        break;
                }
            } catch (Exception e) {
                System.err.println("Please re-enter your selection!");
            }
        } while (true);
    }
}
