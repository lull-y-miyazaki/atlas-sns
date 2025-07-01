-- 初期ユーザー
INSERT INTO users (name, email, password, bio, icon_image, created_at, updated_at)
VALUES 
('テストユーザー', 'testuser@com', 'testuser123', 'テストユーザーです', '/images/icon1.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストA', 'test@a.com', 'testuser123', 'テストユーザーAです', '/images/icon1.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストB', 'test@b.com', 'testuser123', 'テストユーザーBです', '/images/icon2.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストC', 'test@c.com', 'testuser123', 'テストユーザーCです', '/images/icon3.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストD', 'test@d.com', 'testuser123', 'テストユーザーDです', '/images/icon4.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストE', 'test@e.com', 'testuser123', 'テストユーザーEです', '/images/icon5.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストF', 'test@f.com', 'testuser123', 'テストユーザーFです', '/images/icon6.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストG', 'test@g.com', 'testuser123', 'テストユーザーGです', '/images/icon7.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストH', 'test@h.com', 'testuser123', 'テストユーザーHです', '/images/icon1.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストI', 'test@i.com', 'testuser123', 'テストユーザーIです', '/images/icon2.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストJ', 'test@j.com', 'testuser123', 'テストユーザーJです', '/images/icon3.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストK', 'test@k.com', 'testuser123', 'テストユーザーKです', '/images/icon4.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストL', 'test@l.com', 'testuser123', 'テストユーザーLです', '/images/icon5.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストM', 'test@m.com', 'testuser123', 'テストユーザーMです', '/images/icon6.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストN', 'test@n.com', 'testuser123', 'テストユーザーNです', '/images/icon7.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストO', 'test@o.com', 'testuser123', 'テストユーザーOです', '/images/icon1.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストP', 'test@p.com', 'testuser123', 'テストユーザーPです', '/images/icon2.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストQ', 'test@q.com', 'testuser123', 'テストユーザーQです', '/images/icon3.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストR', 'test@r.com', 'testuser123', 'テストユーザーRです', '/images/icon4.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストS', 'test@s.com', 'testuser123', 'テストユーザーSです', '/images/icon5.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストT', 'test@t.com', 'testuser123', 'テストユーザーTです', '/images/icon6.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストU', 'test@u.com', 'testuser123', 'テストユーザーUです', '/images/icon7.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストV', 'test@v.com', 'testuser123', 'テストユーザーVです', '/images/icon1.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストW', 'test@w.com', 'testuser123', 'テストユーザーWです', '/images/icon2.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストX', 'test@x.com', 'testuser123', 'テストユーザーXです', '/images/icon3.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストY', 'test@y.com', 'testuser123', 'テストユーザーYです', '/images/icon4.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('テストZ', 'test@z.com', 'testuser123', 'テストユーザーZです', '/images/icon5.png', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


-- 初期投稿
INSERT INTO posts (user_id, post, created_at, updated_at)
VALUES 
(1, 'Hello World！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Javaで開発中！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, '今日の天気は晴れ！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'DBはMySQLを使ってます！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 'こっちはJPAでやってます！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'こんにちは、世界。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'Springで開発中。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, '今日の天気は曇り。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'DBはPostgresSQLを使用。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'こちらはJDBCです。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'Bonjour le monde！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- フランス語
(4, 'Hola Mundo！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- スペイン語
(5, 'Hallo Welt！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- ドイツ語
(6, 'Ciao Mondo！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- イタリア語
(7, '안녕하세요 세계！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- 韓国語
(8, '你好，世界！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- 中国語（簡体字）
(9, 'Привет, мир！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- ロシア語
(10, 'Olá Mundo！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- ポルトガル語
(11, 'سلام دنیا！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- ペルシャ語
(12, 'हैलो वर्ल्ड！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- ヒンディー語
(13, 'γειά σου κόσμε！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- ギリシャ語
(14, 'שלום עולם！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- ヘブライ語
(15, 'Hallo Wereld！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- オランダ語
(16, 'Hei maailma！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- フィンランド語
(17, 'Hei verden！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- ノルウェー語
(18, 'Hej världen！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- スウェーデン語
(19, 'Ahoj světe！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- チェコ語
(20, 'Szia világ！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- ハンガリー語
(21, 'Halo Dunia！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- インドネシア語
(22, 'Witaj świecie！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- ポーランド語
(23, 'Merhaba Dünya！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- トルコ語
(24, 'Selam Dünya！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- トルコ語（カジュアル）
(25, 'Sawubona Mhlaba！', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP); -- ズールー語

-- 初期フォロー関係
INSERT INTO follows (following_id, followed_id, created_at, updated_at)
VALUES 
(1, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 11, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 12, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 13, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 14, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 15, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 16, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 17, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 18, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 19, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 20, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
