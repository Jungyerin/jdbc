package daotest;

import java.util.List;

import dao.AuthorDao;
import dao.BookDao;
import vo.AuthorVo;
import vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {

		//insertTest();
		updateTest(1L);
		selectTest();
		//deleteTest(1L);
		//selectTest(1L);

	}

	public static void insertTest() {
		BookVo vo = new BookVo();
		vo.setTitle("ant");
		vo.setPrice(25000L);
		vo.setAuthor_no(2L);

		new BookDao().insert(vo);
	}

	public static void selectTest() {
		List<BookVo> list = new BookDao().getList();

		for (BookVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void selectTest(Long no) {
		BookVo vo = new BookDao().get(no);

		System.out.println(vo);
	}

	public static void deleteTest(Long no) {
		new BookDao().delete(no);
	}

	public static void updateTest(Long no) {

		BookVo vo = new BookVo();
		vo.setNo(2L);
		vo.setTitle("ant2");
		vo.setPrice(50000L);
		vo.setAuthor_no(2L);

		new BookDao().update(vo);

	}

}
