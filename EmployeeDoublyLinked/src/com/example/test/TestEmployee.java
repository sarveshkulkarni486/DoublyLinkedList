package com.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.beans.EmployeeData;
import com.example.service.EmployeeService;
import com.example.service.EmployeeServiceImpl;

public class TestEmployee {

	public static void main(String[] args) {
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		EmployeeService eserv = new EmployeeServiceImpl();
		do {
			System.out.println("Enter your choice: ");
			System.out.println("1. Add Employee \n2.Add after an employee \n3. Add before an employee");
			System.out.println("4. Add by position \n5. Delete by eid \n6. Display All");
			System.out.println("7. Search employee by id \n8. Search by name \n9.Exit");
			choice = sc.nextInt();
			switch(choice) {
				case 1 -> {
					int res = eserv.addEmployee();
					if(res==1) {
						System.out.println("List newly created and added one employee");
					}
					else if(res==2) {
						System.out.println("Employee added at last");
					}
					else if(res==-2) {
						System.out.println("Employee already exists: ");
					}
					else {
						System.out.println("Employee not added");
					}
				}
				case 2 -> {
					int stat = eserv.addAfterPosition();
					if(stat==-1) {
						System.out.println("List is empty");
					}
					else if(stat == 1) {
						System.out.println("Employee added after key");
					}
					else if(stat==2) {
						System.out.println("Employee added at last");
					}
					else if(stat==-2) {
						System.out.println("Key not found");
					}
					else if(stat==-3) {
						System.out.println("Employee already exists");
					}
				}
				case 3 -> {
					int stat = eserv.addBeforeEmployee();
					if(stat==-1) {
						System.out.println("List is empty");
					}
					else if(stat==1) {
						System.out.println("employee added at beginning");
					}
					else if(stat==2) {
						System.out.println("Employee added at last");
					}
					else if(stat==3) {
						System.out.println("Employee added in between");
					}
					else if(stat==-3) {
						System.out.println("Employee already exists");
					}
					else if(stat==-2) {
						System.out.println("position is beyon limit");
					}
				}
				case 4 -> {
					int stat = eserv.addByPosition();
					if(stat==-1) {
						System.out.println("List is empty");
					}
					else if(stat==1) {
						System.out.println("Added employee at beginning");
					}
					else if(stat==2) {
						System.out.println("Added employee at last");
					}
					else if(stat==3){
						System.out.println("added in between");
					}
					else if(stat==-2) {
						System.out.println("position is beyond list");
					}
					else if(stat==-3) {
						System.out.println("Employee already exists");
					}
				}
				case 5 -> {
					//delete by id
					boolean res = eserv.deleteById();
					if(res) {
						System.out.println("employee deleted");
					}
					else {
						System.out.println("key not found");
					}
				}
				case 6 -> {
					List<EmployeeData> e = eserv.DisplayAll();
					if(e.size()>0) {
						System.out.println(e);
					}
					else {
						System.out.println("List is empty");
					}
					
				}
				case 7 -> {
					EmployeeData emp = eserv.searchById();
					if(emp!=null) {
						System.out.println(emp);
					}
					else {
						System.out.println("Either list is empty or id not found.");
					}
				}
				case 8 -> {
					//search by name;
					EmployeeData emp = eserv.searchByName();
					if(emp!=null) {
						System.out.println(emp);
					}
					else {
						System.out.println("Either emplyoee name not found or list is empty");
					}
				}
				case 9 -> {
					System.out.println("Thank you...");
				}
				default -> {
					System.out.println("Enter correct choice: ");
				}
			}
		}while(choice!=9);
	}

}
