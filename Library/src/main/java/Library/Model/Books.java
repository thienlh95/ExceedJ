package Library.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Books")
public class Books {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitleBooks() {
		return TitleBooks;
	}
	public void setTitleBooks(String titleBooks) {
		TitleBooks = titleBooks;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String menre) {
		Genre = Genre;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	@Id
	@GeneratedValue(generator = "id", strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "TitleBooks")
	private String TitleBooks;
	@Column(name = "Genre")
	private String Genre;
	@Column(name = "Author")
	private String Author;
	@Column(name = "Amount")
	private String Amount;
	@Column(name = "Price")
	private String Price;
}
