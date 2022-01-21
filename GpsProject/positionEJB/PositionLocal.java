package positionEJB;

import java.util.List;

import javax.ejb.Local;

import beans.Position;

@Local
public interface PositionLocal {
	public List<Position> findAll();
	public Position findById(Long id);
	public boolean save(Position p);
	public boolean deleteById(Long id);
	public boolean update(Position p);

}
