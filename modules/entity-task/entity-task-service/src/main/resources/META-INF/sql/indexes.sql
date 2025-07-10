create index IX_EDF44FCA on ToDoList_Task (groupId, status);
create unique index IX_21BD5FFC on ToDoList_Task (uuid_[$COLUMN_LENGTH:75$], groupId);