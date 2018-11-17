package Library.Service;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Library.Model.Users;
import Library.Repository.UsersRepository;

@Service
public class UsersService implements ServiceImpl {
	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public Users login(String userName, String password) {
		Users user = new Users();
		user = usersRepository.findByUserNameAndPassword(userName, md5(password));
		return user;

	}

	@Override
	public int checkIsActive(String userName) {
		Users user = usersRepository.findByUserNameAndIsActive(userName, true);
		if (user != null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int checkIsAdmin(String userName) {
		Users user = usersRepository.findByUserNameAndIsAdmin(userName, true);
		if (user != null) {
			return 1;
		} else {
			return 0;
		}
	}

	private String md5(String password) {
		String result = "";
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(password.getBytes());
			BigInteger bigInteger = new BigInteger(1, digest.digest());
			result = bigInteger.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String add(String userName, String password) {
		Users u = new Users();
		u.setUserName(userName);
		u.setPassword(md5(password));
		u.setAdmin(false);
		u.setActive(true);
		usersRepository.save(u);
		return u.getUserName();
	}

	@Override
	public String update(String userName, boolean admin, boolean active) {
		Users user = usersRepository.findByUserName(userName);
		user.setAdmin(admin);
		user.setActive(active);
		usersRepository.save(user);
		return user.getUserName() + user.isActive() + user.isAdmin();
	}

	protected JsonNode parseJson(String obj) throws IOException {
		return objectMapper.readTree(obj);

	}
}
