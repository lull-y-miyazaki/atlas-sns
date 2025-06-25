-- 初期ユーザー
INSERT INTO users (username, email, password, bio, icon_image, created_at, updated_at)
VALUES 
('テストユーザー', 'testuser@com', 'testuser', 'テストユーザーです', 'icon1.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストA', 'testa@com', 'testuser', 'テストユーザーAです', 'icon1.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストB', 'testb@com', 'testuser', 'テストユーザーBです', 'icon1.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストC', 'testc@com', 'testuser', 'テストユーザーCです', 'icon1.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストD', 'testd@com', 'testuser', 'テストユーザーDです', 'icon1.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストE', 'teste@com', 'testuser', 'テストユーザーEです', 'icon1.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 初期投稿
INSERT INTO posts (user_id, post, created_at, updated_at)
VALUES 
(1, 'Hello World！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'こんにちは、世界！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 初期フォロー関係
INSERT INTO follows (following_id, followed_id, created_at, updated_at)
VALUES 
(1, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
