package org.example;

import java.util.Scanner;

public class Matrix {
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
        System.out.println("Your matrix:");
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------\n");
    }

    public double[][] getMatrix(){
        System.out.println("Your matrix:");
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return matrix;
    }

}
