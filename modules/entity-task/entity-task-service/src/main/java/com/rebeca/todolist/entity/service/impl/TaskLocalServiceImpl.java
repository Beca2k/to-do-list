package com.rebeca.todolist.entity.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.rebeca.todolist.entity.model.Task;
import com.rebeca.todolist.entity.service.base.TaskLocalServiceBaseImpl;
import com.rebeca.todolist.entity.service.constant.TaskStatus;
import org.osgi.service.component.annotations.Component;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */

@Component(
        property = "model.class.name=com.rebeca.todolist.entity.model.Task",
        service = AopService.class
)

public class TaskLocalServiceImpl extends TaskLocalServiceBaseImpl {

    private static final Log _log = LogFactoryUtil.getLog(TaskLocalServiceImpl.class);

    public Task addTask(String title, String description, String path, long fileEntryId, long relativeId, ServiceContext serviceContext) throws PortalException, PortalException {

        Group group = GroupLocalServiceUtil.getGroup(serviceContext.getScopeGroupId());
        User user = UserLocalServiceUtil.getUser(serviceContext.getUserId());

        long taskId = counterLocalService.increment(Task.class.getName());

        Task task = createTask(taskId);
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(TaskStatus.PENDENTE.getCode());
        task.setPath(path);
        task.setRelativeId(relativeId);
        task.setFileEntryId(fileEntryId);
        task.setGroupId(group.getGroupId());
        task.setCompanyId(group.getCompanyId());
        task.setUserId(user.getUserId());
        task.setUserName(user.getScreenName());
        task.setCreateDate(serviceContext.getCreateDate());
        task.setModifiedDate(serviceContext.getCreateDate());

        task = taskLocalService.addTask(task);

        return task;
    }

    public Task updateTask(long taskId, String title, int status, String description, String path, long relativeId, ServiceContext serviceContext) throws PortalException {

        Task task = null;

        try {
            task = getTask(taskId);
        } catch (PortalException e) {
            _log.error("Task com ID " + taskId + " não encontrada.", e);
            return null;
        }

        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(status);
        task.setPath(path);
        task.setRelativeId(relativeId);
        task.setModifiedDate(new Date());
        task = updateTask(task);
        return task;
    }

    public Task changeStatus(long taskId) throws PortalException {

        Task task = getTask(taskId);

        if (task == null) {//TODO tratamento de exceção
            return null;
        }

        task.setStatus(TaskStatus.CONCLUIDO.getCode());
        task.setModifiedDate(new Date());

        task = updateTask(task);

        return task;
    }

    public List<Task> findByUserIdAndGroupId(long userId, long groupId) {
        return taskPersistence.findByUserIdAndGroupId(userId, groupId);
    }

    public List<Task> findByUserIdAndGroupIdAndRelativeId(long userId, long groupId, int relativeId) {
        return taskPersistence.findByUserIdAndGroupIdAndRelativeId(userId, groupId, relativeId);
    }

    public List<Task> findByUserIdAndGroupIdAndStatus(long userId, long groupId, int status) {
        return taskPersistence.findByUserIdAndGroupIdAndStatus(userId, groupId, status);
    }

    public void deleteTask(long taskId, long userId, long groupId) throws PortalException {

        Task task = getTask(taskId);

        if (task != null) {
            List<Task> tasks = taskPersistence.findByUserIdAndGroupIdAndRelativeId(userId, groupId, task.getTaskId());
            if (!tasks.isEmpty()) {
                for (Task entity : tasks) {
                    deleteTask(entity);
                }
            }
            deleteTask(task);
        }
    }
}