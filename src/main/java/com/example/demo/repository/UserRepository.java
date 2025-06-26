package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	// クエリメソッド SELECT * FROM users WHERE email = ? AND password = ?;
	User findByEmailAndPassword(String email, String password);

	// SELECT * FROM users WHERE name LIKE ?
	// List<User> findByNameContaining(String keyword);
	List<User> findByNameContainingAndIdNot(String keyword, Integer id);

	// SELECT * FROM users WHERE id <> ?
	List<User> findByIdNot(Integer id);

}
