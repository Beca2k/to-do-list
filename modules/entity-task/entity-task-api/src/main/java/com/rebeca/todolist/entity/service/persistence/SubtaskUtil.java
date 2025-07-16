/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.rebeca.todolist.entity.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.rebeca.todolist.entity.model.Subtask;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the subtask service. This utility wraps <code>com.rebeca.todolist.entity.service.persistence.impl.SubtaskPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubtaskPersistence
 * @generated
 */
public class SubtaskUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Subtask subtask) {
		getPersistence().clearCache(subtask);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Subtask> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Subtask> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Subtask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Subtask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Subtask> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Subtask update(Subtask subtask) {
		return getPersistence().update(subtask);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Subtask update(
		Subtask subtask, ServiceContext serviceContext) {

		return getPersistence().update(subtask, serviceContext);
	}

	/**
	 * Returns all the subtasks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching subtasks
	 */
	public static List<Subtask> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the subtasks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubtaskModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of subtasks
	 * @param end the upper bound of the range of subtasks (not inclusive)
	 * @return the range of matching subtasks
	 */
	public static List<Subtask> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the subtasks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubtaskModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of subtasks
	 * @param end the upper bound of the range of subtasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching subtasks
	 */
	public static List<Subtask> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Subtask> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the subtasks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubtaskModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of subtasks
	 * @param end the upper bound of the range of subtasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching subtasks
	 */
	public static List<Subtask> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Subtask> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first subtask in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subtask
	 * @throws NoSuchSubtaskException if a matching subtask could not be found
	 */
	public static Subtask findByUuid_First(
			String uuid, OrderByComparator<Subtask> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchSubtaskException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first subtask in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	public static Subtask fetchByUuid_First(
		String uuid, OrderByComparator<Subtask> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last subtask in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subtask
	 * @throws NoSuchSubtaskException if a matching subtask could not be found
	 */
	public static Subtask findByUuid_Last(
			String uuid, OrderByComparator<Subtask> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchSubtaskException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last subtask in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	public static Subtask fetchByUuid_Last(
		String uuid, OrderByComparator<Subtask> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the subtasks before and after the current subtask in the ordered set where uuid = &#63;.
	 *
	 * @param subtaskId the primary key of the current subtask
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subtask
	 * @throws NoSuchSubtaskException if a subtask with the primary key could not be found
	 */
	public static Subtask[] findByUuid_PrevAndNext(
			long subtaskId, String uuid,
			OrderByComparator<Subtask> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchSubtaskException {

		return getPersistence().findByUuid_PrevAndNext(
			subtaskId, uuid, orderByComparator);
	}

	/**
	 * Removes all the subtasks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of subtasks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching subtasks
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the subtask where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSubtaskException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching subtask
	 * @throws NoSuchSubtaskException if a matching subtask could not be found
	 */
	public static Subtask findByUUID_G(String uuid, long groupId)
		throws com.rebeca.todolist.entity.exception.NoSuchSubtaskException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the subtask where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	public static Subtask fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the subtask where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	public static Subtask fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the subtask where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the subtask that was removed
	 */
	public static Subtask removeByUUID_G(String uuid, long groupId)
		throws com.rebeca.todolist.entity.exception.NoSuchSubtaskException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of subtasks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching subtasks
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the subtasks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching subtasks
	 */
	public static List<Subtask> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the subtasks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubtaskModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of subtasks
	 * @param end the upper bound of the range of subtasks (not inclusive)
	 * @return the range of matching subtasks
	 */
	public static List<Subtask> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the subtasks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubtaskModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of subtasks
	 * @param end the upper bound of the range of subtasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching subtasks
	 */
	public static List<Subtask> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Subtask> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the subtasks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubtaskModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of subtasks
	 * @param end the upper bound of the range of subtasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching subtasks
	 */
	public static List<Subtask> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Subtask> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first subtask in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subtask
	 * @throws NoSuchSubtaskException if a matching subtask could not be found
	 */
	public static Subtask findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Subtask> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchSubtaskException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first subtask in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	public static Subtask fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Subtask> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last subtask in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subtask
	 * @throws NoSuchSubtaskException if a matching subtask could not be found
	 */
	public static Subtask findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Subtask> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchSubtaskException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last subtask in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	public static Subtask fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Subtask> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the subtasks before and after the current subtask in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param subtaskId the primary key of the current subtask
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subtask
	 * @throws NoSuchSubtaskException if a subtask with the primary key could not be found
	 */
	public static Subtask[] findByUuid_C_PrevAndNext(
			long subtaskId, String uuid, long companyId,
			OrderByComparator<Subtask> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchSubtaskException {

		return getPersistence().findByUuid_C_PrevAndNext(
			subtaskId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the subtasks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of subtasks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching subtasks
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the subtasks where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching subtasks
	 */
	public static List<Subtask> findByTaskId(long taskId) {
		return getPersistence().findByTaskId(taskId);
	}

	/**
	 * Returns a range of all the subtasks where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubtaskModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of subtasks
	 * @param end the upper bound of the range of subtasks (not inclusive)
	 * @return the range of matching subtasks
	 */
	public static List<Subtask> findByTaskId(long taskId, int start, int end) {
		return getPersistence().findByTaskId(taskId, start, end);
	}

	/**
	 * Returns an ordered range of all the subtasks where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubtaskModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of subtasks
	 * @param end the upper bound of the range of subtasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching subtasks
	 */
	public static List<Subtask> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<Subtask> orderByComparator) {

		return getPersistence().findByTaskId(
			taskId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the subtasks where taskId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubtaskModelImpl</code>.
	 * </p>
	 *
	 * @param taskId the task ID
	 * @param start the lower bound of the range of subtasks
	 * @param end the upper bound of the range of subtasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching subtasks
	 */
	public static List<Subtask> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<Subtask> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTaskId(
			taskId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first subtask in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subtask
	 * @throws NoSuchSubtaskException if a matching subtask could not be found
	 */
	public static Subtask findByTaskId_First(
			long taskId, OrderByComparator<Subtask> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchSubtaskException {

		return getPersistence().findByTaskId_First(taskId, orderByComparator);
	}

	/**
	 * Returns the first subtask in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	public static Subtask fetchByTaskId_First(
		long taskId, OrderByComparator<Subtask> orderByComparator) {

		return getPersistence().fetchByTaskId_First(taskId, orderByComparator);
	}

	/**
	 * Returns the last subtask in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subtask
	 * @throws NoSuchSubtaskException if a matching subtask could not be found
	 */
	public static Subtask findByTaskId_Last(
			long taskId, OrderByComparator<Subtask> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchSubtaskException {

		return getPersistence().findByTaskId_Last(taskId, orderByComparator);
	}

	/**
	 * Returns the last subtask in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	public static Subtask fetchByTaskId_Last(
		long taskId, OrderByComparator<Subtask> orderByComparator) {

		return getPersistence().fetchByTaskId_Last(taskId, orderByComparator);
	}

	/**
	 * Returns the subtasks before and after the current subtask in the ordered set where taskId = &#63;.
	 *
	 * @param subtaskId the primary key of the current subtask
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subtask
	 * @throws NoSuchSubtaskException if a subtask with the primary key could not be found
	 */
	public static Subtask[] findByTaskId_PrevAndNext(
			long subtaskId, long taskId,
			OrderByComparator<Subtask> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchSubtaskException {

		return getPersistence().findByTaskId_PrevAndNext(
			subtaskId, taskId, orderByComparator);
	}

	/**
	 * Removes all the subtasks where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	public static void removeByTaskId(long taskId) {
		getPersistence().removeByTaskId(taskId);
	}

	/**
	 * Returns the number of subtasks where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching subtasks
	 */
	public static int countByTaskId(long taskId) {
		return getPersistence().countByTaskId(taskId);
	}

	/**
	 * Caches the subtask in the entity cache if it is enabled.
	 *
	 * @param subtask the subtask
	 */
	public static void cacheResult(Subtask subtask) {
		getPersistence().cacheResult(subtask);
	}

	/**
	 * Caches the subtasks in the entity cache if it is enabled.
	 *
	 * @param subtasks the subtasks
	 */
	public static void cacheResult(List<Subtask> subtasks) {
		getPersistence().cacheResult(subtasks);
	}

	/**
	 * Creates a new subtask with the primary key. Does not add the subtask to the database.
	 *
	 * @param subtaskId the primary key for the new subtask
	 * @return the new subtask
	 */
	public static Subtask create(long subtaskId) {
		return getPersistence().create(subtaskId);
	}

	/**
	 * Removes the subtask with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subtaskId the primary key of the subtask
	 * @return the subtask that was removed
	 * @throws NoSuchSubtaskException if a subtask with the primary key could not be found
	 */
	public static Subtask remove(long subtaskId)
		throws com.rebeca.todolist.entity.exception.NoSuchSubtaskException {

		return getPersistence().remove(subtaskId);
	}

	public static Subtask updateImpl(Subtask subtask) {
		return getPersistence().updateImpl(subtask);
	}

	/**
	 * Returns the subtask with the primary key or throws a <code>NoSuchSubtaskException</code> if it could not be found.
	 *
	 * @param subtaskId the primary key of the subtask
	 * @return the subtask
	 * @throws NoSuchSubtaskException if a subtask with the primary key could not be found
	 */
	public static Subtask findByPrimaryKey(long subtaskId)
		throws com.rebeca.todolist.entity.exception.NoSuchSubtaskException {

		return getPersistence().findByPrimaryKey(subtaskId);
	}

	/**
	 * Returns the subtask with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subtaskId the primary key of the subtask
	 * @return the subtask, or <code>null</code> if a subtask with the primary key could not be found
	 */
	public static Subtask fetchByPrimaryKey(long subtaskId) {
		return getPersistence().fetchByPrimaryKey(subtaskId);
	}

	/**
	 * Returns all the subtasks.
	 *
	 * @return the subtasks
	 */
	public static List<Subtask> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the subtasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubtaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subtasks
	 * @param end the upper bound of the range of subtasks (not inclusive)
	 * @return the range of subtasks
	 */
	public static List<Subtask> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the subtasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubtaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subtasks
	 * @param end the upper bound of the range of subtasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of subtasks
	 */
	public static List<Subtask> findAll(
		int start, int end, OrderByComparator<Subtask> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the subtasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubtaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subtasks
	 * @param end the upper bound of the range of subtasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of subtasks
	 */
	public static List<Subtask> findAll(
		int start, int end, OrderByComparator<Subtask> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the subtasks from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of subtasks.
	 *
	 * @return the number of subtasks
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SubtaskPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(SubtaskPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile SubtaskPersistence _persistence;

}