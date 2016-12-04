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
}
