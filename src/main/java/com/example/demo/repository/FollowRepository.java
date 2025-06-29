package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Follow;
import com.example.demo.entity.User;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Integer> {

	Optional<Follow> findByFollowerAndFollowee(User follower, User followee);

	// フォロー数カウント
	int countByFolloweeId(Integer userId);

	// フォロワー数カウント
	int countByFollowerId(Integer userId);

}
