package hus.oop.midterm.polynomial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ListPolynomial() {
        /* TODO */
        coefficients = new ArrayList<Double>();
    }

    public ListPolynomial(double[] coefficients) {
        this.coefficients = new ArrayList<Double>();
        for (double coefficient : coefficients) {
            this.coefficients.add(coefficient);
        }
    }

    @Override
    public int getSize() {
        return coefficients.size();
    }

    /**
     * Lấy hệ số của đa thức tại vị trí index.
     * @return
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
        return coefficients.get(index);
    }

    /**
     * Lấy các hệ số của đa thức.
     * @return
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        double[] coef = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            coef[i] = coefficients.get(i);
        }
        return coef;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào cuối đa thức hiện tại.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial append(double coefficient) {
        /* TODO */
        coefficients.add(coefficient);
        return this;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial insert(double coefficient, int index) {
        /* TODO */
        coefficients.add(index, coefficient);
        return this;
    }

    /**
     * Sửa hệ số của phần tử index là coefficient.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial set(double coefficient, int index) {
        /* TODO */
        coefficients.set(index, coefficient);
        return this;
    }

    /**
     * Lấy ra bậc của đa thức.
     * @return
     */
    @Override
    public int degree() {
        /* TODO */
        return coefficients.size() - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double p = 0;
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            p = coefficients.get(i) + (x * p);
        }
        return p;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
     */
    @Override
    public Polynomial derivative() {
        /* TODO */
        double[] newCoefficients = differentiate();
        return new ListPolynomial(newCoefficients);
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial plus(ListPolynomial another) {
        /* TODO */
        for (int i = 0; i < coefficients.size(); i++) {
            if (i >= another.coefficients.size()) {
                break;
            }
            coefficients.set(i, coefficients.get(i) + another.coefficient(i));
        }
        if (another.coefficients.size() > this.coefficients.size()) {
            for (int i = coefficients.size(); i < another.coefficients.size(); i++) {
                coefficients.add(another.coefficient(i));
            }
        }
        return this;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial minus(ListPolynomial another) {
        /* TODO */
        for (int i = 0; i < coefficients.size(); i++) {
            if (i >= another.coefficients.size()) {
                break;
            }
            coefficients.set(i, coefficients.get(i) - another.coefficient(i));
        }
        if (another.coefficients.size() > this.coefficients.size()) {
            for (int i = coefficients.size(); i < another.coefficients.size(); i++) {
                coefficients.add(another.coefficient(i));
            }
        }
        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial multiply(ListPolynomial another) {
        /* TODO */
        List<Double> prod = new ArrayList<>(
                Arrays.asList(
                        new Double[
                                coefficients.size() + another.coefficients.size() - 1]));

        for (int i = 0; i < another.coefficients.size(); i++) {
            for (int j = 0; j < coefficients.size(); j++) {
                prod.set(i + j, coefficients.get(i) * another.coefficient(j));
            }
        }
        coefficients = prod;
        return this;
    }
}
