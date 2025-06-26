// ログイン処理のController
package com.example.demo.controller.auth;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private HttpSession session;

	@Autowired
	private Account account;

	// ログイン画面の表示
	@GetMapping({ "/login", "/logout" })
	public String showLogin(
			@RequestParam(defaultValue = "") String error,
			Model model) {

		// セッション情報全てをクリア
		session.invalidate();

		// クエリパラメータで"notLoggedIn"を受け取った場合
		if (error.equals("notLoggedIn")) {
			model.addAttribute("message", "ログインしてください");
		}

		return "auth/login";
	}

	// ログイン処理
	@PostMapping("/login")
	public String login(
			@RequestParam String email,
			@RequestParam String password,
			Model model) {

		// email または password が空の場合にエラーメッセージを表示
		if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
			model.addAttribute("message", "メールアドレスとパスワードを入力してください");
			return "auth/login";
		}

		// データーベースからユーザー情報を取得
		User user = userRepository.findByEmailAndPassword(email, password);

		// email または password が正しくない場合にエラーメッセージを表示
		if (user == null) {
			model.addAttribute("message", "メールアドレスまたはパスワードが正しくありません");
			return "auth/login";
		}

		// ログイン情報をAccountに保存
		account.setId(user.getId());
		account.setName(user.getName());
		account.setIconImage(user.getIconImage());

		return "redirect:/posts/index";
	}

}
