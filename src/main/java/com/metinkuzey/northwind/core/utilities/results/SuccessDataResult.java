package com.metinkuzey.northwind.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {
    // return data, true flag and message to super method
    public SuccessDataResult(T data, String message) {
        super(data, true,message);
    }
    //only return data and true flag to super method
    public SuccessDataResult(T data) {
        super(data, true);
    }

    //only return message and true flag to super method
    public SuccessDataResult(String message) {
        super(null, true, message);
    }

    //only return true flag to super method
    public SuccessDataResult() {
        super(null, true);
    }
}
