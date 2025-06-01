package hus.oop.midterm.books;

public class PageComparison implements BookComparator {
    @Override
    public int compare(Book left, Book right) {
        if (left.getPages() > right.getPages()) {
            return 1;
        } else if (left.getPages() < right.getPages()) {
            return -1;
        }
        return 0;
    }
}
