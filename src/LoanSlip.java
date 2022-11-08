import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class LoanSlip implements Serializable {
    private static int INDEX = 0;
    private Long code;
    private Long idStudent;
    private String studentName;
    private ArrayList<ListLoanBook> listLoanBooks;
    private LocalDate loanDate;
    private LocalDate payDate;

    public LoanSlip() {
    }

    public LoanSlip(Long idStudent, String studentName, ArrayList<ListLoanBook> listLoanBooks, LocalDate loanDate, LocalDate payDate) {
        this.code = Long.valueOf(++INDEX);
        this.idStudent = idStudent;
        this.studentName = studentName;
        this.listLoanBooks = listLoanBooks;
        this.loanDate = loanDate;
        this.payDate = payDate;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }


    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public ArrayList<ListLoanBook> getListLoanBooks() {
        return listLoanBooks;
    }

    public void setBookLoanSlips(ArrayList<LoanSlip> bookLoanSlips) {
        this.listLoanBooks = listLoanBooks;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    @Override
    public String toString() {
        return "LoanSlip{" +
                "code=" + code +
                ", idStudent=" + idStudent +
                ", studentName='" + studentName + '\'' +
                ", listLoanBooks=" + listLoanBooks +
                ", loanDate=" + loanDate +
                ", payDate=" + payDate +
                '}';
    }
}
