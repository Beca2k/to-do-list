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

import com.rebeca.todolist.entity.exception.NoSuchTaskException;
import com.rebeca.todolist.entity.model.Task;
import com.rebeca.todolist.entity.service.TaskLocalServiceUtil;
import com.rebeca.todolist.entity.service.persistence.TaskPersistence;
import com.rebeca.todolist.entity.service.persistence.TaskUtil;

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
public class TaskPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.rebeca.todolist.entity.service"));

	@Before
	public void setUp() {
		_persistence = TaskUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Task> iterator = _tasks.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Task task = _persistence.create(pk);

		Assert.assertNotNull(task);

		Assert.assertEquals(task.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Task newTask = addTask();

		_persistence.remove(newTask);

		Task existingTask = _persistence.fetchByPrimaryKey(
			newTask.getPrimaryKey());

		Assert.assertNull(existingTask);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addTask();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Task newTask = _persistence.create(pk);

		newTask.setUuid(RandomTestUtil.randomString());

		newTask.setGroupId(RandomTestUtil.nextLong());

		newTask.setCompanyId(RandomTestUtil.nextLong());

		newTask.setUserId(RandomTestUtil.nextLong());

		newTask.setUserName(RandomTestUtil.randomString());

		newTask.setCreateDate(RandomTestUtil.nextDate());

		newTask.setModifiedDate(RandomTestUtil.nextDate());

		newTask.setStatus(RandomTestUtil.nextInt());

		newTask.setDescription(RandomTestUtil.randomString());

		newTask.setTitle(RandomTestUtil.randomString());

		newTask.setPath(RandomTestUtil.randomString());

		newTask.setRelativeId(RandomTestUtil.nextLong());

		newTask.setFileEntryId(RandomTestUtil.nextLong());

		newTask.setDone(RandomTestUtil.randomBoolean());

		_tasks.add(_persistence.update(newTask));

		Task existingTask = _persistence.findByPrimaryKey(
			newTask.getPrimaryKey());

		Assert.assertEquals(existingTask.getUuid(), newTask.getUuid());
		Assert.assertEquals(existingTask.getTaskId(), newTask.getTaskId());
		Assert.assertEquals(existingTask.getGroupId(), newTask.getGroupId());
		Assert.assertEquals(
			existingTask.getCompanyId(), newTask.getCompanyId());
		Assert.assertEquals(existingTask.getUserId(), newTask.getUserId());
		Assert.assertEquals(existingTask.getUserName(), newTask.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingTask.getCreateDate()),
			Time.getShortTimestamp(newTask.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingTask.getModifiedDate()),
			Time.getShortTimestamp(newTask.getModifiedDate()));
		Assert.assertEquals(existingTask.getStatus(), newTask.getStatus());
		Assert.assertEquals(
			existingTask.getDescription(), newTask.getDescription());
		Assert.assertEquals(existingTask.getTitle(), newTask.getTitle());
		Assert.assertEquals(existingTask.getPath(), newTask.getPath());
		Assert.assertEquals(
			existingTask.getRelativeId(), newTask.getRelativeId());
		Assert.assertEquals(
			existingTask.getFileEntryId(), newTask.getFileEntryId());
		Assert.assertEquals(existingTask.isDone(), newTask.isDone());
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
	public void testCountByUserIdAndGroupId() throws Exception {
		_persistence.countByUserIdAndGroupId(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByUserIdAndGroupId(0L, 0L);
	}

	@Test
	public void testCountByUserIdAndGroupIdAndRelativeId() throws Exception {
		_persistence.countByUserIdAndGroupIdAndRelativeId(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByUserIdAndGroupIdAndRelativeId(0L, 0L, 0L);
	}

	@Test
	public void testCountByUserIdAndGroupIdAndStatus() throws Exception {
		_persistence.countByUserIdAndGroupIdAndStatus(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countByUserIdAndGroupIdAndStatus(0L, 0L, 0);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Task newTask = addTask();

		Task existingTask = _persistence.findByPrimaryKey(
			newTask.getPrimaryKey());

		Assert.assertEquals(existingTask, newTask);
	}

	@Test(expected = NoSuchTaskException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Task> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ToDoList_Task", "uuid", true, "taskId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "status", true, "description", true,
			"title", true, "path", true, "relativeId", true, "fileEntryId",
			true, "done", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Task newTask = addTask();

		Task existingTask = _persistence.fetchByPrimaryKey(
			newTask.getPrimaryKey());

		Assert.assertEquals(existingTask, newTask);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Task missingTask = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingTask);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Task newTask1 = addTask();
		Task newTask2 = addTask();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTask1.getPrimaryKey());
		primaryKeys.add(newTask2.getPrimaryKey());

		Map<Serializable, Task> tasks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, tasks.size());
		Assert.assertEquals(newTask1, tasks.get(newTask1.getPrimaryKey()));
		Assert.assertEquals(newTask2, tasks.get(newTask2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Task> tasks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(tasks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Task newTask = addTask();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTask.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Task> tasks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, tasks.size());
		Assert.assertEquals(newTask, tasks.get(newTask.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Task> tasks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(tasks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Task newTask = addTask();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTask.getPrimaryKey());

		Map<Serializable, Task> tasks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, tasks.size());
		Assert.assertEquals(newTask, tasks.get(newTask.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			TaskLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Task>() {

				@Override
				public void performAction(Task task) {
					Assert.assertNotNull(task);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Task newTask = addTask();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Task.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("taskId", newTask.getTaskId()));

		List<Task> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Task existingTask = result.get(0);

		Assert.assertEquals(existingTask, newTask);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Task.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("taskId", RandomTestUtil.nextLong()));

		List<Task> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Task newTask = addTask();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Task.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("taskId"));

		Object newTaskId = newTask.getTaskId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("taskId", new Object[] {newTaskId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingTaskId = result.get(0);

		Assert.assertEquals(existingTaskId, newTaskId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Task.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("taskId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"taskId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Task newTask = addTask();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newTask.getPrimaryKey()));
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

		Task newTask = addTask();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Task.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("taskId", newTask.getTaskId()));

		List<Task> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Task task) {
		Assert.assertEquals(
			task.getUuid(),
			ReflectionTestUtil.invoke(
				task, "getColumnOriginalValue", new Class<?>[] {String.class},
				"uuid_"));
		Assert.assertEquals(
			Long.valueOf(task.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				task, "getColumnOriginalValue", new Class<?>[] {String.class},
				"groupId"));
	}

	protected Task addTask() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Task task = _persistence.create(pk);

		task.setUuid(RandomTestUtil.randomString());

		task.setGroupId(RandomTestUtil.nextLong());

		task.setCompanyId(RandomTestUtil.nextLong());

		task.setUserId(RandomTestUtil.nextLong());

		task.setUserName(RandomTestUtil.randomString());

		task.setCreateDate(RandomTestUtil.nextDate());

		task.setModifiedDate(RandomTestUtil.nextDate());

		task.setStatus(RandomTestUtil.nextInt());

		task.setDescription(RandomTestUtil.randomString());

		task.setTitle(RandomTestUtil.randomString());

		task.setPath(RandomTestUtil.randomString());

		task.setRelativeId(RandomTestUtil.nextLong());

		task.setFileEntryId(RandomTestUtil.nextLong());

		task.setDone(RandomTestUtil.randomBoolean());

		_tasks.add(_persistence.update(task));

		return task;
	}

	private List<Task> _tasks = new ArrayList<Task>();
	private TaskPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}