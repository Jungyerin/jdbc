package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.AuthorVo;

public class AuthorDao {

	private Connection getConnection() throws SQLException {

		Connection conn = null;

		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2.connection 하기
			String url = "jdbc:mysql://localhost:3306/dev?useUnicode=true&characterEncoding=utf8";
			conn = DriverManager.getConnection(url, "dev", "dev");
		} catch (ClassNotFoundException e) {
			System.out.println();
		}
		return conn;

	}

	public boolean insert(AuthorVo authorVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3.statement 준비
			String sql = "insert into author values(null,?,?)";

			pstmt = conn.prepareStatement(sql); // import할때 java.sql로 해워쟈 됨

			// 4. 바인딩
			pstmt.setString(1, authorVo.getName());
			pstmt.setString(2, authorVo.getBio());

			// 4.sql문 실행
			int count = pstmt.executeUpdate(); // 업데이트한 갯수가 나옴

			return (count == 1);

		} catch (SQLException e) {
			System.out.println("error" + e);
			return false;
		} finally {
			/* 자원정리 */
			try {

				if (pstmt != null) {
					pstmt.close();
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

	public List<AuthorVo> getList() {
		List<AuthorVo> list = new ArrayList<AuthorVo>();

		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;

		try {
			conn = getConnection();

			// 3.statement 생성
			stmt = conn.createStatement(); // import할때 java.sql로 해줘야 나중에ㅔ 확장서잉
											// 좋음

			// 4.sql문 실행
			String sql = "select no,name,bio from author";
			rs = stmt.executeQuery(sql);

			// 5.fetch row(row를 하나씩 가져오기)
			while (rs.next()) {
				Long no = rs.getLong(1); // 첫 칼럼의 타입이 int이면 getint
											// vachar타입이면 string 등 타입을
											// 일치 시켜주는게 좋다.
				String name = rs.getString(2);
				String bio = rs.getString(3);

				AuthorVo authorVo = new AuthorVo();
				authorVo.setNo(no);
				authorVo.setName(name);
				authorVo.setBio(bio);

				list.add(authorVo);

			}

			return list;
		} catch (SQLException e) {
			System.out.println("error" + e);
			return list;
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

	public AuthorVo get(Long no) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		AuthorVo authorVo = null;

		try {
			conn = getConnection();

			// 4.sql문 실행
			String sql = "select no,name,bio from author where no=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();

			// 5.fetch row(row를 하나씩 가져오기)
			if(rs.next()) {

				authorVo = new AuthorVo();
				authorVo.setNo(rs.getLong(1));
				authorVo.setName(rs.getString(2));
				authorVo.setBio(rs.getString(3));

			}

			return authorVo;
		} catch (SQLException e) {
			System.out.println("error" + e);
			return authorVo;
		} finally {
			/* 자원정리 */
			try {
				if (rs != null) {
					rs.close();
				}

				if (pstmt != null) {
					pstmt.close();
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

	public AuthorVo get(String name) {
		return null;
	}

	public boolean delete(Long no) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3.statement 준비
			String sql = "delete from author where no=?";

			pstmt = conn.prepareStatement(sql); // import할때 java.sql로 해워쟈 됨

			// 4. 바인딩
			pstmt.setLong(1, no);

			// 4.sql문 실행
			int count = pstmt.executeUpdate(); // 업데이트한 갯수가 나옴

			return (count == 1);

		} catch (SQLException e) {
			System.out.println("error" + e);
			return false;
		} finally {
			/* 자원정리 */
			try {

				if (pstmt != null) {
					pstmt.close();
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

	public boolean update(AuthorVo authorVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3.statement 준비
			String sql = "update author set name=?,bio=? where no=?";

			pstmt = conn.prepareStatement(sql); // import할때 java.sql로 해워쟈 됨

			// 4. 바인딩
			pstmt.setString(1, authorVo.getName());
			pstmt.setString(2, authorVo.getBio());
			pstmt.setLong(3, authorVo.getNo());

			// 4.sql문 실행
			int count = pstmt.executeUpdate(); // 업데이트한 갯수가 나옴

			return (count == 1);

		} catch (SQLException e) {
			System.out.println("error" + e);
			return false;
		} finally {
			/* 자원정리 */
			try {

				if (pstmt != null) {
					pstmt.close();
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
