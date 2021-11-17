package com.metinkuzey.northwind.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {
    // return data, false flag and message to super method
    public ErrorDataResult(T data, String message) {
        super(data, false,message);
    }
    //only return data and false flag to super method
    public ErrorDataResult(T data) {
        super(data, false);
    }

    //only return message and false flag to super method
    public ErrorDataResult(String message) {
        super(null, false, message);
    }

    //only return false flag to super method
    public ErrorDataResult() {
        super(null, false);
    }
}
