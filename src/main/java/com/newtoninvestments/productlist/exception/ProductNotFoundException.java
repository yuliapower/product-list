package com.newtoninvestments.productlist.exception;


public class ProductNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Not found 'ProductEntity'";
    }
}
