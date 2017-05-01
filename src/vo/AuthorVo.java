package vo;

public class AuthorVo {

	private Long no;
	private String name;
	private String bio;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "AuthorVo [no=" + no + ", name=" + name + ", bio=" + bio + "]";
	}

}
