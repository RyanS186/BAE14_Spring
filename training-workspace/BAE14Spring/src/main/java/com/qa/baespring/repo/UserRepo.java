package com.qa.baespring.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.baespring.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	// @Query(value = "SELECT * FROM User WHERE username = ?1", nativeQuery=true) // With Spring, this line isn't necessary as Spring derives the query from the method name. However, for more intricate queries, this is the method.
	Optional<User> findByUsername(String username);
	
	// Find users with gmail address
	@Query(value = "SELECT * FROM User WHERE email_address LIKE '%gmail.com'", nativeQuery=true)
	List<User> findByGmail();

	// Find users 18+
	@Query(value = "SELECT * FROM User WHERE age >= 18", nativeQuery=true)
	List<User> findAdults();
	
	// Find users <18
	@Query(value = "SELECT * FROM User WHERE age < 18", nativeQuery=true)
	List<User> findChildren();
}