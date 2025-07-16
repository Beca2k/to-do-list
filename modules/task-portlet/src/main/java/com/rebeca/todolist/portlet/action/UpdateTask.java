package com.rebeca.todolist.portlet.action;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.rebeca.todolist.entity.model.Task;
import com.rebeca.todolist.entity.service.TaskLocalService;
import com.rebeca.todolist.portlet.constants.TaskPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import java.io.File;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + TaskPortletKeys.TASK,
                "mvc.command.name=/task/update"
        },
        service = MVCActionCommand.class
)

public class UpdateTask implements MVCActionCommand {

    @Reference
    private TaskLocalService _taskLocalService;

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

        long taskId = ParamUtil.getLong(actionRequest, "taskId");
        String title = ParamUtil.getString(actionRequest, "title");
        String description = ParamUtil.getString(actionRequest, "description");

        try {
           Task task = _taskLocalService.getTask(taskId);
           task.setTitle(title);
           task.setDescription(description);

            UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
            File file = uploadPortletRequest.getFile("file");
            String originalFileName = uploadPortletRequest.getFileName("file");

            if (file != null && file.length() > 0) {
                ServiceContext serviceContext = ServiceContextFactory.getInstance(Task.class.getName(), actionRequest);

                boolean isDifferentFile = true;
                if (task.getFileEntryId() > 0) {
                    try {
                        FileEntry currentFileEntry = DLAppServiceUtil.getFileEntry(task.getFileEntryId());
                        if (currentFileEntry.getFileName().equals(originalFileName)) {
                            isDifferentFile = false;
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }

                if (isDifferentFile) {
                    if (task.getFileEntryId() > 0) {
                        try {
                            DLAppLocalServiceUtil.deleteFileEntry(task.getFileEntryId());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

                String uniqueFileName = System.currentTimeMillis() + "_" + originalFileName;
                long folderId = getFolderId(serviceContext.getScopeGroupId(), "panic", serviceContext.getUserId(), actionRequest);
                FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), serviceContext.getScopeGroupId(), folderId, uniqueFileName, "image/jpeg", uniqueFileName, "", "", file, serviceContext);
                String path = DLUtil.getPreviewURL(DLAppServiceUtil.getFileEntry(fileEntry.getFileEntryId()), DLAppServiceUtil.getFileEntry(fileEntry.getFileEntryId()).getFileVersion(), serviceContext.getThemeDisplay(), "");
                task.setPath(path);
            }
            _taskLocalService.updateTask(task);
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    private long getFolderId(long groupId, String folderName, long userId, ActionRequest actionRequest) throws PortalException {

        DLFolder dlFolder = null;
        ServiceContext dlServiceCtx = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
        try {
            dlFolder = DLFolderLocalServiceUtil.getFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName);
        } catch (Exception e) {
            dlFolder = DLFolderLocalServiceUtil.addFolder(null, userId, groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, false, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName, folderName, false, dlServiceCtx);
        }
        return dlFolder.getFolderId();
    }
}