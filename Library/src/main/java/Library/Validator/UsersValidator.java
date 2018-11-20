package Library.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import Library.Model.Users;

public class UsersValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Users.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Users user = (Users) target;
		if (!user.getUserName().matches("^[a-zA-Z0-9]{8,15}")) {
			errors.rejectValue("userName", "not accept Special letter");
		}
		if (!user.getPassword().matches("^\\w{6,20}$")) {
			errors.rejectValue("password", "not accept Special letter");
		}
	}

}
