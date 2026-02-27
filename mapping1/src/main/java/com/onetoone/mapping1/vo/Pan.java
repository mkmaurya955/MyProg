package com.onetoone.mapping1.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAN")
public class Pan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String panCardNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPanCardNumber() {
		return panCardNumber;
	}

	public void setPanCardNumber(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}

}
