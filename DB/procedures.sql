-- 根據Id查詢單筆投票項目
DELIMITER $$
CREATE PROCEDURE get_vote_item(IN p_item_id INT)
BEGIN
    SELECT item_id, item_name, item_total, item_created_time, item_last_modified_time
    FROM vote_item
    WHERE item_id = p_item_id;
END$$
DELIMITER ;

-- 查詢所有投票項目
DELIMITER $$
CREATE PROCEDURE get_all_vote_items()
BEGIN
    SELECT item_id, item_name, item_total, item_created_time, item_last_modified_time
    FROM vote_item;
    END$$
DELIMITER ;

-- 查詢時鎖定該 item_id 的 item_total
DELIMITER $$
CREATE PROCEDURE get_item_total_for_update(IN p_item_id INT)
BEGIN
    SELECT item_total
    FROM vote_item
    WHERE item_id = p_item_id
    FOR UPDATE;
END$$
DELIMITER ;

-- 新增一筆投票項目
DELIMITER $$
CREATE PROCEDURE insert_vote_item(
    IN p_item_name VARCHAR(128),
    IN p_item_created_time TIMESTAMP,
    IN p_item_last_modified_time TIMESTAMP,
    OUT p_item_id INT)
BEGIN
    INSERT INTO vote_item(item_name, item_created_time, item_last_modified_time)
        VALUES(p_item_name, p_item_created_time, p_item_last_modified_time);
    SET p_item_id = LAST_INSERT_ID();
END$$
DELIMITER ;

-- 修改投票項目的名稱
DELIMITER $$
CREATE PROCEDURE update_vote_item(
    IN p_item_id INT,
    IN p_item_name VARCHAR(128),
    IN p_item_last_modified_time TIMESTAMP)
BEGIN
    UPDATE vote_item SET item_name = p_item_name,
                         item_last_modified_time = p_item_last_modified_time
    WHERE item_id = p_item_id;
END$$
DELIMITER ;

-- 對一個投票項目的票數加1
DELIMITER $$
CREATE PROCEDURE increment_vote_total(IN p_item_id INT)
BEGIN
    UPDATE vote_item SET item_total = item_total + 1
    WHERE item_id = p_item_id;
END$$
DELIMITER ;

-- 新增一筆投票記錄
DELIMITER $$
CREATE PROCEDURE insert_vote_record(
    IN p_voter_name VARCHAR(128),
    IN p_item_id INT,
    IN p_vote_time TIMESTAMP)
BEGIN
    INSERT INTO vote_record(voter_name, item_id, vote_time)
        VALUES(p_voter_name,p_item_id, p_vote_time);
END$$
DELIMITER ;