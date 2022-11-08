import File.IOFile;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoanSlipManager implements Serializable {
    private ArrayList<LoanSlip> loanSlip;

    public LoanSlipManager() {
        loanSlip = ioFile.readFile("src/File/loanSlips.txt");
        listLoanBooks = ioFile.readFile("src/File/listLoanBook.txt");
    }

    private ArrayList<ListLoanBook> listLoanBooks;

    private ArrayList <ArrayList<ListLoanBook>> lists = new ArrayList<>();

    IOFile ioFile = new IOFile();

    public int count;

    public void addSlip(ArrayList<Book> books, Scanner scanner) {
        try {
            count = lists.size();
            System.out.println("Enter id of student: ");
            Long idStudent = Long.parseLong(scanner.nextLine());
            System.out.println("Enter name of student: ");
            String nameStudent = scanner.nextLine();
            creatListLoanBook(books,scanner);
            System.out.println("Enter the loan date:(yyyy-MM-dd)");
            LocalDate loanDate = LocalDate.parse(scanner.nextLine());
            System.out.println("The pay Date is: ");
            LocalDate payDate = loanDate.plusDays(5);
            System.out.println(payDate);
            LoanSlip bookLoanSlip = new LoanSlip(idStudent, nameStudent, lists.get(count), loanDate, payDate);
            if (loanSlip.size() > 0) {
                bookLoanSlip.setCode( loanSlip.get(loanSlip.size() - 1).getCode() + 1);
            }
            loanSlip.add(bookLoanSlip);
            ioFile.writeFile(loanSlip, "src/File/loanSlips.txt");
            System.out.println("Successfully added loan slip!");
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteLoanSlip(Scanner scanner){
        try {
            Book book;
            System.out.println("Enter the code of the loan slip: ");
            Long code = Long.parseLong(scanner.nextLine());
            LoanSlip loanSlipDelete;
            if ((loanSlipDelete = checkExist1(code)) != null) {
                loanSlip.remove(loanSlipDelete);
                ioFile.writeFile(loanSlip, "src/File/loanSlips.txt");
                System.out.println("Successful delete!");
            } else {
                System.err.println("Not exist loan slip have code");
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.err.println(e.getMessage());
        }
    }

    public void display() {
        if (loanSlip.size() == 0) {
        System.out.println("Do not have loan slip");
        }
        for (LoanSlip loanSlip : loanSlip) {
            System.out.printf("\n%-15s%-20s%-20s%s", "Student ID", "Student name", "Loan Date", "Pay Date");
            System.out.printf("\n%-15s%-20s%-20s%s", loanSlip.getIdStudent(), loanSlip.getStudentName(),
                    loanSlip.getLoanDate(), loanSlip.getPayDate() + "\n");
            System.out.println("List loan books: ");
            System.out.printf("%-30s%s", "Book", "Amount" + "\n");
            for (int i = 0; i < loanSlip.getListLoanBooks().size(); i++) {
                System.out.printf("%-32s%s", loanSlip.getListLoanBooks().get(i).getBook().getName(),
                        loanSlip.getListLoanBooks().get(i).getCount() + "\n");
            }
        }
        System.out.println();
    }

    public void displayLoanSlipById(Scanner scanner) {
        System.out.println("Enter the code of the loan slip: ");
        Long code = Long.parseLong(scanner.nextLine());
        LoanSlip loanSlipSearch;
        if ((loanSlipSearch = checkExist1(code)) != null) {
            System.out.println(loanSlipSearch);
        }
    }

    private LoanSlip checkExist1(Long code) {
        for (LoanSlip slip : loanSlip) {
            if (slip.getCode().equals(code)) {
                return slip;
            }
        }
        return null;
    }

    private void creatListLoanBook (ArrayList<Book> books, Scanner scanner) {
        Book book;
        ArrayList<ListLoanBook> listLoanBooks1 = new ArrayList<>();
        do {
            System.out.println("Enter book:");
            book = getBookByIndex(books, scanner);
            if (book != null) {
                System.out.println("Enter amount: ");
                int amount = Integer.parseInt(scanner.nextLine());
                ListLoanBook listLoanBook = new ListLoanBook(book, amount);
                listLoanBooks1.add(listLoanBook);
                book.setAmount(book.getAmount() - amount);
                BookManager.ioFile.writeFile(BookManager.books,"src/File/book.txt");
            }
        } while (book != null);
        lists.add(listLoanBooks1);
        ioFile.writeFile(lists, "src/File/lists.txt.txt");
    }

    private Book getBookByIndex(ArrayList<Book> books, Scanner scanner) {
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i).getName());
        }
        System.out.println("0. Not choice");
        int choice;
        try {
            do {
                System.out.println("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) {
                    return null;
                }
                if (choice > 0 && choice <= books.size()) {
                    return books.get(choice - 1);
                }
                System.err.println("Please re-enter your selection!");
            } while (choice < 0 || choice > books.size());
        } catch (NumberFormatException | InputMismatchException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
