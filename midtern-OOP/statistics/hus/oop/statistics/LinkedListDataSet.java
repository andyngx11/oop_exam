package hus.oop.statistics;

import java.util.List;

public class LinkedListDataSet extends AbstractDataSet {
    private Node head;

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public LinkedListDataSet() {
        this.head = null;
    }

    @Override
    public int size() {
        /* TODO */
        Node current = head;
        if (current == null) {
            return 0;
        }
        int count = 1;
        while (current.next != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    /**
     * Lấy giá trị của phần tử ở vị trí index.
     * @param index
     * @return
     */
    @Override
    public double get(int index) {
        /* TODO */
        return getNodeByIndex(index).data;
    }

    /**
     * Sửa dữ liệu ở vị trí index thành data.
     * @param data
     * @param index
     */
    @Override
    public void set(double data, int index) {
        /* TODO */
        if (!checkBoundaries(index, size() - 1)) {
            throw new IndexOutOfBoundsException();
        };
        getNodeByIndex(index).data = data;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void append(double value) {
        /* TODO */
        if (head == null) {
            head = new Node(value);
            return;
        }
        getNodeByIndex(size() - 1).next = new Node(value);
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của tập dữ liệu.
     * Chỉ thêm được nếu index nằm trong đoạn [0 - size()].
     * @param value
     * @param index
     */
    @Override
    public void insert(double value, int index) {
        /* TODO */
        Node newNode = new Node(value);
        Node current = getNodeByIndex(index - 1);
        newNode.next = current.next;
        current.next = newNode;
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size() - 1)]
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if (!checkBoundaries(index, size() - 1)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
        }
        Node current = getNodeByIndex(index - 1);
        current.next = current.next.next;
    }

    /**
     * Phương thức lấy Node ở vị trí index.
     * @param index
     * @return
     */
    private Node getNodeByIndex(int index) {
        /* TODO */
        if (!checkBoundaries(index, size() - 1)) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * Lấy ra dữ liệu được lưu theo cấu trúc dữ liệu kiểu mảng.
     * @return
     */
    @Override
    public double[] toArray() {
        /* TODO */
        double[] array = new double[size()];
        Node current = head;
        array[0] = current.data;
        for (int i = 1; i < size(); i++) {
            current = current.next;
            array[i] = current.data;
        }
        return array;
    }
}
