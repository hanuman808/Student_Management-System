package com.Student_Management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Operations {
	public static int save(Student s) {
		int status =0;
		Connection con = CreateConn.CreateDB();
		PreparedStatement p;
		try {
			p = con.prepareStatement("INSERT INTO students (studentName, email, phone) VALUES (?, ?, ?)");
		
		p.setString(1, s.getStudentName());
		p.setString(2, s.getEmail());
		p.setLong(3, s.getPhone());
		status = p.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
		
	}
	
	public static List<Student> getAllStudents() {
	    List<Student> list = new ArrayList<>();
	    String sql = "SELECT * FROM students";

	    try (Connection con = CreateConn.CreateDB();
	         PreparedStatement p = con.prepareStatement(sql);
	         ResultSet rs = p.executeQuery()) {

	        while (rs.next()) {
	            Student st = new Student();
	            st.setId(rs.getInt("id"));
	            st.setStudentName(rs.getString("studentName"));
	            st.setEmail(rs.getString("email"));
	            st.setPhone(rs.getLong("phone"));
	            list.add(st);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}

	
	public static int UpdateStudent(Student s) {
		int status =0;
		
		Connection con =  CreateConn.CreateDB();
		try {
			PreparedStatement p = con.prepareStatement("UPDATE students SET studentName=?, email=?, phone=? WHERE id=?");
			p.setString(1, s.getStudentName());
			p.setString(2, s.getEmail());
			p.setLong(3, s.getPhone());
			p.setInt(4,s.getId());
			
			
			
            status = p.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static Student getStudentById(int id) {
        Student st = null;
        String sql = "SELECT * FROM students WHERE id=?";
        try (Connection con = CreateConn.CreateDB();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    st = new Student();
                    st.setId(rs.getInt("id"));
                    st.setStudentName(rs.getString("studentName"));
                    st.setEmail(rs.getString("email"));
                    st.setPhone(rs.getLong("phone"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

	
	public static int DeleteStudent( int id ) {
		int status =0;
				Connection con = CreateConn.CreateDB();
				try {
					PreparedStatement p = con.prepareStatement("DELETE FROM STUDENTS WHERE ID=?");
					
					
					p.setInt(1, id);
					  status = p.executeUpdate();
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				} 
				return status;
		
	}

}
