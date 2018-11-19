package Library.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USERS")
public class Users {
	@Id
	@GeneratedValue(generator = "id", strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
//	@Size(min = 5, max = 10, message = "Name must be at least 5 characters and at most 10 characters")
//	@Pattern(regexp = "[A-Za-z‡‚ÈÍËÏÙ˘˚Á¿¬… »Ã‘Ÿ€«']+(\\\\s|\\\\-[A-Z]+)*")
	@Column(name = "userName")
	private String userName;

	@NotBlank
//	@Size(min = 5, max = 10, message = "Password must be at least 5 characters and at most 10 characters")
	@Column(name = "password")
	private String password;
	@Column(name = "isAdmin")
	private boolean isAdmin;
	@Column(name = "isActive")
	private boolean isActive;
	@Column(name = "idTicket")
	private int idTicket;
	public int getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public Users() {

	}

	public Users(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
