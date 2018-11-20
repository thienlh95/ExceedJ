package Library.Controller;
import java.util.List;

//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Library.Model.Books;
import Library.Model.Ticket;
import Library.Model.Users;
import Library.Repository.TicketRepository;
import Library.Service.TicketServiceImpl;
import Library.Service.UsersServiceImpl;
import Library.Validator.BookFormValidator;
@RestController
@RequestMapping("/library")
public class TicketController {
	@Autowired
	private TicketServiceImpl ticketService;
	@Autowired
	private TicketRepository ticketRepository;
	@RequestMapping(value = "/addticket", method = RequestMethod.POST)
	
	public ResponseEntity<String> addTicket(@RequestBody Ticket ticket,BindingResult validate,BookFormValidator BookFormValidator)
	{
		BookFormValidator.validate(ticket, validate);
		if(validate.hasErrors()) 
		{
			return new ResponseEntity<>("false", HttpStatus.NOT_FOUND);
		}
		else {
		
		String result = ticketService.addTicket(ticket.getUserName(),ticket.getIsbn(),ticket.getDateBorrow(),
				ticket.getDateReturn(),ticket.getIdTicket());
		if(result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
			return new ResponseEntity<>("false", HttpStatus.NOT_FOUND);
		}
	}


	@RequestMapping("ticket/{idticket}")
	public Ticket getYear(@PathVariable("idticket")final Long idticket) {
			return ticketService.findById(idticket);
	}
	@RequestMapping(value ="/ticket",method = RequestMethod.GET)
	public Iterable<Ticket> getAll(){
		return ticketService.findAll();	
	}
	
	
	@RequestMapping(value = "{upticket/{idticket}", method = RequestMethod.PATCH)
	public ResponseEntity<String> updateTicket(@RequestBody Ticket ticket,@PathVariable(value ="idticket")long idticket)
	{
		
		String result = ticketService.updateTicket(ticket.getUserName(),ticket.getIsbn(),ticket.getDateBorrow(), ticket.getDateReturn(),ticket.getIdTicket());
		if(result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
			return new ResponseEntity<>("false", HttpStatus.NOT_FOUND);
		}
	
	
	@RequestMapping("{username}/ticket")
	public List<Ticket> getTicketByUser(@PathVariable("username")final String username) {
		return (List<Ticket>)ticketService.findByUser(username);	
		
	}
	@RequestMapping("{username}/ticket/{id}")
	public List<Ticket> deleteByUser(@PathVariable("username")final String username,@PathVariable("id")final long id) {
		if((List<Ticket>)ticketService.findByUser(username)!=null);
		{
			ticketRepository.deleteById(id);
		}
		return null;
		
	}
	@DeleteMapping("delete/ticket/{id}")
	public void deleteTicket(@PathVariable long id) {
		ticketRepository.deleteById(id);
	}
	
}