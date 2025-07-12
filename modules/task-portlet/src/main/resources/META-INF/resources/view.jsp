<%@ include file="/init.jsp" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

  <div class="container mt-4">
    <h2>Lista de Tarefas</h2>
<portlet:renderURL var="addTaskURL" windowState="normal">
       <portlet:param name="mvcRenderCommandName" value="/task/add_form" />
   </portlet:renderURL>


    <div>
        <a href="${addTaskURL}" class="btn btn-primary">+</a>
        <aui:input name="title" label="" required="true" />
    </div>
         <table class="table table-bordered table-striped align-middle">
                            <thead class="table">
                                <tr>
                                    <th>Título</th>
                                    <th>Imagem</th>
                                    <th>Descrição</th>
                                    <th>Status</th>
                                    <th style="width: 200px;">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="task" items="${tasks}">
                                    <!-- Tarefa principal -->
                                    <tr class="${task.status == 1 ? 'table-success' : ''}">
                                        <td><strong>${task.title}</strong></td>
                                        <td><img src="${task.path}" alt="Imagem da tarefa" width="auto" height="50" /></td>
                                        <td>${task.description}</td>
                                        <td>${task.status}</td>
                                        <td>
                                            <form action="<portlet:actionURL name='/task/status' />" method="post" class="d-inline">
                                                <input type="hidden" name="<portlet:namespace />taskId" value="${task.taskId}" />
                                                <button class="btn btn-sm btn-success" title="Concluir" onclick="return confirm('Marcar como concluída?');">&#10003;</button>
                                             </form>

                                            <portlet:renderURL var="updateTaskURL" windowState="normal">
                                                <portlet:param name="mvcRenderCommandName" value="/task/update_form" />
                                                <portlet:param name="taskId" value="${task.taskId}" />
                                            </portlet:renderURL>
                                            <a href="${updateTaskURL}" class="btn btn-sm btn-warning" title="Editar">&#9998;</a>

                                            <form action="<portlet:actionURL name='/task/remove' />" method="post" class="d-inline">
                                                <input type="hidden" name="<portlet:namespace />taskId" value="${task.taskId}" />
                                                <button class="btn btn-sm btn-danger" title="Excluir" onclick="return confirm('Excluir tarefa?');">&#10006;</button>
                                            </form>
                                        </td>
                                    </tr>
                        </c:forEach>
                    </tbody>
                </table>


    <hr/>
</div>

