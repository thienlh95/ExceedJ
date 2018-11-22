package Library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Library.Validator.TicketValidator;
import Library.Model.Ticket;
import Library.Repository.TicketRepository;
import Library.Service.impl.TicketServiceImpl;

@RestController
@RequestMapping("/library")
public class TicketController {
	@Autowired
	private TicketServiceImpl ticketService;
	@Autowired
	private TicketRepository ticketRepository;

//	@Autowired
//	private TicketValidator ticketValidator;

//	@InitBinder("ticket")
//    public void initBinder(WebDataBinder binder) {
//        binder.setValidator(ticketValidator);
//    }
	@RequestMapping(value = "/ticket", method = RequestMethod.POST)

	public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket, BindingResult re,
			TicketValidator ticketValidator) {
		ticketValidator.validate(ticket, re);
		if (re.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			ticket = ticketService.addTicket(ticket.getUserName(), ticket.getIsbn(), ticket.getDateBorrow(),
					ticket.getDateReturn());
			if (ticket != null) {
				return new ResponseEntity<>(ticket, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "ticket/{idticket}", method = RequestMethod.GET)
	public Ticket getID(@PathVariable("idticket") final Long idticket) {
		return ticketService.findById(idticket);
	}

	@RequestMapping(value = "/ticket", method = RequestMethod.GET)
	public Iterable<Ticket> getAll() {
		return ticketService.findAll();
	}

	// Update Ticket
	@RequestMapping(value = "{username}/ticket/{idticket}", method = RequestMethod.PATCH)
	public Ticket updateTicket(@RequestBody Ticket ticket, @PathVariable("username") String username,

			@PathVariable(value = "idticket") long idticket, BindingResult re, TicketValidator ticketValidator)

	{
		ticketValidator.validate(ticket, re);
		if (re.hasErrors()) {
			return null;
		} else {
			return ticketRepository.save(ticket);
		}
	}

	@RequestMapping(value = "{username}/ticket", method = RequestMethod.GET)
	public List<Ticket> getTicketByUser(@PathVariable("username") final String username) {
		return (List<Ticket>) ticketService.findByUser(username);
	}

	@RequestMapping(value = "{username}/ticket/{id}", method = RequestMethod.DELETE)
	public void deleteByUser(@RequestBody Ticket ticket, @PathVariable("username") final String username,
			@PathVariable("id") final long id) {

		ticketRepository.delete(ticket);
	}

}