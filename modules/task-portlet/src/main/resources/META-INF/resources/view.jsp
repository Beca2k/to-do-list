<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="container mt-5">

    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="fw-bold text-primary">✨ Minhas Tarefas</h2>
        <portlet:renderURL var="addTaskURL">
            <portlet:param name="mvcRenderCommandName" value="/task/add_form" />
        </portlet:renderURL>
        <a href="${addTaskURL}" class="btn btn-primary shadow-sm">+ Nova Tarefa</a>
    </div>

            <div class="table-responsive rounded shadow-sm">
                <table class="table table-bordered table-hover align-middle bg-white">
                    <thead class="table-light text-center">
                        <tr>
                            <th style="width: 10%;">Imagem</th>
                            <th>Título</th>
                            <th>Descrição</th>
                            <th>Status</th>
                            <th>Sub Tarefas</th>
                            <th style="width: 22%;">Ações</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="task" items="${tasks}">
                            <tr class="${task.status == 1 ? 'table-success' : ''}">
                                <td class="text-center">
                                    <img src="${task.path}" alt="Imagem" class="rounded" style="height: 50px;" />
                                </td>
                                <td><strong>${task.title}</strong></td>
                                <td>${task.description}</td>
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
                                     <c:choose>
                                         <c:when test="${not empty subtasksMap[task.taskId]}">
                                             <span class="badge bg-info text-dark">
                                                 ${fn:length(subtasksMap[task.taskId])} subtarefa(s)
                                             </span>
                                         </c:when>
                                         <c:otherwise>
                                             <span class="text-muted">Nenhuma</span>
                                         </c:otherwise>
                                     </c:choose>
                                 </td>
                                </td>
                                <td class="text-center">
                                    <form action="<portlet:actionURL name='/task/change' />" method="post" class="d-inline">
                                        <input type="hidden" name="<portlet:namespace />taskId" value="${task.taskId}" />
                                        <button class="btn btn-outline-success btn-sm me-1" title="Concluir" onclick="return confirm('Tem certeza que deseja concluir esta tarefa?');">
                                            ✔
                                        </button>
                                    </form>

                                    <portlet:renderURL var="editURL">
                                        <portlet:param name="mvcRenderCommandName" value="/task_frm_edit" />
                                        <portlet:param name="taskId" value="${task.taskId}" />
                                    </portlet:renderURL>
                                    <a href="${editURL}" class="btn btn-outline-primary btn-sm me-1" title="Editar">
                                        ✏
                                    </a>

                                    <form action="<portlet:actionURL name='/task/delete' />" method="post" class="d-inline">
                                        <input type="hidden" name="<portlet:namespace />taskId" value="${task.taskId}" />
                                        <button class="btn btn-outline-danger btn-sm" title="Excluir" onclick="return confirm('Tem certeza que deseja excluir esta tarefa?');">
                                            ✖
                                        </button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
</div>
