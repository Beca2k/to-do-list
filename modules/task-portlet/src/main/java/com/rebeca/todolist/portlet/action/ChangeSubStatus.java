package com.rebeca.todolist.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
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
                "mvc.command.name=/subtask/change"
        },
        service = MVCActionCommand.class
)

public class ChangeSubStatus implements MVCActionCommand {
    private static final Log _log = LogFactoryUtil.getLog(ChangeSubStatus.class);

    @Reference
    private SubtaskLocalService _subtaskLocalService;

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

        long taskId = ParamUtil.getLong(actionRequest, "taskId");
        _log.info("Atualizando status da sub tarefa"+ taskId);

        try {
            _subtaskLocalService.changeSubStatus(taskId);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao mudar status da sub tarefa", e);
        }
        return true;
    }
}
