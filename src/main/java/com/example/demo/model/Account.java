package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Account {

	private Integer id;
	private String name;
	private String iconImage;

	// デフォルトコンストラクタ
	public Account() {
		super();
	}

	// ゲッター＆セッター
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIconImage() {
		return iconImage;
	}

	public void setIconImage(String iconImage) {
		this.iconImage = iconImage;
	}

	// ログイン状態を確認するメソッド
	public boolean isLoggedIn() {
		return id != null;
	}

	// デバッグ・ログ出力用
	@Override
	public String toString() {
		return "Account{id = " + id + ", name = '" + name + "'}";
	}

}
