package com.rebeca.todolist.portlet.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.rebeca.todolist.portlet.constants.TaskPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        property = {
                "javax.portlet.name=" + TaskPortletKeys.TASK,
                "mvc.command.name=/task/add_form"
        },
        service = MVCRenderCommand.class
)
public class AddTaskRender  implements MVCRenderCommand{
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        return "/task/task_frm.jsp";
    }
}
