package hus.oop.midterm.books;

public class MyLinkedList extends MyAbstractList {
    private MyLinkedListNode head;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        /* TODO */
        head = null;
        size = 0;
    }

    /**
     * Lấy kích thước của list.
     * @return
     */
    @Override
    public int size() {
        /* TODO */
        return size;
    }

    /**
     * Lấy phần tử ở vị trí index trong list.
     * @param index
     * @return
     */
    @Override
    public Object get(int index) {
        /* TODO */
        return getNodeByIndex(index);
    }

    /**
     * Sửa phần tử ở vị trí index là payload.
     * @param payload
     * @param index
     */
    @Override
    public void set(Object payload, int index) {
        /* TODO */
        MyLinkedListNode node = new MyLinkedListNode(payload);
        MyLinkedListNode temp = getNodeByIndex(index - 1);
        node.setNext(temp.getNext().getNext());
        temp.setNext(node);
    }

    /**
     * Xóa phần tử của list ở vị trí index.
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        MyLinkedListNode node = getNodeByIndex(index - 1);
        node.setNext(node.getNext().getNext());
        size--;
    }

    /**
     * Thêm vào cuối list phần tử có dữ liệu payload.
     * @param payload
     */
    @Override
    public void append(Object payload) {
        /* TODO */
        if (size == 0) {
            head = new MyLinkedListNode(payload);
            size += 1;
            return;
        }
        MyLinkedListNode node = getNodeByIndex(size() - 1);
        MyLinkedListNode nodePayload = new MyLinkedListNode(payload);
        node.setNext(nodePayload);
        size += 1;
    }

    /**
     * Thêm vào list phần tử có dữ liệu payload ở vị trí index.
     * @param payload
     * @param index
     */
    @Override
    public void insert(Object payload, int index) {
        /* TODO */
        MyLinkedListNode node = new MyLinkedListNode(payload);
        MyLinkedListNode prev = getNodeByIndex(index - 1);
        node.setNext(prev.getNext());
        prev.setNext(node);
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator() {
        /* TODO */
        return new MyLinkedListIterator(head);
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private MyLinkedListNode getNodeByIndex(int index) {
        /* TODO */
        MyLinkedListNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }
}
