package com.app.surveyor.mappers;

public interface Mapper<T, U> {
    public U map(T t);
}
