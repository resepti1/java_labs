package org.example;

public class Main {
    public static void main(String[] args) {
        int rows = 2;
        int columns = 2;

        Matrix obj1 = new Matrix(2, 3);
        obj1.setMatrix(new double[][]{{1,2,2},
                                    {3,1,1}});
        Matrix obj2 = new Matrix(3, 2);
        obj2.setMatrix(new double[][]{{4,2},
                {3,1},
                {1,5}});
        double[][] result = obj1.multiply(obj2);


    }
}