package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.model.Account;
import com.example.demo.repository.FollowRepository;

// 全コントローラーに共通の処理や設定をまとめて適用
@ControllerAdvice
public class GlobalModelAttributeAdvice {

	@Autowired
	private FollowRepository followRepository;

	@Autowired
	private Account account;

	@ModelAttribute
	public void addFollowCounts(Model model) {

		// もしログイン状態ならフォロー数フォロワー数を取得
		if (account != null && account.getId() != null) {
			int followings = followRepository.countByFollowerId(account.getId());
			int followers = followRepository.countByFolloweeId(account.getId());

			model.addAttribute("followings", followings);
			model.addAttribute("followers", followers);
		}
	}

}
