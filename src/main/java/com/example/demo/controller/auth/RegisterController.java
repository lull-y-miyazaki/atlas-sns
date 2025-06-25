// ユーザー新規登録処理のController
package com.example.demo.controller.auth;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping("/auth")
public class RegisterController {

	@Autowired
	private UserRepository userRepository;

	// 新規ユーザー登録画面の表示
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("user", new User());
		return "auth/register";
	}

	// 新規登録の処理内容
	@PostMapping("/register")
	public String store(
			@Valid @ModelAttribute User user,
			BindingResult bindingResult,
			@RequestParam String password_confirm,
			RedirectAttributes redirectAttributes,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "auth/register";
		}

		if (!user.getPassword().equals(password_confirm)) {
			model.addAttribute("error", "パスワードが一致しません");
			model.addAttribute("user", user);
			return "auth/register";
		}

		userRepository.save(user);
		// 登録完了ページにデータを送る
		redirectAttributes.addFlashAttribute("name", user.getName());

		return "redirect:/auth/added";
	}

	// 登録完了画面の表示
	@GetMapping("/added")
	public String showAdded() {
		return "auth/added";
	}

}
