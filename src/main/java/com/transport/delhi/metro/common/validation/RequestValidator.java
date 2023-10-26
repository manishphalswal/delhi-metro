package com.transport.delhi.metro.common.validation;

public interface RequestValidator<T> {
    boolean validate (T t);
}
