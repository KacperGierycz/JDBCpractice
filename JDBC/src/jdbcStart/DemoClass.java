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
*/

public class DemoClass {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/aliens";
		String uname = "hbstudent";
		String pass = "hbstudent";
		
		String username="Tytus";
		int userId=6;

		String query = "SELECT * FROM student;";
		String query2 = "insert into student values (" + userId + ",'"+ username +"')";
		String query3 = "insert into student values (?,?)";



		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
	//	Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(query3);
		st.setInt(1, userId);
		st.setString(2,username	);
		//ResultSet rs = st.executeQuery(query); // DDL, DML, DQL, "TCL"
		 int count=st.executeUpdate(query2); // DDL, DML, DQL, "TCL"

		 System.out.println(count + "row afected");

		
//		  String userData="";
//		  
//		  while(rs.next()) {
//		  
//		  userData= rs.getInt(1) +" " +rs.getString(2);
//		  
//		  System.out.println(userData);
//		  
//		  }
		 

		st.close();
		con.close();

	}

}
