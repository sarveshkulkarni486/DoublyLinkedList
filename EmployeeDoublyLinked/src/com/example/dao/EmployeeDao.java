package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.beans.EmployeeData;

public interface EmployeeDao {

	int addToList(EmployeeData e);

	List<EmployeeData> getAll();

	int addAfter(EmployeeData ed, int key);

	int addBefore(EmployeeData ed, int key);

	int addAtPosition(EmployeeData ed, int pos);

	boolean deleteEmployee(int id);

	EmployeeData searchEmployee(int id);

	EmployeeData searchEmpName(String name);

}
