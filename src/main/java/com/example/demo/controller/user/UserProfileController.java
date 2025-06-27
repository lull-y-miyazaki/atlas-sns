// ユーザープロフィール周りの処理用Controller
package com.example.demo.controller.user;

import java.util.List;

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
public class UserProfileController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PostRepository postRepository;

	@Autowired
	private Account account;

	// マイプロフィール画面の表示
	@GetMapping("/myProfile")
	public String showMyProfile(Model model) {

		User loginUser = userRepository.findById(account.getId()).orElse(null);
		model.addAttribute("user", loginUser);

		return "users/myProfile";
	}

	// ユーザーの詳細画面の表示
	@GetMapping("/{userId}/profile")
	public String showProfile(
			@PathVariable Integer userId,
			Model model) {

		User loginUser = userRepository.findById(account.getId()).orElse(null);
		User selectUser = userRepository.findById(userId).orElse(null);

		// フォローしているかのチェック
		boolean isFollowing = false;
		if (loginUser != null && selectUser != null) {
			for (Follow follow : loginUser.getFollowings()) {
				// フォローしているユーザーに含まれているかチェック
				if (follow.getFollowee().getId().equals(selectUser.getId())) {
					isFollowing = true;
					break;
				}
			}
		}

		// Stream APIなら
		/*
		boolean isFollowing = loginUser.getFollowings().stream()
				.anyMatch(f -> f.getFollowee().getId().equals(selectUser.getId()));
		*/

		// ユーザーの投稿一覧の取得
		List<Post> postList = postRepository.findByUserIdOrderByCreatedAtDesc(userId);

		model.addAttribute("user", selectUser);
		model.addAttribute("isFollowing", isFollowing);
		model.addAttribute("postList", postList);

		return "users/profile";
	}

}
