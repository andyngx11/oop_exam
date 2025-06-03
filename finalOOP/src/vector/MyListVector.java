package vector;

import java.util.List;
import java.util.ArrayList;


public class MyListVector extends MyAbstractVector {
    private List<Double> data;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyListVector() {
        /* TODO */
        this.data = new ArrayList<>();
    }

    @Override
    public int size() {
        /* TODO */
        return this.data.size();
    }

    @Override
    public double coordinate(int index) {
        /* TODO */
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return data.get(index);
    }

    @Override
    public double[] coordinates() {
        /* TODO */
        double[] result = new double[data.size()];
        for (int i = 0; i < data.size(); i++) {
            result[i] = data.get(i);
        }
        return result;
    }

    @Override
    public MyListVector insert(double value) {
        /* TODO */
        data.add(value);
        return this;
    }

    @Override
    public MyListVector insert(double value, int index) {
        /* TODO */
        if (index < 0 || index > data.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        data.add(index, value);
        return this;
    }

    @Override
    public MyListVector remove(int index) {
        /* TODO */
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        data.remove(index);
        return this;
    }

    @Override
    public MyListVector extract(int[] indices) {
        /* TODO */
        MyListVector result = new MyListVector();
        for (int index : indices) {
            if (index < 0 || index >= data.size()) {
                throw new IndexOutOfBoundsException("Invalid index in extract: " + index);
            }
            result.insert(data.get(index));
        }
        return result;
    }

    @Override
    public void set(double value, int index) {
        /* TODO */
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        data.set(index, value);
    }

    @Override
    public MyListVector add(double value) {
        /* TODO */
        MyListVector result = new MyListVector();
        for (double v : data) {
            result.insert(v + value);
        }
        return result;
    }

    @Override
    public MyListVector add(MyVector another) {
        /* TODO */
        if (another.size() != this.size()) {
            throw new IllegalArgumentException("Vectors must be of same size to add.");
        }
        MyListVector result = new MyListVector();
        for (int i = 0; i < data.size(); i++) {
            result.insert(data.get(i) + another.coordinate(i));
        }
        return result;
    }

    @Override
    public MyListVector addTo(double value) {
        /* TODO */
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) + value);
        }
        return this;
    }

    @Override
    public MyListVector addTo(MyVector another) {
        /* TODO */
        if (another.size() != this.size()) {
            throw new IllegalArgumentException("Vectors must be of same size to add.");
        }
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) + another.coordinate(i));
        }
        return this;
    }

    @Override
    public MyListVector minus(double value) {
        /* TODO */
        MyListVector result = new MyListVector();
        for (double v : data) {
            result.insert(v - value);
        }
        return result;
    }

    @Override
    public MyListVector minus(MyVector another) {
        /* TODO */
        if (another.size() != this.size()) {
            throw new IllegalArgumentException("Vectors must be of same size to subtract.");
        }
        MyListVector result = new MyListVector();
        for (int i = 0; i < data.size(); i++) {
            result.insert(data.get(i) - another.coordinate(i));
        }
        return result;
    }

    @Override
    public MyListVector minusFrom(double value) {
        /* TODO */
        for (int i = 0; i < data.size(); i++) {
            data.set(i, value - data.get(i));
        }
        return this;
    }

    @Override
    public MyListVector minusFrom(MyVector another) {
        /* TODO */
        if (another.size() != this.size()) {
            throw new IllegalArgumentException("Vectors must be of same size to subtract.");
        }
        for (int i = 0; i < data.size(); i++) {
            data.set(i, another.coordinate(i) - data.get(i));
        }
        return this;
    }

    @Override
    public double dot(MyVector another) {
        /* TODO */
        if (another.size() != this.size()) {
            throw new IllegalArgumentException("Vectors must be of same size to calculate dot product.");
        }
        double sum = 0;
        for (int i = 0; i < data.size(); i++) {
            sum += data.get(i) * another.coordinate(i);
        }
        return sum;
    }

    @Override
    public MyListVector pow(double power) {
        /* TODO */
        for (int i = 0; i < data.size(); i++) {
            data.set(i, Math.pow(data.get(i), power));
        }
        return this;
    }

    @Override
    public MyListVector scale(double value) {
        /* TODO */
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) * value);
        }
        return this;
    }

    @Override
    public double norm() {
        /* TODO */
        double sum = 0;
        for (double v : data) {
            sum += v * v;
        }
        return Math.sqrt(sum);
    }
}
