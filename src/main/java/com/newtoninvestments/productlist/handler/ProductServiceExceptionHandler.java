package com.newtoninvestments.productlist.handler;

import com.newtoninvestments.productlist.exception.ProductAlreadyAddedToListException;
import com.newtoninvestments.productlist.exception.ProductListNotFoundException;
import com.newtoninvestments.productlist.exception.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ProductServiceExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductListNotFoundException.class)
    public String handleNotFoundException(ProductListNotFoundException exception) {

        log.trace("Caught ProductServiceException: {}", exception.toString());
        return exception.getLocalizedMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProductAlreadyAddedToListException.class)
    public String handleAlreadyAddedException(ProductAlreadyAddedToListException exception) {

        log.trace("Caught ProductServiceException: {}", exception.toString());
        return exception.getLocalizedMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public String handleNotFoundException(ProductNotFoundException exception) {

        log.trace("Caught ProductServiceException: {}", exception.toString());
        return exception.getLocalizedMessage();
    }
}
