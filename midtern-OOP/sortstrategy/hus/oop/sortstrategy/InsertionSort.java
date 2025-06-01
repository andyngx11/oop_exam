package hus.oop.sortstrategy;

public class InsertionSort implements Sorter {
    /**
     * Phương thức sắp xếp dữ liệu sử dụng thuật toán Insertion sort.
     * @param data
     */
    @Override
    public void sort(double[] data, boolean order) {
        /* TODO */
        if (order) {
            sortAscending(data);
        } else {
            sortDescending(data);
        }
    }

    /**
     * Phương thức sắp xếp mảng dữ liệu theo thứ tự tăng dần,
     * sử dụng thuật toán Insertion sort.
     * @param data
     */
    private void sortAscending(double[] data) {
        /* TODO */
        for (int i = 1; i < data.length; i++) {
            int insertIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (data[j] > data[insertIndex]) {
                    data[j + 1] = data[j];
                    insertIndex = j;
                } else {
                    break;
                }
            }
            data[insertIndex] = data[i];
        }
    }

    /**
     * Phương thức sắp xếp mảng dữ liệu theo thứ tự giảm dần,
     * sử dụng thuật toán Insertion sort.
     * @param data
     */
    private void sortDescending(double[] data) {
        /* TODO */
        for (int i = 1; i < data.length; i++) {
            int insertIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (data[j] < data[insertIndex]) {
                    data[j + 1] = data[j];
                    insertIndex = j;
                } else {
                    break;
                }
            }
            data[insertIndex] = data[i];
        }
    }
}
