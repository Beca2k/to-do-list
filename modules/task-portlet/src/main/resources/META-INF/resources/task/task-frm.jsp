<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<portlet:actionURL name="/task/add" var="addTaskURL" />
  <div class="container mt-4">
<aui:form action="${addTaskURL}" method="post">

    <aui:input name="title" label="Titulo" required="true" />
    <aui:input type="textarea" name="description" label="Descrição" rows="4" />
    <aui:input name="file" label="Imagem" type="file" accept="image/*" required="true" />

    <aui:select name="parentId" label="Tarefa principal" showEmptyOption="false" value="0">
        <aui:option value="0"></aui:option>

        <c:forEach var="task" items="${parentTasks}">
            <aui:option value="${task.taskId}">${task.title}</aui:option>
        </c:forEach>
    </aui:select>

    <aui:button type="submit" value="Salvar" />

    <portlet:renderURL var="cancelURL">
        <portlet:param name="mvcRenderCommandName" value="/" />
    </portlet:renderURL>
    <a href="${cancelURL}" class="btn btn-outline-danger">Cancelar</a>
</aui:form>
    <hr/>
</div>