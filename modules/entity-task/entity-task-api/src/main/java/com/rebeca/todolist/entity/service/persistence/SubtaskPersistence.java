/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.rebeca.todolist.entity.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.rebeca.todolist.entity.exception.NoSuchSubtaskException;
import com.rebeca.todolist.entity.model.Subtask;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the subtask service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubtaskUtil
 * @generated
 */
@ProviderType
public interface SubtaskPersistence extends BasePersistence<Subtask> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubtaskUtil} to access the subtask persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the subtasks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching subtasks
	 */
	public java.util.List<Subtask> findByUuid(String uuid);

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
	public java.util.List<Subtask> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Subtask> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subtask>
			orderByComparator);

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
	public java.util.List<Subtask> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subtask>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first subtask in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subtask
	 * @throws NoSuchSubtaskException if a matching subtask could not be found
	 */
	public Subtask findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Subtask>
				orderByComparator)
		throws NoSuchSubtaskException;

	/**
	 * Returns the first subtask in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	public Subtask fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Subtask>
			orderByComparator);

	/**
	 * Returns the last subtask in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subtask
	 * @throws NoSuchSubtaskException if a matching subtask could not be found
	 */
	public Subtask findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Subtask>
				orderByComparator)
		throws NoSuchSubtaskException;

	/**
	 * Returns the last subtask in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	public Subtask fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Subtask>
			orderByComparator);

	/**
	 * Returns the subtasks before and after the current subtask in the ordered set where uuid = &#63;.
	 *
	 * @param subtaskId the primary key of the current subtask
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subtask
	 * @throws NoSuchSubtaskException if a subtask with the primary key could not be found
	 */
	public Subtask[] findByUuid_PrevAndNext(
			long subtaskId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Subtask>
				orderByComparator)
		throws NoSuchSubtaskException;

	/**
	 * Removes all the subtasks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of subtasks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching subtasks
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the subtask where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSubtaskException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching subtask
	 * @throws NoSuchSubtaskException if a matching subtask could not be found
	 */
	public Subtask findByUUID_G(String uuid, long groupId)
		throws NoSuchSubtaskException;

	/**
	 * Returns the subtask where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	public Subtask fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the subtask where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	public Subtask fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the subtask where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the subtask that was removed
	 */
	public Subtask removeByUUID_G(String uuid, long groupId)
		throws NoSuchSubtaskException;

	/**
	 * Returns the number of subtasks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching subtasks
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the subtasks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching subtasks
	 */
	public java.util.List<Subtask> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Subtask> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Subtask> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subtask>
			orderByComparator);

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
	public java.util.List<Subtask> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subtask>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first subtask in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subtask
	 * @throws NoSuchSubtaskException if a matching subtask could not be found
	 */
	public Subtask findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Subtask>
				orderByComparator)
		throws NoSuchSubtaskException;

	/**
	 * Returns the first subtask in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	public Subtask fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Subtask>
			orderByComparator);

	/**
	 * Returns the last subtask in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subtask
	 * @throws NoSuchSubtaskException if a matching subtask could not be found
	 */
	public Subtask findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Subtask>
				orderByComparator)
		throws NoSuchSubtaskException;

	/**
	 * Returns the last subtask in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	public Subtask fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Subtask>
			orderByComparator);

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
	public Subtask[] findByUuid_C_PrevAndNext(
			long subtaskId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Subtask>
				orderByComparator)
		throws NoSuchSubtaskException;

	/**
	 * Removes all the subtasks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of subtasks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching subtasks
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the subtasks where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching subtasks
	 */
	public java.util.List<Subtask> findByTaskId(long taskId);

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
	public java.util.List<Subtask> findByTaskId(
		long taskId, int start, int end);

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
	public java.util.List<Subtask> findByTaskId(
		long taskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subtask>
			orderByComparator);

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
	public java.util.List<Subtask> findByTaskId(
		long taskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subtask>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first subtask in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subtask
	 * @throws NoSuchSubtaskException if a matching subtask could not be found
	 */
	public Subtask findByTaskId_First(
			long taskId,
			com.liferay.portal.kernel.util.OrderByComparator<Subtask>
				orderByComparator)
		throws NoSuchSubtaskException;

	/**
	 * Returns the first subtask in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	public Subtask fetchByTaskId_First(
		long taskId,
		com.liferay.portal.kernel.util.OrderByComparator<Subtask>
			orderByComparator);

	/**
	 * Returns the last subtask in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subtask
	 * @throws NoSuchSubtaskException if a matching subtask could not be found
	 */
	public Subtask findByTaskId_Last(
			long taskId,
			com.liferay.portal.kernel.util.OrderByComparator<Subtask>
				orderByComparator)
		throws NoSuchSubtaskException;

	/**
	 * Returns the last subtask in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	public Subtask fetchByTaskId_Last(
		long taskId,
		com.liferay.portal.kernel.util.OrderByComparator<Subtask>
			orderByComparator);

	/**
	 * Returns the subtasks before and after the current subtask in the ordered set where taskId = &#63;.
	 *
	 * @param subtaskId the primary key of the current subtask
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subtask
	 * @throws NoSuchSubtaskException if a subtask with the primary key could not be found
	 */
	public Subtask[] findByTaskId_PrevAndNext(
			long subtaskId, long taskId,
			com.liferay.portal.kernel.util.OrderByComparator<Subtask>
				orderByComparator)
		throws NoSuchSubtaskException;

	/**
	 * Removes all the subtasks where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	public void removeByTaskId(long taskId);

	/**
	 * Returns the number of subtasks where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching subtasks
	 */
	public int countByTaskId(long taskId);

	/**
	 * Caches the subtask in the entity cache if it is enabled.
	 *
	 * @param subtask the subtask
	 */
	public void cacheResult(Subtask subtask);

	/**
	 * Caches the subtasks in the entity cache if it is enabled.
	 *
	 * @param subtasks the subtasks
	 */
	public void cacheResult(java.util.List<Subtask> subtasks);

	/**
	 * Creates a new subtask with the primary key. Does not add the subtask to the database.
	 *
	 * @param subtaskId the primary key for the new subtask
	 * @return the new subtask
	 */
	public Subtask create(long subtaskId);

	/**
	 * Removes the subtask with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subtaskId the primary key of the subtask
	 * @return the subtask that was removed
	 * @throws NoSuchSubtaskException if a subtask with the primary key could not be found
	 */
	public Subtask remove(long subtaskId) throws NoSuchSubtaskException;

	public Subtask updateImpl(Subtask subtask);

	/**
	 * Returns the subtask with the primary key or throws a <code>NoSuchSubtaskException</code> if it could not be found.
	 *
	 * @param subtaskId the primary key of the subtask
	 * @return the subtask
	 * @throws NoSuchSubtaskException if a subtask with the primary key could not be found
	 */
	public Subtask findByPrimaryKey(long subtaskId)
		throws NoSuchSubtaskException;

	/**
	 * Returns the subtask with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subtaskId the primary key of the subtask
	 * @return the subtask, or <code>null</code> if a subtask with the primary key could not be found
	 */
	public Subtask fetchByPrimaryKey(long subtaskId);

	/**
	 * Returns all the subtasks.
	 *
	 * @return the subtasks
	 */
	public java.util.List<Subtask> findAll();

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
	public java.util.List<Subtask> findAll(int start, int end);

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
	public java.util.List<Subtask> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subtask>
			orderByComparator);

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
	public java.util.List<Subtask> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subtask>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the subtasks from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of subtasks.
	 *
	 * @return the number of subtasks
	 */
	public int countAll();

}