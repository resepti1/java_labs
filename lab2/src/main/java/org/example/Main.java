package org.example;

public class Main {
    public static void main(String[] args) {
        int rows = 3;
        int columns = 3;
        Matrix obj1 = new Matrix(rows,columns);
        obj1.setMatrix(new double[][]{{1.5, 2, 3},
                                      {4, 5, 6},
                                      {7, 8, 9}});
        System.out.println("Matrix obj2 = new Matrix(obj1);");
        Matrix obj2 = new Matrix(obj1);
        System.out.println("obj2.showMatrix();");
        obj2.getMatrix();
        System.out.println("obj2.setMatrix");
        obj2.setMatrix(new double[][]{{1.5, 2, 3},
                                      {4, 5, 6},
                                      {0, 0, 0}});
        System.out.println("obj1.showMatrix();");
        obj1.getMatrix();
    }
}