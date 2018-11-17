package Library.Service;

import Library.Model.Users;

public interface ServiceImpl {
	public String update(String a, boolean b, boolean c);
	public String add(String a, String b);
	public Users login(String a, String b);
	public int checkIsActive(String a);
	public int checkIsAdmin(String a);
}
