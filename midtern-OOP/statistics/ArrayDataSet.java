package hus.oop.statistics;

public class ArrayDataSet extends AbstractDataSet {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] data;
    private int size;

    /**
     * Hàm dựng để khởi tạo dữ liệu.
     */
    public ArrayDataSet() {
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
     * Thêm phần tử dữ liệu vào cuối mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void append(double value) {
        /* TODO */
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
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

    /**
     * Mở rộng gấp đôi kích thước mảng this.data.
     */
    private void allocateMore() {
        /* TODO */
    }
}
