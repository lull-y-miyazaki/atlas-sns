// の処理用Controller
package com.example.demo.controller.user;

import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Follow;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.FollowRepository;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class FollowController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FollowRepository followRepository;

	@Autowired
	private Account account;

	// フォロー登録処理
	@PostMapping("/follow")
	public String followUser(
			@RequestParam(name = "followUserId") Integer followUserId,
			RedirectAttributes redirectAttributes,
			HttpServletRequest request) {

		Follow follow = new Follow();
		Optional<User> optLoginUser = userRepository.findById(account.getId());
		Optional<User> optFollowUser = userRepository.findById(followUserId);

		if (optLoginUser.isEmpty() || optFollowUser.isEmpty()) {
			// NULLの場合はエラー文を出力
			redirectAttributes.addFlashAttribute("info", "ユーザーが存在しません");
			String referer = request.getHeader("Referer");
			return "redirect:" + referer;
		}

		User loginUser = optLoginUser.get();
		User followUser = optFollowUser.get();

		follow.setFollower(loginUser);
		follow.setFollowee(followUser);

		followRepository.save(follow);
		redirectAttributes.addFlashAttribute("info", "フォローしました");

		// 元のページのURLを取得してリダイレクト
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	// フォロー解除処理
	@PostMapping("/unfollow")
	public String unfollowUser(
			@RequestParam(name = "followUserId") Integer followUserId,
			RedirectAttributes redirectAttributes,
			HttpServletRequest request) {

		Optional<User> optLoginUser = userRepository.findById(account.getId());
		Optional<User> optFollowUser = userRepository.findById(followUserId);

		if (optLoginUser.isEmpty() || optFollowUser.isEmpty()) {
			// NULLの場合はエラー文を出力
			redirectAttributes.addFlashAttribute("info", "ユーザーが存在しません");

			String referer = request.getHeader("Referer");
			return "redirect:" + referer;
		}

		User loginUser = optLoginUser.get();
		User followUser = optFollowUser.get();

		Optional<Follow> optFollow = followRepository.findByFollowerAndFollowee(loginUser, followUser);

		if (optFollow.isPresent()) {
			followRepository.delete(optFollow.get());
			redirectAttributes.addFlashAttribute("info", "フォローを解除しました");
		} else {
			redirectAttributes.addFlashAttribute("info", "フォロー関係が存在しません");
		}

		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

}
