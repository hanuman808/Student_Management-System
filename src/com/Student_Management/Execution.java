package com.Student_Management;
import java.util.List;
import java.util.Scanner;
public class Execution {




	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int choice = 0;

	        do {
	            System.out.println("\n=== Student Management System ===");
	            System.out.println("1. Add Student");
	            System.out.println("2. View All Students");
	            System.out.println("3. View Student by ID");
	            System.out.println("4. Update Student");
	            System.out.println("5. Delete Student");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();
	            sc.nextLine(); 

	            switch (choice) {
	                case 1:
	                    Student s1 = new Student();
	                    System.out.print("Enter Name: ");
	                    s1.setStudentName(sc.nextLine());
	                    System.out.print("Enter Email: ");
	                    s1.setEmail(sc.nextLine());
	                    System.out.print("Enter Phone: ");
	                    s1.setPhone(sc.nextLong());
	                    int saveStatus = Operations.save(s1);
	                    System.out.println(saveStatus > 0 ? "Student Added Successfully" : "Error Adding Student");
	                    break;

	                case 2:
	                    List<Student> students = Operations.getAllStudents();
	                    if (students.isEmpty()) System.out.println("No students found.");
	                    else students.forEach(System.out::println);
	                    break;

	                case 3:
	                    System.out.print("Enter Student ID: ");
	                    int id = sc.nextInt();
	                    Student st = Operations.getStudentById(id);
	                    System.out.println(st != null ? st : "Student Not Found");
	                    break;

	                case 4:
	                    Student s2 = new Student();
	                    System.out.print("Enter Student ID to Update: ");
	                    s2.setId(sc.nextInt());
	                    sc.nextLine();
	                    System.out.print("Enter New Name: ");
	                    s2.setStudentName(sc.nextLine());
	                    System.out.print("Enter New Email: ");
	                    s2.setEmail(sc.nextLine());
	                    System.out.print("Enter New Phone: ");
	                    s2.setPhone(sc.nextLong());
	                    int updateStatus = Operations.UpdateStudent(s2);
	                    System.out.println(updateStatus > 0 ? "Student Updated Successfully" : "Error Updating Student");
	                    break;

	                case 5:
	                    System.out.print("Enter Student ID to Delete: ");
	                    int delId = sc.nextInt();
	                    int deleteStatus = Operations.DeleteStudent(delId);
	                    System.out.println(deleteStatus > 0 ? "Student Deleted Successfully" : "Error Deleting Student");
	                    break;

	                case 6:
	                    System.out.println("Exiting...");
	                    break;

	                default:
	                    System.out.println("Invalid Choice! Try Again.");
	            }

	        } while (choice != 6);

	        sc.close();
	    }
	}



