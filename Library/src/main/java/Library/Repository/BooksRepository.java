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
	
	
	@Query(
			  value = "SELECT * FROM books b WHERE b.author like %:author%", 
			  nativeQuery = true)
	List<Books> findByAuthor(@Param("author") String author);
	
	
	@Query(
			  value = "SELECT * FROM books b WHERE b.publishing_year like %:year%", 
			  nativeQuery = true)
	List<Books> findByYear(@Param("year") String year);
	
	
	@Query(
			  value = "SELECT * FROM books b WHERE b.title_books like %:title%", 
			  nativeQuery = true)
	List<Books> findByTitle(@Param("title") String title);
	
	
	@Query(
			  value = "SELECT * FROM books b WHERE b.short_desc like %:desc%", 
			  nativeQuery = true)
	List<Books> findByDesc(@Param("desc") String desc);
	
	
	@Query(
			  value = "SELECT * FROM books b WHERE b.amount >0", 
			  nativeQuery = true)
	List<Books> findByAvailable();
	
	
	@Query(
			  value = "SELECT * FROM books b WHERE b.amount =0", 
			  nativeQuery = true)
	List<Books> findByUnAvailable();
	@Query(
			  value = "SELECT * FROM books b WHERE b.isbn = :isbn", 
			  nativeQuery = true)
	List<Books> findByIsbn(@Param("isbn")String isbn);
	//List<Books> findAll();
}
