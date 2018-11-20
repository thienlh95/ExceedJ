package Library.Service;

import java.util.List;
import java.util.Optional;

import Library.Model.Books;
import Library.Model.Ticket;

public interface TicketService {
	public String addTicket(String userName, String isbn, String dateBorrow, String dateReturn,Long idticket);
	public Ticket findById(Long id);
	Iterable<Ticket> findAll();
	public String updateTicket(String userName, String isbn, String dateBorrow, String dateReturn,Long idticket);
	public  List<Ticket> findByUser(String username);
	//public void delete(Ticket ticket);
	//public String deleteTicket(String userName, String isbn, String dateBorrow, String dateReturn,Long idticket);
}
