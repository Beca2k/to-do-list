package com.rebeca.todolist.entity.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.rebeca.todolist.entity.service.base.TaskLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import com.rebeca.todolist.entity.model.Task;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.rebeca.todolist.entity.model.Task",
	service = AopService.class
)

public class TaskLocalServiceImpl extends TaskLocalServiceBaseImpl {

	public Task addTask(String title, String description, String path, int relativeId, ServiceContext serviceContext) throws PortalException, PortalException {

		Group group = GroupLocalServiceUtil.getGroup(serviceContext.getScopeGroupId());
		User user = UserLocalServiceUtil.getUser(serviceContext.getUserId());

		long taskId = counterLocalService.increment(Task.class.getName());

		Task task = createTask(taskId);
		task.setTitle(title);
		task.setDescription(description);
		//task.setStatus(TaskStatus.PENDENTE.getCodigo());
		task.setPath(path);
		task.setRelativeId(relativeId);


		task.setGroupId(group.getGroupId());
		task.setCompanyId(group.getCompanyId());
		task.setUserId(user.getUserId());
		task.setUserName(user.getScreenName());
		task.setCreateDate(serviceContext.getCreateDate());
		task.setModifiedDate(serviceContext.getCreateDate());

		task = taskLocalService.addTask(task);

		return task;
	}
	public Task updateTask(long taskId,String title, int status, String description, String path, long fileEntryId, int relativeId, ServiceContext serviceContext) throws PortalException {

		Task task = getTask(taskId);

		if (task == null) {
			return null;
		}

		task.setTitle(title);
		task.setDescription(description);
		task.setStatus(status);
		task.setPath(path);
		task.setRelativeId(relativeId);
		//task.setFileEntryId(fileEntryId);
		task.setModifiedDate(new Date());

		task = updateTask(task);

		return task;
	}

	public Task changeStatus(long taskId) throws PortalException {

		Task task = getTask(taskId);

		if (task == null) {
			return null;
		}

		//task.setStatus(TaskStatus.CONCLUIDO.getCodigo());  taskStatus é um metodo
		task.setModifiedDate(new Date());

		task = updateTask(task);

		return task;

	}
}