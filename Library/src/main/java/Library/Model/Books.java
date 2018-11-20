package Library.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Books")
public class Books {
	
	public Books(String titleBooks, String genre, String author, String amount, String price,String publishingYear, String shortDesc, String isbn) {
		super();
		this.isbn = isbn;
		TitleBooks = titleBooks;
		Genre = genre;
		Author = author;
		Amount = amount;
		Price = price;
		this.publishingYear = publishingYear;
		this.shortDesc = shortDesc;
		
		
	}
	
	

	public Books() {}
	
	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	public String getShortDesc() {
		return shortDesc;
	}



	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	
	
	
	public String getTitleBooks() {
		return TitleBooks;
	}
	
	public void setTitleBooks(String titleBooks) {
		this.TitleBooks = titleBooks;
	}
	
	
	
	public String getGenre() {
		return Genre;
	}
	
	public void setGenre(String genre) {
		this.Genre = genre;
	}
	
	
	
	public String getAuthor() {
		return Author;
	}
	
	public void setAuthor(String author) {
		this.Author = author;
	}
	
	
	public String getAmount() {
		return Amount;
	}
	
	
	public void setAmount(String amount) {
		this.Amount = amount;
	}
	public String getPrice() {
		return Price;
	}
	
	public void setPrice(String price) {
		this.Price = price;
	}
	
	
	public String getPublishingYear() {
		return publishingYear;
	}

	public void setPublishingYear(String publishingYear) {
		this.publishingYear = publishingYear;
	}
	@Id
	@Column(name = "isbn")
	private String isbn;
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
	@Column(name = "publishingYear")
	private String publishingYear;
	@Column(name = "shortDesc")
	private String shortDesc;

}
