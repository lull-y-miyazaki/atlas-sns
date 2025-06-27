package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByUserId(Integer userId);

	// 複数のuserIdが一致する投稿を、投稿順に取得
	// SELECT * FROM posts WHERE user_id IN (?, ?, ?, ...) ORDER BY created_at DESC;
	List<Post> findByUserIdInOrderByCreatedAtDesc(List<Integer> userIds);

	List<Post> findByUserIdOrderByCreatedAtDesc(Integer userId);

}
