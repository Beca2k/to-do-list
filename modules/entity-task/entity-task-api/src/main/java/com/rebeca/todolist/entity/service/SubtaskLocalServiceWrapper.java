/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.rebeca.todolist.entity.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link SubtaskLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SubtaskLocalService
 * @generated
 */
public class SubtaskLocalServiceWrapper
	implements ServiceWrapper<SubtaskLocalService>, SubtaskLocalService {

	public SubtaskLocalServiceWrapper() {
		this(null);
	}

	public SubtaskLocalServiceWrapper(SubtaskLocalService subtaskLocalService) {
		_subtaskLocalService = subtaskLocalService;
	}

	@Override
	public com.rebeca.todolist.entity.model.Subtask addSubTask(String title)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subtaskLocalService.addSubTask(title);
	}

	/**
	 * Adds the subtask to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubtaskLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subtask the subtask
	 * @return the subtask that was added
	 */
	@Override
	public com.rebeca.todolist.entity.model.Subtask addSubtask(
		com.rebeca.todolist.entity.model.Subtask subtask) {

		return _subtaskLocalService.addSubtask(subtask);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subtaskLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new subtask with the primary key. Does not add the subtask to the database.
	 *
	 * @param subtaskId the primary key for the new subtask
	 * @return the new subtask
	 */
	@Override
	public com.rebeca.todolist.entity.model.Subtask createSubtask(
		long subtaskId) {

		return _subtaskLocalService.createSubtask(subtaskId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subtaskLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the subtask with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubtaskLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subtaskId the primary key of the subtask
	 * @return the subtask that was removed
	 * @throws PortalException if a subtask with the primary key could not be found
	 */
	@Override
	public com.rebeca.todolist.entity.model.Subtask deleteSubtask(
			long subtaskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subtaskLocalService.deleteSubtask(subtaskId);
	}

	/**
	 * Deletes the subtask from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubtaskLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subtask the subtask
	 * @return the subtask that was removed
	 */
	@Override
	public com.rebeca.todolist.entity.model.Subtask deleteSubtask(
		com.rebeca.todolist.entity.model.Subtask subtask) {

		return _subtaskLocalService.deleteSubtask(subtask);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _subtaskLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _subtaskLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _subtaskLocalService.dynamicQuery();
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

		return _subtaskLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.rebeca.todolist.entity.model.impl.SubtaskModelImpl</code>.
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

		return _subtaskLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.rebeca.todolist.entity.model.impl.SubtaskModelImpl</code>.
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

		return _subtaskLocalService.dynamicQuery(
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

		return _subtaskLocalService.dynamicQueryCount(dynamicQuery);
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

		return _subtaskLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.rebeca.todolist.entity.model.Subtask fetchSubtask(
		long subtaskId) {

		return _subtaskLocalService.fetchSubtask(subtaskId);
	}

	/**
	 * Returns the subtask matching the UUID and group.
	 *
	 * @param uuid the subtask's UUID
	 * @param groupId the primary key of the group
	 * @return the matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	@Override
	public com.rebeca.todolist.entity.model.Subtask
		fetchSubtaskByUuidAndGroupId(String uuid, long groupId) {

		return _subtaskLocalService.fetchSubtaskByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.rebeca.todolist.entity.model.Subtask>
		findByTaskId(long taskId) {

		return _subtaskLocalService.findByTaskId(taskId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _subtaskLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _subtaskLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _subtaskLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _subtaskLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subtaskLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the subtask with the primary key.
	 *
	 * @param subtaskId the primary key of the subtask
	 * @return the subtask
	 * @throws PortalException if a subtask with the primary key could not be found
	 */
	@Override
	public com.rebeca.todolist.entity.model.Subtask getSubtask(long subtaskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subtaskLocalService.getSubtask(subtaskId);
	}

	/**
	 * Returns the subtask matching the UUID and group.
	 *
	 * @param uuid the subtask's UUID
	 * @param groupId the primary key of the group
	 * @return the matching subtask
	 * @throws PortalException if a matching subtask could not be found
	 */
	@Override
	public com.rebeca.todolist.entity.model.Subtask getSubtaskByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subtaskLocalService.getSubtaskByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the subtasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.rebeca.todolist.entity.model.impl.SubtaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subtasks
	 * @param end the upper bound of the range of subtasks (not inclusive)
	 * @return the range of subtasks
	 */
	@Override
	public java.util.List<com.rebeca.todolist.entity.model.Subtask> getSubtasks(
		int start, int end) {

		return _subtaskLocalService.getSubtasks(start, end);
	}

	/**
	 * Returns all the subtasks matching the UUID and company.
	 *
	 * @param uuid the UUID of the subtasks
	 * @param companyId the primary key of the company
	 * @return the matching subtasks, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.rebeca.todolist.entity.model.Subtask>
		getSubtasksByUuidAndCompanyId(String uuid, long companyId) {

		return _subtaskLocalService.getSubtasksByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of subtasks matching the UUID and company.
	 *
	 * @param uuid the UUID of the subtasks
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of subtasks
	 * @param end the upper bound of the range of subtasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching subtasks, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.rebeca.todolist.entity.model.Subtask>
		getSubtasksByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.rebeca.todolist.entity.model.Subtask> orderByComparator) {

		return _subtaskLocalService.getSubtasksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of subtasks.
	 *
	 * @return the number of subtasks
	 */
	@Override
	public int getSubtasksCount() {
		return _subtaskLocalService.getSubtasksCount();
	}

	/**
	 * Updates the subtask in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubtaskLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subtask the subtask
	 * @return the subtask that was updated
	 */
	@Override
	public com.rebeca.todolist.entity.model.Subtask updateSubtask(
		com.rebeca.todolist.entity.model.Subtask subtask) {

		return _subtaskLocalService.updateSubtask(subtask);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _subtaskLocalService.getBasePersistence();
	}

	@Override
	public SubtaskLocalService getWrappedService() {
		return _subtaskLocalService;
	}

	@Override
	public void setWrappedService(SubtaskLocalService subtaskLocalService) {
		_subtaskLocalService = subtaskLocalService;
	}

	private SubtaskLocalService _subtaskLocalService;

}