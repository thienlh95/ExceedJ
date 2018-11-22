package Library.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import Library.Model.Ticket;
@Component
public class TicketValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> aClazz) {
		return Ticket.class.isAssignableFrom(aClazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		Ticket ticket = (Ticket) o;
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
