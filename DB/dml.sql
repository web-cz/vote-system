-- 新增投票項目
INSERT INTO vote_item (item_name, item_created_time, item_last_modified_time) VALUES ('電腦', NOW(), NOW());
INSERT INTO vote_item (item_name, item_created_time, item_last_modified_time) VALUES ('滑鼠', NOW(), NOW());
INSERT INTO vote_item (item_name, item_created_time, item_last_modified_time) VALUES ('鍵盤', NOW(), NOW());

-- 新增投票記錄
INSERT INTO vote_record (voter_name, item_id, vote_time) VALUES ('Leo', 1, NOW());
INSERT INTO vote_record (voter_name, item_id, vote_time) VALUES ('Sandy', 1, NOW());
INSERT INTO vote_record (voter_name, item_id, vote_time) VALUES ('Sandy', 2, NOW());
INSERT INTO vote_record (voter_name, item_id, vote_time) VALUES ('Randy', 2, NOW());
INSERT INTO vote_record (voter_name, item_id, vote_time) VALUES ('RSY', 2, NOW());


  
    
    
