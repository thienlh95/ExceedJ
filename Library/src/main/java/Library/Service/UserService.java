package Library.Service;

import Library.Model.Users;

public interface UserService {
	public String update(String userName, boolean admin, boolean active);
	public String add(String userName, String password);
	public Users login(String userName, String password);
	public int checkIsActive(String userName);
	public int checkIsAdmin(String userName);
	public int checkUserExist(String userName);
}
