package org.example;

import java.util.Arrays;


public class Matrix{
    private int rows;
    private int columns;
    private double[][] matrix;

    //конструктор створення пустої матриці

    public Matrix() {
        this.rows = 0;
        this.columns = 0;
        this.matrix = new double[0][0];
    }

    // конструктор створення матриці заданого розміру
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.columns = cols;
        this.matrix = new double[rows][cols];
    }

    // конструктор копіювання матриці
    public Matrix(Matrix otherMatrix) {
        this.rows = otherMatrix.rows;
        this.columns = otherMatrix.columns;
        this.matrix = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.matrix[i][j] = otherMatrix.matrix[i][j];
            }
        }
    }

    public void setMatrix(double[][] values) {

        System.out.println("---------------------------");
        System.out.println("3. Заповнити матрицю значеннями\n");

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

    public double[][] getMatrix(){
        System.out.println("Матриця:");
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------\n");
        return matrix;
    }

    public double[] getRow(int n){
        System.out.println("4. Отримати заданий рядок матриці");
        double[] row = this.matrix[n-1];
        System.out.println(n + " " + "Рядок:" + Arrays.toString(row));

        System.out.println("---------------------------\n");
        return  row;
    }

    public double[] getColumn(int n){
        System.out.println("4. Отримати заданий стовпець матриці");

        double[] column = new double[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][n-1];
        }

        System.out.println(n + " " + "Стовпець:" + Arrays.toString(column));

        System.out.println("---------------------------\n");
        return  column;
    }

    public double getElement(int n){
        System.out.println("4. Отримати заданий елемент матриці");
        int count = 0;
        double element = 0;
        for (int i = 0; i < this.rows; i++){
            for (int j = 0; j < this.columns; j++){
                if(count == n-1){
                    element = matrix[i][j];
                }
                count++;
            }
        }

        System.out.println(n + " " + "Елемент:" + element);

        System.out.println("---------------------------\n");
        return element;
    }

    public int[] getSize(){
        int colsNumber = 0;

        int rowsNumber = matrix.length;
        for (double element : matrix[0]){
            colsNumber++;
        }

        int[] size = new int[]{rowsNumber, colsNumber};
        System.out.println("5. Розмірність матриці:" + " " + Arrays.toString(size));
        System.out.println("---------------------------\n");
        return size;

    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Matrix other = (Matrix) obj;

        boolean equals = Arrays.deepEquals(this.matrix, other.matrix);
        System.out.println("6. Equals: " + equals);
        System.out.println("---------------------------\n");
        return equals;
    }

    @Override
    public int hashCode() {
        int hashcode = Arrays.deepHashCode(matrix);
        System.out.println("6. Hashcode: " + hashcode);
        System.out.println("---------------------------\n");
        return hashcode;
    }
}
