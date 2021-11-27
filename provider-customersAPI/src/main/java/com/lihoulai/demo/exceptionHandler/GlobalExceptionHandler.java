package com.lihoulai.demo.exceptionHandler;

import com.lihoulai.demo.dto.ErrorDto;
import com.lihoulai.demo.exception.NotFundException;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFundException.class)
    public ResponseEntity<ErrorDto> notFundExceptionHandle(NotFundException e){
        return new ResponseEntity<ErrorDto>(ErrorDto.builder().withCode("911").withMessage(e.getMessage()).
                build(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleServletException(Exception e) {
        return new ResponseEntity<ErrorDto>(ErrorDto.builder().withCode("911").withMessage(e.getMessage()).
                build(), HttpStatus.BAD_REQUEST);
    }
}
