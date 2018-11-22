package Library.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Library.Model.Users;
import Library.Service.impl.UserServiceImpl;
import Library.Validator.UsersValidator;

@Controller
@RequestMapping(value = "/library")
public class UsersController {

	@Autowired
	private UserServiceImpl usersService;

	@Autowired
	private UsersValidator usersValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(usersValidator);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Users> login(@RequestBody Users user) {

		int check = usersService.checkIsActive(user.getUserName());
		int checkIsAdmin = usersService.checkIsAdmin(user.getUserName());
		if (check == 1 && checkIsAdmin == 1) {
			user = usersService.login(user.getUserName(), user.getPassword());
			if (user != null) {
				return new ResponseEntity<>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else if (check == 1 && checkIsAdmin == 0) {
			user = usersService.login(user.getUserName(), user.getPassword());
			if (user != null) {
				return new ResponseEntity<>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/users", method = RequestMethod.PATCH)
	public ResponseEntity<Users> update(@RequestBody Users user) {
		user = usersService.update(user.getUserName(), user.isAdmin(), user.isActive());
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<Users> add(@Valid @RequestBody Users user) {
		int check = usersService.checkUserExist(user.getUserName());
		if (check != 1) {
			user = usersService.add(user.getUserName(), user.getPassword());
			if (user != null) {
				return new ResponseEntity<>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
