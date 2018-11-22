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
	
	public Books(long id,String titleBooks, String genre, String author, String amount, String price,String publishingYear, String shortDesc, String isbn) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.titleBooks = titleBooks;
		this.genre = genre;
		this.author = author;
		this.amount = amount;
		this.price = price;
		this.publishingYear = publishingYear;
		this.shortDesc = shortDesc;
		
		
	}
	
	

	public Books() {}
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



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
		return titleBooks;
	}
	
	public void setTitleBooks(String titleBooks) {
		this.titleBooks = titleBooks;
	}
	
	
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	public String getAmount() {
		return amount;
	}
	
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	public String getPublishingYear() {
		return publishingYear;
	}

	public void setPublishingYear(String publishingYear) {
		this.publishingYear = publishingYear;
	}
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "id", strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "isbn")
	private String isbn;
	@Column(name = "titleBooks")
	private String titleBooks;
	@Column(name = "genre")
	private String genre;
	@Column(name = "author")
	private String author;
	@Column(name = "Amount")
	private String amount;
	@Column(name = "price")
	private String price;
	@Column(name = "publishingYear")
	private String publishingYear;
	@Column(name = "shortDesc")
	private String shortDesc;

}
