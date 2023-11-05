package org.example;

public class Main {
    public static void main(String[] args) {
        int rows = 3;
        int columns = 3;

        double[] vector = new double[]{1,2,3};

        Matrix obj = Matrix.diagonalMatrix(vector, rows, columns);


    }
}