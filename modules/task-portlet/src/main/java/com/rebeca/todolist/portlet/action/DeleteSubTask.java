package com.rebeca.todolist.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.rebeca.todolist.entity.model.Subtask;
import com.rebeca.todolist.entity.service.SubtaskLocalService;
import com.rebeca.todolist.portlet.constants.TaskPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;


@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + TaskPortletKeys.TASK,
                "mvc.command.name=/subtask/delete"
        },
        service = MVCActionCommand.class
)

public class DeleteSubTask implements MVCActionCommand  {

    @Reference
    private SubtaskLocalService _subtaskLocalService;

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

        long taskId = ParamUtil.getLong(actionRequest, "taskId");
        try {
            _subtaskLocalService.deleteSubtask(taskId);
        } catch (PortalException e) {
            throw new PortletException("Erro ao deletar sub tarefa com ID: " + taskId, e);
        }
        return true;
    }
}