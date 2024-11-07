package com.example.beans;

public class EmployeeData {
	private int eid;
	private String ename;
	public EmployeeData() {
		super();
	}
	public EmployeeData(int eid, String ename) {
		super();
		this.eid = eid;
		this.ename = ename;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	@Override
	public String toString() {
		return "EmployeeData [eid=" + eid + ", ename=" + ename + "]";
	}
	

}
