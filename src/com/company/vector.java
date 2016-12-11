package com.company;

/**
 * Created by Alexandra on 04/12/2016.
 */
public class vector extends matrix {

    vector(int N) {
        this.N = N;
        this.M = 1;
        data = new int[N][M];
    }

    vector summation(vector B) {
        vector result = new vector(B.N);

        for(int i = 0; i < result.N; i++){
            result.data[i][0] = B.data[i][0] + this.data[i][0];
        }
        return result;
    }
}
