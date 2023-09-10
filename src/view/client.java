package view;

import controller.ManagerLibrary;

import java.util.Scanner;

public class client {

    public static void main(String[] args) {
        while (ManagerLibrary.login() == true) {
            int choose = -1;
            while (choose != 0) {
                System.out.println("                                  |----------------------------------------------------------------|");
                System.out.println("                                  |---------            SÁCH TRONG THƯ VIỆN           --------|");
                System.out.println("                                  |----------------------------------------------------------------|");
                System.out.println("<--------------------------------------------------------------------------------------------------------------->");
                ManagerLibrary.showAllBook();
                System.out.println("<--------------------------------------------------------------------------------------------------------------->");
                System.out.println("Menu");
                Scanner scanner = new Scanner(System.in);
                System.out.println("1. thêm sách mới");
                System.out.println("2. sửa sách trong thư viện");
                System.out.println("3.xóa sách trong thư viện");
                System.out.println("4. tìm kiếm sách");
                System.out.println("5. cho mượn sách");
                System.out.println("6. trả sách");
                System.out.println("7. sách đã cho mượn");
                System.out.println("8. sách đã trả");
                System.out.println("nhập lựa chọn của bạn: ");
                int choose1 = scanner.nextInt();
                switch (choose1) {
                    case 1:
                        ManagerLibrary.addBook();
                        break;
                    case 2:
                        ManagerLibrary.editBookByName();
                        break;
                    case 3:
                        ManagerLibrary.deleteBookByName();
                        break;
                    case 4:
                        ManagerLibrary.searchBookByName();
                        break;
                    case 5:
                        ManagerLibrary.lendBooks();
                        break;
                    case 6:
                        ManagerLibrary.giveBookBack();
                        break;
                    case 7:
                        System.out.println("                                 |----------------------------------------------------------------|");
                        System.out.println("                                 |---------danh sách những cuốn sách đã cho mượn--------|");
                        System.out.println("                                 |----------------------------------------------------------------|");
                        System.out.println("<---------------------------------------------------------------------------------------------------------------->");
                        boolean result = ManagerLibrary.lentBooks.isEmpty();
                        if (result == true)
                            System.out.println("danh sách rỗng!!!");
                        else
                            ManagerLibrary.showAllLentBook();
                        System.out.println("<---------------------------------------------------------------------------------------------------------------->");
                        break;
                    case 8:
                        System.out.println("1. hiển thị danh sách");
                        System.out.println("2. xóa danh sách đã trả");
                        Scanner scanner1 = new Scanner(System.in);
                        int choose8 = scanner1.nextInt();
                        switch (choose8){
                            case 1:
                                System.out.println("                                 |------------------------------------------------------------------------|");
                                System.out.println("                                 |---------danh sách những cuốn sách đã trả cho thư viện--------|");
                                System.out.println("                                 |------------------------------------------------------------------------|");
                                System.out.println("<---------------------------------------------------------------------------------------------------------------->");
                                boolean result1 = ManagerLibrary.paidBooks.isEmpty();
                                if (result1 == true)
                                    System.out.println("danh sách rỗng!!!");
                                else
                                    ManagerLibrary.showAllPaidBook();
                                System.out.println("<---------------------------------------------------------------------------------------------------------------->");
                                break;
                            case 2:
                                ManagerLibrary.removeListPaidBook();
                                System.out.println("Hoàn thành");
                                break;
                        }

                }
            }
        }
    }
}
