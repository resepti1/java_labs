package org.example;

public class Main {
    public static void main(String[] args) {
        int rows = 2;
        int columns = 2;

        ImmutableMatrix obj = new ImmutableMatrix(rows,columns);
        obj.setMatrix(new double[][]{{1,2},
                {3,5}});
    }
}