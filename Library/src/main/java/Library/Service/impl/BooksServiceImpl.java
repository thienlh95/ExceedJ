package Library.Service.impl;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Library.Model.Books;
import Library.Repository.BooksRepository;
import Library.Service.BooksService;;
@Service
public class BooksServiceImpl implements BooksService{
	@Autowired
	private BooksRepository booksRepository;

	public  Iterable<Books> findAll() {
		return booksRepository.findAll();
	}
	public  List<Books> findByGenre(String Genre) {
		return booksRepository.findByGenre(Genre);
	}
	public  List<Books> findByTitle(String title) {
		return booksRepository.findByTitle(title);
	}
	public  List<Books> findByAuthor(String author) {
		return booksRepository.findByAuthor(author);
	}
	public  List<Books> findByYear(String year) {
		return booksRepository.findByYear(year);
	}
	public  List<Books> findByDesc(String desc) {
		return booksRepository.findByDesc(desc);
	}
	public  List<Books> findByIsbn(String isbn) {
		return booksRepository.findByIsbn(isbn);
	}
	public  List<Books> findByAvailable() {
		return booksRepository.findByAvailable();
	}	
	public Books add(String TitleBooks, String Genre,String Author,String Amount,String Price, String publishingYear,String shortDesc,String isbn) {
		Books Book = new Books();
		Book.setTitleBooks(TitleBooks);
		Book.setGenre(Genre);
		Book.setAuthor(Author);
		Book.setAmount(Amount);
		Book.setPrice(Price);
		Book.setPublishingYear(publishingYear);
		Book.setShortDesc(shortDesc);
		Book.setIsbn(isbn);
		booksRepository.save(Book);
		return Book;
	}
	
}