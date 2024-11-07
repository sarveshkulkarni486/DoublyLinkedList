package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.beans.EmployeeData;

public interface EmployeeService {

	int addEmployee();

	List<EmployeeData> DisplayAll();

	int addAfterPosition();

	int addBeforeEmployee();

	int addByPosition();

	boolean deleteById();

	EmployeeData searchById();

	EmployeeData searchByName();




}
