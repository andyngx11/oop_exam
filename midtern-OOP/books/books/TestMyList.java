package hus.oop.midterm.books;

public class TestMyList {
    public static void main(String[] args) {
        /*
         TODO

         - Chạy demo các hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_MyList>.txt
           (ví dụ, NguyenVanA_123456_MyList.txt)
         - Nộp kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        testMyArrayList();
        System.out.println();
        testMyLinkedList();
    }

    public static void testMyArrayList() {
        /*
         TODO

         - Tạo ra một list kiểu MyArrayList có ít nhất 10 Book.

         - Sử dụng BookManager để
             + Sắp xếp và in ra danh sách các Book theo thứ tự tăng dần theo title.
             + Sắp xếp và in ra danh sách các Book theo thứ tự giảm dần theo title.
             + Sắp xếp và in ra danh sách các Book theo thứ tự tăng dần theo số trang.
             + Sắp xếp và in ra danh sách các Book theo thứ tự giảm dần theo số trang.
         */
        MyList list = new MyArrayList();
        list.append(new Book("Akc ref", 1958, 200));
        list.append(new Book("Bcd wef", 1959, 216));
        list.append(new Book("Acd ryhb", 1859, 186));
        list.append(new Book("Ccd wed", 7522, 251));
        list.append(new Book("Gsd ergv", 785, 452));
        list.append(new Book("Ebf wed", 695, 362));
        list.append(new Book("Ndf wegfw", 1959, 82));
        list.append(new Book("Sdf wfc", 1959, 362));
        list.append(new Book("Avd wer", 7852, 452));
        list.append(new Book("Rsg gfhn", 865, 52));

        BookManager manager = new BookManager(list);
        MyList list1 = manager.sortByTitle(true);
        System.out.println(list1.toString());
        list1 = manager.sortByTitle(false);
        System.out.println(list1.toString());
        list1 = manager.sortByPageNumber(true);
        System.out.println(list1.toString());
        list1 = manager.sortByPageNumber(false);
        System.out.println(list1.toString());
    }

    public static void testMyLinkedList() {
        /*
         TODO

         - Tạo ra một list kiểu MyLinkedList có ít nhất 10 Book.

         - Sử dụng BookManager để
             + Sắp xếp và in ra danh sách các Book theo thứ tự tăng dần theo tên sách.
             + Sắp xếp và in ra danh sách các Book theo thứ tự giảm dần theo tên sách.
             + Sắp xếp và in ra danh sách các Book theo thứ tự tăng dần theo số trang.
             + Sắp xếp và in ra danh sách các Book theo thứ tự giảm dần theo số trang.
         */
        MyList list = new MyLinkedList();
        list.append(new Book("Akc ref", 1958, 200));
        list.append(new Book("Bcd wef", 1959, 216));
        list.append(new Book("Acd ryhb", 1859, 186));
        list.append(new Book("Ccd wed", 7522, 251));
        list.append(new Book("Gsd ergv", 785, 452));
        list.append(new Book("Ebf wed", 695, 362));
        list.append(new Book("Ndf wegfw", 1959, 82));
        list.append(new Book("Sdf wfc", 1959, 362));
        list.append(new Book("Avd wer", 7852, 452));
        list.append(new Book("Rsg gfhn", 865, 52));

        BookManager manager = new BookManager(list);
        MyList list1 = manager.sortByTitle(true);
        System.out.println(list1.toString());
        list1 = manager.sortByTitle(false);
        System.out.println(list1.toString());
        list1 = manager.sortByPageNumber(true);
        System.out.println(list1.toString());
        list1 = manager.sortByPageNumber(false);
        System.out.println(list1.toString());
    }

    public static void testIterator(MyList myList) {
        /*
         TODO

         Sử dụng iterator duyệt qua tất cả các phần tử trong danh sách myList và in ra thông tin về phần tử đó.
         */
    }
}
