package fraction1;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyListDataSet implements MyDataSet {
    private List<MyFraction> fractions;

    /**
     * Hàm dựng khởi tạo list chứa các phân số.
     */
    public MyListDataSet() {
        this.fractions = new ArrayList<>();
    }

    /**
     * Hàm dựng khởi tạo list chứa các phân số theo truyền vào.
     * @param fractions
     */
    public MyListDataSet(List<MyFraction> fractions) {
        this.fractions = new ArrayList<>();
        for (MyFraction f : fractions) {
            this.fractions.add(new MyFraction(f));
        }
    }

    @Override
    public boolean insert(MyFraction fraction, int index) {
        /* TODO */
        if (index < 0 || index > fractions.size()) {
            return false;
        }
        fractions.add(index, new MyFraction(fraction));
        return true;
    }

    @Override
    public boolean append(MyFraction fraction) {
        /* TODO */
        return fractions.add(new MyFraction(fraction));
    }

    @Override
    public MyListDataSet toSimplify() {
        /* TODO */
        List<MyFraction> simplified = new ArrayList<>();
        for (MyFraction f : fractions) {
            MyFraction copy = new MyFraction(f);
            copy.simplify();
            simplified.add(copy);
        }
        return new MyListDataSet(simplified);
    }

    public MyListDataSet sortIncreasing() {
        /* TODO */
        List<MyFraction> sorted = new ArrayList<>(fractions);
        Collections.sort(sorted, (a, b) -> {
            int cmp = a.compareTo(b);
            if (cmp != 0) return cmp;
            return Integer.compare(a.getDenominator(), b.getDenominator());
        });
        return new MyListDataSet(sorted);

    }

    public MyListDataSet sortDecreasing() {
        /* TODO */
        List<MyFraction> sorted = new ArrayList<>(fractions);
        Collections.sort(sorted, (a, b) -> {
            int cmp = b.compareTo(a);
            if (cmp != 0) return cmp;
            return Integer.compare(b.getDenominator(), a.getDenominator());
        });
        return new MyListDataSet(sorted);
    }

    @Override
    public String myDataSetToString() {
        /* TODO */
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < fractions.size(); i++) {
            sb.append(fractions.get(i).toString());
            if (i < fractions.size() - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void print() {
        /* TODO */
        System.out.println(myDataSetToString());
    }
}
