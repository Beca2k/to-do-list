/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.rebeca.todolist.entity.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.rebeca.todolist.entity.exception.NoSuchSubtaskException;
import com.rebeca.todolist.entity.model.Subtask;
import com.rebeca.todolist.entity.model.SubtaskTable;
import com.rebeca.todolist.entity.model.impl.SubtaskImpl;
import com.rebeca.todolist.entity.model.impl.SubtaskModelImpl;
import com.rebeca.todolist.entity.service.persistence.SubtaskPersistence;
import com.rebeca.todolist.entity.service.persistence.SubtaskUtil;
import com.rebeca.todolist.entity.service.persistence.impl.constants.ToDoListPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the subtask service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SubtaskPersistence.class)
public class SubtaskPersistenceImpl
	extends BasePersistenceImpl<Subtask> implements SubtaskPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SubtaskUtil</code> to access the subtask persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SubtaskImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the subtasks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching subtasks
	 */
	@Override
	public List<Subtask> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Subtask> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Subtask> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Subtask> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Subtask> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Subtask> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Subtask> list = null;

		if (useFinderCache) {
			list = (List<Subtask>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Subtask subtask : list) {
					if (!uuid.equals(subtask.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SUBTASK_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SubtaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Subtask>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first subtask in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subtask
	 * @throws NoSuchSubtaskException if a matching subtask could not be found
	 */
	@Override
	public Subtask findByUuid_First(
			String uuid, OrderByComparator<Subtask> orderByComparator)
		throws NoSuchSubtaskException {

		Subtask subtask = fetchByUuid_First(uuid, orderByComparator);

		if (subtask != null) {
			return subtask;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSubtaskException(sb.toString());
	}

	/**
	 * Returns the first subtask in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	@Override
	public Subtask fetchByUuid_First(
		String uuid, OrderByComparator<Subtask> orderByComparator) {

		List<Subtask> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last subtask in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subtask
	 * @throws NoSuchSubtaskException if a matching subtask could not be found
	 */
	@Override
	public Subtask findByUuid_Last(
			String uuid, OrderByComparator<Subtask> orderByComparator)
		throws NoSuchSubtaskException {

		Subtask subtask = fetchByUuid_Last(uuid, orderByComparator);

		if (subtask != null) {
			return subtask;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSubtaskException(sb.toString());
	}

	/**
	 * Returns the last subtask in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	@Override
	public Subtask fetchByUuid_Last(
		String uuid, OrderByComparator<Subtask> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Subtask> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Subtask[] findByUuid_PrevAndNext(
			long subtaskId, String uuid,
			OrderByComparator<Subtask> orderByComparator)
		throws NoSuchSubtaskException {

		uuid = Objects.toString(uuid, "");

		Subtask subtask = findByPrimaryKey(subtaskId);

		Session session = null;

		try {
			session = openSession();

			Subtask[] array = new SubtaskImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, subtask, uuid, orderByComparator, true);

			array[1] = subtask;

			array[2] = getByUuid_PrevAndNext(
				session, subtask, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Subtask getByUuid_PrevAndNext(
		Session session, Subtask subtask, String uuid,
		OrderByComparator<Subtask> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SUBTASK_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SubtaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(subtask)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Subtask> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the subtasks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Subtask subtask :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(subtask);
		}
	}

	/**
	 * Returns the number of subtasks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching subtasks
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SUBTASK_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "subtask.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(subtask.uuid IS NULL OR subtask.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the subtask where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSubtaskException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching subtask
	 * @throws NoSuchSubtaskException if a matching subtask could not be found
	 */
	@Override
	public Subtask findByUUID_G(String uuid, long groupId)
		throws NoSuchSubtaskException {

		Subtask subtask = fetchByUUID_G(uuid, groupId);

		if (subtask == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSubtaskException(sb.toString());
		}

		return subtask;
	}

	/**
	 * Returns the subtask where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	@Override
	public Subtask fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the subtask where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	@Override
	public Subtask fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Subtask) {
			Subtask subtask = (Subtask)result;

			if (!Objects.equals(uuid, subtask.getUuid()) ||
				(groupId != subtask.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SUBTASK_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Subtask> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Subtask subtask = list.get(0);

					result = subtask;

					cacheResult(subtask);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Subtask)result;
		}
	}

	/**
	 * Removes the subtask where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the subtask that was removed
	 */
	@Override
	public Subtask removeByUUID_G(String uuid, long groupId)
		throws NoSuchSubtaskException {

		Subtask subtask = findByUUID_G(uuid, groupId);

		return remove(subtask);
	}

	/**
	 * Returns the number of subtasks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching subtasks
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		Subtask subtask = fetchByUUID_G(uuid, groupId);

		if (subtask == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"subtask.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(subtask.uuid IS NULL OR subtask.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"subtask.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the subtasks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching subtasks
	 */
	@Override
	public List<Subtask> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Subtask> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Subtask> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Subtask> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Subtask> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Subtask> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Subtask> list = null;

		if (useFinderCache) {
			list = (List<Subtask>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Subtask subtask : list) {
					if (!uuid.equals(subtask.getUuid()) ||
						(companyId != subtask.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SUBTASK_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SubtaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<Subtask>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Subtask findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Subtask> orderByComparator)
		throws NoSuchSubtaskException {

		Subtask subtask = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (subtask != null) {
			return subtask;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSubtaskException(sb.toString());
	}

	/**
	 * Returns the first subtask in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	@Override
	public Subtask fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Subtask> orderByComparator) {

		List<Subtask> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Subtask findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Subtask> orderByComparator)
		throws NoSuchSubtaskException {

		Subtask subtask = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (subtask != null) {
			return subtask;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSubtaskException(sb.toString());
	}

	/**
	 * Returns the last subtask in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	@Override
	public Subtask fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Subtask> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Subtask> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Subtask[] findByUuid_C_PrevAndNext(
			long subtaskId, String uuid, long companyId,
			OrderByComparator<Subtask> orderByComparator)
		throws NoSuchSubtaskException {

		uuid = Objects.toString(uuid, "");

		Subtask subtask = findByPrimaryKey(subtaskId);

		Session session = null;

		try {
			session = openSession();

			Subtask[] array = new SubtaskImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, subtask, uuid, companyId, orderByComparator, true);

			array[1] = subtask;

			array[2] = getByUuid_C_PrevAndNext(
				session, subtask, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Subtask getByUuid_C_PrevAndNext(
		Session session, Subtask subtask, String uuid, long companyId,
		OrderByComparator<Subtask> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SUBTASK_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SubtaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(subtask)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Subtask> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the subtasks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Subtask subtask :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(subtask);
		}
	}

	/**
	 * Returns the number of subtasks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching subtasks
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SUBTASK_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"subtask.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(subtask.uuid IS NULL OR subtask.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"subtask.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByTaskId;
	private FinderPath _finderPathWithoutPaginationFindByTaskId;
	private FinderPath _finderPathCountByTaskId;

	/**
	 * Returns all the subtasks where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the matching subtasks
	 */
	@Override
	public List<Subtask> findByTaskId(long taskId) {
		return findByTaskId(taskId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Subtask> findByTaskId(long taskId, int start, int end) {
		return findByTaskId(taskId, start, end, null);
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
	@Override
	public List<Subtask> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<Subtask> orderByComparator) {

		return findByTaskId(taskId, start, end, orderByComparator, true);
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
	@Override
	public List<Subtask> findByTaskId(
		long taskId, int start, int end,
		OrderByComparator<Subtask> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTaskId;
				finderArgs = new Object[] {taskId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTaskId;
			finderArgs = new Object[] {taskId, start, end, orderByComparator};
		}

		List<Subtask> list = null;

		if (useFinderCache) {
			list = (List<Subtask>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Subtask subtask : list) {
					if (taskId != subtask.getTaskId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SUBTASK_WHERE);

			sb.append(_FINDER_COLUMN_TASKID_TASKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SubtaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(taskId);

				list = (List<Subtask>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first subtask in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subtask
	 * @throws NoSuchSubtaskException if a matching subtask could not be found
	 */
	@Override
	public Subtask findByTaskId_First(
			long taskId, OrderByComparator<Subtask> orderByComparator)
		throws NoSuchSubtaskException {

		Subtask subtask = fetchByTaskId_First(taskId, orderByComparator);

		if (subtask != null) {
			return subtask;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskId=");
		sb.append(taskId);

		sb.append("}");

		throw new NoSuchSubtaskException(sb.toString());
	}

	/**
	 * Returns the first subtask in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	@Override
	public Subtask fetchByTaskId_First(
		long taskId, OrderByComparator<Subtask> orderByComparator) {

		List<Subtask> list = findByTaskId(taskId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last subtask in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subtask
	 * @throws NoSuchSubtaskException if a matching subtask could not be found
	 */
	@Override
	public Subtask findByTaskId_Last(
			long taskId, OrderByComparator<Subtask> orderByComparator)
		throws NoSuchSubtaskException {

		Subtask subtask = fetchByTaskId_Last(taskId, orderByComparator);

		if (subtask != null) {
			return subtask;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskId=");
		sb.append(taskId);

		sb.append("}");

		throw new NoSuchSubtaskException(sb.toString());
	}

	/**
	 * Returns the last subtask in the ordered set where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subtask, or <code>null</code> if a matching subtask could not be found
	 */
	@Override
	public Subtask fetchByTaskId_Last(
		long taskId, OrderByComparator<Subtask> orderByComparator) {

		int count = countByTaskId(taskId);

		if (count == 0) {
			return null;
		}

		List<Subtask> list = findByTaskId(
			taskId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Subtask[] findByTaskId_PrevAndNext(
			long subtaskId, long taskId,
			OrderByComparator<Subtask> orderByComparator)
		throws NoSuchSubtaskException {

		Subtask subtask = findByPrimaryKey(subtaskId);

		Session session = null;

		try {
			session = openSession();

			Subtask[] array = new SubtaskImpl[3];

			array[0] = getByTaskId_PrevAndNext(
				session, subtask, taskId, orderByComparator, true);

			array[1] = subtask;

			array[2] = getByTaskId_PrevAndNext(
				session, subtask, taskId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Subtask getByTaskId_PrevAndNext(
		Session session, Subtask subtask, long taskId,
		OrderByComparator<Subtask> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SUBTASK_WHERE);

		sb.append(_FINDER_COLUMN_TASKID_TASKID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SubtaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(taskId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(subtask)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Subtask> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the subtasks where taskId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 */
	@Override
	public void removeByTaskId(long taskId) {
		for (Subtask subtask :
				findByTaskId(
					taskId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(subtask);
		}
	}

	/**
	 * Returns the number of subtasks where taskId = &#63;.
	 *
	 * @param taskId the task ID
	 * @return the number of matching subtasks
	 */
	@Override
	public int countByTaskId(long taskId) {
		FinderPath finderPath = _finderPathCountByTaskId;

		Object[] finderArgs = new Object[] {taskId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SUBTASK_WHERE);

			sb.append(_FINDER_COLUMN_TASKID_TASKID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(taskId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TASKID_TASKID_2 =
		"subtask.taskId = ?";

	public SubtaskPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Subtask.class);

		setModelImplClass(SubtaskImpl.class);
		setModelPKClass(long.class);

		setTable(SubtaskTable.INSTANCE);
	}

	/**
	 * Caches the subtask in the entity cache if it is enabled.
	 *
	 * @param subtask the subtask
	 */
	@Override
	public void cacheResult(Subtask subtask) {
		entityCache.putResult(
			SubtaskImpl.class, subtask.getPrimaryKey(), subtask);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {subtask.getUuid(), subtask.getGroupId()}, subtask);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the subtasks in the entity cache if it is enabled.
	 *
	 * @param subtasks the subtasks
	 */
	@Override
	public void cacheResult(List<Subtask> subtasks) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (subtasks.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Subtask subtask : subtasks) {
			if (entityCache.getResult(
					SubtaskImpl.class, subtask.getPrimaryKey()) == null) {

				cacheResult(subtask);
			}
		}
	}

	/**
	 * Clears the cache for all subtasks.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SubtaskImpl.class);

		finderCache.clearCache(SubtaskImpl.class);
	}

	/**
	 * Clears the cache for the subtask.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Subtask subtask) {
		entityCache.removeResult(SubtaskImpl.class, subtask);
	}

	@Override
	public void clearCache(List<Subtask> subtasks) {
		for (Subtask subtask : subtasks) {
			entityCache.removeResult(SubtaskImpl.class, subtask);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SubtaskImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SubtaskImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(SubtaskModelImpl subtaskModelImpl) {
		Object[] args = new Object[] {
			subtaskModelImpl.getUuid(), subtaskModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathFetchByUUID_G, args, subtaskModelImpl);
	}

	/**
	 * Creates a new subtask with the primary key. Does not add the subtask to the database.
	 *
	 * @param subtaskId the primary key for the new subtask
	 * @return the new subtask
	 */
	@Override
	public Subtask create(long subtaskId) {
		Subtask subtask = new SubtaskImpl();

		subtask.setNew(true);
		subtask.setPrimaryKey(subtaskId);

		String uuid = PortalUUIDUtil.generate();

		subtask.setUuid(uuid);

		subtask.setCompanyId(CompanyThreadLocal.getCompanyId());

		return subtask;
	}

	/**
	 * Removes the subtask with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subtaskId the primary key of the subtask
	 * @return the subtask that was removed
	 * @throws NoSuchSubtaskException if a subtask with the primary key could not be found
	 */
	@Override
	public Subtask remove(long subtaskId) throws NoSuchSubtaskException {
		return remove((Serializable)subtaskId);
	}

	/**
	 * Removes the subtask with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the subtask
	 * @return the subtask that was removed
	 * @throws NoSuchSubtaskException if a subtask with the primary key could not be found
	 */
	@Override
	public Subtask remove(Serializable primaryKey)
		throws NoSuchSubtaskException {

		Session session = null;

		try {
			session = openSession();

			Subtask subtask = (Subtask)session.get(
				SubtaskImpl.class, primaryKey);

			if (subtask == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubtaskException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(subtask);
		}
		catch (NoSuchSubtaskException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Subtask removeImpl(Subtask subtask) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(subtask)) {
				subtask = (Subtask)session.get(
					SubtaskImpl.class, subtask.getPrimaryKeyObj());
			}

			if (subtask != null) {
				session.delete(subtask);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (subtask != null) {
			clearCache(subtask);
		}

		return subtask;
	}

	@Override
	public Subtask updateImpl(Subtask subtask) {
		boolean isNew = subtask.isNew();

		if (!(subtask instanceof SubtaskModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(subtask.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(subtask);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in subtask proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Subtask implementation " +
					subtask.getClass());
		}

		SubtaskModelImpl subtaskModelImpl = (SubtaskModelImpl)subtask;

		if (Validator.isNull(subtask.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			subtask.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (subtask.getCreateDate() == null)) {
			if (serviceContext == null) {
				subtask.setCreateDate(date);
			}
			else {
				subtask.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!subtaskModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				subtask.setModifiedDate(date);
			}
			else {
				subtask.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(subtask);
			}
			else {
				subtask = (Subtask)session.merge(subtask);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(SubtaskImpl.class, subtaskModelImpl, false, true);

		cacheUniqueFindersCache(subtaskModelImpl);

		if (isNew) {
			subtask.setNew(false);
		}

		subtask.resetOriginalValues();

		return subtask;
	}

	/**
	 * Returns the subtask with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the subtask
	 * @return the subtask
	 * @throws NoSuchSubtaskException if a subtask with the primary key could not be found
	 */
	@Override
	public Subtask findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubtaskException {

		Subtask subtask = fetchByPrimaryKey(primaryKey);

		if (subtask == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubtaskException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return subtask;
	}

	/**
	 * Returns the subtask with the primary key or throws a <code>NoSuchSubtaskException</code> if it could not be found.
	 *
	 * @param subtaskId the primary key of the subtask
	 * @return the subtask
	 * @throws NoSuchSubtaskException if a subtask with the primary key could not be found
	 */
	@Override
	public Subtask findByPrimaryKey(long subtaskId)
		throws NoSuchSubtaskException {

		return findByPrimaryKey((Serializable)subtaskId);
	}

	/**
	 * Returns the subtask with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subtaskId the primary key of the subtask
	 * @return the subtask, or <code>null</code> if a subtask with the primary key could not be found
	 */
	@Override
	public Subtask fetchByPrimaryKey(long subtaskId) {
		return fetchByPrimaryKey((Serializable)subtaskId);
	}

	/**
	 * Returns all the subtasks.
	 *
	 * @return the subtasks
	 */
	@Override
	public List<Subtask> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Subtask> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Subtask> findAll(
		int start, int end, OrderByComparator<Subtask> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Subtask> findAll(
		int start, int end, OrderByComparator<Subtask> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Subtask> list = null;

		if (useFinderCache) {
			list = (List<Subtask>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SUBTASK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SUBTASK;

				sql = sql.concat(SubtaskModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Subtask>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the subtasks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Subtask subtask : findAll()) {
			remove(subtask);
		}
	}

	/**
	 * Returns the number of subtasks.
	 *
	 * @return the number of subtasks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SUBTASK);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "subtaskId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SUBTASK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SubtaskModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the subtask persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByTaskId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTaskId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"taskId"}, true);

		_finderPathWithoutPaginationFindByTaskId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTaskId",
			new String[] {Long.class.getName()}, new String[] {"taskId"}, true);

		_finderPathCountByTaskId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTaskId",
			new String[] {Long.class.getName()}, new String[] {"taskId"},
			false);

		SubtaskUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		SubtaskUtil.setPersistence(null);

		entityCache.removeCache(SubtaskImpl.class.getName());
	}

	@Override
	@Reference(
		target = ToDoListPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = ToDoListPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ToDoListPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SUBTASK =
		"SELECT subtask FROM Subtask subtask";

	private static final String _SQL_SELECT_SUBTASK_WHERE =
		"SELECT subtask FROM Subtask subtask WHERE ";

	private static final String _SQL_COUNT_SUBTASK =
		"SELECT COUNT(subtask) FROM Subtask subtask";

	private static final String _SQL_COUNT_SUBTASK_WHERE =
		"SELECT COUNT(subtask) FROM Subtask subtask WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "subtask.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Subtask exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Subtask exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SubtaskPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}