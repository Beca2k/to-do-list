create index IX_FC539EE4 on ToDoList_Subtask (taskId);
create unique index IX_CDB86F66 on ToDoList_Subtask (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_2584B9D9 on ToDoList_Task (groupId, userId, relativeId);
create index IX_663DAA04 on ToDoList_Task (groupId, userId, status);
create unique index IX_EF766C50 on ToDoList_Task (groupId, uuid_[$COLUMN_LENGTH:75$]);
create index IX_859CB06E on ToDoList_Task (uuid_[$COLUMN_LENGTH:75$]);