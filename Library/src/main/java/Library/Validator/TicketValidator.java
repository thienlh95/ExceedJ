package Library.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import Library.Model.Books;
import Library.Model.Ticket;

public class TicketValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> aClass) {
		return Ticket.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		Ticket ticket = (Ticket) o;
		
		if(!ticket.getUserName().matches("^[a-zA-Z\\s]*$"))
		{
			errors.rejectValue("username", "not accept Special letter");
		}
		if(!ticket.getIsbn().matches("^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$")) 
		{
			errors.rejectValue("ISBN", "You Should Input Exactly Syntax");
		}
		
		if(!ticket.getDateBorrow().matches("^((0|1)\\d{1})/((0|1|2)\\d{1})/((19|20)\\d{2})")) 
		{
			errors.rejectValue("dateBorrow", "format is MM/DD/YYYY");
		}
		if(!ticket.getDateReturn().matches("^((0|1)\\d{1})/((0|1|2)\\d{1})/((19|20)\\d{2})")) 
		{
			errors.rejectValue("dateReturn", "format is MM/DD/YYYY");
		}
	}
}
