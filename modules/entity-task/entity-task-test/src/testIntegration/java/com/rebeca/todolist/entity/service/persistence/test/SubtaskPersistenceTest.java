/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.rebeca.todolist.entity.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import com.rebeca.todolist.entity.exception.NoSuchSubtaskException;
import com.rebeca.todolist.entity.model.Subtask;
import com.rebeca.todolist.entity.service.SubtaskLocalServiceUtil;
import com.rebeca.todolist.entity.service.persistence.SubtaskPersistence;
import com.rebeca.todolist.entity.service.persistence.SubtaskUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class SubtaskPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.rebeca.todolist.entity.service"));

	@Before
	public void setUp() {
		_persistence = SubtaskUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Subtask> iterator = _subtasks.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Subtask subtask = _persistence.create(pk);

		Assert.assertNotNull(subtask);

		Assert.assertEquals(subtask.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Subtask newSubtask = addSubtask();

		_persistence.remove(newSubtask);

		Subtask existingSubtask = _persistence.fetchByPrimaryKey(
			newSubtask.getPrimaryKey());

		Assert.assertNull(existingSubtask);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSubtask();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Subtask newSubtask = _persistence.create(pk);

		newSubtask.setUuid(RandomTestUtil.randomString());

		newSubtask.setTaskId(RandomTestUtil.nextLong());

		newSubtask.setTitle(RandomTestUtil.randomString());

		newSubtask.setStatus(RandomTestUtil.nextInt());

		newSubtask.setGroupId(RandomTestUtil.nextLong());

		newSubtask.setCompanyId(RandomTestUtil.nextLong());

		newSubtask.setUserId(RandomTestUtil.nextLong());

		newSubtask.setUserName(RandomTestUtil.randomString());

		newSubtask.setCreateDate(RandomTestUtil.nextDate());

		newSubtask.setModifiedDate(RandomTestUtil.nextDate());

		_subtasks.add(_persistence.update(newSubtask));

		Subtask existingSubtask = _persistence.findByPrimaryKey(
			newSubtask.getPrimaryKey());

		Assert.assertEquals(existingSubtask.getUuid(), newSubtask.getUuid());
		Assert.assertEquals(
			existingSubtask.getSubtaskId(), newSubtask.getSubtaskId());
		Assert.assertEquals(
			existingSubtask.getTaskId(), newSubtask.getTaskId());
		Assert.assertEquals(existingSubtask.getTitle(), newSubtask.getTitle());
		Assert.assertEquals(
			existingSubtask.getStatus(), newSubtask.getStatus());
		Assert.assertEquals(
			existingSubtask.getGroupId(), newSubtask.getGroupId());
		Assert.assertEquals(
			existingSubtask.getCompanyId(), newSubtask.getCompanyId());
		Assert.assertEquals(
			existingSubtask.getUserId(), newSubtask.getUserId());
		Assert.assertEquals(
			existingSubtask.getUserName(), newSubtask.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingSubtask.getCreateDate()),
			Time.getShortTimestamp(newSubtask.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingSubtask.getModifiedDate()),
			Time.getShortTimestamp(newSubtask.getModifiedDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByTaskId() throws Exception {
		_persistence.countByTaskId(RandomTestUtil.nextLong());

		_persistence.countByTaskId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Subtask newSubtask = addSubtask();

		Subtask existingSubtask = _persistence.findByPrimaryKey(
			newSubtask.getPrimaryKey());

		Assert.assertEquals(existingSubtask, newSubtask);
	}

	@Test(expected = NoSuchSubtaskException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Subtask> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ToDoList_Subtask", "uuid", true, "subtaskId", true, "taskId", true,
			"title", true, "status", true, "groupId", true, "companyId", true,
			"userId", true, "userName", true, "createDate", true,
			"modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Subtask newSubtask = addSubtask();

		Subtask existingSubtask = _persistence.fetchByPrimaryKey(
			newSubtask.getPrimaryKey());

		Assert.assertEquals(existingSubtask, newSubtask);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Subtask missingSubtask = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSubtask);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Subtask newSubtask1 = addSubtask();
		Subtask newSubtask2 = addSubtask();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSubtask1.getPrimaryKey());
		primaryKeys.add(newSubtask2.getPrimaryKey());

		Map<Serializable, Subtask> subtasks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, subtasks.size());
		Assert.assertEquals(
			newSubtask1, subtasks.get(newSubtask1.getPrimaryKey()));
		Assert.assertEquals(
			newSubtask2, subtasks.get(newSubtask2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Subtask> subtasks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(subtasks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Subtask newSubtask = addSubtask();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSubtask.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Subtask> subtasks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, subtasks.size());
		Assert.assertEquals(
			newSubtask, subtasks.get(newSubtask.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Subtask> subtasks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(subtasks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Subtask newSubtask = addSubtask();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSubtask.getPrimaryKey());

		Map<Serializable, Subtask> subtasks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, subtasks.size());
		Assert.assertEquals(
			newSubtask, subtasks.get(newSubtask.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SubtaskLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Subtask>() {

				@Override
				public void performAction(Subtask subtask) {
					Assert.assertNotNull(subtask);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Subtask newSubtask = addSubtask();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Subtask.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("subtaskId", newSubtask.getSubtaskId()));

		List<Subtask> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Subtask existingSubtask = result.get(0);

		Assert.assertEquals(existingSubtask, newSubtask);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Subtask.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("subtaskId", RandomTestUtil.nextLong()));

		List<Subtask> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Subtask newSubtask = addSubtask();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Subtask.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("subtaskId"));

		Object newSubtaskId = newSubtask.getSubtaskId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"subtaskId", new Object[] {newSubtaskId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingSubtaskId = result.get(0);

		Assert.assertEquals(existingSubtaskId, newSubtaskId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Subtask.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("subtaskId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"subtaskId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Subtask newSubtask = addSubtask();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newSubtask.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		Subtask newSubtask = addSubtask();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Subtask.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("subtaskId", newSubtask.getSubtaskId()));

		List<Subtask> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Subtask subtask) {
		Assert.assertEquals(
			subtask.getUuid(),
			ReflectionTestUtil.invoke(
				subtask, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(subtask.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				subtask, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected Subtask addSubtask() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Subtask subtask = _persistence.create(pk);

		subtask.setUuid(RandomTestUtil.randomString());

		subtask.setTaskId(RandomTestUtil.nextLong());

		subtask.setTitle(RandomTestUtil.randomString());

		subtask.setStatus(RandomTestUtil.nextInt());

		subtask.setGroupId(RandomTestUtil.nextLong());

		subtask.setCompanyId(RandomTestUtil.nextLong());

		subtask.setUserId(RandomTestUtil.nextLong());

		subtask.setUserName(RandomTestUtil.randomString());

		subtask.setCreateDate(RandomTestUtil.nextDate());

		subtask.setModifiedDate(RandomTestUtil.nextDate());

		_subtasks.add(_persistence.update(subtask));

		return subtask;
	}

	private List<Subtask> _subtasks = new ArrayList<Subtask>();
	private SubtaskPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}