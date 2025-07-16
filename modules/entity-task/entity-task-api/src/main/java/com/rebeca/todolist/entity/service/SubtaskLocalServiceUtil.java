/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.rebeca.todolist.entity.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.rebeca.todolist.entity.model.Subtask;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Subtask. This utility wraps
 * <code>com.rebeca.todolist.entity.service.impl.SubtaskLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SubtaskLocalService
 * @generated
 */
public class SubtaskLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.rebeca.todolist.entity.service.impl.SubtaskLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Subtask addSubTask(String title) throws PortalException {
		return getService().addSubTask(title);
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
	public static Subtask addSubtask(Subtask subtask) {
		return getService().addSubtask(subtask);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new subtask with the primary key. Does not add the subtask to the database.
	 *
	 * @param subtaskId the primary key for the new subtask
	 * @return the new subtask
	 */
	public static Subtask createSubtask(long subtaskId) {
		return getService().createSubtask(subtaskId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static Subtask deleteSubtask(long subtaskId) throws PortalException {
		return getService().deleteSubtask(subtaskId);
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
	public static Subtask deleteSubtask(Subtask subtask) {
		return getService().deleteSubtask(subtask);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Subtask fetchSubtask(long subtaskId) {
		return getService().fetchSubtask(subtaskId);
	}

	/**
	 * Returns the subtask matching the UUID and group.
	 *
	 * @param uuid the subtask's UUID
	 * @param groupId the primary key of the group
	 * @return the matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	public static Subtask fetchSubtaskByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchSubtaskByUuidAndGroupId(uuid, groupId);
	}

	public static List<Subtask> findByTaskId(long taskId) {
		return getService().findByTaskId(taskId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the subtask with the primary key.
	 *
	 * @param subtaskId the primary key of the subtask
	 * @return the subtask
	 * @throws PortalException if a subtask with the primary key could not be found
	 */
	public static Subtask getSubtask(long subtaskId) throws PortalException {
		return getService().getSubtask(subtaskId);
	}

	/**
	 * Returns the subtask matching the UUID and group.
	 *
	 * @param uuid the subtask's UUID
	 * @param groupId the primary key of the group
	 * @return the matching subtask
	 * @throws PortalException if a matching subtask could not be found
	 */
	public static Subtask getSubtaskByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getSubtaskByUuidAndGroupId(uuid, groupId);
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
	public static List<Subtask> getSubtasks(int start, int end) {
		return getService().getSubtasks(start, end);
	}

	/**
	 * Returns all the subtasks matching the UUID and company.
	 *
	 * @param uuid the UUID of the subtasks
	 * @param companyId the primary key of the company
	 * @return the matching subtasks, or an empty list if no matches were found
	 */
	public static List<Subtask> getSubtasksByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getSubtasksByUuidAndCompanyId(uuid, companyId);
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
	public static List<Subtask> getSubtasksByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Subtask> orderByComparator) {

		return getService().getSubtasksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of subtasks.
	 *
	 * @return the number of subtasks
	 */
	public static int getSubtasksCount() {
		return getService().getSubtasksCount();
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
	public static Subtask updateSubtask(Subtask subtask) {
		return getService().updateSubtask(subtask);
	}

	public static SubtaskLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<SubtaskLocalService> _serviceSnapshot =
		new Snapshot<>(
			SubtaskLocalServiceUtil.class, SubtaskLocalService.class);

}