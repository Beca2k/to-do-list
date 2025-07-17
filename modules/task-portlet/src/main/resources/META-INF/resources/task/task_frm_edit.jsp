<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />

<portlet:actionURL name="/task/update" var="updateTaskURL" />

<div class="container mt-4">

    <liferay-portlet:actionURL  name="/subtask/create" var="subTaskCreateURL" >
        <liferay-portlet:param name="taskId" value="${task.taskId}" />
    </liferay-portlet:actionURL>

    <aui:form action="${subTaskCreateURL}" method="post">
        <div class="mb-3">
            <label class="form-label">Subtarefas</label>
            <div id="subtask-container">
                <aui:input type="text" name="title" label="" cssClass="form-control mb-2" placeholder="Subtarefa" />
            </div>
            <aui:button type="submit" class="btn btn-secondary btn-sm" value="Adicionar Subtarefa" />
        </div>
    </aui:form>

    <div class="table-responsive rounded shadow-sm">
                    <table class="table table-bordered table-hover align-middle bg-white">
                        <thead class="table-light text-center">
                            <tr>
                                <th>Título</th>
                                <th>Status</th>
                                <th style="width: 22%;">Ações</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="task" items="${subtasks}">
                                <tr class="${task.status == 1 ? 'table-success' : ''}">

                                    <td><strong>${task.title}</strong></td>

                                    <td class="text-center">
                                        <c:choose>
                                            <c:when test="${task.status == 1}">
                                                <span class="badge bg-success">Concluída</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="badge bg-warning text-dark">Pendente</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>

                                    <td class="text-center">
                                        <form action="<portlet:actionURL name='/subtask/change' />" method="post" class="d-inline">
                                            <input type="hidden" name="<portlet:namespace />taskId" value="${task.subtaskId}" />
                                            <button class="btn btn-outline-success btn-sm me-1" title="Concluir" onclick="return confirm('Tem certeza que deseja concluir esta sub tarefa?');">
                                                ✔
                                            </button>
                                        </form>

                                        <form action="<portlet:actionURL name='/subtask/delete' />" method="post" class="d-inline">
                                            <input type="hidden" name="<portlet:namespace />taskId" value="${task.subtaskId}" />
                                            <button class="btn btn-outline-danger btn-sm" title="Excluir" onclick="return confirm('Tem certeza que deseja excluir esta sub tarefa?');">
                                                ✖
                                            </button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

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
</div>