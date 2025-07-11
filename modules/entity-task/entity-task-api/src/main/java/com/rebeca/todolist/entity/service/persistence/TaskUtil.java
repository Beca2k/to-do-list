/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.rebeca.todolist.entity.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.rebeca.todolist.entity.model.Task;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the task service. This utility wraps <code>com.rebeca.todolist.entity.service.persistence.impl.TaskPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskPersistence
 * @generated
 */
public class TaskUtil {

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
	public static void clearCache(Task task) {
		getPersistence().clearCache(task);
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
	public static Map<Serializable, Task> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Task> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Task> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Task> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Task> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Task update(Task task) {
		return getPersistence().update(task);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Task update(Task task, ServiceContext serviceContext) {
		return getPersistence().update(task, serviceContext);
	}

	/**
	 * Returns all the tasks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching tasks
	 */
	public static List<Task> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the tasks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of matching tasks
	 */
	public static List<Task> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the tasks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tasks
	 */
	public static List<Task> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Task> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tasks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tasks
	 */
	public static List<Task> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Task> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public static Task findByUuid_First(
			String uuid, OrderByComparator<Task> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchTaskException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	public static Task fetchByUuid_First(
		String uuid, OrderByComparator<Task> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public static Task findByUuid_Last(
			String uuid, OrderByComparator<Task> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchTaskException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	public static Task fetchByUuid_Last(
		String uuid, OrderByComparator<Task> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the tasks before and after the current task in the ordered set where uuid = &#63;.
	 *
	 * @param taskId the primary key of the current task
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	public static Task[] findByUuid_PrevAndNext(
			long taskId, String uuid, OrderByComparator<Task> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchTaskException {

		return getPersistence().findByUuid_PrevAndNext(
			taskId, uuid, orderByComparator);
	}

	/**
	 * Removes all the tasks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of tasks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching tasks
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the task where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTaskException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public static Task findByUUID_G(String uuid, long groupId)
		throws com.rebeca.todolist.entity.exception.NoSuchTaskException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching task, or <code>null</code> if a matching task could not be found
	 */
	public static Task fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the task where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching task, or <code>null</code> if a matching task could not be found
	 */
	public static Task fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the task where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the task that was removed
	 */
	public static Task removeByUUID_G(String uuid, long groupId)
		throws com.rebeca.todolist.entity.exception.NoSuchTaskException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of tasks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching tasks
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the tasks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching tasks
	 */
	public static List<Task> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the tasks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of matching tasks
	 */
	public static List<Task> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the tasks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tasks
	 */
	public static List<Task> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Task> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tasks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tasks
	 */
	public static List<Task> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Task> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first task in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public static Task findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Task> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchTaskException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first task in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	public static Task fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Task> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last task in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public static Task findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Task> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchTaskException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last task in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	public static Task fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Task> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the tasks before and after the current task in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param taskId the primary key of the current task
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	public static Task[] findByUuid_C_PrevAndNext(
			long taskId, String uuid, long companyId,
			OrderByComparator<Task> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchTaskException {

		return getPersistence().findByUuid_C_PrevAndNext(
			taskId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the tasks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of tasks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching tasks
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the tasks where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching tasks
	 */
	public static List<Task> findByUserIdAndGroupId(long userId, long groupId) {
		return getPersistence().findByUserIdAndGroupId(userId, groupId);
	}

	/**
	 * Returns a range of all the tasks where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of matching tasks
	 */
	public static List<Task> findByUserIdAndGroupId(
		long userId, long groupId, int start, int end) {

		return getPersistence().findByUserIdAndGroupId(
			userId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the tasks where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tasks
	 */
	public static List<Task> findByUserIdAndGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<Task> orderByComparator) {

		return getPersistence().findByUserIdAndGroupId(
			userId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tasks where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tasks
	 */
	public static List<Task> findByUserIdAndGroupId(
		long userId, long groupId, int start, int end,
		OrderByComparator<Task> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserIdAndGroupId(
			userId, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first task in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public static Task findByUserIdAndGroupId_First(
			long userId, long groupId,
			OrderByComparator<Task> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchTaskException {

		return getPersistence().findByUserIdAndGroupId_First(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the first task in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	public static Task fetchByUserIdAndGroupId_First(
		long userId, long groupId, OrderByComparator<Task> orderByComparator) {

		return getPersistence().fetchByUserIdAndGroupId_First(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the last task in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public static Task findByUserIdAndGroupId_Last(
			long userId, long groupId,
			OrderByComparator<Task> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchTaskException {

		return getPersistence().findByUserIdAndGroupId_Last(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the last task in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	public static Task fetchByUserIdAndGroupId_Last(
		long userId, long groupId, OrderByComparator<Task> orderByComparator) {

		return getPersistence().fetchByUserIdAndGroupId_Last(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the tasks before and after the current task in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param taskId the primary key of the current task
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	public static Task[] findByUserIdAndGroupId_PrevAndNext(
			long taskId, long userId, long groupId,
			OrderByComparator<Task> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchTaskException {

		return getPersistence().findByUserIdAndGroupId_PrevAndNext(
			taskId, userId, groupId, orderByComparator);
	}

	/**
	 * Removes all the tasks where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 */
	public static void removeByUserIdAndGroupId(long userId, long groupId) {
		getPersistence().removeByUserIdAndGroupId(userId, groupId);
	}

	/**
	 * Returns the number of tasks where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching tasks
	 */
	public static int countByUserIdAndGroupId(long userId, long groupId) {
		return getPersistence().countByUserIdAndGroupId(userId, groupId);
	}

	/**
	 * Returns all the tasks where userId = &#63; and groupId = &#63; and relativeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param relativeId the relative ID
	 * @return the matching tasks
	 */
	public static List<Task> findByUserIdAndGroupIdAndRelativeId(
		long userId, long groupId, long relativeId) {

		return getPersistence().findByUserIdAndGroupIdAndRelativeId(
			userId, groupId, relativeId);
	}

	/**
	 * Returns a range of all the tasks where userId = &#63; and groupId = &#63; and relativeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param relativeId the relative ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of matching tasks
	 */
	public static List<Task> findByUserIdAndGroupIdAndRelativeId(
		long userId, long groupId, long relativeId, int start, int end) {

		return getPersistence().findByUserIdAndGroupIdAndRelativeId(
			userId, groupId, relativeId, start, end);
	}

	/**
	 * Returns an ordered range of all the tasks where userId = &#63; and groupId = &#63; and relativeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param relativeId the relative ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tasks
	 */
	public static List<Task> findByUserIdAndGroupIdAndRelativeId(
		long userId, long groupId, long relativeId, int start, int end,
		OrderByComparator<Task> orderByComparator) {

		return getPersistence().findByUserIdAndGroupIdAndRelativeId(
			userId, groupId, relativeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tasks where userId = &#63; and groupId = &#63; and relativeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param relativeId the relative ID
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tasks
	 */
	public static List<Task> findByUserIdAndGroupIdAndRelativeId(
		long userId, long groupId, long relativeId, int start, int end,
		OrderByComparator<Task> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserIdAndGroupIdAndRelativeId(
			userId, groupId, relativeId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first task in the ordered set where userId = &#63; and groupId = &#63; and relativeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param relativeId the relative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public static Task findByUserIdAndGroupIdAndRelativeId_First(
			long userId, long groupId, long relativeId,
			OrderByComparator<Task> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchTaskException {

		return getPersistence().findByUserIdAndGroupIdAndRelativeId_First(
			userId, groupId, relativeId, orderByComparator);
	}

	/**
	 * Returns the first task in the ordered set where userId = &#63; and groupId = &#63; and relativeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param relativeId the relative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	public static Task fetchByUserIdAndGroupIdAndRelativeId_First(
		long userId, long groupId, long relativeId,
		OrderByComparator<Task> orderByComparator) {

		return getPersistence().fetchByUserIdAndGroupIdAndRelativeId_First(
			userId, groupId, relativeId, orderByComparator);
	}

	/**
	 * Returns the last task in the ordered set where userId = &#63; and groupId = &#63; and relativeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param relativeId the relative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public static Task findByUserIdAndGroupIdAndRelativeId_Last(
			long userId, long groupId, long relativeId,
			OrderByComparator<Task> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchTaskException {

		return getPersistence().findByUserIdAndGroupIdAndRelativeId_Last(
			userId, groupId, relativeId, orderByComparator);
	}

	/**
	 * Returns the last task in the ordered set where userId = &#63; and groupId = &#63; and relativeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param relativeId the relative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	public static Task fetchByUserIdAndGroupIdAndRelativeId_Last(
		long userId, long groupId, long relativeId,
		OrderByComparator<Task> orderByComparator) {

		return getPersistence().fetchByUserIdAndGroupIdAndRelativeId_Last(
			userId, groupId, relativeId, orderByComparator);
	}

	/**
	 * Returns the tasks before and after the current task in the ordered set where userId = &#63; and groupId = &#63; and relativeId = &#63;.
	 *
	 * @param taskId the primary key of the current task
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param relativeId the relative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	public static Task[] findByUserIdAndGroupIdAndRelativeId_PrevAndNext(
			long taskId, long userId, long groupId, long relativeId,
			OrderByComparator<Task> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchTaskException {

		return getPersistence().findByUserIdAndGroupIdAndRelativeId_PrevAndNext(
			taskId, userId, groupId, relativeId, orderByComparator);
	}

	/**
	 * Removes all the tasks where userId = &#63; and groupId = &#63; and relativeId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param relativeId the relative ID
	 */
	public static void removeByUserIdAndGroupIdAndRelativeId(
		long userId, long groupId, long relativeId) {

		getPersistence().removeByUserIdAndGroupIdAndRelativeId(
			userId, groupId, relativeId);
	}

	/**
	 * Returns the number of tasks where userId = &#63; and groupId = &#63; and relativeId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param relativeId the relative ID
	 * @return the number of matching tasks
	 */
	public static int countByUserIdAndGroupIdAndRelativeId(
		long userId, long groupId, long relativeId) {

		return getPersistence().countByUserIdAndGroupIdAndRelativeId(
			userId, groupId, relativeId);
	}

	/**
	 * Returns all the tasks where userId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching tasks
	 */
	public static List<Task> findByUserIdAndGroupIdAndStatus(
		long userId, long groupId, int status) {

		return getPersistence().findByUserIdAndGroupIdAndStatus(
			userId, groupId, status);
	}

	/**
	 * Returns a range of all the tasks where userId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of matching tasks
	 */
	public static List<Task> findByUserIdAndGroupIdAndStatus(
		long userId, long groupId, int status, int start, int end) {

		return getPersistence().findByUserIdAndGroupIdAndStatus(
			userId, groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the tasks where userId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tasks
	 */
	public static List<Task> findByUserIdAndGroupIdAndStatus(
		long userId, long groupId, int status, int start, int end,
		OrderByComparator<Task> orderByComparator) {

		return getPersistence().findByUserIdAndGroupIdAndStatus(
			userId, groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tasks where userId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tasks
	 */
	public static List<Task> findByUserIdAndGroupIdAndStatus(
		long userId, long groupId, int status, int start, int end,
		OrderByComparator<Task> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserIdAndGroupIdAndStatus(
			userId, groupId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first task in the ordered set where userId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public static Task findByUserIdAndGroupIdAndStatus_First(
			long userId, long groupId, int status,
			OrderByComparator<Task> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchTaskException {

		return getPersistence().findByUserIdAndGroupIdAndStatus_First(
			userId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the first task in the ordered set where userId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task, or <code>null</code> if a matching task could not be found
	 */
	public static Task fetchByUserIdAndGroupIdAndStatus_First(
		long userId, long groupId, int status,
		OrderByComparator<Task> orderByComparator) {

		return getPersistence().fetchByUserIdAndGroupIdAndStatus_First(
			userId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the last task in the ordered set where userId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task
	 * @throws NoSuchTaskException if a matching task could not be found
	 */
	public static Task findByUserIdAndGroupIdAndStatus_Last(
			long userId, long groupId, int status,
			OrderByComparator<Task> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchTaskException {

		return getPersistence().findByUserIdAndGroupIdAndStatus_Last(
			userId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the last task in the ordered set where userId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task, or <code>null</code> if a matching task could not be found
	 */
	public static Task fetchByUserIdAndGroupIdAndStatus_Last(
		long userId, long groupId, int status,
		OrderByComparator<Task> orderByComparator) {

		return getPersistence().fetchByUserIdAndGroupIdAndStatus_Last(
			userId, groupId, status, orderByComparator);
	}

	/**
	 * Returns the tasks before and after the current task in the ordered set where userId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param taskId the primary key of the current task
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	public static Task[] findByUserIdAndGroupIdAndStatus_PrevAndNext(
			long taskId, long userId, long groupId, int status,
			OrderByComparator<Task> orderByComparator)
		throws com.rebeca.todolist.entity.exception.NoSuchTaskException {

		return getPersistence().findByUserIdAndGroupIdAndStatus_PrevAndNext(
			taskId, userId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the tasks where userId = &#63; and groupId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByUserIdAndGroupIdAndStatus(
		long userId, long groupId, int status) {

		getPersistence().removeByUserIdAndGroupIdAndStatus(
			userId, groupId, status);
	}

	/**
	 * Returns the number of tasks where userId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching tasks
	 */
	public static int countByUserIdAndGroupIdAndStatus(
		long userId, long groupId, int status) {

		return getPersistence().countByUserIdAndGroupIdAndStatus(
			userId, groupId, status);
	}

	/**
	 * Caches the task in the entity cache if it is enabled.
	 *
	 * @param task the task
	 */
	public static void cacheResult(Task task) {
		getPersistence().cacheResult(task);
	}

	/**
	 * Caches the tasks in the entity cache if it is enabled.
	 *
	 * @param tasks the tasks
	 */
	public static void cacheResult(List<Task> tasks) {
		getPersistence().cacheResult(tasks);
	}

	/**
	 * Creates a new task with the primary key. Does not add the task to the database.
	 *
	 * @param taskId the primary key for the new task
	 * @return the new task
	 */
	public static Task create(long taskId) {
		return getPersistence().create(taskId);
	}

	/**
	 * Removes the task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskId the primary key of the task
	 * @return the task that was removed
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	public static Task remove(long taskId)
		throws com.rebeca.todolist.entity.exception.NoSuchTaskException {

		return getPersistence().remove(taskId);
	}

	public static Task updateImpl(Task task) {
		return getPersistence().updateImpl(task);
	}

	/**
	 * Returns the task with the primary key or throws a <code>NoSuchTaskException</code> if it could not be found.
	 *
	 * @param taskId the primary key of the task
	 * @return the task
	 * @throws NoSuchTaskException if a task with the primary key could not be found
	 */
	public static Task findByPrimaryKey(long taskId)
		throws com.rebeca.todolist.entity.exception.NoSuchTaskException {

		return getPersistence().findByPrimaryKey(taskId);
	}

	/**
	 * Returns the task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskId the primary key of the task
	 * @return the task, or <code>null</code> if a task with the primary key could not be found
	 */
	public static Task fetchByPrimaryKey(long taskId) {
		return getPersistence().fetchByPrimaryKey(taskId);
	}

	/**
	 * Returns all the tasks.
	 *
	 * @return the tasks
	 */
	public static List<Task> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @return the range of tasks
	 */
	public static List<Task> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tasks
	 */
	public static List<Task> findAll(
		int start, int end, OrderByComparator<Task> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tasks
	 * @param end the upper bound of the range of tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tasks
	 */
	public static List<Task> findAll(
		int start, int end, OrderByComparator<Task> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the tasks from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of tasks.
	 *
	 * @return the number of tasks
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TaskPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(TaskPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile TaskPersistence _persistence;

}