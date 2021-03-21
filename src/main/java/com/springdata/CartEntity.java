package com.springdata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name="cart")
public class CartEntity {
	@Id
	@Column(name="id")
	long id;
	@Column(name="userid")
	String uid;
	@Column(name="products")
	String products;	
	public long getId() {
		return id;
	}
	public void setId(long  id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	@Override
	public String toString() {
		return "LoginEntity [uid=" + uid + ", products=" + products + "]";
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getProducts() {
		return products;
	}
	public void setProducts(String products) {
		this.products = products;
	}
	
}
