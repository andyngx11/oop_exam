package hus.oop.midterm.polynomial;

public class SecantSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public SecantSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của đa thức theo phương pháp Secant
     * @param polynomial
     * @param lower
     * @param upper
     * @return nghiệm của đa thức trong khoảng [lower, upper]
     */
    @Override
    public double solve(Polynomial polynomial, double lower, double upper) {
        /* TODO */
        double x0;
        double x1 = lower;
        double x2 = upper;
        int count = 0;
        while (Math.abs(x2 - x1) > tolerance && count < maxIterations) {
            x0 = x1;
            x1 = x2;
            double fx1 = polynomial.evaluate(x1);
            double fx0 = polynomial.evaluate(x0);
            x2 = x0 - ((x1 - x0) / (fx1 - fx0)) * fx0;
            count++;
        }
        return x2;
    }
}
