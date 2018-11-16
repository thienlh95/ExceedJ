package Library.Service;

import java.io.IOException;
import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Library.Model.Books;
import Library.Repository.BooksRepository;;
@Service


public class BooksService {
	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	private BooksRepository booksRepository;

	public  Iterable<Books> findAll() {
		return booksRepository.findAll();
	}
	public  List<Books> findByGenre(String Genre) {
		return booksRepository.findByGenre(Genre);
	}
	public String add(String TitleBooks, String Genre,String Author,String Amount,String Price) {
		Books Book = new Books();
		Book.setTitleBooks(TitleBooks);
		Book.setGenre(Genre);
		Book.setAuthor(Author);
		Book.setAmount(Amount);
		Book.setPrice(Price);
		booksRepository.save(Book);
		return Book.getTitleBooks()+Book.getGenre()+Book.getAuthor()+Book.getAmount()+Book.getPrice();
	}
	
	protected JsonNode parseJson(String obj) throws IOException {
		return objectMapper.readTree(obj);
	}	
}