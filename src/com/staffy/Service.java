package com.staffy;

import com.staffy.staff.employee.Department;

public interface Service<T> {
    void listAll();
    T add(String[] data);
    T editById(int id);
    T searchById(int id);
}
