INSERT INTO user_details (id, birth_date,name) VALUES (1001, current_date(),'jagdish');
INSERT INTO user_details (id, birth_date,name) VALUES (1002, current_date(),'sameer');
INSERT INTO user_details (id, birth_date,name) VALUES (1003, current_date(),'Anand');

INSERT INTO POST(id,description,user_id)
values(20001,'I want to Learn AWS',1001);

INSERT INTO POST(id,description,user_id)
values(20002,'I want to Learn DevOps',1001);

INSERT INTO POST(id,description,user_id)
values(20003,'I want to Get AWS Certified',1002);

INSERT INTO POST(id,description,user_id)
values(20004,'I want to Learn MultiCloud',1002);