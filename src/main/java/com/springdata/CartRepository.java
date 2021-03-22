package com.springdata;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface CartRepository extends JpaRepository<CartEntity, String> {
	public ArrayList<CartEntity>
	findByUid(String userid);
}
