package daotest;

import java.util.List;

import dao.AuthorDao;
import vo.AuthorVo;

public class AuthorDaoTest {

	public static void main(String[] args) {
		// insertTest();
		updateTest(1L);
		selectTest();
		deleteTest(1L);
		selectTest(1L);
	
	}

	public static void insertTest() {
		AuthorVo vo = new AuthorVo();
		vo.setName("robert");
		vo.setBio("blah~bla~");

		new AuthorDao().insert(vo);
	}

	public static void selectTest() {
		List<AuthorVo> list = new AuthorDao().getList();

		for (AuthorVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void selectTest(Long no) {
		AuthorVo vo = new AuthorDao().get(no);

		System.out.println(vo);
	}

	public static void deleteTest(Long no) {
		new AuthorDao().delete(no);
	}

	public static void updateTest(Long no) {
		AuthorVo vo = new AuthorVo();
		vo.setNo(2L);
		vo.setName("robert2");
		vo.setBio("blah~bla~");

		new AuthorDao().update(vo);

	}
}
