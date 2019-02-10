package techgig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlServerConnection {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Connection conn = null;
		try {
			// jdbc:sqlserver://127.0.0.1:1433;instance=SQLEXPRESS;databaseName=jdo;
			// server=DEVIL-PC
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=studywithdemo", "hr",
					"hr");
			if (conn != null)
				System.out.println("Database Successfully connected");
			
			Statement stmt=conn.createStatement();
			
			ResultSet rs=stmt.executeQuery("SELECT [firstname],[lastname] FROM [studywithdemo].[dbo].[student]");
			while(rs.next()) {
				System.out.println(rs.getRow()+ " - " + rs.getString(1)+ " - "+ rs.getString(2));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
