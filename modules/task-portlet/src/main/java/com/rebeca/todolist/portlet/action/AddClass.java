package com.rebeca.todolist.portlet.action;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
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
import com.rebeca.todolist.portlet.portlet.TaskPortlet;
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
                "mvc.command.name=/task/add"
        },
        service = MVCActionCommand.class
)

public class AddClass implements MVCActionCommand {

private static final Log _log = LogFactoryUtil.getLog(AddClass.class);

@Reference
private TaskLocalService _taskLocalService;

@Reference
private SubtaskLocalService _subtaskLocalService;


@Override
 public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

    // Pega os dados do formulário
    String title = ParamUtil.getString(actionRequest, "title");
    String description = ParamUtil.getString(actionRequest, "description");
    long relativeId = ParamUtil.getLong(actionRequest, "relativeId");
    String subtitles = ParamUtil.getString(actionRequest, "subtitles");

    FileEntry fileEntry = null;
    try {
        // Lê o arquivo enviado pelo formulário
        UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        File file = uploadPortletRequest.getFile("file");
        String originalFileName = uploadPortletRequest.getFileName("file");

        // Gera um nome único para evitar conflitos
        String uniqueFileName = System.currentTimeMillis() + "_" + originalFileName;
        // Pega o contexto do Liferay
        ServiceContext serviceContext = ServiceContextFactory.getInstance(Task.class.getName(), actionRequest);

        // Busca ou cria a pasta "panic" na Document Library
        long folderId = getFolderId(serviceContext.getScopeGroupId(), "panic", serviceContext.getUserId(), actionRequest);

        // Gera a URL da imagem salva
        fileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), serviceContext.getScopeGroupId(), folderId, uniqueFileName, "image/jpeg", uniqueFileName, "", "", file, serviceContext);
        String path = DLUtil.getPreviewURL(DLAppServiceUtil.getFileEntry(fileEntry.getFileEntryId()), DLAppServiceUtil.getFileEntry(fileEntry.getFileEntryId()).getFileVersion(), serviceContext.getThemeDisplay(), "");

        // Salva a tarefa no banco
        Task task = _taskLocalService.addTask(
                title, description, path, fileEntry.getFileEntryId(), relativeId, serviceContext
        );

        // Pega as subtarefas do formulário
        String[] subtasks = ParamUtil.getParameterValues(actionRequest, "subtasks");

        // Adiciona as Subtarefas (se vierem do formulário)
        if (subtasks != null && subtasks.length > 0) {
            String[] subtarefaArray = subtitles.split(",");
            for (String sub : subtarefaArray) {
                String subtitle = sub.trim();
                if (!subtitle.isEmpty()) {
                    Subtask subtask = _subtaskLocalService.createSubtask(CounterLocalServiceUtil.increment());
                    subtask.setTaskId(task.getTaskId());
                    subtask.setTitle(subtitle);

                    _subtaskLocalService.addSubtask(subtask);
                }
            }
        }
        // Manda para a tela principal
        MutableRenderParameters renderParams = actionResponse.getRenderParameters();
        renderParams.setValue("mvcRenderCommandName", "/");
        _log.info("Tarefas e subtarefas adicionadas com sucesso!");
    } catch (Exception e) {
        _log.error("Erro ao adicionar tarefa" + fileEntry.getTitle());
        throw new PortletException(e);
    }
    return true;
}

    private long getFolderId(long groupId, String folderName, long userId, ActionRequest actionRequest) throws PortalException, PortalException {

        DLFolder dlFolder = null;
        ServiceContext dlServiceCtx = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);

        try {
            dlFolder = DLFolderLocalServiceUtil.getFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName);
        } catch (Exception e) {
            dlFolder = DLFolderLocalServiceUtil.addFolder(null, userId, groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, false, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName, folderName, false, dlServiceCtx);
        }
        return dlFolder.getFolderId();
    }
    private ServiceContext getFileServiceContext(ActionRequest actionRequest) throws PortalException {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(FileEntry.class.getName(), actionRequest);
        serviceContext.setAddGroupPermissions(true);
        serviceContext.setAddGuestPermissions(true);
        return serviceContext;
    }
}