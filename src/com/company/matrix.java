package com.company;

/**
 * Created by Alexandra on 04/12/2016.
 */
import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

public class matrix implements Serializable{
    private static Random rand = new Random();

    protected int N;
    protected int M;
    protected int[][] data;

    matrix(){
    }

    public matrix(int N, int M) {
        this.N = N;
        this.M = M;
        data = new int[N][M];

    }

    private void swap(matrix A, int i, int j) {
        int keeper = A.data[i][j];
        A.data[i][j] = A.data[j][i];
        A.data[j][i] = keeper;
    }

    void fillByRandomValues() {
        fill(this);
    }

    matrix fill(matrix data) {
        for (int i = 0; i < data.N; i++) {
            for (int j = 0; j < data.M; j++) {
                data.data[i][j] = rand.nextInt(42);
            }
        }
        return data;
    }

    void print() {
        for (int i = 0; i < this.N; i++) {
            System.out.println(Arrays.toString(this.data[i]));
        }
        System.out.println();
    }

    matrix summation(matrix B) {

        if (this.N != B.N || this.M != B.M) throw new IllegalArgumentException("Sizes of matrix must be equal");

        matrix C = new matrix(this.N, this.M);

        for (int i = 0; i < this.N; i++) {
            for (int j = 0; j < this.M; j++) {
                C.data[i][j] = this.data[i][j] + B.data[i][j];
            }
        }

        return C;
    }

    matrix transposing() {
        if (this.N == this.M) {
            for (int i = 0; i < this.N; i++) {
                for (int j = i + 1; j < this.M; j++) {
                    swap(this, i, j);
                }
            }
            return this;
        } else {
            matrix TransposedMatrix = new matrix(this.M, this.N);

            for (int i = 0; i < this.N; i++) {
                for (int j = 0; j < this.M; j++) {
                    TransposedMatrix.data[j][i] = this.data[i][j];
                }
            }
            return TransposedMatrix;
        }
    }

    matrix multiplication(matrix B) {

        if (this.M != B.N) throw new IllegalArgumentException("Sizes of matrix must be equal " + this.M + " != " + B.N + "");

        matrix C = new matrix(this.N, B.M);
        int collector = 0;

        for (int i = 0; i < C.N; i++) {
            for (int j = 0; j < C.M; j++) {
                for (int k = 0; k < this.M; k++) {
                    collector += this.data[i][k] * B.data[k][j];
                }
                C.data[i][j] = collector;
                collector = 0;
            }
        }

        return C;
    }
}
