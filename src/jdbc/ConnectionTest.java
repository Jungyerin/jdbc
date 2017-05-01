package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {

	public static void main(String[] args) {
		try {
			//1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.connection 하기
			String url="jdbc:mysql://localhost:3306/employees";
			Connection conn = DriverManager.getConnection(url, "hr","hr");
			
			System.out.println("연결 성공");
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("JDBC Driver를 찾을 수 없습니다.");
		}catch (SQLException e)
		{
			System.out.println("error"+e);
		}

	}

}
