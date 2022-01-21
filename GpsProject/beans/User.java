package beans;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String telephone;
	@Column(nullable = false, unique = true)
	private String email;
	@Temporal(value = TemporalType.DATE)
	private Date dateN;
	@OneToMany(mappedBy = "user", targetEntity = Smartphone.class,fetch = FetchType.EAGER)
	private List<Smartphone> Smartphones;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	public User(String nom, String prenom, String telephone, String email, Date dateN,
			List<Smartphone> Smartphones) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.dateN = dateN;
		this.Smartphones = Smartphones;
	}

	public User(String nom, String prenom, String telephone, String email, Date dateN) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.dateN = dateN;
	}
	
	
	public List<Smartphone> getSmartphones() {
		return Smartphones;
	}

	public void setSmartphones(List<Smartphone> Smartphones) {
		this.Smartphones = Smartphones;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getdateN() {
		return this.dateN;
	}

	public void setdateN(Date dateN) {
		this.dateN = dateN;
	}

}
