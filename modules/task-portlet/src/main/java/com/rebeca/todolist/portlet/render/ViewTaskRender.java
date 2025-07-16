package com.rebeca.todolist.portlet.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component(
        property = {
                "javax.portlet.name=" + TaskPortletKeys.TASK,
                "mvc.command.name=/",
                "mvc.command.name=/task/view"
        },
        service = MVCRenderCommand.class
)
public class ViewTaskRender  implements MVCRenderCommand {

    @Reference
    private TaskLocalService _taskLocalService;

    @Reference
    private SubtaskLocalService _subtaskLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        long userId = themeDisplay.getUserId();
        long groupId = themeDisplay.getScopeGroupId();

        List<Task> tasks = _taskLocalService.findByUserIdAndGroupId(userId,groupId);
        renderRequest.setAttribute("tasks",tasks);

        Map<Long, List<Subtask>> subtasksMap = new HashMap<>();
        for (Task task : tasks) {
            List<Subtask> subtasks = _subtaskLocalService.findByTaskId(task.getTaskId());
            subtasksMap.put(task.getTaskId(), subtasks);
        }

        renderRequest.setAttribute("subtasksMap", subtasksMap);

        return "/view.jsp";
    }
}