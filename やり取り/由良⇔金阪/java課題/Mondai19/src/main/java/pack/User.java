package pack;

public class User {
//	一目でわかるし確認する意味なしBeanやんけこれ
	private int id;
	private String name;
	private String favoriteBook;
	private String detail;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFavoriteBook() {
		return favoriteBook;
	}
	public void setFavoriteBook(String favoriteBook) {
		this.favoriteBook = favoriteBook;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
}
