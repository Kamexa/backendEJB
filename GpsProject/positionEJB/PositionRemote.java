package positionEJB;

import java.util.List;

import javax.ejb.Remote;

import beans.Position;

@Remote
public interface PositionRemote {
	public List<Position> findAll();
	public Position findById(Long id);	
	public boolean save(Position p);
	public boolean deleteById(Long id);
	public boolean update(Position p);

}
