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

    public double[][] add(Matrix otherMatrix) {
        if (this.rows != otherMatrix.rows || this.columns != otherMatrix.columns) {
            throw new IllegalArgumentException("Матриці мають різний розмір");
        }

        double[][] result = new double[rows][columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result[i][j] = this.matrix[i][j] + otherMatrix.matrix[i][j];
            }
        }
        System.out.println("8. Додавання матриць: ");
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------\n");
        return result;
    }

    public double[][] multiplyByNumber(double k) {
        double[][] result = new double[rows][columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result[i][j] = this.matrix[i][j] * k;
            }
        }
        System.out.println("8. Множення матриці на скаляр: ");
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------\n");
        return result;
    }
    public double[][] multiply(Matrix otherMatrix) {
        if (this.columns != otherMatrix.rows) {
            throw new IllegalArgumentException("Кількість стовпців матриці А повинно співпадати з кількість рядків матриці Б");
        }

        double[][] result = new double[this.rows][otherMatrix.columns];
        int sum = 0;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < result[0].length; j++) {
                sum = 0;
                for (int k = 0; k < this.columns; k++){
                    sum += this.matrix[i][k] * otherMatrix.matrix[k][j];
                }
                result[i][j] = sum;
            }
        }
        System.out.println("9. Множення матриць: ");
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < otherMatrix.columns; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------\n");
        return result;
    }

    public double[][] transpose() {
        double[][] result = new double[columns][rows];
        for (int i = 0; i < this.columns; i++) {
            for (int j = 0; j < this.rows; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        System.out.println("10. Транспонована матриця: ");
        for (int i = 0; i < this.columns; i++) {
            for (int j = 0; j < this.rows; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------\n");
        return result;
    }

    public static Matrix diagonalMatrix(double[] vector, int rows, int columns) {
        Matrix obj = new Matrix(rows, columns);

        if (obj.columns != obj.rows) {
            throw new IllegalArgumentException("Матриця повинна бути квадратною.");
        }

        if (vector.length != obj.rows) {
            throw new IllegalArgumentException("Вектор неправильного розміру.");
        }

        for (int i = 0; i < obj.columns; i++) {
            for (int j = 0; j < obj.rows; j++) {
                if (i == j) {
                    obj.matrix[i][j] = vector[i];
                }
            }
        }

        System.out.println("11. Діагональна матриця: ");
        for (int i = 0; i < obj.columns; i++) {
            for (int j = 0; j < obj.rows; j++) {
                System.out.print(obj.matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------\n");
        return obj;
    }
}
