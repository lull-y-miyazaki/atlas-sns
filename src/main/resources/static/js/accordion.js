/**
 * アコーディオンメニュー
 */

// ちゃんとHTML読み込んでからスタート
document.addEventListener("DOMContentLoaded", function() {
	// DOMから対象のクラス名の要素を取得して変数に定義
	const button = document.querySelector(".accordion-button");
	const item = document.querySelector(".accordion-item");

	// buttonがクリックされた時にイベントが発火
	button.addEventListener("click", function() {
		// `<div class="accordion-item">`に`active`クラスを追加、あれば取り除く
		item.classList.toggle("active");
	});
});

/**
 * 【復習】
 * item:
 * → document.querySelectorで取得したDOMオブジェクトが格納されている変数
 * 
 * classList:
 * → DOMオブジェクトが持ってるフィールド(オブジェクト型)で、追加・削除・切り替えなどclass属性を操作するメソッドを持っている
 * ※呼び出されたタイミングで、自動でインスタンス生成して取得される
 * 
 * toggle():
 * → classListのメソッド。戻り値は、true(追加された)または、false(削除された)
 * 
 * 要素.addEventListener("イベントの種類", 実行する関数): 
 * → 要素(DOMオブジェクト)の親関係にある`EventTarget`インターフェースで定義されているメソッド
 * 
 */