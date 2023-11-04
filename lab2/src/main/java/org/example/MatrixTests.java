package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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


}
