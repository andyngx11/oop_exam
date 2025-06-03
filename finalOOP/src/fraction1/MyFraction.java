package fraction1;

public class MyFraction implements MyFractionComparable {
    private int numerator;
    private int denominator;

    /**
     * Hàm dựng khởi tạo giá trị mặc định là 1/1.
     */
    public MyFraction() {
        /* TODO */
        this.numerator = 1;
        this.denominator = 1;
    }

    /**
     * Hàm dựng khởi tạo giá trị cho tử số và mẫu số.
     * @param numerator
     * @param denominator
     */
    public MyFraction(int numerator, int denominator) {
        /* TODO */
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    /**
     * Hàm dựng copy, copy giá trị của phân số truyền vào.
     * @param copyMyFraction
     */
    public MyFraction(MyFraction copyMyFraction) {
        /* TODO */
        this.numerator = copyMyFraction.numerator;
        this.denominator = copyMyFraction.denominator;
    }

    public int getNumerator() {
        /* TODO */
        return numerator;
    }

    public void setNumerator(int numerator) {
        /* TODO */
        this.numerator = numerator;
    }

    public int getDenominator() {
        /* TODO */
        return denominator;
    }

    public void setDenominator(int denominator) {
        /* TODO */
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.denominator = denominator;
    }

    /**
     * Phương thức trả về giá trị kiểu byte của phân số.
     * @return
     */
    public byte byteValue() {
        /* TODO */
        return (byte) (numerator / (double) denominator);
    }

    /**
     * Phương thức trả về giá trị kiểu int của phân số.
     * @return
     */
    public int intValue() {
        /* TODO */
        return (int) (numerator / (double) denominator);
    }

    /**
     * Phương thức trả về giá trị kiểu long của phân số.
     * @return
     */
    public long longValue() {
        /* TODO */
        return (long) (numerator / (double) denominator);
    }

    /**
     * Phương thức trả về giá trị kiểu short của phân số.
     * @return
     */
    public short shortValue() {
        /* TODO */
        return (short) (numerator / (double) denominator);
    }

    /**
     * Phương thức trả về giá trị kiểu double của phân số.
     * @return
     */
    public double doubleValue() {
        /* TODO */
        return (double) numerator / denominator;
    }

    /**
     * Phương thức trả về giá trị kiểu float của phân số.
     * @return
     */
    public float floatValue() {
        /* TODO */
        return (float) numerator / denominator;
    }

    private int gcd(int a, int b) {
        if (b == 0) return Math.abs(a);
        return gcd(b, a % b);
    }


    /**
     * Phương thức tính ước số chung lớn nhất của tử số và mẫu số.
     * @return ước số chung lớn nhất của tử số và mẫu số.
     */
    private int gcd() {
        /* TODO */
        return gcd(numerator, denominator);
    }

    /**
     * Phương thức rút gọn phân số về phân số tối giản.
     */
    public void simplify() {
        /* TODO */
        if (denominator == 0) {
            throw new ArithmeticException("Cannot simplify with zero denominator.");
        }
        int gcd = gcd();
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) {  // giữ mẫu số dương
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    @Override
    public int compareTo(MyFraction another) {
        /* TODO */
        return Integer.compare(this.numerator * another.denominator, this.denominator * another.numerator);
    }

    /**
     * Phương thức mô tả phân số theo định dạng numerator/denominator;
     * @return
     */
    @Override
    public String toString() {
        /* TODO */
        return numerator + "/" + denominator;
    }
}
