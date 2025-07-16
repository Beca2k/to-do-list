/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.rebeca.todolist.entity.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TaskPK implements Comparable<TaskPK>, Serializable {

	public long taskId;
	public long subtaskId;

	public TaskPK() {
	}

	public TaskPK(long taskId, long subtaskId) {
		this.taskId = taskId;
		this.subtaskId = subtaskId;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public long getSubtaskId() {
		return subtaskId;
	}

	public void setSubtaskId(long subtaskId) {
		this.subtaskId = subtaskId;
	}

	@Override
	public int compareTo(TaskPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (taskId < pk.taskId) {
			value = -1;
		}
		else if (taskId > pk.taskId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (subtaskId < pk.subtaskId) {
			value = -1;
		}
		else if (subtaskId > pk.subtaskId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TaskPK)) {
			return false;
		}

		TaskPK pk = (TaskPK)object;

		if ((taskId == pk.taskId) && (subtaskId == pk.subtaskId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, taskId);
		hashCode = HashUtil.hash(hashCode, subtaskId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("taskId=");

		sb.append(taskId);
		sb.append(", subtaskId=");

		sb.append(subtaskId);

		sb.append("}");

		return sb.toString();
	}

}