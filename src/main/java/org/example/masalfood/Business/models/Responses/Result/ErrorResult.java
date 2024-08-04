package org.example.masalfood.Business.models.Responses.Result;

public class ErrorResult extends Result {
    public ErrorResult(String message) {
        super(false, message);
    }

    public ErrorResult() {
        super(false);
    }
}
