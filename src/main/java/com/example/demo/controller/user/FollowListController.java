package com.example.demo.controller.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Follow;
import com.example.demo.entity.Post;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class FollowListController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private Account account;

	// フォローリスト一覧画面の表示
	@GetMapping("/{id}/followings")
	public String showFollowings(
			@PathVariable Integer id,
			Model model) {

		User user = userRepository.findById(id).orElseThrow();
		User loginUser = userRepository.findById(account.getId()).orElse(null);

		model.addAttribute("userList", user.getFollowings().stream()
				.map(Follow::getFollowee)
				.collect(Collectors.toList()));

		List<Integer> userIds = new ArrayList<>();
		for (Follow follow : loginUser.getFollowings()) {
			userIds.add(follow.getFollowee().getId());
		}
		List<Post> postList = postRepository.findByUserIdInOrderByCreatedAtDesc(userIds);

		model.addAttribute("listType", "followings");
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("postList", postList);

		return "users/followList";
	}

	// フォロワー一覧画面の表示
	@GetMapping("/{id}/followers")
	public String showFollowers(
			@PathVariable Integer id,
			Model model) {

		User user = userRepository.findById(id).orElseThrow();
		User loginUser = userRepository.findById(account.getId()).orElse(null);

		model.addAttribute("userList", user.getFollowers().stream()
				.map(Follow::getFollower)
				.collect(Collectors.toList()));

		List<Integer> userIds = new ArrayList<>();
		for (Follow follow : loginUser.getFollowers()) {
			userIds.add(follow.getFollower().getId());
		}
		List<Post> postList = postRepository.findByUserIdInOrderByCreatedAtDesc(userIds);

		model.addAttribute("listType", "followers");
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("postList", postList);

		return "users/followList";
	}

}
