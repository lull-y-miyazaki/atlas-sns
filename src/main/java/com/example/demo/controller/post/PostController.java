// 投稿処理のController
package com.example.demo.controller.post;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Follow;
import com.example.demo.entity.Post;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PostRepository postRepository;

	@Autowired
	Account account;

	// TOPページ画面の表示
	@GetMapping("/index")
	public String showIndex(Model model) {

		User loginUser = userRepository.findById(account.getId()).orElse(null);

		// 自分とフォローユーザーの投稿を分割して取得して、追加して並び替えするやり方
		/*
		List<Post> postList = new ArrayList<>();
		
		// 自分の投稿を取得
		List<Post> myPosts = postRepository.findByUserId(loginUser.getId());
		postList.addAll(myPosts);
		
		// フォローしているユーザーの投稿をリストに追加
		for (Follow follow : loginUser.getFollowings()) {
			User followee = follow.getFollowee();
			List<Post> followeePosts = postRepository.findByUserId(followee.getId());
			postList.addAll(followeePosts);
		}
		
		// ラムダ式（無名関数）で、投稿順に並び替え
		postList.sort((a, b) -> b.getCreatedAt().compareTo(a.getCreatedAt()));
		*/

		// 投稿一覧はDB側でまとめて取得して並び替え
		List<Integer> userIds = new ArrayList<>();
		userIds.add(loginUser.getId());
		for (Follow follow : loginUser.getFollowings()) {
			userIds.add(follow.getFollowee().getId());
		}
		List<Post> postList = postRepository.findByUserIdInOrderByCreatedAtDesc(userIds);

		model.addAttribute("loginUser", loginUser);
		model.addAttribute("postList", postList);

		// フォーム用インスタンス生成、既にあればそのまま
		if (!model.containsAttribute("post")) {
			model.addAttribute("post", new Post());
		}

		return "posts/index";
	}

	// 投稿の登録処理
	@PostMapping("/createPost")
	public String createPost(
			@Valid @ModelAttribute Post post,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			// エラー内容をリダイレクト先に渡す
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.post", bindingResult);
			redirectAttributes.addFlashAttribute("post", post);
			return "redirect:/posts/index";
		}

		// 改行を<br />に変換して保存
		String contentWithBr = post.getContent().replace("\n", "<br>");
		post.setContent(contentWithBr);

		post.setUser(userRepository.findById(account.getId()).orElseThrow());
		postRepository.save(post);
		redirectAttributes.addFlashAttribute("info", "投稿が完了しました！");

		return "redirect:/posts/index";
	}

	// 投稿の更新処理
	@PostMapping("/{postId}/update")
	public String updatePost(
			@PathVariable("postId") Integer postId,
			@Validated @ModelAttribute("post") Post post,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			// エラー内容をリダイレクト先に渡す
			String message = bindingResult.getFieldError("content").getDefaultMessage();
			redirectAttributes.addFlashAttribute("info", message);
			return "redirect:/posts/index";
		}

		post.setId(postId);
		post.setUser(userRepository.findById(account.getId()).orElseThrow());

		postRepository.save(post);
		redirectAttributes.addFlashAttribute("info", "投稿の編集が完了しました！");

		return "redirect:/posts/index";
	}

	// 投稿の削除処理
	@PostMapping("/{postId}/delete")
	public String deletePost(
			@PathVariable Integer postId,
			RedirectAttributes redirectAttributes) {

		postRepository.deleteById(postId);
		redirectAttributes.addFlashAttribute("info", "投稿を削除しました！");

		return "redirect:/posts/index";
	}

}
