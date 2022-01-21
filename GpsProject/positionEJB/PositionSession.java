package positionEJB;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import beans.Position;

@Stateless(name = "PositionSession")
@LocalBean
public class PositionSession implements PositionRemote, PositionLocal {
	@PersistenceContext
	private EntityManager entityManager;
	
    public PositionSession() {
    }

    @Override
	public List<Position> findAll() {
		return entityManager.createQuery("from Position").getResultList();
	}
    
    @Override
	public Position findById(Long id) {
		return entityManager.find(Position.class, id);
	}
    
	@Override
	public boolean save(Position p) {
		entityManager.persist(p);
		return true;
	}

	@Override
	public boolean deleteById(Long id) {
		Position p = findById(id);
		if (p == null) return false;
		entityManager.remove(p);
		return true;
	}

	@Override
	public boolean update(Position p) {
		if (p.getId() == null) {
			return false;
		}
		Position po = findById(p.getId());
		if (po == null) {
			return false;
		}
		po.setDate(p.getDate());
		po.setLongitude(p.getLongitude());
		po.setLatitude(p.getLatitude());
		entityManager.merge(po);
		return true;
	}

}
