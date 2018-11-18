package Library.Controller;

//import java.nio.channels.ReadPendingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
import Library.Validator.BookFormValidator;
//import Library.Validator.BookFormValidator;

@RestController
@RequestMapping("library/book")
public class BooksController {

	@Autowired
	private BooksService booksService; 
	
	@RequestMapping(value = "/addbooks", method = RequestMethod.POST)
	public ResponseEntity<String> add(@RequestBody Books Book,BindingResult result,BookFormValidator BookFormValidator) {
		BookFormValidator.validate(Book, result);
		if(result.hasErrors()) 
		{
			return new ResponseEntity<>("false", HttpStatus.NOT_FOUND);
		}
		else {
		String result1 = booksService.add(Book.getTitleBooks(),Book.getGenre(),Book.getAuthor(),Book.getAmount(),Book.getPrice(),Book.getPublishingYear(),Book.getShortDesc(),Book.getIsbn());
		if (result != null) {
			return new ResponseEntity<>(result1, HttpStatus.OK);
		}
			return new ResponseEntity<>("false", HttpStatus.NOT_FOUND);
		}
	}
	
	
	@RequestMapping("genre/{Genre}")
	public List<Books> getGenre(@PathVariable("Genre")final String Genre) {
		return (List<Books>)booksService.findByGenre(Genre);	
		
	}
	@RequestMapping("author/{author}")
	public List<Books> getAuthor(@PathVariable("author")final String author) {
		return (List<Books>)booksService.findByAuthor(author);	
		
	}
	@RequestMapping("year/{year}")
	public List<Books> getYear(@PathVariable("year")final String year) {
		return (List<Books>)booksService.findByYear(year);	
		
	}
	@RequestMapping("desc/{desc}")
	public List<Books> getDesc(@PathVariable("desc")final String desc) {
		return (List<Books>)booksService.findByDesc(desc);	
		
	}
	@RequestMapping(value ="/getavailable",method = RequestMethod.GET)
	public List<Books> getavailable(){
		return (List<Books>)booksService.findByAvailable();	
	}
	@RequestMapping(value ="/getunavailable",method = RequestMethod.GET)
	public List<Books> getunavailable(){
		return (List<Books>)booksService.findByUnAvailable();
	}
	@RequestMapping("title/{title}")
	public List<Books> getTitle(@PathVariable("title")final String title) {
		return (List<Books>)booksService.findByTitle(title);	
		
	}
	@RequestMapping(value ="/getall",method = RequestMethod.GET)
	public List<Books> getAll(){
		return (List<Books>)booksService.findAll();	
	}
}
