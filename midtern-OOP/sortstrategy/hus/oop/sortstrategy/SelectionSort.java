package hus.oop.sortstrategy;

public class SelectionSort implements Sorter {
    /**
     * Phương thức sắp xếp dữ liệu sử dụng thuật toán Selection sort.
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
     * sử dụng thuật toán Selection sort.
     * @param data
     */
    private void sortAscending(double[] data) {
        /* TODO */
        for (int i = 0; i < data.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
    }

    /**
     * Phương thức sắp xếp mảng dữ liệu theo thứ tự giảm dần,
     * sử dụng thuật toán Selection sort.
     * @param data
     */
    private void sortDescending(double[] data) {
        /* TODO */
        for (int i = 0; i < data.length; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[maxIndex]) {
                    maxIndex = j;
                }
            }
            double temp = data[i];
            data[i] = data[maxIndex];
            data[maxIndex] = temp;
        }
    }
}
