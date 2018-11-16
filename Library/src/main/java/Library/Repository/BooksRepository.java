package Library.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Library.Model.Books;;

@Repository
public interface 
BooksRepository extends CrudRepository<Books, Long>, JpaRepository<Books, Long> {
	
	@Query(
			  value = "SELECT * FROM books b WHERE b.genre like %:Genre%", 
			  nativeQuery = true)
	List<Books> findByGenre(@Param("Genre") String Genre);
	//List<Books> findAll();
}
