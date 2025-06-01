package hus.oop.datastructure;

public class MyQueue {
    private MyList queueData;

    public MyQueue() {
        this.queueData = new MyArrayList();
    }

    /**
     * Thêm giá trị vào cuối của queue.
     * @param value
     */
    public void add(int value) {
        /* TODO */
    }

    /**
     * Xóa và trả lại giá trị ở đầu của queue.
     * @return
     */
    public int remove() {
        /* TODO */
    }

    /**
     * Kiểm tra xem queue có rỗng hay không.
     * @return true nếu queue không chứa giá trị nào, false nếu queue đã chứa giá trị.
     */
    public boolean isEmpty() {
        /* TODO */
    }

    /**
     * Trả lại giá trị ở đầu của queue mà không xóa phần tử.
     * @return giá trị ở vị trí đầu của queue.
     */
    public int peek() {
        /* TODO */
    }

    /**
     * Lấy kích thước của queue.
     * @return
     */
    public int size() {
        /* TODO */
    }
}
