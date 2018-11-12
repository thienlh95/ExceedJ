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

	protected JsonNode parseJson(String obj) throws IOException {
		return objectMapper.readTree(obj);

	}
}
