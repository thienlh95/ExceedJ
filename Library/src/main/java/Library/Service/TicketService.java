package Library.Service;

import java.util.List;
import Library.Model.Ticket;

public interface TicketService {
	public String addTicket(String userName, String isbn, String dateBorrow, String dateReturn);
	public Ticket findById(Long id);
	Iterable<Ticket> findAll();

	public  List<Ticket> findByUser(String username);
	public void deleteByUser(String username, long id);
}
