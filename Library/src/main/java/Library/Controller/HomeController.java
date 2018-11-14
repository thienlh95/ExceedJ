package Library.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Library.Model.Users;
import Library.Service.UsersService;

@Controller
public class HomeController {

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

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResponseEntity<String> login(@RequestParam String userName, @RequestParam String passWord) {

		int check = usersService.checkStatus(userName);

		if (check == 1) {
			Users user = usersService.login(userName, passWord);
			if (user != null) {
				return new ResponseEntity<>("true", HttpStatus.OK);
			}
			return new ResponseEntity<>("false", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("false", HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ResponseEntity<String> checkRole(@RequestParam String userName) {

		int check = usersService.checkRole(userName);

		if (check == 1) {
			return new ResponseEntity<>("true", HttpStatus.OK);
		} else{
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

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<String> add(@RequestParam String userName, @RequestParam String passWord) {
		String resulrt = usersService.add(userName, passWord);
		if (resulrt != null) {
			return new ResponseEntity<>(resulrt, HttpStatus.OK);
		}
		return new ResponseEntity<>("false", HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "Login";

	}
}
