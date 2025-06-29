// ユーザー情報更新処理のController
package com.example.demo.controller.user;

import java.nio.file.Files;
import java.nio.file.Paths;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserUpdateController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private Account account;

	// マイプロフィールの更新処理
	@PostMapping("/update")
	public String updateMyProfile(
			@Valid @ModelAttribute User user,
			BindingResult bindingResult,
			@RequestParam String password_confirm,
			@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			// エラー内容をリダイレクト先に渡す
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", bindingResult);
			redirectAttributes.addFlashAttribute("user", user);
			return "redirect:/users/myProfile";
		}

		if (!user.getPassword().equals(password_confirm)) {
			// パスワードとパスワード確認が一致しない場合、エラーメッセージとともにリダイレクト
			redirectAttributes.addFlashAttribute("error", "パスワードが一致しません");
			redirectAttributes.addFlashAttribute("user", user);
			return "redirect:/users/myProfile";
		}

		try {
			if (file != null && !file.isEmpty()) {
				// ファイルがアップロードされれば保存
				String filename = file.getOriginalFilename();
				String filePath = "static/upload/" + filename;
				byte[] content = file.getBytes();
				Files.write(Paths.get(filePath), content);

				String imageUrl = "/upload/" + filename;
				user.setIconImage(imageUrl);

			} else {
				// アップロードされなかったら現在のアイコンを更新
				user.setIconImage(account.getIconImage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ログインユーザー情報の更新
		account.setName(user.getName());
		account.setIconImage(user.getIconImage());

		// マイプロフィール情報の更新
		user.setId(account.getId());
		userRepository.save(user);
		redirectAttributes.addFlashAttribute("info", "プロフィールの変更が完了しました！");

		return "redirect:/posts/index";
	}

}
