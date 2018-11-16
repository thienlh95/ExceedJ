package Library.Controller;

import java.nio.channels.ReadPendingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Library.Model.Books;
//import Library.Repository.BooksRepository;
import Library.Service.BooksService;

@RestController
@RequestMapping("book")
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
	@RequestMapping("/{Genre}")
	public List<Books> getGenre(@PathVariable("Genre")final String Genre) {
		return (List<Books>)booksService.findByGenre(Genre);	
		
	}
	@RequestMapping(value ="/getall",method = RequestMethod.GET)
	public List<Books> getAll(){
		return (List<Books>)booksService.findAll();	
	}
}
