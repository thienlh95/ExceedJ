package Library.Validator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import Library.Model.Books;
@Component
public class BookFormValidator implements Validator {
	@Override
	public boolean supports(Class<?> aClass) {
		return Books.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		Books Book = (Books) o;
		
	
			if(!Book.getTitleBooks().matches("^[a-zA-Z0-9\\s]*$"))
			{
				errors.rejectValue("TitleBooks", "not accept Special letter");
			}
				if(!Book.getAuthor().matches("^[a-zA-Z\\s]*$"))
		{
			errors.rejectValue("Author", "not accept Special letter");
		}
		if(!Book.getGenre().matches("^[a-zA-Z\\s]*$"))
		{
			errors.rejectValue("Genre", "not accept Special letter and number");
		}
		if(!Book.getAmount().matches("^[0-9]+$"))
		{
			errors.rejectValue("Amount", "Just a Number (0-9)");
		}
		if(!Book.getPrice().matches("^[0-9]+$"))
		{
			errors.rejectValue("Price", "Just a Number (0-9)");
		}
		if(!Book.getIsbn().matches("^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$")) 
		{
			errors.rejectValue("ISBN", "You Should Input Exactly Syntax");
		}
		if(!Book.getPublishingYear().matches("\\d{4}$")) 
		{
			errors.rejectValue("Year", "format year is YYYY");
		}
	}
}
