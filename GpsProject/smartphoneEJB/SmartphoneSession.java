package smartphoneEJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import beans.Smartphone;
import beans.User;

@Stateless
public class SmartphoneSession implements SmartphoneLocal, SmartphoneRemote {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Smartphone> findAll() {
		Query query = em.createQuery("select s from Smartphone s");
		return query.getResultList();
	}

	@Override
	public Smartphone findByRef(String ref) {
		for (Smartphone s : findAll()) {
			if (s.getRef().equals(ref)) {
				return s;
			}
		}
		return null;
	}
	
	@Override
	public Smartphone findById(Long id) {
		return em.find(Smartphone.class, id);
	}
	
	@Override
	public boolean deleteById(Long id) {
		Smartphone sm = em.find(Smartphone.class, id);
		em.remove(sm);
		return true;
	}

	@Override
	public boolean update(Smartphone s) {
		if (s.getRef() == null && s.getId() == null ) {
			return false;
		}
		if (s.getId() != null) {
			Smartphone sp = em.find(Smartphone.class, s.getId());
			sp.setUser(s.getUser());
			sp.setName(s.getName());
			sp.setMarque(s.getMarque());
			em.merge(sp);
			return true;
		} else if (s.getRef() != null) {
			Smartphone sp = findByRef(s.getRef());
			sp.setUser(s.getUser());
			sp.setName(s.getName());
			sp.setMarque(s.getMarque());
			em.merge(sp);
			return true;
		}
		return false;
	}

	@Override
	public boolean save(Smartphone s) {
		if (s.getUser() != null) {
			User u = em.getReference(User.class, s.getUser().getId());
			s.setUser(u);
			em.persist(s);
			return true;
		}
		em.persist(s);
		return true;
	}
	
}