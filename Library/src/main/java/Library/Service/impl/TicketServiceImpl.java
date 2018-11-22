package Library.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Library.Model.Ticket;
import Library.Repository.TicketRepository;
@Service
public class TicketServiceImpl implements TicketService{
	@Autowired
	private TicketRepository ticketRepository;
	@Override
	public String addTicket(String userName, String isbn, String dateBorrow, String dateReturn) {
		Ticket ticket = new Ticket();
		ticket.setUserName(userName);
		ticket.setIsbn(isbn);
		ticket.setDateBorrow(dateBorrow);
		ticket.setDateReturn(dateReturn);
		ticketRepository.save(ticket);
		return ticket.getIdTicket()+ticket.getUserName()+ticket.getIsbn()+ticket.getDateBorrow()+ticket.getDateReturn();
	}
	public Ticket findById(Long id)
	{
		Ticket ticket =  ticketRepository.findById(id).get();
		return ticket;
	}
	public  Iterable<Ticket> findAll() {
		return ticketRepository.findAll();
	}
	
	public  List<Ticket> findByUser(String username) {
		return ticketRepository.findByUser(username);
	}
	public void deleteByUser(String username,long id) {
		ticketRepository.deletebyUser(username, id);
	}
	
}
