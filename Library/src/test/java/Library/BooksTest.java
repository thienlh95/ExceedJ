package Library;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Library.Model.Books;
import Library.Repository.BooksRepository;
import Library.Service.BooksService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BooksTest {
	private static final String TITLE_BOOK = "TEST";
	private static final String GENRE = "TEST";
	private static final String AUTHOR = "TEST";
	private static final String AMOUNT = "TEST";
	private static final String PRICE = "TEST";
	private static final String PUBLISHING_YEAR = "TEST";
	private static final String SHORT_DESC = "TEST";
	private static final String ISBN = "TEST";
	@Mock
	BooksRepository repository;
	@Mock
	Books book;

	@InjectMocks
	BooksService service;

	@Before
	public void setUp() {
		book = new Books();
		book.setIsbn(ISBN);
		book.setTitleBooks(TITLE_BOOK);
		book.setAmount(AMOUNT);
		book.setAuthor(AUTHOR);
		book.setGenre(GENRE);
		book.setPrice(PRICE);
		book.setPublishingYear(PUBLISHING_YEAR);
		book.setShortDesc(SHORT_DESC);
	}

	@Test
	public void add() {
		Books b = new Books();
		b.setIsbn(ISBN);
		b.setTitleBooks(TITLE_BOOK);
		b.setAmount(AMOUNT);
		b.setAuthor(AUTHOR);
		b.setGenre(GENRE);
		b.setPrice(PRICE);
		b.setPublishingYear(PUBLISHING_YEAR);
		b.setShortDesc(SHORT_DESC);

		when(repository.save(b)).thenReturn(book);
		Books books = service.add(TITLE_BOOK, GENRE, AUTHOR, AMOUNT, PRICE, PUBLISHING_YEAR, SHORT_DESC, ISBN);
		Assert.assertEquals(TITLE_BOOK, books.getTitleBooks());
		Assert.assertEquals(GENRE, books.getGenre());
		Assert.assertEquals(AUTHOR, books.getAuthor());
		Assert.assertEquals(AMOUNT, books.getAmount());
		Assert.assertEquals(PRICE, books.getPrice());
		Assert.assertEquals(PUBLISHING_YEAR, books.getPublishingYear());
		Assert.assertEquals(ISBN, books.getIsbn());
		Assert.assertEquals(SHORT_DESC, books.getShortDesc());
	}

	@Test
	public void search() {
		
	}
}
