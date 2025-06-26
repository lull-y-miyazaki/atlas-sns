package com.example.demo.entity;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "ユーザー名は必須です")
	@Size(min = 2, max = 12, message = "ユーザー名は2文字以上12文字以内で入力してください")
	private String name;

	@NotBlank(message = "メールアドレスは必須です")
	@Size(min = 5, max = 40, message = "メールアドレスは5文字以上40文字以内で入力してください")
	@Email(message = "メールアドレスの形式が正しくありません")
	private String email;

	@NotBlank(message = "パスワードは必須です")
	@Size(min = 8, max = 20, message = "パスワードは8文字以上20文字以内で入力してください")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "パスワードは英数字のみで入力してください")
	private String password;

	private String bio;

	@Column(name = "icon_image")
	private String iconImage = "icon1.png";

	@Column(name = "created_at", insertable = false, updatable = false)
	private Timestamp createdAt;

	@Column(name = "updated_at", insertable = false, updatable = false)
	private Timestamp updatedAt;

	@Column(name = "deleted_at")
	private Timestamp deletedAt;

	@OneToMany(mappedBy = "follower")
	private List<Follow> followings;

	@OneToMany(mappedBy = "followee")
	private List<Follow> followers;

	// デフォルトコンストラクタ
	public User() {
		super();
	}

	// 新規登録用コンストラクタ
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getIconImage() {
		return iconImage;
	}

	public void setIconImage(String iconImage) {
		this.iconImage = iconImage;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Timestamp getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Timestamp deletedAt) {
		this.deletedAt = deletedAt;
	}

	public List<Follow> getFollowings() {
		return followings;
	}

	public void setFollowings(List<Follow> followings) {
		this.followings = followings;
	}

	public List<Follow> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Follow> followers) {
		this.followers = followers;
	}

}
