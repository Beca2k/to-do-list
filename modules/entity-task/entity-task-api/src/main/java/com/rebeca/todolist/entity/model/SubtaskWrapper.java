/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.rebeca.todolist.entity.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Subtask}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Subtask
 * @generated
 */
public class SubtaskWrapper
	extends BaseModelWrapper<Subtask>
	implements ModelWrapper<Subtask>, Subtask {

	public SubtaskWrapper(Subtask subtask) {
		super(subtask);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("subtaskId", getSubtaskId());
		attributes.put("taskId", getTaskId());
		attributes.put("title", getTitle());
		attributes.put("status", getStatus());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long subtaskId = (Long)attributes.get("subtaskId");

		if (subtaskId != null) {
			setSubtaskId(subtaskId);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Subtask cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this subtask.
	 *
	 * @return the company ID of this subtask
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this subtask.
	 *
	 * @return the create date of this subtask
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this subtask.
	 *
	 * @return the group ID of this subtask
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this subtask.
	 *
	 * @return the modified date of this subtask
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this subtask.
	 *
	 * @return the primary key of this subtask
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this subtask.
	 *
	 * @return the status of this subtask
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the subtask ID of this subtask.
	 *
	 * @return the subtask ID of this subtask
	 */
	@Override
	public long getSubtaskId() {
		return model.getSubtaskId();
	}

	/**
	 * Returns the task ID of this subtask.
	 *
	 * @return the task ID of this subtask
	 */
	@Override
	public long getTaskId() {
		return model.getTaskId();
	}

	/**
	 * Returns the title of this subtask.
	 *
	 * @return the title of this subtask
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this subtask.
	 *
	 * @return the user ID of this subtask
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this subtask.
	 *
	 * @return the user name of this subtask
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this subtask.
	 *
	 * @return the user uuid of this subtask
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this subtask.
	 *
	 * @return the uuid of this subtask
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this subtask.
	 *
	 * @param companyId the company ID of this subtask
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this subtask.
	 *
	 * @param createDate the create date of this subtask
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this subtask.
	 *
	 * @param groupId the group ID of this subtask
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this subtask.
	 *
	 * @param modifiedDate the modified date of this subtask
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this subtask.
	 *
	 * @param primaryKey the primary key of this subtask
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this subtask.
	 *
	 * @param status the status of this subtask
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the subtask ID of this subtask.
	 *
	 * @param subtaskId the subtask ID of this subtask
	 */
	@Override
	public void setSubtaskId(long subtaskId) {
		model.setSubtaskId(subtaskId);
	}

	/**
	 * Sets the task ID of this subtask.
	 *
	 * @param taskId the task ID of this subtask
	 */
	@Override
	public void setTaskId(long taskId) {
		model.setTaskId(taskId);
	}

	/**
	 * Sets the title of this subtask.
	 *
	 * @param title the title of this subtask
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this subtask.
	 *
	 * @param userId the user ID of this subtask
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this subtask.
	 *
	 * @param userName the user name of this subtask
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this subtask.
	 *
	 * @param userUuid the user uuid of this subtask
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this subtask.
	 *
	 * @param uuid the uuid of this subtask
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected SubtaskWrapper wrap(Subtask subtask) {
		return new SubtaskWrapper(subtask);
	}

}