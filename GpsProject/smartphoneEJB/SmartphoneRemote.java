package smartphoneEJB;

import java.util.List;

import javax.ejb.Remote;

import beans.Smartphone;

@Remote
public interface SmartphoneRemote {
	public List<Smartphone> findAll();
	public Smartphone findByRef(String ref);
	public Smartphone findById(Long id);
	public boolean deleteById(Long id);
	public boolean update(Smartphone s);
	public boolean save(Smartphone s);
}
