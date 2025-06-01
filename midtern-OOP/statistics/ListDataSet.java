package hus.oop.statistics;

import java.util.List;

public class ListDataSet extends AbstractDataSet {
    private List<Double> data;

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public ListDataSet() {
        /* TODO */
    }

    @Override
    public int size() {
        /* TODO */
    }

    @Override
    public double getAt(int index) {
        /* TODO */
    }

    @Override
    public double[] getAll(int from, int to) {
        /* TODO */
    }

    /**
     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void append(double value) {
        /* TODO */
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của tập dữ liệu.
     * @param index
     * @param value
     */
    @Override
    public void insert(int index, double value) {
        /* TODO */
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
    }

    /**
     * Xóa tất cả các phần tử dữ liệu có giá trị bằng value trong tập dữ liệu.
     * @param value
     */
    @Override
    public void remove(double value) {
        /* TODO */
    }
}
