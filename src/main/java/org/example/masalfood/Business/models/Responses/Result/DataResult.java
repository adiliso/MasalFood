package org.example.masalfood.Business.models.Responses.Result;

import lombok.Getter;

public class DataResult<T> extends Result {
    @Getter
    private T data;

    public DataResult(boolean success, String message, T data) {
        super(success, message);
        this.data = data;
    }

    public DataResult(boolean success, T data) {
        super(success);
        this.data = data;
    }

}

