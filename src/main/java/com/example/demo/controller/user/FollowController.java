// の処理用Controller
package com.example.demo.controller.user;

import java.util.Optional;

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

	@PostMapping("/follow")
	public String followUser(
			@RequestParam(name = "followUserId") Integer followUserId,
			RedirectAttributes redirectAttributes) {

		Follow follow = new Follow();
		Optional<User> optLoginUser = userRepository.findById(account.getId());
		Optional<User> optFollowUser = userRepository.findById(followUserId);

		if (optLoginUser.isEmpty() || optFollowUser.isEmpty()) {
			// NULLの場合はエラー文を出力
			redirectAttributes.addFlashAttribute("error", "ユーザーが存在しません");
			return "redirect:/users/search";
		}

		User loginUser = optLoginUser.get();
		User followUser = optFollowUser.get();

		follow.setFollower(loginUser);
		follow.setFollowee(followUser);

		followRepository.save(follow);

		return "redirect:/users/search";
	}

	@PostMapping("/unfollow")
	public String unfollowUser(
			@RequestParam(name = "followUserId") Integer followUserId,
			RedirectAttributes redirectAttributes) {

		Optional<User> optLoginUser = userRepository.findById(account.getId());
		Optional<User> optFollowUser = userRepository.findById(followUserId);

		if (optLoginUser.isEmpty() || optFollowUser.isEmpty()) {
			// NULLの場合はエラー文を出力
			redirectAttributes.addFlashAttribute("error", "ユーザーが存在しません");
			return "redirect:/users/search";
		}

		User loginUser = optLoginUser.get();
		User followUser = optFollowUser.get();

		Optional<Follow> optFollow = followRepository.findByFollowerAndFollowee(loginUser, followUser);

		if (optFollow.isPresent()) {
			followRepository.delete(optFollow.get());
			redirectAttributes.addFlashAttribute("success", "フォローを解除しました");
		} else {
			redirectAttributes.addFlashAttribute("info", "フォロー関係が存在しません");
		}

		return "redirect:/users/search";
	}

}
