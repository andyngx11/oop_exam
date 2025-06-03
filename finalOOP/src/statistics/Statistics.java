package statistics;

import java.util.*;

public class Statistics {
    private MyList data;

    /**
     * Khởi tạo dữ liệu cho BasicStatistic.
     */
    public Statistics(MyList data) {
        /* TODO */
        this.data = data;
    }

    /**
     * Lấy giá trị lớn nhất trong list.
     * @return giá trị lớn nhất.
     */
    public double max() {
        /* TODO */
        if (data.size() == 0) {
            throw new IllegalStateException("List is empty");
        }
        MyIterator it = data.iterator(0);
        double max = it.next().doubleValue();
        while (it.hasNext()) {
            double val = it.next().doubleValue();
            if (val > max) {
                max = val;
            }
        }
        return max;
    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     * @return giá trị nhỏ nhất.
     */
    public double min() {
        /* TODO */
        if (data.size() == 0) {
            throw new IllegalStateException("List is empty");
        }
        MyIterator it = data.iterator(0);
        double min = it.next().doubleValue();
        while (it.hasNext()) {
            double val = it.next().doubleValue();
            if (val < min) {
                min = val;
            }
        }
        return min;
    }

    /**
     * Tính kỳ vọng của mẫu theo dữ liệu trong list.
     * @return kỳ vọng.
     */
    public double mean() {
        /* TODO */
        if (data.size() == 0) {
            throw new IllegalStateException("List is empty");
        }
        MyIterator it = data.iterator(0);
        double sum = 0;
        int count = 0;
        while (it.hasNext()) {
            sum += it.next().doubleValue();
            count++;
        }
        return sum / count;
    }

    /**
     * Tính phương sai của mẫu theo dữ liệu trong list.
     * @return phương sai.
     */
    public double variance() {
        /* TODO */
        if (data.size() == 0) {
            throw new IllegalStateException("List is empty");
        }
        double mean = mean();
        MyIterator it = data.iterator(0);
        double sumSq = 0;
        int count = 0;
        while (it.hasNext()) {
            double val = it.next().doubleValue();
            sumSq += (val - mean) * (val - mean);
            count++;
        }
        return sumSq / count;
    }

    /**
     * Tìm kiếm trong list có phẩn tử nào có giá trị bằng data không, sử dụng binarySearch trong list.
     * Trả về index một phần tử có giá trị bằng data, nếu không tìm thấy thì trả về -1.
     * @return
     */
    public int search(double data) {
        /* TODO */
        return this.data.binarySearch(data);
    }

    /**
     * Tính rank của các phần tử trong list.
     * @return rank của các phần tử trong list
     */
    public double[] rank() {
        /* TODO */
        int size = data.size();
        if (size == 0) {
            return new double[0];
        }

        // Lưu trữ dữ liệu và chỉ số ban đầu
        double[] original = new double[size];
        MyIterator it = data.iterator(0);
        for (int i = 0; i < size; i++) {
            original[i] = it.next().doubleValue();
        }

        // Tạo bản sao và sắp xếp để xếp hạng
        double[] sorted = original.clone();
        Arrays.sort(sorted);

        double[] ranks = new double[size];
        Map<Double, Double> rankMap = new HashMap<>();

        // Tính rank có xử lý trường hợp giá trị trùng nhau (rank trung bình)
        for (int i = 0; i < size; ) {
            int j = i;
            while (j < size && sorted[j] == sorted[i]) {
                j++;
            }
            double avgRank = (i + j - 1) / 2.0 + 1; // cộng 1 vì rank bắt đầu từ 1
            for (int k = i; k < j; k++) {
                rankMap.put(sorted[k], avgRank);
            }
            i = j;
        }

        // Gán rank theo vị trí ban đầu
        for (int i = 0; i < size; i++) {
            ranks[i] = rankMap.get(original[i]);
        }

        return ranks;
    }

}
