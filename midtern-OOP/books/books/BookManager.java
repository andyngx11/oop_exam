package hus.oop.midterm.books;

import java.util.Comparator;
import java.util.Iterator;

public class BookManager {
    private MyList books;

    /**
     * Khởi tạo dữ liệu cho BookManager.
     */
    public BookManager(MyList data) {
        /* TODO */
        this.books = data;
    }

    /**
     * Lấy ra danh sách các sách được sắp xếp theo thứ tự title.
     * Chú ý, không thay đổi thứ tự sách trong danh sách gốc.
     * @param order
     * @return danh sách các sách đã được sắp xếp.
     */
    public MyList sortByTitle(boolean order) {
        /*
         TODO

         - Sửa lại lớp Book để sử dụng BookComparable để thực hiện việc so sánh các Book theo title.

         - Sử dụng tiêu chí so sánh trong BookComparable, viết code để sắp xếp danh sách các sách theo thứ tự
           phụ thuộc tham số order. Nếu order là true thì sắp xệp theo thứ tự tăng dần. Nếu order là false thì
           sắp xếp theo thứ tự giảm dần.

         - Trả ra danh sách mới các sách đã được sắp thứ tự.
         */
        MyList newList = new MyArrayList();
        MyIterator iterator = this.books.iterator();
        newList.append(iterator.next());
        while (iterator.hasNext()) {
            newList.append(iterator.next());
        }

        if (order) {
            sortAscendingTitle(newList);
        } else {
            sortDescendingTitle(newList);
        }
        return newList;
    }

    private void sortAscendingTitle(MyList newList) {
        for (int i = 0; i < newList.size() - 1; i++) {
            for (int j = i + 1; j < newList.size(); j++) {
                if (((Book) newList.get(i)).
                        compareTo((Book) newList.get(j)) > 0) {
                    Object temp = newList.get(i);
                    newList.set(newList.get(j), i);
                    newList.set(temp, j);
                }
            }
        }
    }

    private void sortDescendingTitle(MyList newList) {
        for (int i = 0; i < newList.size() - 1; i++) {
            for (int j = i + 1; j < newList.size(); j++) {
                if (((Book) newList.get(i)).
                        compareTo((Book) newList.get(j)) < 0) {
                    Object temp = newList.get(i);
                    newList.set(newList.get(j), i);
                    newList.set(temp, j);
                }
            }
        }
    }

    /**
     * Lấy ra danh sách các sách được sắp xếp theo pages.
     * Chú ý, không thay đổi thứ tự sách trong danh sách gốc.
     * @param order
     * @return danh sách các sách đã được sắp xếp.
     */
    public MyList sortByPageNumber(boolean order) {
        /*
         TODO

         - Thêm lớp PageComparison sử dụng BookComparator để có thể so sánh các sách theo pages.

         - Viết code sử dụng PageComparison để sắp xếp sách theo thứ tự phụ thuộc tham số order.
           Nếu order là true thì sắp xệp theo thứ tự tăng dần. Nếu order là false thì sắp xếp theo thứ tự giảm dần.

         - Trả ra danh sách mới các sách đã được sắp xếp.
         */
        MyList newList = new MyArrayList();
        MyIterator iterator = this.books.iterator();
        newList.append(iterator.next());
        while (iterator.hasNext()) {
            newList.append(iterator.next());
        }

        if (order) {
            sortAscendingPageNumber(newList);
        } else {
            sortDescendingPageNumber(newList);
        }
        return newList;
    }

    public void sortAscendingPageNumber(MyList newList) {
        BookComparator comparator = new PageComparison();
        for (int i = 0; i < newList.size() - 1; i++) {
            for (int j = i + 1; j < newList.size(); j++) {
                if (comparator.compare(((Book) newList.get(i)), (Book) newList.get(j)) > 0) {
                    Object temp = newList.get(i);
                    newList.set(newList.get(j), i);
                    newList.set(temp, j);
                }
            }
        }
    }

    public void sortDescendingPageNumber(MyList newList) {
        BookComparator comparator = new PageComparison();
        for (int i = 0; i < newList.size() - 1; i++) {
            for (int j = i + 1; j < newList.size(); j++) {
                if (comparator.compare(((Book) newList.get(i)), (Book) newList.get(j)) < 0) {
                    Object temp = newList.get(i);
                    newList.set(newList.get(j), i);
                    newList.set(temp, j);
                }
            }
        }
    }
}
