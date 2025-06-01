package hus.oop.statistics;

import java.util.Arrays;

public class BasicStatistics implements Statistics {
    private DataSet dataSet;

    /**
     * Hàm dựng khởi tạo tập dữ liệu.
     */
    public BasicStatistics() {
        /* TODO */
        this.dataSet = null;
    }

    public void setDataSet(DataSet dataSet) {
        /* TODO */
        this.dataSet = dataSet;
    }

    @Override
    public int size() {
        /* TODO */
        return this.dataSet.size();
    }

    @Override
    public double max() {
        /* TODO */
        double[] arr = dataSet.toArray();
        double max = arr[0];
        for (double item : arr) {
            if (max < item) {
                max = item;
            }
        }
        return max;
    }

    @Override
    public double min() {
        /* TODO */
        double[] arr = dataSet.toArray();
        double min = arr[0];
        for (double item : arr) {
            if (min > item) {
                min = item;
            }
        }
        return min;
    }

    @Override
    public double mean() {
        /* TODO */
        double[] arr = dataSet.toArray();
        double mean = arr[0];
        for (double item : arr) {
            mean += item;
        }
        return mean / arr.length;
    }

    @Override
    public double variance() {
        /* TODO */
        double[] arr = dataSet.toArray();
        double mean = mean();
        double variance = 0;
        for (double item : arr) {
            variance += (item - mean) * (item - mean);
        }
        return variance / arr.length;
    }

    @Override
    public AbstractDataSet rank() {
        /* TODO */
        double[] arr = dataSet.toArray();
        Arrays.sort(arr);
        AbstractDataSet dataSet1 = new ArrayDataSet();
        double temp = arr[0];
        dataSet1.append(temp);
        for (double item : arr) {
            if (temp < item) {
                temp = item;
                dataSet1.append(temp);
            }
        }
        return dataSet1;
    }

    @Override
    public double median() {
        /* TODO */
        double[] arr = dataSet.toArray();
        Arrays.sort(arr);
        if (arr.length % 2 == 1) {
            return arr[arr.length / 2];
        }
        return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
    }
}
