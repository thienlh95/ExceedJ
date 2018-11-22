package Library.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Library.Model.Books;
import Library.Repository.BooksRepository;
import Library.Service.BooksService;
import Library.Service.UserService;
import Library.Validator.BookFormValidator;

@RestController
@RequestMapping("/library")
public class BooksController {

	@Autowired
	private UserService userService;

	@Autowired
	private BooksService booksService;
	@Autowired
	private BooksRepository booksRepository;
	@Autowired
	private BookFormValidator bookValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(bookValidator);
	}

	@RequestMapping(value = "/{userName}/book", method = RequestMethod.POST)
	public ResponseEntity<Books> add(@Valid @RequestBody Books Book, @PathVariable("userName") String userName) {
		int check = userService.checkIsAdmin(userName);
		if (check == 1) {
			Book = booksService.add(Book.getTitleBooks(), Book.getGenre(), Book.getAuthor(), Book.getAmount(),
					Book.getPrice(), Book.getPublishingYear(), Book.getShortDesc(), Book.getIsbn());
			if (Book != null) {
				return new ResponseEntity<>(Book, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{userName}/book/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<Books> updateBook(@Valid @RequestBody Books book, @PathVariable(value = "id") long id,
			@PathVariable("userName") String userName) {
		int check = userService.checkIsAdmin(userName);
		if (check == 1) {
			book = booksRepository.save(book);
			return new ResponseEntity<>(book, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/available", method = RequestMethod.GET)
	public List<Books> getavailable() {
		return (List<Books>) booksService.findByAvailable();
	}

	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public List<Books> getBook(@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "genre", required = false) String genre,
			@RequestParam(value = "desc", required = false) String desc,
			@RequestParam(value = "author", required = false) String author,
			@RequestParam(value = "year", required = false) String year,
			@RequestParam(value = "isbn", required = false) String isbn) {
		if (title != null) {
			return (List<Books>) booksService.findByTitle(title);
		}

		if (genre != null) {
			return (List<Books>) booksService.findByGenre(genre);
		}
		if (desc != null) {
			return (List<Books>) booksService.findByDesc(desc);
		}
		if (author != null) {
			return (List<Books>) booksService.findByAuthor(author);
		}
		if (year != null) {
			return (List<Books>) booksService.findByYear(year);
		}
		if (isbn != null) {
			return (List<Books>) booksService.findByIsbn(isbn);
		}
		return (List<Books>) booksService.findAll();
	}

	@DeleteMapping("delete/book/{id}")
	public void deleteBook(@PathVariable long id) {
		booksRepository.deleteById(id);
	}

}
