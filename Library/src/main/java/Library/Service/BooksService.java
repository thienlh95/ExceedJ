package Library.Service;

import java.io.IOException;

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