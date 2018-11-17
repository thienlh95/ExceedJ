package Library.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Library.Model.Users;
import Library.Service.UsersService;

@Controller
@RequestMapping(value="/library")
public class UsersController {

	@Autowired
	private UsersService usersService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody Users user) {

		int check = usersService.checkIsActive(user.getUserName());

		if (check == 1) {
			user = usersService.login(user.getUserName(), user.getPassword());
			if (user != null) {
				return new ResponseEntity<>(user.getUserName(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>("false", HttpStatus.NOT_FOUND);

			}
		} else {
			return new ResponseEntity<>("false", HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ResponseEntity<String> checkRole(@RequestBody Users user) {

		int check = usersService.checkIsAdmin(user.getUserName());

		if (check == 1) {
			return new ResponseEntity<>("true", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("false", HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/users", method = RequestMethod.PATCH)
	public ResponseEntity<String> update(@RequestBody Users user) {
		String result = usersService.update(user.getUserName(), user.isAdmin(), user.isActive());
		if (result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>("false", HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<String> add(@RequestBody Users user) {
		String result = usersService.add(user.getUserName(), user.getPassword());
		if (result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>("false", HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "Login";

	}
}
