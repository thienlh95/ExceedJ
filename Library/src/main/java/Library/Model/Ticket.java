package Library.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {
	@Id
	@Column(name = "idTicket")
	@GeneratedValue(generator = "idTicket", strategy = GenerationType.IDENTITY)
	private Long idTicket;
	@Column(name = "userName")
	private String userName;
	@Column(name = "isbn")
	private String isbn;
	@Column(name = "dateBorrow")
	private String dateBorrow;
	@Column(name = "dateReturn")
	private String dateReturn;
	
	public Ticket(String userName, String isbn, String dateBorrow, String dateReturn) {
		super();
		this.userName = userName;
		this.isbn = isbn;
		this.dateBorrow = dateBorrow;
		this.dateReturn = dateReturn;
	}

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(Long idTicket) {
		this.idTicket = idTicket;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDateBorrow() {
		return dateBorrow;
	}

	public void setDateBorrow(String dateBorrow) {
		this.dateBorrow = dateBorrow;
	}

	public String getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(String dateReturn) {
		this.dateReturn = dateReturn;
	}

}
