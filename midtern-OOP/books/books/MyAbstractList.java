package hus.oop.midterm.books;

public abstract class MyAbstractList implements MyList {
    /**
     * Mô tả dữ liệu của list.
     * @return mô tả list theo định dạng [a1] [a2] [a3] ... [an]
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {

            if (i != this.size() - 1) {
                s.append("[").append(this.get(i).toString()).append("]");
            } else {
                s.append("[").append(this.get(i).toString()).append("]").append(" ");
            }
        }
        return s.toString();
    }
}
