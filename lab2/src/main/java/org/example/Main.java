package org.example;

public class Main {
    public static void main(String[] args) {
        int rows = 2;
        int columns = 2;

        Matrix obj1 = new Matrix(3, 2);
        obj1.setMatrix(new double[][]{{1,2},
                                      {3,4},
                                      {5,6}});
        double[][] result = obj1.transpose();

    }
}