package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {

		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;

		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2.connection 하기
			String url = "jdbc:mysql://localhost:3306/employees";
			conn = DriverManager.getConnection(url, "hr", "hr");

			// 3.statement 생성
			stmt = conn.createStatement(); // import할때 java.sql로 해줘야 나중에ㅔ 확장서잉
											// 좋음

			// 4.sql문 실행
			String sql = "select dept_no,dept_name from departments";
			rs = stmt.executeQuery(sql);

			// 5.fetch row(row를 하나씩 가져오기)
			while (rs.next()) {
				String deptNo = rs.getString(1); // 첫 칼럼의 타입이 int이면 getint
													// vachar타입이면 string 등 타입을
													// 일치 시켜주는게 좋다.
				String deptName = rs.getString(2);

				System.out.println(deptNo + "," + deptName);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("JDBC Driver를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("error" + e);
			return;
		} finally {
			/* 자원정리 */
			try {
				if (rs != null) {
					rs.close();
				}

				if (stmt != null) {
					stmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
