package hus.oop.sortstrategy;

import java.util.Arrays;

public class TestSortStrategy {
    public static void main(String[] args) {
        /* Yêu cầu:
        - Sinh ra ngẫu nhiên một số tự nhiên có giá trị nằm trong khoảng [20 - 30].
        - Sinh ra ngẫu nhiên một mảng các số kiểu double, có kích thước bằng số tự nhiên đã sinh ngẫu nhiên ở trên.
        - Copy dữ liệu mảng trên sang 2 mảng khác để có 3 mảng có dữ liệu giống nhau.
        - Tạo đối tượng có kiểu dữ liệu SortStrategy. Dùng đối tượng này test 3 thuật toán đã cho với 3 mảng dữ liệu trên.
          Các kết quả test được in ra terminal theo định dạng: ví dụ
          Using Bubble Sort Algorithm:
          Before sorting: [5.0 4.0 3.0 2.0 1.0]
          After sorting: [1.0 2.0 3.0 4.0 5.0]

          Using Insertion Sort Algorithm:
          Before sorting: [5.0 4.0 3.0 2.0 1.0]
          After sorting: [1.0 2.0 3.0 4.0 5.0]

        - Kết quả chạy chương trình lưu vào file text được đặt tên <TenSinhVien_MaSinhVien_SortStrategy.txt.
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
          nộp lên classroom
         */
        double[] arr = generateArray();
        double[] arr2 = generateArray();
        double[] arr3 = generateArray();

        System.out.println(Arrays.toString(arr));
        SortStrategy.getInstance().setSortee(new BubbleSort()).sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();

        System.out.println(Arrays.toString(arr2));
        SortStrategy.getInstance().setSortee(new InsertionSort()).sort(arr2);
        System.out.println(Arrays.toString(arr2));
        System.out.println();

        System.out.println(Arrays.toString(arr3));
        SortStrategy.getInstance().setSortee(new SelectionSort()).sort(arr3);
        System.out.println(Arrays.toString(arr3));
        System.out.println();
    }

    public static double[] generateArray() {
        double[] array = new double[20 + ((int) (Math.random() * 11))];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.round(Math.random() * 10000) / 100.0;
        }
        return array;
    }
}
