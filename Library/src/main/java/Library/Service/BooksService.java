package Library.Service;

import java.util.List;

import Library.Model.Books;

public interface BooksService {
	Iterable<Books> findAll();
	List<Books> findByGenre(String genre);
	List<Books> findByAuthor(String author);
	List<Books> findByTitle(String title);
	List<Books> findByYear(String year);
	List<Books> findByIsbn(String isbn);
	List<Books> findByAvailable();
	List<Books> findByDesc(String desc);
	public String add(String TitleBooks, String Genre,String Author,String Amount,String Price, String publishingYear,String shortDesc,String isbn);
}
