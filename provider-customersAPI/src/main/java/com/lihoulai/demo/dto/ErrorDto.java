package com.lihoulai.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto {
    public String code;
    public String message;
    public ErrorDto(String code,String message){
        this.code=code;
        this.message=message;
    }
    public static ErrorDtoBuilder builder(){
        return new ErrorDtoBuilder();
    }
    public static class ErrorDtoBuilder{
        public String code;
        public String message;
        public ErrorDtoBuilder withCode(final String code){
            this.code=code;
            return this;
        }
        public ErrorDtoBuilder withMessage(final String message){
            this.message=message;
            return this;
        }
        public ErrorDto build(){
            return new ErrorDto(code,message);
        }
    }
}
