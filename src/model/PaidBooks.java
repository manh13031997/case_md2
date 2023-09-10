package model;

import java.time.LocalDate;

public class PaidBooks extends Book {
    public LocalDate payDay;
    public String payerName;

    public PaidBooks() {
    }

    public PaidBooks(int id, String name, String author, int amount, String category, double price, LocalDate payDay, String payerName) {
        super(id, name, author, category, amount, price);
        this.payDay = payDay;
        this.payerName = payerName;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public LocalDate getPayDay() {
        return payDay;
    }

    public void setPayDay(LocalDate payDay) {
        this.payDay = payDay;
    }

    @Override
    public String toString() {
        return "bạn " + payerName +  " đã trả " +
                "cuốn sách có id là: " + id +
                ", tên: " + name +
                ", tác giả: " + author +
                ", thể loại: " + category +
                ", số lượng " + amount +
                ", giá: " + price +
                ", ngày trả sách: " + payDay ;
    }
}
