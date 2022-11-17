package com.newtoninvestments.productlist.exception;


public class ProductAlreadyAddedToListException extends RuntimeException {

    @Override
    public String getMessage() {
        return "'Product' already added to list";
    }
}
