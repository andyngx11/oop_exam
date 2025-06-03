package statistics;

import java.util.Random;

public class TestStatistics {
    private Statistics statistics;

    public TestStatistics(Statistics statistics) {
        /* TODO */
        this.statistics = statistics;
    }

    public static void main(String[] args) {
        /* TODO
           - Thực hiện từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
             là <TenSinhVien_MaSinhVien_Statistics>.txt (Ví dụ, NguyenVanA_123456_Statistics.txt).
           - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
             <TenSinhVien_MaSinhVien_Statistics>.zip (Ví dụ, NguyenVanA_123456_Statistics.zip),
             nộp lên classroom.
         */
        TestStatistics test = new TestStatistics(null);
        System.out.println("=== Test MyArrayList ===");
        test.testMyArrayList();

        System.out.println("\n=== Test MyLinkedList ===");
        test.testMyLinkedList();
    }

    public void testMyArrayList() {
        /* TODO
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo một list kiểu MyArrayList, có các phần tử dữ liệu kiểu double được sinh ngẫu nhiên
             nằm trong đoạn [1, 20]. Tạo Statistics có dữ liệu là list dữ liệu vừa tạo, lưu vào statistics.
           - Sử dụng Statistics để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai, rank, sắp xếp, tìm kiếm).
             In ra terminal tập dữ liệu, tập dữ liệu được sắp xếp, các đại lượng thống kê và kết quả chức năng tìm kiếm.
         */
        Random rand = new Random();
        int length = rand.nextInt(21) + 30;  // [30,50]

        MyArrayList list = new MyArrayList();
        for (int i = 0; i < length; i++) {
            double val = 1 + rand.nextDouble() * 19;  // [1,20]
            list.add(val);
        }

        statistics = new Statistics(list);

        System.out.println("Original data:");
        System.out.println(list.toString());

        MyList sortedList = list.sortIncreasing();
        System.out.println("Sorted data:");
        System.out.println(sortedList.toString());

        System.out.printf("Max: %.4f\n", statistics.max());
        System.out.printf("Min: %.4f\n", statistics.min());
        System.out.printf("Mean: %.4f\n", statistics.mean());
        System.out.printf("Variance: %.4f\n", statistics.variance());

        double[] ranks = statistics.rank();
        System.out.println("Ranks:");
        for (double r : ranks) {
            System.out.printf("%.4f ", r);
        }
        System.out.println();

        // Test search with a random value from the list (pick an element randomly)
        int randomIndex = rand.nextInt(length);
        double searchValue = list.iterator(0).next().doubleValue(); // fallback if needed
        // get actual random value:
        MyIterator it = list.iterator(0);
        for (int i = 0; i <= randomIndex; i++) {
            searchValue = it.next().doubleValue();
        }

        int foundIndex = statistics.search(searchValue);
        System.out.printf("Search for value %.4f found at index: %d\n", searchValue, foundIndex);
    }

    public void testMyLinkedList() {
        /* TODO
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo một list kiểu MyLinkedList, có các phần tử lưu dữ liệu kiểu double được sinh ngẫu nhiên
             nằm trong đoạn [1, 20]. Tạo Statistics có dữ liệu là list dữ liệu vừa tạo, lưu vào statistics.
           - Sử dụng Statistics để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai, rank, sắp xếp, tìm kiếm).
             In ra terminal tập dữ liệu, tập dữ liệu được sắp xếp, các đại lượng thống kê và kết quả chức năng tìm kiếm.
         */
        Random rand = new Random();
        int length = rand.nextInt(21) + 30;  // [30,50]

        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < length; i++) {
            double val = 1 + rand.nextDouble() * 19;  // [1,20]
            list.add(val);
        }

        statistics = new Statistics(list);

        System.out.println("Original data:");
        System.out.println(list.toString());

        MyList sortedList = list.sortIncreasing();
        System.out.println("Sorted data:");
        System.out.println(sortedList.toString());

        System.out.printf("Max: %.4f\n", statistics.max());
        System.out.printf("Min: %.4f\n", statistics.min());
        System.out.printf("Mean: %.4f\n", statistics.mean());
        System.out.printf("Variance: %.4f\n", statistics.variance());

        double[] ranks = statistics.rank();
        System.out.println("Ranks:");
        for (double r : ranks) {
            System.out.printf("%.4f ", r);
        }
        System.out.println();

        // Test search with a random value from the list
        int randomIndex = rand.nextInt(length);
        double searchValue = list.iterator(0).next().doubleValue(); // fallback if needed
        // get actual random value:
        MyIterator it = list.iterator(0);
        for (int i = 0; i <= randomIndex; i++) {
            searchValue = it.next().doubleValue();
        }

        int foundIndex = statistics.search(searchValue);
        System.out.printf("Search for value %.4f found at index: %d\n", searchValue, foundIndex);
    }
}
