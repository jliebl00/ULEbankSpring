package es.unileon.ulebank.domain.office;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "office")
public class Office implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Id of the office
	 */
	private String idOffice;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/**
	 * The address of the office
	 */
	private String address;
	private Double balance;
	private Double utilitiesCost;
	private Double localCost;
	private Double employeeCost;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdOffice() {
		return idOffice;
	}

	public void setIdOffice(String idOffice) {
		this.idOffice = idOffice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getUtilitiesCost() {
		return utilitiesCost;
	}

	public void setUtilitiesCost(Double utilitiesCost) {
		this.utilitiesCost = utilitiesCost;
	}

	public Double getLocalCost() {
		return localCost;
	}

	public void setLocalCost(Double localCost) {
		this.localCost = localCost;
	}

	public Double getEmployeeCost() {
		return employeeCost;
	}

	public void setEmployeeCost(Double employeeCost) {
		this.employeeCost = employeeCost;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Address: " + address + ";");
		buffer.append("Balance: " + this.getBalance());
		buffer.append("Utilities costs: " + this.getUtilitiesCost());
		buffer.append("Local costs: " + this.getLocalCost());
		buffer.append("Employee costs: " + this.getEmployeeCost());
		return buffer.toString();
	}

}
