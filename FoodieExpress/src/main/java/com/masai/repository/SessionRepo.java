package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.CurrentLoginSession;


@Repository
public interface SessionRepo extends JpaRepository<CurrentLoginSession, Integer>{

	public CurrentLoginSession findByUuid(String uuid);
	
}
