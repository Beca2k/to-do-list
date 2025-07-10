create table ToDoList_Task (
	uuid_ VARCHAR(75) null,
	taskId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	description VARCHAR(75) null,
	title VARCHAR(75) null,
	path_ VARCHAR(75) null,
	relativeId INTEGER
);