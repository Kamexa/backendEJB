package userEJB;

import java.util.List;

import javax.ejb.Local;

import beans.User;

@Local
public interface UserLocal {
	public List<User> findAll();
	public User findByEmail(String email);
	public User findById(Long id);
	public boolean save(User u);
	public boolean deleteById(Long id);
	public boolean update(User u);
}
