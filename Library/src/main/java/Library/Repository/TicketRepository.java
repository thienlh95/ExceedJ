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
	//update ticket repository
//	@Query(value = "UPDATE ticket SET user_name= ?, isbn= ?,date_borrow= ?,"
//			+ "date_return= ? WHERE (user_name= :user AND id_ticket= :idticket) ",
//			  nativeQuery = true)
//	Ticket updateById(@Param("user") String user, @Param("idticket") Long idticket);
//	
	
	
	
	
	
	@Query(
			  value = "SELECT * FROM ticket t WHERE t.user_name = :username", 
			  nativeQuery = true)
	List<Ticket> findByUser(@Param("username") String username);
	
	
	@Query(
			  value = "DELETE FROM ticket t WHERE (t.user_name = :username AND t.id_ticket = :id)", 
			  nativeQuery = true)
	public Ticket deletebyUser(@Param("username")String username,@Param("id")long id);
}
