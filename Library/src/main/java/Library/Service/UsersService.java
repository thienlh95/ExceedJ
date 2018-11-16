package Library.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Library.Model.Users;
import Library.Repository.UsersRepository;

@Service
public class UsersService {
	private static final String USER_NAME = "userName";
	private static final String PASS_WORD = "passWord";
	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	private UsersRepository usersRepository;

	public Users login(String json) {
		Users user = new Users();
		try {
			JsonNode node = parseJson(json);
			String userName = node.get(USER_NAME).textValue();
			String passWord = node.get(PASS_WORD).textValue();
			user = usersRepository.findByUserNameAndPassWord(userName, passWord);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}

	public Users login(String userName, String passWord) {
		Users user = new Users();
		// JsonNode node = parseJson(json);
//			String userName = node.get(USER_NAME).textValue();
//			String passWord = node.get(PASS_WORD).textValue();
		user = usersRepository.findByUserNameAndPassWord(userName, passWord);
		return user;

	}

	public int checkStatus(String userName) {
		Users user = usersRepository.findByUserNameAndStatus(userName, true);
		if (user != null) {
			return 1;
		} else {
			return 0;
		}
	}

	public int checkRole(String userName) {
		Users user = usersRepository.findByUserNameAndRole(userName, true);
		if (user != null) {
			return 1;
		} else {
			return 0;
		}
	}

	public String add(String json) {
		try {
			JsonNode node = parseJson(json);
			String userName = node.get(USER_NAME).textValue();
			String passWord = node.get(PASS_WORD).textValue();
			Users u = new Users(userName, passWord);
			usersRepository.save(u);
			return userName;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String add(String userName, String passWord) {
		Users u = new Users();
		u.setUserName(userName);
		u.setPassWord(passWord);
		u.setRole(false);
		u.setStatus(true);
		usersRepository.save(u);
		return u.getUserName();
	}

	public String update(String userName, boolean role, boolean status) {
		Users user = usersRepository.findByUserName(userName);
		user.setRole(role);
		user.setStatus(status);
		usersRepository.save(user);
		return user.getUserName() + user.isStatus() + user.isRole();
	}

	protected JsonNode parseJson(String obj) throws IOException {
		return objectMapper.readTree(obj);

	}
}
