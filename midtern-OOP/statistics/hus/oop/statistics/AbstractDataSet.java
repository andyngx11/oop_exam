package hus.oop.statistics;

public abstract class AbstractDataSet implements DataSet {
    /**
     * Phương thức kiểm tra xem index có nằm trong đoạn [0 - limit] không.
     * @param index
     * @param limit
     * @return
     */
    public boolean checkBoundaries(int index, int limit) {
        /* TODO */
        return index >= 0 && index <= limit;
    }

    /**
     * Mô tả tập dữ liệu.
     * @return mô tả tập dữ liệu theo định dạng [a1, a2, a3, ..., an].
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < toArray().length; i++) {
            if (i == toArray().length - 1) {
                sb.append(toArray()[i]);
            } else {
                sb.append(toArray()[i]).append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
