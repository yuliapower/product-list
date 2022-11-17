package com.newtoninvestments.productlist.exception;


public class ProductListNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Not found 'ProductListEntity'";
    }
}
