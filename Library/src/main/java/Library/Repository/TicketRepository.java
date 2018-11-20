package Library.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Library.Model.Books;
import Library.Model.Ticket;

@Repository
public interface  TicketRepository extends CrudRepository<Ticket, Long>, JpaRepository<Ticket, Long>{
	@Query(value = "UPDATE ticket SET user_name= :user, isbn= :isbn,date_borrow= :dateborrow,date_return= :datereturn WHERE id_ticket= :idticket",
			  nativeQuery = true)
	Ticket updateById(@Param("user") String user,@Param("isbn") String isbn,@Param("dateborrow") 
	String dateborrow,@Param("datereturn") String datereturn,@Param("idticket") Long idticket);
	@Query(
			  value = "SELECT * FROM ticket t WHERE t.user_name = :username", 
			  nativeQuery = true)
	List<Ticket> findByUser(@Param("username") String username);
}
