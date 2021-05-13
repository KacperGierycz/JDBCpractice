package jdbcStart;

import java.sql.*;

/*
1. import---->java.sql
2. load and register the driver--- com.mysql.Driver
3.Create connection --->Connection
4.create a statement---> Statement
5.sequre the query-->
6.proces the result-->
7.close

DAO Data Acces Object
*
*/

public class DemoClass {

	public static void main(String[] args) throws Exception {

//		String url = "jdbc:mysql://localhost:3306/aliens";
//		String uname = "hbstudent";
//		String pass = "hbstudent";
//		
//		String username="Tytus";
//		int userId=6;
//
//		String query = "SELECT * FROM student;";
//		String query2 = "insert into student values (" + userId + ",'"+ username +"')";
//		String query3 = "insert into student values (?,?)";
//
//
//
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection con = DriverManager.getConnection(url, uname, pass);
//	//	Statement st = con.createStatement();
//		PreparedStatement st = con.prepareStatement(query3);
//		st.setInt(1, userId);
//		st.setString(2,username	);
//		//ResultSet rs = st.executeQuery(query); // DDL, DML, DQL, "TCL"
//		 int count=st.executeUpdate(query); // DDL, DML, DQL, "TCL"
//
//		 System.out.println(count + "row afected");

		
//		  String userData="";
//		  
//		  while(rs.next()) {
//		  
//		  userData= rs.getInt(1) +" " +rs.getString(2);
//		  
//		  System.out.println(userData);
//		  
//		  }
		 
	

//		st.close();
//		con.close();
		
		StudentDAO dao= new  StudentDAO();		
		Student s2=new Student();
				s2.userId=11;
				s2.name="Arachna";
				dao.connect();
			//	dao.addStudent(s2);
		Student s1=dao.getStudent(1);
		dao.removeStudent(s2);
		System.out.println(s1.name);
		

	}
}
	
	class StudentDAO{
		
		String url = "jdbc:mysql://localhost:3306/aliens";
		String uname = "hbstudent";
		String pass = "hbstudent";
		
		
		Connection con=null;
		public void connect() {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				 con = DriverManager.getConnection(url, uname, pass);
		
			} catch (Exception ex) {
			System.out.println(ex);
			}		
		}
		

		public Student getStudent(int userId) {			
		
		try {
			String query = "select username from student where userId="+userId;
			Student s= new Student();
			s.userId=userId;	


			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(query);
			rs.next();
			String name = rs.getString(1);
			s.name=name;
			
			return s;
			
			} catch (Exception ex) {
			System.out.println(ex);
			}
			
			return null;
	
		}
	
		public void addStudent(Student s) {
			
			String query = "insert into Student values (?,?)";
			PreparedStatement pst;
			try {
				pst = con.prepareStatement(query);
				pst.setInt(1, s.userId);
				pst.setString(2,s.name);
				pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			
		}
		
		public void removeStudent(Student s) {
			String query = "delete from Student where userId=?";
			PreparedStatement pst;
			try {
				pst = con.prepareStatement(query);
				pst.setInt(1, s.userId);
			//	pst.setString(2,s.name);
				pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	class Student{
		
		int userId;		
		String name;
	}























