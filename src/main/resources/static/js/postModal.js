/**
 * モーダル機能
 */

document.addEventListener("DOMContentLoaded", () => {

	// 投稿編集モーダル
	const editButtons = document.querySelectorAll(".edit-modal-open");
	const editModal = document.getElementById("edit-modal");

	// 更新モーダル開く
	editButtons.forEach((button) => {
		button.addEventListener("click", (event) => {
			event.preventDefault();

			const editPostId = button.getAttribute("data-id");
			const editPostContent = button.getAttribute("data-content");
			editModal.querySelector(".modal-post-content").value = editPostContent;

			const editForm = document.getElementById("editModalForm");
			editForm.action = `/posts/${editPostId}/update`;

			editModal.style.display = "block";
		});
	});

	// 更新モーダル閉じる
	document.querySelectorAll(".edit-modal-close").forEach(closeBtn => {
		closeBtn.addEventListener("click", (event) => {
			event.preventDefault();
			editModal.style.display = "none";
		});
	});


	// 投稿削除モーダル
	const deleteButtons = document.querySelectorAll(".delete-modal-open");
	const deleteModal = document.getElementById("delete-modal");

	// 削除モーダル開く
	deleteButtons.forEach((button) => {
		button.addEventListener("click", (event) => {
			event.preventDefault();

			const deletePostId = button.getAttribute("data-id");
			/*const deletePostContent = button.getAttribute("data-content");
			deleteModal.querySelector(".delete_post_content").textContent = deletePostContent;*/

			const deleteForm = document.getElementById("deleteModalForm");
			deleteForm.action = `/posts/${deletePostId}/delete`;

			deleteModal.style.display = "block";
		});
	});

	// 削除モーダル閉じる
	document.querySelectorAll(".delete-modal-close").forEach(closeBtn => {
		closeBtn.addEventListener("click", (event) => {
			event.preventDefault();
			deleteModal.style.display = "none";
		});
	});

});


/**
 * 【復習】
 * アロー関数と通常関数の書き方の違い
 * 
 * ①通常:
 * document.addEventListener("DOMContentLoaded", function() {
 *   ...
 * });
 * 
 * ②アロー関数:
 * document.addEventListener("DOMContentLoaded", () => {
 *   ...
 * });
 * 
 * ①通常:
 * editButtons.forEach(function(button) {
 *   button.addEventListener("click", function(event) {
 *     ...
 *   });
 * });
 * 
 * ②アロー関数:
 * editButtons.forEach((button) => {
 *   button.addEventListener("click", (event) => {
 *     ...
 *   });
 * });
 * 
 * ①通常:
 * document.querySelectorAll(".js-modal-close").forEach(function(closeBtn) {
 *   closeBtn.addEventListener("click", function(event) {
 *     ...
 *   });
 * });
 * 
 * ②アロー関数:
 * document.querySelectorAll(".js-modal-close").forEach(closeBtn => {
 *   closeBtn.addEventListener("click", event => {
 *     ...
 *   });
 * });
 * 
 * ※引数が1つの場合 () は省略可能
 * ①function()は、thisの挙動が呼び出し元によって違う
 * ②アロー関数は、thisは常に定義時のスコープを参照
 */
