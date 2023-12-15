package org.example;

public class ImmutableMatrix extends Matrix {
    private int rows;
    private int columns;
    private double[][] matrix;
    public ImmutableMatrix(int rows, int columns) {
        super(rows, columns);
    }
    public ImmutableMatrix() {
        super();
    }

    public ImmutableMatrix(Matrix otherMatrix) {
        super(otherMatrix);
    }

    public ImmutableMatrix(double[][] values) {
        this.rows = values.length;
        this.columns = values[0].length;
        this.matrix = new double[this.rows][this.columns];

        for (int i = 0; i < this.rows; i++){
            for (int j = 0; j < this.columns; j++){
                matrix[i][j] = values[i][j];
            }
        }
        System.out.println("Матриця:");
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------\n");
    }

    @Override
    public void setMatrix(double[][] values) {
        throw new UnsupportedOperationException("Метод setMatrix не підтримується в ImmutableMatrix");
    }
}
