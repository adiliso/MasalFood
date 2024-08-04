package org.example.masalfood.Business.models.Responses.Result;

public class SuccessResult extends Result {

    public SuccessResult(String message) {
        super(true, message);
    }

    public SuccessResult() {
        super(true);
    }
}
