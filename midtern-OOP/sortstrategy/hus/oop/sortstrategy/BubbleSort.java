package hus.oop.sortstrategy;

public class BubbleSort implements Sorter {
    /**
     * Phương thức sắp xếp dữ liệu sử dụng thuật toán Bubble sort.
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
     * sử dụng thuật toán Bubble sort.
     * @param data
     */
    private void sortAscending(double[] data) {
        /* TODO */
        boolean changed;
        for (int i = 0; i < data.length - 1; i++) {
            changed = true;
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] > data[j]) {
                    double temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                    changed = false;
                }
            }
            if (changed) {
                break;
            }
        }
    }

    /**
     * Phương thức sắp xếp mảng dữ liệu theo thứ tự giảm dần,
     * sử dụng thuật toán Bubble sort.
     * @param data
     */
    private void sortDescending(double[] data) {
        /* TODO */
        boolean changed;
        for (int i = 0; i < data.length - 1; i++) {
            changed = true;
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] < data[j]) {
                    double temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                    changed = false;
                }
            }
            if (changed) {
                break;
            }
        }
    }
}
