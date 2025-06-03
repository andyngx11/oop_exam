package statistics;

public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayList() {
        /* TODO */
        this.data = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        /* TODO */
        return this.size;
    }

    @Override
    public void add(double data) {
        /* TODO */
        allocateMore();
        this.data[size++] = data;
    }

    @Override
    public void insert(double data, int index) {
        /* TODO */
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        allocateMore();
        // Dịch chuyển phần tử từ index trở đi sang phải 1 vị trí
        for (int i = size; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = data;
        size++;
    }

    @Override
    public void remove(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        // Dịch chuyển phần tử từ index + 1 trở đi sang trái 1 vị trí
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        // Optionally: gán phần tử cuối cùng bằng 0 để tránh giữ tham chiếu
        data[size] = 0;
    }

    @Override
    public MyArrayList sortIncreasing() {
        /* TODO */
        MyArrayList sortedList = new MyArrayList();
        for (int i = 0; i < size; i++) {
            sortedList.add(this.data[i]);
        }
        // Sắp xếp mảng bên trong sortedList
        java.util.Arrays.sort(sortedList.data, 0, sortedList.size);
        return sortedList;
    }

    @Override
    public int binarySearch(double data) {
        /* TODO */
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (this.data[mid] == data) {
                return mid;
            } else if (this.data[mid] < data) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Tạo iterator để có thể duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator(int start) {
        /* TODO */
        if (start < 0 || start > size) {
            throw new IndexOutOfBoundsException("Start index out of bounds: " + start);
        }
        return new MyArrayListIterator(start);
    }

    /**
     * Cấp phát gấp đôi chỗ cho danh sách khi cần thiết.
     */
    private void allocateMore() {
        /* TODO */
        if (size >= data.length) {
            double[] newData = new double[data.length * 2];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    private class MyArrayListIterator implements MyIterator {
        /**
         * Vị trí hiện tại của iterator trong MyArrayList.
         */
        private int currentPosition;

        private boolean canRemove = false;

        /**
         * Khởi tạo dữ liệu cho iterator tại vị trí position của list.
         */
        public MyArrayListIterator(int position) {
            /* TODO */
            this.currentPosition = position - 1; // vị trí trước phần tử tiếp theo trả về
        }

        @Override
        public boolean hasNext() {
            /* TODO */
            return currentPosition + 1 < size;

        }

        @Override
        public Number next() {
            /* TODO */
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            currentPosition++;
            canRemove = true;
            return data[currentPosition];
        }

        @Override
        public void remove() {
            /* TODO */
            if (!canRemove) {
                throw new IllegalStateException("Cannot remove before next() or after remove() called.");
            }
            MyArrayList.this.remove(currentPosition);
            currentPosition--;
            canRemove = false;
        }
    }
}
