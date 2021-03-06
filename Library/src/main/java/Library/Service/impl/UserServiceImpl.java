package Library.Service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Library.Model.Users;
import Library.Repository.UsersRepository;
import Library.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
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
	public Users add(String userName, String password) {
		Users u = new Users();
		u.setUserName(userName);
		u.setPassword(md5(password));
		u.setAdmin(false);
		u.setActive(true);
		usersRepository.saveAndFlush(u);
		return u;
	}

	@Override
	public Users update(String userName, boolean admin, boolean active) {
		Users user = usersRepository.findByUserName(userName);
		user.setAdmin(admin);
		user.setActive(active);
		usersRepository.saveAndFlush(user);
		return user;
	}

	@Override	
	public int checkUserExist(String userName) {
		Users user = usersRepository.findByUserName(userName);
		if (user != null) {
			return 1;
		} else {
			return 0;
		}
	}
}
