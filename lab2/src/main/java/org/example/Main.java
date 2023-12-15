package org.example;

import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {
        int rows = 3;
        int columns = 3;

        Matrix obj = new Matrix(rows,columns);

        obj.setMatrix(new double[][]{{2,4,6},
                                     {8,4,9},
                                     {10,2,18}});

        double[][][] result = obj.triangle();
    }
}