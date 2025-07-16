/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.rebeca.todolist.entity.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link TaskLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TaskLocalService
 * @generated
 */
public class TaskLocalServiceWrapper
	implements ServiceWrapper<TaskLocalService>, TaskLocalService {

	public TaskLocalServiceWrapper() {
		this(null);
	}

	public TaskLocalServiceWrapper(TaskLocalService taskLocalService) {
		_taskLocalService = taskLocalService;
	}

	@Override
	public com.rebeca.todolist.entity.model.Task addTask(
			String title, String description, String path, long fileEntryId,
			long relativeId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskLocalService.addTask(
			title, description, path, fileEntryId, relativeId, serviceContext);
	}

	/**
	 * Adds the task to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TaskLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param task the task
	 * @return the task that was added
	 */
	@Override
	public com.rebeca.todolist.entity.model.Task addTask(
		com.rebeca.todolist.entity.model.Task task) {

		return _taskLocalService.addTask(task);
	}

	@Override
	public com.rebeca.todolist.entity.model.Task changeStatus(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskLocalService.changeStatus(taskId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new task with the primary key. Does not add the task to the database.
	 *
	 * @param taskId the primary key for the new task
	 * @return the new task
	 */
	@Override
	public com.rebeca.todolist.entity.model.Task createTask(long taskId) {
		return _taskLocalService.createTask(taskId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TaskLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param taskId the primary key of the task
	 * @return the task that was removed
	 * @throws PortalException if a task with the primary key could not be found
	 */
	@Override
	public com.rebeca.todolist.entity.model.Task deleteTask(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskLocalService.deleteTask(taskId);
	}

	@Override
	public void deleteTask(long taskId, long userId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_taskLocalService.deleteTask(taskId, userId, groupId);
	}

	/**
	 * Deletes the task from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TaskLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param task the task
	 * @return the task that was removed
	 */
	@Override
	public com.rebeca.todolist.entity.model.Task deleteTask(
		com.rebeca.todolist.entity.model.Task task) {

		return _taskLocalService.deleteTask(task);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _taskLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _taskLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _taskLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _taskLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.rebeca.todolist.entity.model.impl.TaskModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _taskLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.rebeca.todolist.entity.model.impl.TaskModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _taskLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _taskLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _taskLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.rebeca.todolist.entity.model.Task fetchTask(long taskId) {
		return _taskLocalService.fetchTask(taskId);
	}

	/**
	 * Returns the task matching the UUID and group.
	 *
	 * @param uuid the task's UUID
	 * @param groupId the primary key of the group
	 * @return the matching task, or <code>null</code> if a matching task could not be found
	 */
	@Override
	public com.rebeca.todolist.entity.model.Task fetchTaskByUuidAndGroupId(
		String uuid, long groupId) {

		return _taskLocalService.fetchTaskByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.rebeca.todolist.entity.model.Task>
		findByUserIdAndGroupId(long userId, long groupId) {

		return _taskLocalService.findByUserIdAndGroupId(userId, groupId);
	}

	@Override
	public java.util.List<com.rebeca.todolist.entity.model.Task>
		findByUserIdAndGroupIdAndRelativeId(
			long userId, long groupId, int relativeId) {

		return _taskLocalService.findByUserIdAndGroupIdAndRelativeId(
			userId, groupId, relativeId);
	}

	@Override
	public java.util.List<com.rebeca.todolist.entity.model.Task>
		findByUserIdAndGroupIdAndStatus(long userId, long groupId, int status) {

		return _taskLocalService.findByUserIdAndGroupIdAndStatus(
			userId, groupId, status);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _taskLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _taskLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _taskLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _taskLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the task with the primary key.
	 *
	 * @param taskId the primary key of the task
	 * @return the task
	 * @throws PortalException if a task with the primary key could not be found
	 */
	@Override
	public com.rebeca.todolist.entity.model.Task getTask(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskLocalService.getTask(taskId);
	}

	/**
	 * Returns the task matching the UUID and group.
	 *
	 * @param uuid the task's UUID
	 * @param groupId the primary key of the group
	 * @return the matching task
	 * @throws PortalException if a matching task could not be found
	 */
	@Override
	public com.rebeca.todolist.entity.model.Task getTaskByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskLocalService.getTaskByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.rebeca.todolist.entity.model.impl.TaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of tasks
	 */
	@Override
	public java.util.List<com.rebeca.todolist.entity.model.Task> getTasks(
		int start, int end) {

		return _taskLocalService.getTasks(start, end);
	}

	/**
	 * Returns all the tasks matching the UUID and company.
	 *
	 * @param uuid the UUID of the tasks
	 * @param companyId the primary key of the company
	 * @return the matching tasks, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.rebeca.todolist.entity.model.Task>
		getTasksByUuidAndCompanyId(String uuid, long companyId) {

		return _taskLocalService.getTasksByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of tasks matching the UUID and company.
	 *
	 * @param uuid the UUID of the tasks
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching tasks, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.rebeca.todolist.entity.model.Task>
		getTasksByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.rebeca.todolist.entity.model.Task> orderByComparator) {

		return _taskLocalService.getTasksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of tasks.
	 *
	 * @return the number of tasks
	 */
	@Override
	public int getTasksCount() {
		return _taskLocalService.getTasksCount();
	}

	@Override
	public com.rebeca.todolist.entity.model.Task updateTask(
			long taskId, String title, int status, String description,
			String path, long relativeId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskLocalService.updateTask(
			taskId, title, status, description, path, relativeId,
			serviceContext);
	}

	/**
	 * Updates the task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TaskLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param task the task
	 * @return the task that was updated
	 */
	@Override
	public com.rebeca.todolist.entity.model.Task updateTask(
		com.rebeca.todolist.entity.model.Task task) {

		return _taskLocalService.updateTask(task);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _taskLocalService.getBasePersistence();
	}

	@Override
	public TaskLocalService getWrappedService() {
		return _taskLocalService;
	}

	@Override
	public void setWrappedService(TaskLocalService taskLocalService) {
		_taskLocalService = taskLocalService;
	}

	private TaskLocalService _taskLocalService;

}