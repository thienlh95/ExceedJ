package Library.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Library.Model.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long>, JpaRepository<Users, Long> {
	Users findByUserNameAndPassword(String userName, String password);

	Users findByUserNameAndIsActive(String userName, boolean isActive);
	
	Users findByUserNameAndIsAdmin(String userName, boolean isAdmin);
	
	Users findByUserName(String userName);
	
	List<Users> findAll();
}
