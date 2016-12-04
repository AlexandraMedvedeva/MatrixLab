package com.company;

/**
 * Created by Alexandra on 04/12/2016.
 */

class myException extends Exception {
    public myException(Throwable e) {
        initCause(e);
    }
}

