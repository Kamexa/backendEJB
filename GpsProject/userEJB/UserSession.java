package userEJB;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import beans.User;

@Stateless(name = "UserSession")
public class UserSession implements UserLocal, UserRemote{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@PermitAll
	public List<User> findAll() {
		return em.createQuery("from User").getResultList();
	}
	
	@Override
	@PermitAll
	public User findByEmail(String email) {
		List<User> allUsers = findAll();
		for (User u : allUsers) {
			if (u.getEmail().equals(email)) return u;
		}
		return null;
	}
	
	@Override
	@PermitAll
	public User findById(Long id) {
		return em.find(User.class, id);
	}
	
	@Override
	@Transactional
	@PermitAll
	public boolean save(User u) {
		em.persist(u);
		return true;
	}

	@Override
	@Transactional
	@PermitAll
	public boolean deleteById(Long id) {
		User user = em.find(User.class, id);
		em.remove(user);
		return true;
	}

	@Override
	@Transactional
	@PermitAll
	public boolean update(User u) {
		if (u.getId() == null && u.getEmail() == null) {
			return false;
		}
		if (u.getId() != null) {
			User us = em.find(User.class, u.getId());
			us.setdateN(u.getdateN());
			us.setNom(u.getNom());
			us.setPrenom(u.getPrenom());
			us.setTelephone(u.getTelephone());
			em.merge(us);
			return true;
		} else if (u.getEmail() != null) {
			User us = findByEmail(u.getEmail());
			us.setdateN(u.getdateN());
			us.setNom(u.getNom());
			us.setPrenom(u.getPrenom());
			us.setTelephone(u.getTelephone());
			em.merge(us);
			return true;
		}
		return false;
	}

}
