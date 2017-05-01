package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.AuthorVo;
import vo.BookVo;

public class BookDao {
	
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

	public boolean insert(BookVo bookVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3.statement 준비
			String sql = "insert into book values(null,?,?,?)";

			pstmt = conn.prepareStatement(sql); // import할때 java.sql로 해워쟈 됨

			// 4. 바인딩
			pstmt.setString(1, bookVo.getTitle());
			pstmt.setLong(2, bookVo.getPrice());
			pstmt.setLong(3, bookVo.getAuthor_no());

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
	
	public List<BookVo> getList() {
		List<BookVo> list = new ArrayList<BookVo>();

		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;

		try {
			conn = getConnection();

			// 3.statement 생성
			stmt = conn.createStatement(); // import할때 java.sql로 해줘야 나중에ㅔ 확장서잉
											// 좋음

			// 4.sql문 실행
			String sql = "select no,title,price,author_no from book";
			rs = stmt.executeQuery(sql);

			// 5.fetch row(row를 하나씩 가져오기)
			while (rs.next()) {
				Long no=rs.getLong(1);
				String title=rs.getString(2);
				Long price=rs.getLong(3);
				Long author_no=rs.getLong(4);				

				BookVo bookVo = new BookVo();
				
				bookVo.setNo(no);
				bookVo.setTitle(title);
				bookVo.setPrice(price);
				bookVo.setAuthor_no(author_no);

				list.add(bookVo);

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
	
	
	public BookVo get(Long no) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		BookVo bookVo = null;

		try {
			conn = getConnection();

			String sql = "select no,title,price,author_no from book where no=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();

			if(rs.next()) {

				bookVo = new BookVo();
				bookVo.setNo(rs.getLong(1));
				bookVo.setTitle(rs.getString(2));
				bookVo.setPrice(rs.getLong(3));
				bookVo.setAuthor_no(rs.getLong(4));

			}

			return bookVo;
		} catch (SQLException e) {
			System.out.println("error" + e);
			return bookVo;
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
	
	public boolean delete(Long no) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3.statement 준비
			String sql = "delete from book where no=?";

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

	public boolean update(BookVo bookVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "update book set title=?,price=?,author_no=? where no=?";

			pstmt = conn.prepareStatement(sql); // import할때 java.sql로 해워쟈 됨

			pstmt.setString(1, bookVo.getTitle());
			pstmt.setLong(2, bookVo.getPrice());
			pstmt.setLong(3, bookVo.getAuthor_no());
			pstmt.setLong(4, bookVo.getNo());

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
