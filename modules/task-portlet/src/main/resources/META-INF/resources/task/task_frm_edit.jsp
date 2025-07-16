<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />

<portlet:actionURL name="/task/update" var="updateTaskURL" />

<div class="container mt-4">

    <aui:form action="${subTaskCreateURL}" method="post">
        <div class="mb-3">
            <label class="form-label">Subtarefas</label>
            <div id="subtask-container">
                <input type="text" name="title" class="form-control mb-2" placeholder="Subtarefa" />
            </div>
            <aui:button type="submit" class="btn btn-secondary btn-sm" value="Adicionar Subtarefa" />
        </div>
    </aui:form>

    <aui:form action="${updateTaskURL}" method="post">

        <aui:input name="taskId" label="Código" value="${task.taskId}" readonly="true" />
        <aui:input name="title" label="Título" required="true" value="${task.title}" />
        <aui:input type="textarea" name="description" label="Descrição" rows="4" value="${task.description}" />

        <c:if test="${not empty task.path}">
            <img src="${task.path}" width="auto" height="200" class="image mt-3 mb-3" />
        </c:if>

        <aui:input name="file" label="Nova imagem (opcional)" type="file" accept="image/*" />

        <aui:button type="submit" value="Atualizar" />

        <portlet:renderURL var="cancelURL">
            <portlet:param name="mvcRenderCommandName" value="/" />
        </portlet:renderURL>

        <a href="${cancelURL}" class="btn btn-outline-danger">Cancelar</a>
    
    </aui:form>

    <liferay-portlet:actionURL  name="/subtask/create" var="subTaskCreateURL" >
        <liferay-portlet:param name="taskId" value="${task.taskId}" />
   </liferay-portlet:actionURL>
</div>