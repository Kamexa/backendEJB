package beans;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Long;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Position implements Serializable {

	   
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double latitude;
	private Double longitude;
	@Temporal(TemporalType.DATE)
	private Date date;
	@ManyToOne(fetch = FetchType.EAGER)
	private Smartphone smartphones;
	private static final long serialVersionUID = 1L;

	public Position() {
		super();
	}   
	public Smartphone getSmartphones() {
		return smartphones;
	}
	public void setSmartPhones(Smartphone Smartphones) {
		this.smartphones = Smartphones;
	}
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}   
	public Double getLatitude() {
		return this.latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}   
	public Double getLongitude() {
		return this.longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}   
	public Date getDate() {
		return this.date;
	}
	public void setDate(Date date) {
		this.date = date;
	}   
}
