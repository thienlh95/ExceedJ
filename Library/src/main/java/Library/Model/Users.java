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
	@Size(min = 5, max = 10, message = "Name must be at least 5 characters and at most 10 characters")
	@Pattern(regexp = "[A-Za-zàâéêèìôùûçÀÂÉÊÈÌÔÙÛÇ']+(\\\\s|\\\\-[A-Z]+)*")
	@Column(unique = true, name = "userName")
	private String userName;

	@NotBlank
//	@Size(min = 5, max = 10, message = "Password must be at least 5 characters and at most 10 characters")
	@Column(name = "passWord")
	private String passWord;
	@Column(name = "role")
	private boolean role;
	@Column(name = "status")
	private boolean status;

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Users() {

	}

	public Users(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
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

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
