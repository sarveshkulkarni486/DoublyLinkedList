package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.beans.EmployeeData;

public class EmployeeDaoImpl implements EmployeeDao {
	class Node {
		EmployeeData data;
		Node next;
		Node prev;
		
		public Node(EmployeeData data) {
			this.data = data;
			next = null;
			prev = null;
		}
	}
	Node head;
	public EmployeeDaoImpl() {
		head = null;
	}

	@Override
	public int addToList(EmployeeData e) {
		Node newnode = new Node(e);
		if(head==null) {
			head = newnode;
			return 1;
		}
		else {
			//for end
			Node temp = head;
			while(temp.next!=null) {
				temp = temp.next;
			}
			if(temp.data.getEid()==e.getEid()) {
				return -2;
			}
			temp.next = newnode;
			newnode.prev = temp;
			return 2;
		}
	}

	@Override
	public List<EmployeeData> getAll() {
		if(head==null) {
			return null;
		}
		else {
			Node temp = head;
			List<EmployeeData> elst = new ArrayList<EmployeeData>();
			while(temp!=null) {
				elst.add(temp.data);
				temp = temp.next;
			}
			return elst;
			
		}
	}

	@Override
	public int addAfter(EmployeeData ed, int key) {
		if(head==null) {
			return -1;
		}
		else {
			Node newnode = new Node(ed);
			Node temp = head;
			while(temp!=null && temp.data.getEid()!=key) {
				temp = temp.next;
			}
			if(temp.next==null && temp.data.getEid()==key && temp.data.getEid()!=ed.getEid()) {
				return addToList(ed);
			}
			else if(temp!=null && temp.data.getEid()==key && temp.data.getEid()!=ed.getEid()) {
				newnode.next = temp.next;
				newnode.prev = temp;
				temp.next.prev = newnode;
				temp.next = newnode;
				return 1;
			}
			else if(temp.data.getEid()==ed.getEid()) {
				return -3;
			}
			else {
				return -2;
			}
		}
	}

	@Override
	public int addBefore(EmployeeData ed, int key) {
		if(head==null) {
			return -1;
		}
		else {
			Node newnode = new Node(ed);
			Node temp = head;
			if(key == head.data.getEid() && temp.data.getEid()!=ed.getEid()) {
				newnode.next = head;
				head.prev = newnode;
				head = newnode;
				return 1;
			}
			else {
				while(temp!=null && temp.data.getEid()!=key) {
					temp = temp.next;
				}
				if(temp.next!=null && temp.data.getEid()==key && temp.data.getEid()!=ed.getEid()) {
					newnode.next = temp;
					newnode.prev = temp.prev;
					temp.prev.next = newnode;
					temp.prev = newnode;
					return 2;
				}
				else if(temp.data.getEid()==ed.getEid()) {
					return -3;
				}
				else {
					return -2;
				}
			}
		}
	}

	@Override
	public int addAtPosition(EmployeeData ed, int pos) {
		if(head == null) {
			return -1;
		}
		else {
			Node newnode = new Node(ed);
			Node temp = head;
			for(int i=0; temp!=null && i<=pos-2; i++, temp=temp.next);
			if(temp!=null) {
				//for before first position
				if(pos==1 && temp.data.getEid()!=ed.getEid()) {
					newnode.next = head;
					head.prev = newnode;
					head = newnode;
					return 1;
				}
				else if(temp.next == null && temp.data.getEid()!=ed.getEid()) {
					return addToList(ed);
					
				}
				else if(temp.data.getEid()!=ed.getEid()) {
					//adding in between
					newnode.next = temp.next;
					temp.next.prev = newnode;
					newnode.prev = temp;
					temp.next = newnode;
					return 3;
				}
				else if(temp.data.getEid()==ed.getEid()) {
					return -3;
				}
			}
			return -2;
			
		}
	}

	@Override
	public boolean deleteEmployee(int id) {
		if(head == null) {
			return false;
		}
		else {
			Node temp = head;
			while(temp!=null && temp.data.getEid()!=id) {
				temp = temp.next;
			}
			//deleting first node
			if(id == head.data.getEid()) {
				head = temp.next;
				temp.next.prev = null;
				temp.next = null;
				temp = null;
				return true;
			}
			if(temp.next == null && temp.data.getEid()==id) {
				//deleting last node;
				temp.prev.next = null;
				temp.prev = null;
				temp.next = null;
				temp= null;
				return true;
			}
			else if(temp!=null && temp.data.getEid()==id) {
				//deleting middle element
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				temp.prev = null;
				temp.next = null;
				temp = null;
				return true;
			}
		}
		return false;
	}
	@Override
	public EmployeeData searchEmployee(int id) {
		if(head==null) {
			return null;
		}
		else {
			try {
				Node temp = head;
				while(temp!=null && temp.data.getEid()!=id) {
					temp = temp.next;
				}
				if(temp.data.getEid()==id && temp.next==null) {
					return temp.data;
				}
				else if(temp.data.getEid()==id && temp.next!=null) {
					return temp.data;
				}
				if(temp.next==null && temp.data.getEid()!=id) {
					return null;
				}
			} catch(NullPointerException ne) {
				return null;
			}
			
		}
		return null;
	}

	@Override
	public EmployeeData searchEmpName(String name) {
		if(head==null) {
			return null;
		}
		else {
			try {
				Node temp = head;
				while(temp!=null && temp.data.getEname().equals(name)!=true) {
					temp = temp.next;
				}
				if(temp.data.getEname().equals(name) && temp.next==null) {
					return temp.data;
				}
				else if(temp.next!=null && temp.data.getEname().equals(name)) {
					return temp.data;
				}
			}catch(NullPointerException ne) {
				return null;
			}
			
		}
		return null;
	}
	
	

}
