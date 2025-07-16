/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.rebeca.todolist.entity.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.rebeca.todolist.entity.model.Subtask;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Subtask in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SubtaskCacheModel implements CacheModel<Subtask>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SubtaskCacheModel)) {
			return false;
		}

		SubtaskCacheModel subtaskCacheModel = (SubtaskCacheModel)object;

		if (subtaskId == subtaskCacheModel.subtaskId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, subtaskId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", subtaskId=");
		sb.append(subtaskId);
		sb.append(", taskId=");
		sb.append(taskId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", status=");
		sb.append(status);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Subtask toEntityModel() {
		SubtaskImpl subtaskImpl = new SubtaskImpl();

		if (uuid == null) {
			subtaskImpl.setUuid("");
		}
		else {
			subtaskImpl.setUuid(uuid);
		}

		subtaskImpl.setSubtaskId(subtaskId);
		subtaskImpl.setTaskId(taskId);

		if (title == null) {
			subtaskImpl.setTitle("");
		}
		else {
			subtaskImpl.setTitle(title);
		}

		subtaskImpl.setStatus(status);
		subtaskImpl.setGroupId(groupId);
		subtaskImpl.setCompanyId(companyId);
		subtaskImpl.setUserId(userId);

		if (userName == null) {
			subtaskImpl.setUserName("");
		}
		else {
			subtaskImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			subtaskImpl.setCreateDate(null);
		}
		else {
			subtaskImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			subtaskImpl.setModifiedDate(null);
		}
		else {
			subtaskImpl.setModifiedDate(new Date(modifiedDate));
		}

		subtaskImpl.resetOriginalValues();

		return subtaskImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		subtaskId = objectInput.readLong();

		taskId = objectInput.readLong();
		title = objectInput.readUTF();

		status = objectInput.readInt();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(subtaskId);

		objectOutput.writeLong(taskId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long subtaskId;
	public long taskId;
	public String title;
	public int status;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}