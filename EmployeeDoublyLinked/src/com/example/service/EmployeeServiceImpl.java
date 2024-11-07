package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.beans.EmployeeData;
import com.example.dao.EmployeeDao;
import com.example.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDao edao;
	public EmployeeServiceImpl() {
		edao = new EmployeeDaoImpl();
	}
	
	Scanner sc = new Scanner(System.in);

	@Override
	public int addEmployee() {
		System.out.println("Enter id of an employee: ");
		int eid = sc.nextInt();
		System.out.println("Enter name of an employee: ");
		String ename = sc.next();
		EmployeeData e = new EmployeeData(eid, ename);
		return edao.addToList(e);
	}

	@Override
	public List<EmployeeData> DisplayAll() {
		return edao.getAll();
	}

	@Override
	public int addAfterPosition() {
		System.out.println("Enter id: ");
		int id = sc.nextInt();
		System.out.println("Enter name: ");
		String name =sc.next();
		EmployeeData ed = new EmployeeData(id, name);
		System.out.println("Enter id after which you want to add ");
		int key = sc.nextInt();
		return edao.addAfter(ed, key);
	}

	@Override
	public int addBeforeEmployee() {
		System.out.println("Enter id: ");
		int id = sc.nextInt();
		System.out.println("Enter name: ");
		String name =sc.next();
		EmployeeData ed = new EmployeeData(id, name);
		System.out.println("Enter id before which you want to add ");
		int key = sc.nextInt();
		return edao.addBefore(ed, key);
	}

	@Override
	public int addByPosition() {
		System.out.println("Enter id: ");
		int id = sc.nextInt();
		System.out.println("Enter name: ");
		String name =sc.next();
		EmployeeData ed = new EmployeeData(id, name);
		System.out.println("Enter pos at which you want to add ");
		int pos = sc.nextInt();
		return edao.addAtPosition(ed, pos);
	}

	@Override
	public boolean deleteById() {
		System.out.println("Enter id which you want to delete");
		int id = sc.nextInt();
		return edao.deleteEmployee(id);
	}

	@Override
	public EmployeeData searchById() {
		System.out.println("Enter id ");
		int id = sc.nextInt();
		return edao.searchEmployee(id);
	}

	@Override
	public EmployeeData searchByName() {
		System.out.println("Enter employee name you want to search: ");
		String name = sc.next();
		return edao.searchEmpName(name);
	}

}
