package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixTests {
    @Test
    public void setMatrix() {
        Matrix obj = new Matrix(3,3);
        obj.setMatrix(new double[][]{{1, 2, 3},
                                     {4, 5, 6},
                                     {7, 8, 9}});
        double[][] result = obj.getMatrix();
        double[][] expected = {{1, 2, 3},
                               {4, 5, 6},
                               {7, 8, 9}};
        Assertions.assertArrayEquals(expected, result);
    }
    @Test
    public void getRow() {
        Matrix obj = new Matrix(3,3);
        obj.setMatrix(new double[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}});
        double[] result = obj.getRow(2);
        double[] expected = {4,5,6};
        Assertions.assertArrayEquals(expected, result);
    }
    @Test
    public void getColumn() {
        Matrix obj = new Matrix(3,3);
        obj.setMatrix(new double[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}});
        double[] result = obj.getColumn(2);
        double[] expected = {2,5,8};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void getElement() {
        Matrix obj = new Matrix(3,3);
        obj.setMatrix(new double[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}});
        double result = obj.getElement(3);
        double expected = 3;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void getSize(){
        Matrix obj1 = new Matrix(4,5);
        obj1.setMatrix(new double[][]{{1.5, 2, 3, 1, 5},
                {4, 5, 6, 2, 5},
                {7, 8, 9, 3, 5},
                {7, 8, 9, 4, 5}});
        int[] result = obj1.getSize();
        int[] expected = {4,5};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void Equals(){
        Matrix obj1 = new Matrix(2,2);
        obj1.setMatrix(new double[][]{{1,2},
                                      {3,4}});

        Matrix obj2 = new Matrix(2,2);
        obj2.setMatrix(new double[][]{{1,2},
                {3,4}});

        boolean result = obj1.equals(obj2);
        boolean expected = true;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void Hashcode(){
        Matrix obj1 = new Matrix(2,2);
        obj1.setMatrix(new double[][]{{1,2},
                {3,4}});
        Matrix obj2 = new Matrix(2,2);
        obj2.setMatrix(new double[][]{{1,2},
                {3,4}});
        Assertions.assertEquals(obj1.hashCode(), obj2.hashCode());
    }

    @Test
    public void testSettingMatrixAfterImmutable() {
        ImmutableMatrix obj = new ImmutableMatrix();
        assertThrows(UnsupportedOperationException.class, () -> {
            obj.setMatrix(new double[][]{{1, 2}, {3, 5}});
        });
    }

    @Test
    public void add(){
        Matrix obj1 = new Matrix(2,2);
        obj1.setMatrix(new double[][]{{1,2},
                                      {3,4}});
        Matrix obj2 = new Matrix(2,2);
        obj2.setMatrix(new double[][]{{10,10},
                {10,10}});

        double[][] result = obj1.add(obj2);
        double[][] expected = new double[][]{{11,12},
                {13,14}};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void multiplyBuNumber(){
        Matrix obj1 = new Matrix(2,2);
        obj1.setMatrix(new double[][]{{1,2},
                {3,4}});

        double[][] result = obj1.multiplyByNumber(10);
        double[][] expected = new double[][]{{10,20},
                {30,40}};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void addException(){
        Matrix obj1 = new Matrix(2,2);
        obj1.setMatrix(new double[][]{{1,2},
                {3,4}});
        Matrix obj2 = new Matrix(3,2);
        obj2.setMatrix(new double[][]{{10,10},
                {10,10},
                {10,10}});
        assertThrows(IllegalArgumentException.class, () -> {
            obj1.add(obj2);
        });
    }
    @Test
    public void multiplyMatrix(){
        Matrix obj1 = new Matrix(2, 3);
        obj1.setMatrix(new double[][]{{1,2,2},
                {3,1,1}});
        Matrix obj2 = new Matrix(3, 2);
        obj2.setMatrix(new double[][]{{4,2},
                {3,1},
                {1,5}});
        double[][] result = obj1.multiply(obj2);
        double[][] expected = new double[][]{{12,14},
                {16,12}};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void multiplyMatrixException(){
        Matrix obj1 = new Matrix(2, 4);
        obj1.setMatrix(new double[][]{{1,2,2,4},
                {3,1,1,4}});
        Matrix obj2 = new Matrix(3, 2);
        obj2.setMatrix(new double[][]{{4,2},
                {3,1},
                {1,5}});
        assertThrows(IllegalArgumentException.class, () -> {
            obj1.multiply(obj2);
        });
    }

    @Test
    public void transpose(){
        Matrix obj1 = new Matrix(3, 2);
        obj1.setMatrix(new double[][]{{1,2},
                {3,4},
                {5,6}});
        double[][] result = obj1.transpose();
        double[][] expected = new double[][]{{1,3,5},
                {2,4,6}};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void diagonalMatrix(){
        int rows = 3;
        int columns = 3;

        double[] vector = new double[]{1,2,3};

        Matrix obj = Matrix.diagonalMatrix(vector, rows, columns);
        double[][] expected = new double[][]{{1,0,0},
                {0,2,0},
                {0,0,3}};
        Assertions.assertArrayEquals(expected, obj.getMatrix());
    }

    @Test
    public void IncorrectVector(){
        int rows = 3;
        int columns = 3;

        double[] vector = new double[]{1,2,3,4};
        assertThrows(IllegalArgumentException.class, () -> {
            Matrix obj = Matrix.diagonalMatrix(vector, rows, columns);
        });
    }

    @Test
    public void diagonalMatrixIncorrectSize(){
        int rows = 3;
        int columns = 4;

        double[] vector = new double[]{1,2,3};
        assertThrows(IllegalArgumentException.class, () -> {
            Matrix obj = Matrix.diagonalMatrix(vector, rows, columns);
        });
    }
    @Test
    public void identityMatrixIncorrectSize(){
        int rows = 3;
        int columns = 4;

        assertThrows(IllegalArgumentException.class, () -> {
            Matrix obj = Matrix.identityMatrix(rows, columns);
        });
    }

    @Test
    public void identityMatrix(){
        int rows = 3;
        int columns = 3;

        Matrix obj = Matrix.identityMatrix(rows,columns);

        double[][] expected = new double[][]{{1,0,0},
                {0,1,0},
                {0,0,1}};
        Assertions.assertArrayEquals(expected, obj.getMatrix());
    }

    @Test
    public void triangle(){
        int rows = 3;
        int columns = 3;

        Matrix obj = new Matrix(rows,columns);

        obj.setMatrix(new double[][]{{2,4,6},
                {8,4,9},
                {10,2,18}});
        double[][][] result = obj.triangle();
        double[][] expectedL = new double[][]{{2,4,6},
                {0,-12,-15},
                {0,0,10.5}};
        double[][] expectedU = new double[][]{{1,0,0},
                {4,1,0},
                {5,1.5,1.0}};


        Assertions.assertArrayEquals(expectedL, result[1]);
        Assertions.assertArrayEquals(expectedU, result[0]);
    }
}
