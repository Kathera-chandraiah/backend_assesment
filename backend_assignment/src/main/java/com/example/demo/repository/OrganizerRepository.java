package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {

	boolean existsByEmail(String email);
	
	@Query("SELECT COALESCE(MAX(o.id), 0) FROM Organizer o")
	long findMaxId();

	@Query("SELECT o FROM Organizer o WHERE o.name LIKE %:q% OR o.email LIKE %:q% OR o.phone LIKE %:q%")
	Page<Organizer> search(@Param("q") String q, Pageable pageable);

}
