/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.rebeca.todolist.entity.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Subtask service. Represents a row in the &quot;ToDoList_Subtask&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SubtaskModel
 * @generated
 */
@ImplementationClassName("com.rebeca.todolist.entity.model.impl.SubtaskImpl")
@ProviderType
public interface Subtask extends PersistedModel, SubtaskModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.rebeca.todolist.entity.model.impl.SubtaskImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Subtask, Long> SUBTASK_ID_ACCESSOR =
		new Accessor<Subtask, Long>() {

			@Override
			public Long get(Subtask subtask) {
				return subtask.getSubtaskId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Subtask> getTypeClass() {
				return Subtask.class;
			}

		};

}