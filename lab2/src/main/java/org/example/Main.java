package org.example;

public class Main {
    public static void main(String[] args) {
        int rows = 3;
        int columns = 3;

        Matrix obj1 = new Matrix(rows,columns);
        obj1.setMatrix(new double[][]{{1.5, 2, 3},
                                      {4, 5, 6},
                                      {7, 8, 9}});

        double[] row = obj1.getRow(2);
        double[] column = obj1.getColumn(2);
        double element = obj1.getElement(5);

    }
}