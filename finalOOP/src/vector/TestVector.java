package vector;

import java.util.Random;


public class TestVector {
    private MyVector vector;

    public TestVector(MyVector vector) {
        this.vector = vector;
    }

    public static void main(String[] args) {
        /* TODO
           - Thực hiện các hàm test.
           - Lưu các kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_Vector>.txt
             (ví dụ NguyenVanA_123456_Vector.txt). Nén các file source code và file kết quả vào file zip có tên
             <Ten_MaSinhVien_Vector>.zip (ví dụ NguyenVanA_123456_Vector.zip), nộp lên classroom.
         */
        System.out.println("=== TEST ARRAY VECTOR ===");
        TestVector testArray = new TestVector(new MyArrayVector());
        testArray.testArrayVector();

        System.out.println("\n=== TEST LIST VECTOR ===");
        TestVector testList = new TestVector(new MyListVector());
        testList.testListVector();
    }

    public void testArrayVector() {
        /* TODO
         - Sinh ngẫu nhiên một số tự nhiên, lưu giá trị sinh ra vào biến n.
         - Tạo ra vector có kích thước n, với các phần tử được sinh ngẫu nhiên, lưu vào biến vector, sử dụng MyArrayVector.
         - Viết các các chứ năng của các vector, như thêm vào phần tử, xóa bớt phần tử, sửa giá trị các
           phần tử, cộng các vector, nhân vector với vô hướng, tích vô hướng 2 vector, chuẩn vector, ... Mỗi lần thay
           đổi vector hoặc tính toán, in các kết quả ra terminal.
         */
        Random rand = new Random();
        int n = rand.nextInt(5) + 3; // Tạo kích thước n từ 3 đến 7
        MyArrayVector v1 = new MyArrayVector();

        System.out.println("Tạo vector MyArrayVector với " + n + " phần tử ngẫu nhiên:");
        for (int i = 0; i < n; i++) {
            double val = rand.nextDouble() * 10;
            v1.insert(val);
        }
        System.out.println("Vector ban đầu: " + v1);

        v1.insert(99.9, 1);
        System.out.println("Chèn 99.9 vào vị trí 1: " + v1);

        v1.set(88.8, 2);
        System.out.println("Set giá trị 88.8 vào vị trí 2: " + v1);

        v1.remove(0);
        System.out.println("Xóa phần tử ở vị trí 0: " + v1);

        MyArrayVector v2 = v1.add(1.5);
        System.out.println("Vector v2 = v1 + 1.5: " + v2);

        MyArrayVector v3 = v1.scale(2);
        System.out.println("v1 sau khi nhân 2 (scale): " + v3);

        System.out.println("Norm của v1: " + v1.norm());

        MyArrayVector v4 = new MyArrayVector();
        for (int i = 0; i < v1.size(); i++) {
            v4.insert(rand.nextDouble() * 10);
        }
        System.out.println("Vector v4 mới: " + v4);
        System.out.println("Tổng v1 + v4: " + v1.add(v4));
        System.out.println("Tích vô hướng v1 · v4 = " + v1.dot(v4));
    }

    public void testListVector() {
        /* TODO
         - Sinh ngẫu nhiên một số tự nhiên, lưu giá trị sinh ra vào biến n.
         - Tạo ra vector có kích thước n, với các phần tử được sinh ngẫu nhiên, lưu vào biến vector, sử dụng MyListVector.
         - Viết các các chứ năng của các vector, như thêm vào phần tử, xóa bớt phần tử, sửa giá trị các
           phần tử, cộng các vector, nhân vector với vô hướng, tích vô hướng 2 vector, chuẩn vector, ... Mỗi lần thay
           đổi vector hoặc tính toán, in các kết quả ra terminal.
         */
        Random rand = new Random();
        int n = rand.nextInt(5) + 3; // Tạo kích thước n từ 3 đến 7
        MyListVector v1 = new MyListVector();

        System.out.println("Tạo vector MyListVector với " + n + " phần tử ngẫu nhiên:");
        for (int i = 0; i < n; i++) {
            double val = rand.nextDouble() * 10;
            v1.insert(val);
        }
        System.out.println("Vector ban đầu: " + v1);

        v1.insert(77.7, 2);
        System.out.println("Chèn 77.7 vào vị trí 2: " + v1);

        v1.set(66.6, 3);
        System.out.println("Set giá trị 66.6 vào vị trí 3: " + v1);

        v1.remove(1);
        System.out.println("Xóa phần tử ở vị trí 1: " + v1);

        MyListVector v2 = v1.add(2.5);
        System.out.println("Vector v2 = v1 + 2.5: " + v2);

        MyListVector v3 = v1.scale(0.5);
        System.out.println("v1 sau khi nhân 0.5 (scale): " + v3);

        System.out.println("Norm của v1: " + v1.norm());

        MyListVector v4 = new MyListVector();
        for (int i = 0; i < v1.size(); i++) {
            v4.insert(rand.nextDouble() * 10);
        }
        System.out.println("Vector v4 mới: " + v4);
        System.out.println("Tổng v1 + v4: " + v1.add(v4));
        System.out.println("Tích vô hướng v1 · v4 = " + v1.dot(v4));
    }
}
