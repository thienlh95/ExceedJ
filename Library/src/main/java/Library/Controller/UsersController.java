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
public class UsersController {

	@Autowired
	private UsersService usersService;

//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public ResponseEntity<String> login(@RequestBody String json) {
//		Users user = usersService.login(json);
//		if (user != null) {
//			return new ResponseEntity<>("true", HttpStatus.OK);
//		}
//		return new ResponseEntity<>("false", HttpStatus.NOT_FOUND);
//	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/library", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody Users user) {

		int check = usersService.checkStatus(user.getUserName());

		if (check == 1) {
			user = usersService.login(user.getUserName(), user.getPassWord());
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

		int check = usersService.checkRole(user.getUserName());

		if (check == 1) {
			return new ResponseEntity<>("true", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("false", HttpStatus.NOT_FOUND);
		}
	}

//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public ResponseEntity<String> add(@RequestBody String json) {
//		String resulrt = usersService.add(json);
//		if (resulrt != null) {
//			return new ResponseEntity<>(resulrt, HttpStatus.OK);
//		}
//		return new ResponseEntity<>("false", HttpStatus.NOT_FOUND);
//	}

	@RequestMapping(value = "/library/users", method = RequestMethod.PATCH)
	public ResponseEntity<String> update(@RequestBody Users user) {
		String result = usersService.update(user.getUserName(), user.isRole(), user.isStatus());
		if (result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>("false", HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/library/users", method = RequestMethod.POST)
	public ResponseEntity<String> add(@RequestBody Users user) {
		String result = usersService.add(user.getUserName(), user.getPassWord());
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
