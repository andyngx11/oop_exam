package hus.oop.midterm.polynomial;

public class ArrayPolynomial extends AbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 2;
    private double[] coefficents;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ArrayPolynomial() {
        /* TODO */
        this.coefficents = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    public ArrayPolynomial(double[] coefficents) {
        /* TODO */
        this.coefficents = coefficents;
        size = coefficents.length;
    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * Lấy hệ số của đa thức tại phần tử index
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
        return coefficents[index];
    }

    /**
     * Lấy mảng các hệ số của đa thức.
     * @return mảng các hệ số của đa thức.
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        double[] coef = new double[size];
        System.arraycopy(coefficents, 0, coef, 0, size);
        return coefficents;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial append(double coefficient) {
        /* TODO */
        if (size >= this.coefficents.length) {
            enlarge();
        }
        this.coefficents[size] = coefficient;
        size++;
        return this;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insert(double coefficient, int index) {
        /* TODO */
        if (size >= this.coefficents.length) {
            enlarge();
        }
        for (int i = size - 1; i > index ; i--) {
            coefficents[i + 1] = coefficents[i];
        }
        coefficents[index] = coefficient;
        return this;
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial set(double coefficient, int index) {
        /* TODO */
        coefficents[index] = coefficient;
        return this;
    }

    /**
     * Lấy bậc của đa thức.
     * @return bậc của đa thức.
     */
    @Override
    public int degree() {
        /* TODO */
        return size - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return giá trị của đa thức.
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double p = 0;
        for (int i = size - 1; i >= 0; i--) {
            p = coefficents[i] + (x * p);
        }
        return p;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public Polynomial derivative() {
        /* TODO */
        double[] newCoefficients = new double[size - 1];
        newCoefficients = differentiate();
        return new ArrayPolynomial(newCoefficients);
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial plus(ArrayPolynomial another) {
        /* TODO */
        while (coefficents.length < another.size) {
            enlarge();
        }
        size = Math.max(size, another.size);
        for (int i = 0; i < size; i++) {
            coefficents[i] += another.coefficient(i);
        }
        return this;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial minus(ArrayPolynomial another) {
        /* TODO */
        while (coefficents.length < another.size) {
            enlarge();
        }
        size = Math.max(size, another.size);
        for (int i = 0; i < size; i++) {
            coefficents[i] -= another.coefficient(i);
        }
        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial multiply(ArrayPolynomial another) {
        /* TODO */
        while (coefficents.length <= size + another.size - 1) {
            enlarge();
        }
        double[] prod = new double[size + another.size - 1];

        for (int i = 0; i < another.size; i++) {
            for (int j = 0; j < this.size; j++) {
                prod[i + j] += coefficents[i] * another.coefficients()[j];
            }
        }
        size = size + another.size - 2;
        System.arraycopy(prod, 0, coefficents, 0, size);
        return this;
    }

    /**
     * Thêm kích thước để lưu đa thức khi cần thiết.
     */
    private void enlarge() {
        /* TODO */
        double[] newCoef = new double[size * 2];
        System.arraycopy(coefficents, 0, newCoef, 0, size);
        coefficents = newCoef;
    }
}
