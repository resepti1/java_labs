package org.example;

public class Main {
    public static void main(String[] args) {
        int rows = 4;
        int columns = 5;

        Matrix obj1 = new Matrix(rows,columns);
        obj1.setMatrix(new double[][]{{1.5, 2, 3, 1, 5},
                                      {4, 5, 6, 2, 5},
                                      {7, 8, 9, 3, 5},
                                      {7, 8, 9, 4, 5}});

        int[] size = obj1.getSize();
        Matrix obj2 = new Matrix(2,2);
        obj2.getMatrix();
        obj2.getSize();
    }
}