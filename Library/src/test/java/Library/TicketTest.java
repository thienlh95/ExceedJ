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

import Library.Model.Ticket;
import Library.Repository.TicketRepository;
import Library.Service.impl.TicketServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketTest {
	private static final String USER_NAME = "TEST";
	private static final String DATE_BORROW = "TEST";
	private static final String DATE_RETURN = "TEST";
	private static final String ISBN = "TEST";
	@Mock
	TicketRepository repository;
	@Mock
	Ticket ticket;

	@InjectMocks
	TicketServiceImpl service;

	@Before
	public void setUp() {
		ticket = new Ticket();
		ticket.setIsbn(ISBN);
		ticket.setUserName(USER_NAME);
		ticket.setDateBorrow(DATE_BORROW);
		ticket.setDateReturn(DATE_RETURN);
	}

	@Test
	public void addTicket() {
		Ticket t = new Ticket();
		t.setIsbn(ISBN);
		t.setUserName(USER_NAME);
		t.setDateBorrow(DATE_BORROW);
		t.setDateReturn(DATE_RETURN);

		when(repository.save(t)).thenReturn(ticket);
		Ticket tickets = service.addTicket(USER_NAME, ISBN, DATE_BORROW, DATE_RETURN);
		Assert.assertEquals(USER_NAME, tickets.getUserName());
		Assert.assertEquals(ISBN, tickets.getIsbn());
		Assert.assertEquals(DATE_BORROW, tickets.getDateBorrow());
		Assert.assertEquals(DATE_RETURN, tickets.getDateReturn());
	}
}