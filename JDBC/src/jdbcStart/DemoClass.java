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
		
		String url="jdbc:mysql://localhost:3306/aliens";
		String uname="root";
		String pass="Zamiec01";
		String query="SELECT * FROM aliens.student;";
		
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection(url, uname, pass);
		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		rs.next();
		String name= rs.getString("username");
		
		System.out.println(name);
		
		st.close();
		con.close();
		
	}

}
