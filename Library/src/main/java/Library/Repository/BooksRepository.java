package Library.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Library.Model.Books;;

@Repository
public interface 
BooksRepository extends CrudRepository<Books, Long>, JpaRepository<Books, Long> {
	
	
	List<Books> findAll();
}
