package controller;

import model.Book;
import model.LentBook;
import model.LibraryManagerName;
import model.PaidBooks;
import storage.BookFile;
import storage.LentBookFile;
import storage.PaidBookFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerLibrary {
    public static BookFile bookFile = new BookFile();
    public static LentBookFile lentBookFile = new LentBookFile();
    public static PaidBookFile paidBookFile = new PaidBookFile();
    public static ArrayList<Book> books = bookFile.readFile();
    public static ArrayList<LentBook> lentBooks = lentBookFile.readFile();
    public static ArrayList<PaidBooks> paidBooks = paidBookFile.readFile();
    public static ArrayList<LibraryManagerName> libraryManagerNames = new ArrayList<>();

    public static boolean login() {
        LibraryManagerName name1 = new LibraryManagerName("NguyenManh");
        LibraryManagerName name2 = new LibraryManagerName("Manh");
        libraryManagerNames.add(name1);
        libraryManagerNames.add(name2);
        Scanner scanner = new Scanner(System.in);
        System.out.println("|----------------------------------------------------------------------------------|");
        System.out.println("|-----                                        LOGIN                                               -----|");
        System.out.println("|----------------------------------------------------------------------------------|");
        System.out.println("Nhập tên người quản lý: ");
        String name = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < libraryManagerNames.size(); i++) {
            if (libraryManagerNames.get(i).getManagerName().equals(name)) {
                check = true;
            }
        }
        return check;
    }

    public static void showAllBook() {
        for (Book b : books
        ) {
            System.out.println(b.toString());
        }
    }

    public static void showAllLentBook() {
        for (LentBook l : lentBooks
        ) {
            System.out.println(l.toString());
        }
    }

    public static void showAllPaidBook() {
        for (PaidBooks p : paidBooks
        ) {
            System.out.println(p.toString());
        }
    }

    public static void addBook() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập id: ");
        int id = scanner.nextInt();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("nhập tên sách: ");
        String name = scanner1.nextLine();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("nhập tên tác giả: ");
        String author = scanner2.nextLine();

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("nhập thể loại sách: ");
        String category = scanner3.nextLine();

        Scanner scanner5 = new Scanner(System.in);
        System.out.println("nhập số lượng: ");
        int amount = scanner5.nextInt();

        Scanner scanner4 = new Scanner(System.in);
        System.out.println("nhập giá: ");
        double price = scanner4.nextDouble();

        Book book = new Book(id, name, author, category, amount, price);
        books.add(book);
        try {
            bookFile.writeFile(books);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void editBookByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập tên cuốn sách muốn chỉnh sửa: ");
        String name = scanner.nextLine();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name)) {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("nhập id: ");
                int id = scanner1.nextInt();

                Scanner scanner2 = new Scanner(System.in);
                System.out.println("nhập tên sách: ");
                String name1 = scanner2.nextLine();

                Scanner scanner3 = new Scanner(System.in);
                System.out.println("nhập tên tác giả: ");
                String author = scanner3.nextLine();

                Scanner scanner4 = new Scanner(System.in);
                System.out.println(" nhập thể loại sách: ");
                String category = scanner4.nextLine();

                Scanner scanner6 = new Scanner(System.in);
                System.out.println("Nhập số lượng: ");
                int amount = scanner6.nextInt();

                Scanner scanner5 = new Scanner(System.in);
                System.out.println("nhập giá: ");
                double price = scanner5.nextDouble();

                books.get(i).setId(id);
                books.get(i).setName(name1);
                books.get(i).setAuthor(author);
                books.get(i).setCategory(category);
                books.get(i).setAmount(amount);
                books.get(i).setPrice(price);
            } else {
                System.out.println("cuốn sách này không có trong thư viện!!!");
            }
        }
        try {
            bookFile.writeFile(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteBookByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập tên cuốn sách muốn xóa: ");
        String name = scanner.nextLine();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name)) {
                books.remove(books.get(i));
                try {
                    bookFile.writeFile(books);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("cuốn sách này không có trong thư viện!!!");
            }
        }
    }



    public static void lendBooks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập tên cuốn sách cho mượn: ");
        String lentBookName = scanner.nextLine();
        int check = -1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(lentBookName)) {
                check = i;
                break;
            }
        }
        if (check != -1){
            System.out.println("nhập ngày cho mượn: ");
            Scanner scanner1 = new Scanner(System.in);
            int day = scanner1.nextInt();

            System.out.println("nhập tháng: ");
            Scanner scanner2 = new Scanner(System.in);
            int month = scanner2.nextInt();

            System.out.println("nhập năm: ");
            Scanner scanner3 = new Scanner(System.in);
            int year = scanner3.nextInt();

            System.out.println("nhập tên người mượn: ");
            Scanner scanner4 = new Scanner(System.in);
            String borrowerName = scanner4.nextLine();

            Scanner scanner5 = new Scanner(System.in);
            System.out.println("Nhập số lượng: ");
            int amount = scanner5.nextInt();

            LocalDate date = LocalDate.of(year, month, day);
            LentBook lentBook = new LentBook(books.get(check).getId(), books.get(check).getName(), books.get(check).getAuthor(),
                    books.get(check).getCategory(), amount, books.get(check).getPrice(), date, borrowerName);
            lentBooks.add(lentBook);
            int difference = 0;
            if (amount < books.get(check).getAmount()) {
                difference = books.get(check).getAmount() - amount;
                books.get(check).setId(books.get(check).getId());
                books.get(check).setName(books.get(check).getName());
                books.get(check).setAuthor(books.get(check).getAuthor());
                books.get(check).setCategory(books.get(check).getCategory());
                books.get(check).setAmount(difference);
                books.get(check).setPrice(books.get(check).getPrice());
            } else if (amount == books.get(check).getAmount()){
                books.remove(books.get(check));
            } else {
                System.out.println("số sách trong thư viện không đủ cho yêu cầu này");
            }
            try {
                lentBookFile.writeFile(lentBooks);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bookFile.writeFile(books);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("cuốn sách bạn tìm không có trong thư viện");
        }
    }

    public static void giveBookBack() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập tên cuốn sách khách trả cho thư viện: ");
        String name = scanner.nextLine();
        int check = -1;
        for (int i = 0; i < lentBooks.size(); i++) {
            if (lentBooks.get(i).getName().equals(name)) {
                check = i;
                break;
            }
        }
        if (check != -1){
            System.out.println("nhập ngày trả: ");
            Scanner scanner1 = new Scanner(System.in);
            int day = scanner1.nextInt();

            System.out.println("nhập tháng: ");
            Scanner scanner2 = new Scanner(System.in);
            int month = scanner2.nextInt();

            System.out.println("nhập năm: ");
            Scanner scanner3 = new Scanner(System.in);
            int year = scanner3.nextInt();

            System.out.println("nhập tên người trả sách: ");
            Scanner scanner4 = new Scanner(System.in);
            String payerName = scanner4.nextLine();

            Scanner scanner5 = new Scanner(System.in);
            System.out.println("Nhập số lượng: ");
            int amount = scanner5.nextInt();

            LocalDate date = LocalDate.of(year, month, day);
            if (amount == lentBooks.get(check).getAmount()) {
                PaidBooks paidBook = new PaidBooks(lentBooks.get(check).getId(), lentBooks.get(check).getName(),
                        lentBooks.get(check).getAuthor(), amount, lentBooks.get(check).getCategory(), lentBooks.get(check).getPrice(), date, payerName);
                paidBooks.add(paidBook);
                lentBooks.remove(lentBooks.get(check));
                int index = -1;
                for (int j = 0; j < books.size(); j++) {
                    if (books.get(j).getName().equals(name)) {
                        index = j;
                        break;
                    }
                }
                if (index != -1){
                    books.get(index).setAmount(books.get(index).getAmount() + amount);
                }  else {
                    Book book = new Book(lentBooks.get(check).getId(), lentBooks.get(check).getName(), lentBooks.get(check).getAuthor(),
                            lentBooks.get(check).getCategory(), amount, lentBooks.get(check).getPrice());
                    lentBooks.remove(lentBooks.get(check));
                    books.add(book);
                }
            } else if (amount < lentBooks.get(check).getAmount()) {
                PaidBooks paidBook = new PaidBooks(lentBooks.get(check).getId(), lentBooks.get(check).getName(),
                        lentBooks.get(check).getAuthor(), amount, lentBooks.get(check).getCategory(),
                        lentBooks.get(check).getPrice(), date, payerName);
                paidBooks.add(paidBook);
                lentBooks.get(check).setAmount(lentBooks.get(check).getAmount() - amount);
                int index = -1;
                for (int j = 0; j < books.size(); j++) {
                    if (books.get(j).getName().equals(name)) {
                        index = j;
                        break;
                    }
                }
                if (index != -1){
                    books.get(index).setAmount(books.get(index).getAmount() + amount);
                } else {
                    Book book = new Book(lentBooks.get(check).getId(), lentBooks.get(check).getName(), lentBooks.get(check).getAuthor(),
                            lentBooks.get(check).getCategory(), amount, lentBooks.get(check).getPrice());
                    books.add(book);
                }
            }

            try {
                paidBookFile.writeFile(paidBooks);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                lentBookFile.writeFile(lentBooks);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bookFile.writeFile(books);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void searchBookByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập tên cuốn sách bạn muốn tìm: ");
        String bookName = scanner.nextLine();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(bookName)) {
                System.out.println(books.get(i).toString());
            } else {
                for (int j = 0; j < lentBooks.size(); j++) {
                    if (lentBooks.get(i).getName().equals(bookName)) {
                        System.out.println("Cuốn sách này đã có người mượn. Vui lòng kiểm tra trong danh sách mượn");
                    } else {
                        System.out.println("cuốn sách bạn tìm không có trong thư viện!!!");
                    }
                }
            }
        }
    }

        public static void removeListPaidBook () {
            paidBooks.removeAll(paidBooks);
            try {
                paidBookFile.writeFile(paidBooks);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
