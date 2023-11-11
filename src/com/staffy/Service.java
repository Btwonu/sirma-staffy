package com.staffy;

public interface Service<T> {
    void listAll();
    T add(int id);
    T editById(int id);
    T searchById(int id);
}
