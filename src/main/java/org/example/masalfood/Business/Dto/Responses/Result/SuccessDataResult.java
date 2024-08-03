package org.example.masalfood.Business.Dto.Responses.Result;

public class SuccessDataResult<T> extends DataResult<T>{
    public SuccessDataResult(String message, T data) {
        super(true, message, data);
    }
    public SuccessDataResult(String message) {
        super(true, message, null);
    }

    public SuccessDataResult(T data) {
        super(true, data);
    }
}
