package statistics;

public class MyLinkedList extends MyAbstractList {
    private MyNode top;


    // Add size
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        /* TODO */
        this.top = null;
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
        MyNode newNode = new MyNode(data);
        if (top == null) {
            top = newNode;
        } else {
            MyNode last = getNodeByIndex(size - 1);
            last.next = newNode;
            newNode.previous = last;
        }
        size++;
    }

    @Override
    public void insert(double data, int index) {
        /* TODO */
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        MyNode newNode = new MyNode(data);

        if (index == 0) {
            // Chèn vào đầu list
            newNode.next = top;
            if (top != null) {
                top.previous = newNode;
            }
            top = newNode;
        } else {
            MyNode prev = getNodeByIndex(index - 1);
            MyNode nextNode = prev.next;

            prev.next = newNode;
            newNode.previous = prev;

            newNode.next = nextNode;
            if (nextNode != null) {
                nextNode.previous = newNode;
            }
        }
        size++;
    }

    @Override
    public void remove(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        if (index == 0) {
            // Xóa node đầu
            top = top.next;
            if (top != null) {
                top.previous = null;
            }
        } else {
            MyNode nodeToRemove = getNodeByIndex(index);
            MyNode prev = nodeToRemove.previous;
            MyNode nextNode = nodeToRemove.next;

            prev.next = nextNode;
            if (nextNode != null) {
                nextNode.previous = prev;
            }
        }
        size--;
    }

    @Override
    public MyLinkedList sortIncreasing() {
        /* TODO */
        MyLinkedList sortedList = new MyLinkedList();

        // Sao chép dữ liệu ra mảng để sắp xếp
        double[] arr = new double[size];
        MyIterator it = this.iterator(0);
        for (int i = 0; i < size; i++) {
            arr[i] = it.next().doubleValue();
        }
        java.util.Arrays.sort(arr);

        // Thêm vào danh sách mới theo thứ tự đã sắp xếp
        for (double v : arr) {
            sortedList.add(v);
        }

        return sortedList;
    }

    @Override
    public int binarySearch(double data) {
        /* TODO */
        // Tìm kiếm nhị phân chỉ hiệu quả trên list đã sắp xếp
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            double midVal = getNodeByIndex(mid).data;
            if (midVal == data) {
                return mid;
            } else if (midVal < data) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator(int start) {
        /* TODO */
        if (start < 0 || start > size) {
            throw new IndexOutOfBoundsException("Start index out of bounds: " + start);
        }
        return new MyLinkedListIterator(start);
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private MyNode getNodeByIndex(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        MyNode current = top;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private class MyLinkedListIterator implements MyIterator {
        /*
         * Vị trí hiện tại của iterator trong list.
         */
        private int currentPosition;

        private MyNode currentNode;
        private boolean canRemove = false;

        /**
         * Khởi tạo cho iterator ở vị trí position trong MyLinkedList.
         * @param position
         */
        public MyLinkedListIterator(int position) {
            /* TODO */
            this.currentPosition = position - 1;
            this.currentNode = (position == 0) ? null : getNodeByIndex(position - 1);
        }

        @Override
        public boolean hasNext() {
            /* TODO */
            if (currentNode == null) {
                return top != null;
            }
            return currentNode.next != null;
        }

        @Override
        public Number next() {
            /* TODO */
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            if (currentNode == null) {
                currentNode = top;
                currentPosition = 0;
            } else {
                currentNode = currentNode.next;
                currentPosition++;
            }
            canRemove = true;
            return currentNode.data;
        }

        @Override
        public void remove() {
            /* TODO */
            if (!canRemove) {
                throw new IllegalStateException("Cannot remove before next() or after remove() called.");
            }
            MyLinkedList.this.remove(currentPosition);
            currentPosition--;
            currentNode = (currentPosition < 0) ? null : getNodeByIndex(currentPosition);
            canRemove = false;
        }
    }
}
