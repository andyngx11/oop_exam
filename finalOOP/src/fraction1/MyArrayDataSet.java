package fraction1;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayDataSet implements MyDataSet {
    private static int DEFAULT_CAPACITY = 16;
    private MyFraction[] fractions;
    private int length;

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số có kích thước là DEFAULT_CAPACITY.
     */
    public MyArrayDataSet() {
        this.fractions = new MyFraction[DEFAULT_CAPACITY];
        this.length = 0;
    }

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số truyền vào.
     * @param fractions
     */
    public MyArrayDataSet(MyFraction[] fractions) {
        this.length = fractions.length;
        this.fractions = new MyFraction[Math.max(DEFAULT_CAPACITY, length)];
        for (int i = 0; i < length; i++) {
            this.fractions[i] = new MyFraction(fractions[i]); // sao chép để tránh thay đổi gốc
        }
    }

    /**
     * Phương thức chèn phân số fraction vào vị trí index.
     * Nếu index nằm ngoài đoạn [0, length] thì không chèn được vào.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction là một phân số.
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    @Override
    public boolean insert(MyFraction fraction, int index) {
        /* TODO */
        if (!checkBoundaries(index, length)) return false;

        if (length >= fractions.length) {
            allocateMore();
        }

        // dịch các phần tử từ index về sau sang phải
        for (int i = length; i > index; i--) {
            fractions[i] = fractions[i - 1];
        }

        fractions[index] = new MyFraction(fraction);
        length++;
        return true;
    }

    /**
     * Phương thức thêm phân số fraction vào vị trí cuối cùng chưa có dứ liệu của mảng data.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    @Override
    public boolean append(MyFraction fraction) {
        /* TODO */
        if (length >= fractions.length) {
            allocateMore();
        }
        fractions[length++] = new MyFraction(fraction);
        return true;
    }

    @Override
    public MyArrayDataSet toSimplify() {
        /* TODO */
        MyFraction[] simplified = new MyFraction[length];
        for (int i = 0; i < length; i++) {
            MyFraction f = new MyFraction(fractions[i]);
            f.simplify();
            simplified[i] = f;
        }
        return new MyArrayDataSet(simplified);
    }

    @Override
    public MyArrayDataSet sortIncreasing() {
        /* TODO */
        MyFraction[] sorted = Arrays.copyOf(fractions, length);
        Arrays.sort(sorted, (a, b) -> {
            int cmp = a.compareTo(b);
            if (cmp != 0) return cmp;
            return Integer.compare(a.getDenominator(), b.getDenominator());
        });
        return new MyArrayDataSet(sorted);
    }

    @Override
    public MyArrayDataSet sortDecreasing() {
        /* TODO */
        MyFraction[] sorted = Arrays.copyOf(fractions, length);
        Arrays.sort(sorted, (a, b) -> {
            int cmp = b.compareTo(a);
            if (cmp != 0) return cmp;
            return Integer.compare(b.getDenominator(), a.getDenominator());
        });
        return new MyArrayDataSet(sorted);
    }

    @Override
    public String myDataSetToString() {
        /* TODO */
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < length; i++) {
            sb.append(fractions[i]);
            if (i < length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void print() {
        /* TODO */
        System.out.println(myDataSetToString());
    }

    /**
     * Phương thức mở rộng kích thước mảng gấp đôi, bằng cách tạo ra mảng mới có kích thước
     * gấp đôi, sau đó copy dự liệu từ mảng cũ vào.
     */
    private void allocateMore() {
        /* TODO */
        int newCapacity = fractions.length * 2;
        fractions = Arrays.copyOf(fractions, newCapacity);
    }

    /**
     * Phương thức kiểm tra xem index có nằm trong khoảng [0, upperBound] hay không.
     * @param index
     * @param upperBound
     * @return true nếu index nằm trong khoảng [0, upperBound], false nếu ngược lại.
     */
    private boolean checkBoundaries(int index, int upperBound) {
        /* TODO */
        return index >= 0 && index <= upperBound;
    }
}
