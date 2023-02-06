package com.Springboot.Springboot.service;

public class AgenotFoundException extends Throwable {
    public AgenotFoundException(String InvalidAge) {
        super(InvalidAge);
    }
}
