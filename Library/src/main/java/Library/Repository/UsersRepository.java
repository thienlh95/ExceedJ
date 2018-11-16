package Library.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Library.Model.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long>, JpaRepository<Users, Long> {
	Users findByUserNameAndPassWord(String userName, String passWord);

	Users findByUserNameAndStatus(String userName, boolean status);
	
	Users findByUserNameAndRole(String userName, boolean role);
	
	Users findByUserName(String userName);
	
	List<Users> findAll();
}
