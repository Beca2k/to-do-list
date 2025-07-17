package com.rebeca.todolist.portlet.render;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.rebeca.todolist.entity.model.Subtask;
import com.rebeca.todolist.entity.model.Task;
import com.rebeca.todolist.entity.service.SubtaskLocalService;
import com.rebeca.todolist.entity.service.TaskLocalService;
import com.rebeca.todolist.portlet.constants.TaskPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

@Component(
        property = {
                "javax.portlet.name=" + TaskPortletKeys.TASK,
                "mvc.command.name=/task_frm_edit"
        },
        service = MVCRenderCommand.class
)

public class ViewTaskFrmRender implements MVCRenderCommand{

    @Reference
    private TaskLocalService _taskLocalService;

    @Reference
    private SubtaskLocalService _subtaskLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        System.out.println("Buscando tarefa id");
        long taskId = ParamUtil.getLong(renderRequest, "taskId");

        Task task = _taskLocalService.fetchTask(taskId);

            System.out.println("Buscando tarefa no banco");

        renderRequest.setAttribute("task", task);
        System.out.println("task" + task.getTaskId());

        _subtaskLocalService.findByTaskId(taskId);
        List<Subtask> subtasks = _subtaskLocalService.findByTaskId(task.getTaskId());
        renderRequest.setAttribute("subtasks", subtasks);

        return "/task/task_frm_edit.jsp";
    }
}