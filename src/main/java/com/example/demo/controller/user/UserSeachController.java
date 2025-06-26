// ユーザー検索の処理用Controller
package com.example.demo.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Follow;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserSeachController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private Account account;

	// ユーザー検索画面の表示
	@GetMapping("/search")
	public String showSearch(
			@RequestParam(name = "keyword", defaultValue = "") String keyword,
			Model model) {

		List<User> userList = null;
		if (keyword.length() > 0) {
			// キーワードが送られてきた場合はあいまい検索
			userList = userRepository.findByNameContainingAndIdNot(keyword, account.getId());
			model.addAttribute("keyword", keyword);
		} else {
			// 自分以外のユーザー取得
			userList = userRepository.findByIdNot(account.getId());
		}

		User loginUser = userRepository.findById(account.getId()).orElse(null);

		// Stream APIを使った場合

		/*
		// Stream API使用（リストを処理の流れとして扱う）
		List<User> followingUsers = loginUser.getFollowings().stream()
				// Followオブジェクトからfolloweeを取り出す
				.map(Follow::getFollowee)
				// map()で変換されたUserオブジェクトをList<User> にまとめて再構築（終端処理）
				.collect(Collectors.toList());
		*/

		// 拡張for文を使った場合
		List<User> followingUsers = new ArrayList<>();
		if (loginUser != null) {
			// ログインユーザーがフォローしているユーザーの一覧から、一件ずつ取り出して繰り返す
			for (Follow follow : loginUser.getFollowings()) {
				// Followエンティティからフォロー相手（followee）を取り出す
				User followee = follow.getFollowee();
				followingUsers.add(followee);
			}
		}

		model.addAttribute("followingUsers", followingUsers);
		model.addAttribute("userList", userList);

		return "users/search";
	}

}
