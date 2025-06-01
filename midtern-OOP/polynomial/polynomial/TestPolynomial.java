package hus.oop.midterm.polynomial;

public class TestPolynomial {
    public static void main(String[] args) {
        /*
         TODO

         - Chạy demo các hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_MyList>.txt
           (ví dụ, NguyenVanA_123456_MyList.txt)
         - Nộp kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        testArrayPolynomial();
        System.out.println();
        testListPolynomial();
        System.out.println();
        testRootSolver();
    }

    public static void testArrayPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ArrayPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        ArrayPolynomial a = new ArrayPolynomial();
        a.append(1).append(-2).append(3);
        System.out.println("Polynomial a: " + a);
        ArrayPolynomial b = new ArrayPolynomial();
        b.append(1).append(5).append(-7);
        System.out.println("Polynomial b: " + b);

        b.set(0, 1);
        System.out.println("Polynomial b after remove x: " + b);

        b.set(6, 1);
        System.out.println("Polynomial b after set: " + b);

        b.plus(b);
        System.out.println("Polynomial b after plus: " + b);

        b.minus(b);
        System.out.println("Polynomial b after minus: " + b);

        b = new ArrayPolynomial();
        b.append(1).append(5).append(-7).append(9);
        b.multiply(a);
        System.out.println("Polynomial b after multiply: " + b);

        System.out.println("Polynomial a at x0: " + a.evaluate(10));
    }

    public static void testListPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ListPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        ListPolynomial a = new ListPolynomial();
        a.append(1).append(-2).append(3);
        System.out.println("Polynomial a: " + a);
        ListPolynomial b = new ListPolynomial();
        b.append(1).append(5).append(-7);
        System.out.println("Polynomial b: " + b);

        b.set(0, 1);
        System.out.println("Polynomial b after remove x: " + b);

        b.set(6, 1);
        System.out.println("Polynomial b after set: " + b);

        b.plus(b);
        System.out.println("Polynomial b after plus: " + b);

        b.minus(b);
        System.out.println("Polynomial b after minus: " + b);

        b = new ListPolynomial();
        b.append(1).append(5).append(-7);
        b.multiply(a);
        System.out.println("Polynomial b after multiply: " + b);

        System.out.println("Polynomial a at x0: " + a.evaluate(10));
    }

    public static void testRootSolver() {
        /*
         TODO

         - Tạo đa thức có nghiệm trong khoảng [a, b] nào đó.
         - Viết chương trình tìm nghiệm của đa thức theo các phương pháp đã cho (Bisection, Newton-Raphson, Secant) sử dụng
           PolynomialRootFinding. Các phương pháp tìm nghiệm của thể thay đổi ở thời gian chạy chương trình.
         - In ra phương pháp sử dụng, đa thức, và nghiệm của đa thức.
         */
        ListPolynomial a = new ListPolynomial();
        a.append(0).append(1);
        System.out.println("Polynomial a: " + a);

        PolynomialRootFinding rootFinding = new PolynomialRootFinding(
                a, new BisectionSolver(1e-12, 1000));
        System.out.println("Bisection method: " + rootFinding.solve(-5, 5));
        rootFinding.setRootSolver(new NewtonRaphsonSolver(1e-12, 1000));
        System.out.println("NewtonRaphson method: " + rootFinding.solve(-5, 5));
        rootFinding.setRootSolver(new SecantSolver(1e-12, 1000));
        System.out.println("Secant method: " + rootFinding.solve(-5, 5));
    }
}
