package org.example;

public class Main {
    public static void main(String[] args) {
        int rows = 2;
        int columns = 2;

        Matrix obj1 = new Matrix(rows, columns);
        obj1.setMatrix(new double[][]{{1,2},
                {3,4}});
        Matrix obj2 = new Matrix(rows, columns);
        obj2.setMatrix(new double[][]{{1,1},
                {1,1}});
        double[][] result = obj1.add(obj2);
        double[][] result2 = obj1.multiplyByNumber(10);

    }
}