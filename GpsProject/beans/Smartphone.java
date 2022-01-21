package beans;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

@Entity
public class Smartphone implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String ref;
	private String name;
	private String marque;
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	@OneToMany(targetEntity = Position.class, mappedBy = "smartphones",fetch = FetchType.EAGER)
	private List<Position> position;
	private static final long serialVersionUID = -558553967080513790L;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Position> getPosition() {
		return position;
	}
	public void setPosition(List<Position> position) {
		this.position = position;
	}
	public Smartphone( String ref, String name, String marque, User user) {
		super();
		this.ref = ref;
		this.name = name;
		this.marque = marque;
		this.user = user;
	}
	public Smartphone() {
		super();
	}
}
