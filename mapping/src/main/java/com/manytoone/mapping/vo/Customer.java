package com.manytoone.mapping.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")

public class Customer implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String custName;

    private String email;

    private String gender;
    
    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cp_fk", referencedColumnName = "id")
//    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> product;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", custName=" + custName + ", email=" + email + ", gender=" + gender
				+ ", product=" + product + "]";
	}
	public Customer(Long id, String custName, String email, String gender, List<Product> product) {
		super();
		this.id = id;
		this.custName = custName;
		this.email = email;
		this.gender = gender;
		this.product = product;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
