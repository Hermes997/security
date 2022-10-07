package ryu.assign.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ryu.assign.security.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByUsername(String username);
	
}
