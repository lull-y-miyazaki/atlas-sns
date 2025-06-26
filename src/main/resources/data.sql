-- 初期ユーザー
INSERT INTO users (name, email, password, bio, icon_image, created_at, updated_at)
VALUES 
('テストユーザー', 'testuser@com', 'testuser123', 'テストユーザーです', 'icon1.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストA', 'testa@com', 'testuser123', 'テストユーザーAです', 'icon1.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストB', 'testb@com', 'testuser123', 'テストユーザーBです', 'icon1.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストC', 'testc@com', 'testuser123', 'テストユーザーCです', 'icon1.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストD', 'testd@com', 'testuser123', 'テストユーザーDです', 'icon1.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストE', 'teste@com', 'testuser123', 'テストユーザーEです', 'icon1.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 初期投稿
INSERT INTO posts (user_id, post, created_at, updated_at)
VALUES 
(1, 'Hello World！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Javaで開発中！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, '今日の天気は晴れ！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'DBはMySQLを使ってます！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'こっちはJPAでやってます！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'こんにちは、世界。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'Springで開発中。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, '今日の天気は曇り。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'DBはPostgresSQLを使用。！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'こちらはJDBCです。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 初期フォロー関係
INSERT INTO follows (following_id, followed_id, created_at, updated_at)
VALUES 
(1, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
