/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.rebeca.todolist.entity.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.rebeca.todolist.entity.model.Subtask;
import com.rebeca.todolist.entity.model.Task;
import com.rebeca.todolist.entity.service.base.SubtaskLocalServiceBaseImpl;

import com.rebeca.todolist.entity.service.constant.TaskStatus;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.rebeca.todolist.entity.model.Subtask",
	service = AopService.class
)
public class SubtaskLocalServiceImpl extends SubtaskLocalServiceBaseImpl {

	public Subtask addSubTask(String title) throws PortalException, PortalException {

		long subTaskId = counterLocalService.increment(Subtask.class.getName());

		Subtask subtask = createSubtask(subTaskId);
		subtask.setTitle(title);
		subtask.setStatus(TaskStatus.PENDENTE.getCode());

		return subtask;
	}

	public List<Subtask>findByTaskId(long taskId) {
	return subtaskPersistence.findByTaskId(taskId);
	}
}