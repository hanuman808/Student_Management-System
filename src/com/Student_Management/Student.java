package com.Student_Management;

public class Student {
    private int id;              
	private String  studentName;
	private String email;
	private long phone;
	
	public Student() {
		
	}
	
	
	public Student(int id, String studentName, String email, long phone) {
		
		this.id = id;
		this.studentName = studentName;
		this.email = email;
		this.phone = phone;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
	

}
