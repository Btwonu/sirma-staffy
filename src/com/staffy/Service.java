package com.staffy;

import com.staffy.staff.employee.Department;

import java.util.ArrayList;

public interface Service<T> {
    void listAll();
    T add(String[] data);
    T editById(int id);
    T searchById(int id);

    T searchByName(String name);
    ArrayList<T> searchByDepartment(String department);

    void exit();
}
