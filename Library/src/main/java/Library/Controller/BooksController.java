package Library.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Library.Model.Books;
import Library.Service.BooksService;

@Controller
public class BooksController {

	@Autowired
	private BooksService booksService; 
	@RequestMapping(value = "/addbooks", method = RequestMethod.POST)
	public ResponseEntity<String> add(@RequestBody Books Book) {
		String result = booksService.add(Book.getTitleBooks(),Book.getGenre(),Book.getAuthor(),Book.getAmount(),Book.getPrice());
		if (result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>("false", HttpStatus.NOT_FOUND);
	}
}
