package model;

import java.time.LocalDate;

public class LentBook extends Book {
    public LocalDate borrowedDate;
    public String borrowerName;

    public LentBook() {
    }

    public LentBook(int id, String name, String author, String category, int amount, double price, LocalDate borrowedDate, String borrowerName) {
        super(id, name, author, category, amount, price);
        this.borrowedDate = borrowedDate;
        this.borrowerName = borrowerName;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    @Override
    public String toString() {
        return "Bạn " + borrowerName + " đã mượn cuốn sách có id là: " + id +
                ", tên: " + name +
                ", tác giả: " + author +
                ", thể loại: " + category +
                ", số lượng: " + amount +
                ", giá: " + price +
                ", ngày mượn: " + borrowedDate;
    }
}
