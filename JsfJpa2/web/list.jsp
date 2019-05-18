<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listagem!</h1>
        <f:view>
            <h:form id="login">
                <h:panelGrid columns="3" border="0">
                <tr >
                    <th bgcolor=>ID</th>
                    <th bgcolor=>Primeiro nome</th>
                    <th bgcolor=>Ultimo nome</th>
                    <th bgcolor=>Usuário</th>
                    <th bgcolor=>Senha</th>
                    <th bgcolor=>Since</th>
                </tr>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}&nbsp;&nbsp;</td> 
                        <td>${user.firstname}&nbsp;&nbsp;</td> 
                        <td>${user.lastname}&nbsp;&nbsp;</td> 
                        <td>${user.username}&nbsp;&nbsp;</td>
                        <td>${user.password}&nbsp;&nbsp;</td> 
                        <td>${user.since}&nbsp;&nbsp;</td> 
                    </tr 
                </c:forEach>
            </h:panelGrid>
        </h:form>
        <br/>
        <h:form id="voltar">
            <h:commandLink id="voltar"
                           value="Voltar"
                           action="login"/>
        </h:form>
    </f:view>

</body>
</html>
