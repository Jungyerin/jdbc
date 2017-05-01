package vo;

public class BookVo {
	
	private Long no;
	private String title;
	private Long price;
	private Long author_no;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getAuthor_no() {
		return author_no;
	}
	public void setAuthor_no(Long author_no) {
		this.author_no = author_no;
	}
	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", price=" + price + ", author_no=" + author_no + "]";
	}

	

}
