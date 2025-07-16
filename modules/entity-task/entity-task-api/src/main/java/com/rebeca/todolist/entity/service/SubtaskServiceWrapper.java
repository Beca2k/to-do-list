/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.rebeca.todolist.entity.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SubtaskService}.
 *
 * @author Brian Wing Shun Chan
 * @see SubtaskService
 * @generated
 */
public class SubtaskServiceWrapper
	implements ServiceWrapper<SubtaskService>, SubtaskService {

	public SubtaskServiceWrapper() {
		this(null);
	}

	public SubtaskServiceWrapper(SubtaskService subtaskService) {
		_subtaskService = subtaskService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _subtaskService.getOSGiServiceIdentifier();
	}

	@Override
	public SubtaskService getWrappedService() {
		return _subtaskService;
	}

	@Override
	public void setWrappedService(SubtaskService subtaskService) {
		_subtaskService = subtaskService;
	}

	private SubtaskService _subtaskService;

}