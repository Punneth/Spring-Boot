Category Table

insert into category(category_desc) values("Hardware");
insert into category(category_desc) values("Software");
insert into category(category_desc) values("Access Management");

SubCategory Table
insert into sub_category(category_id,sub_category_des) value(1,"Allocate Laptop");
insert into sub_category(category_id,sub_category_des) value(1,"Allocate Hardware");
insert into sub_category(category_id,sub_category_des) value(1,"Hardware replacement");
insert into sub_category(category_id,sub_category_des) value(2,"Software Installation");
insert into sub_category(category_id,sub_category_des) value(2,"Antivirus");
insert into sub_category(category_id,sub_category_des) value(2,"Email Password update");
insert into sub_category(category_id,sub_category_des) value(2,"Laptop Slowness issue");
insert into sub_category(category_id,sub_category_des) value(2,"Software Issue");
insert into sub_category(category_id,sub_category_des) value(3,"Software access");
insert into sub_category(category_id,sub_category_des) value(3,"Wifi Access");
insert into sub_category(category_id,sub_category_des) value(3,"Database Access");
insert into sub_category(category_id,sub_category_des) value(3,"VPN Access");

Admin Table
insert into admin_team(admin_email_id,admin_name) values("cmr@gmail.com","Bipin");
insert into admin_team(admin_email_id,admin_name) values("itOrizon@gmail.com","Sunny");
insert into admin_team(admin_email_id,admin_name) values("rns@gmail.com","Sudhakar");

Status Table
insert into status(status) value("Open");
insert into status(status) value("Assigned");
insert into status(status) value("In Progress");
insert into status(status) value("Completed");

Priority Table
insert into priority(priority) value("Low");
insert into priority(priority) value("Medium");
insert into priority(priority) value("High");
insert into priority(priority) value("Critical");

Ticket Table
alter table ticket modify priority_id tinyint null;

