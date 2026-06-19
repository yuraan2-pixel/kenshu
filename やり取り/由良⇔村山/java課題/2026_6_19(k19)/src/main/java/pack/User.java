package pack;

import java.io.Serializable;

public class User implements Serializable {
	private int id;
	private String name;
	private String favoriteBook;
	private String detail;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFavoriteBook() {
		return this.favoriteBook;
	}

	public void setFavoriteBook(String favoriteBook) {
		this.favoriteBook = favoriteBook;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
