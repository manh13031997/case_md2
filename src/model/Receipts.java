package model;

import controller.ManagerLibrary;

import java.util.ArrayList;


public class Receipts {
    public LentBook lentBook = new LentBook();
    public double code;
    public static ArrayList<LentBook> list = ManagerLibrary.lentBooks;

    public double getCode() {
        double a = Math.random();
        return a * 1000000000 + 1;
    }

    public void setCode(double code) {
        this.code = code;
    }

    public String toString(){
        return "Mã phiếu thu: " + getCode() + "\n" +
                "ngay muon "  + lentBook.borrowedDate + "\n" +
                "ten khach hang" + lentBook.borrowerName + "\n" +
                "danh sach da muon" + "\n" +
                list.get(0).toString();
    }
}
