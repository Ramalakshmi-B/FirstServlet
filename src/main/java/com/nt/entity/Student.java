package com.nt.entity;

public class Student {
	private int stdid;
	private String stdname;


	public Student() {
	}

	public Student(int stdid, String stdname) {
		super();
		this.stdid = stdid;
		this.stdname = stdname;
	}

	public int getStdid() {
		return stdid;
	}

	public void setStdid(int stdid) {
		this.stdid = stdid;
	}

	public String getStdname() {
		return stdname;
	}

	public void setStdname(String stdname) {
		this.stdname = stdname;
	}


}
