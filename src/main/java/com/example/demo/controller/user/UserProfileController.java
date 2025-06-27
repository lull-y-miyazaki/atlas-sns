// ユーザープロフィール周りの処理用Controller
package com.example.demo.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserProfileController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private Account account;

	// マイプロフィール画面の表示
	@GetMapping("/myProfile")
	public String showMyProfile(
			Model model) {

		User loginUser = userRepository.findById(account.getId()).orElse(null);
		model.addAttribute("user", loginUser);

		return "users/myProfile";
	}

}
