package com.rebeca.todolist.portlet.action;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.rebeca.todolist.entity.model.Subtask;
import com.rebeca.todolist.entity.model.Task;
import com.rebeca.todolist.entity.service.SubtaskLocalService;
import com.rebeca.todolist.entity.service.TaskLocalService;
import com.rebeca.todolist.portlet.constants.TaskPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletException;
import java.io.File;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + TaskPortletKeys.TASK,
                "mvc.command.name=/subtask/create"
        },
        service = MVCActionCommand.class
)

public class AddSubTask implements MVCActionCommand {

private static final Log _log = LogFactoryUtil.getLog(AddSubTask.class);

@Reference
private TaskLocalService _taskLocalService;

@Reference
private SubtaskLocalService _subtaskLocalService;

@Override
 public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

    long taskId = ParamUtil.getLong(actionRequest, "taskId");
    String titleTask = ParamUtil.getString(actionRequest, "title");

    try {
        Subtask subtask = _subtaskLocalService.addSubTask(titleTask, taskId);
        actionResponse.setRenderParameter("mvcRenderCommandName", "/task_frm_edit");
        actionResponse.setRenderParameter("taskId", subtask.getTaskId() + "");
    } catch (PortalException e) {
        throw new RuntimeException(e);
    }
    return true;
}
}