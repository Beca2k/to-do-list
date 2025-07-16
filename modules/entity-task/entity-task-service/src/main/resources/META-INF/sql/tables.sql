create table ToDoList_Subtask (
	uuid_ VARCHAR(75) null,
	subtaskId LONG not null primary key,
	taskId LONG,
	title VARCHAR(75) null,
	status INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

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
	description VARCHAR(2000) null,
	title VARCHAR(75) null,
	path_ TEXT null,
	relativeId LONG,
	fileEntryId LONG,
	done BOOLEAN
);