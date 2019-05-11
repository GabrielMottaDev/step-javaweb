<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSF + JPA</title>
    </head>
    <body>
        <f:view>
            <h1><h:outputText value="JSF + JPA" /></h1>
            Bem-vindo ${user.firstname} ${user.lastname}!  Você está registrado desde ${user.since}.
            <h:form>
                <h:commandButton id="logout" value="Deslogar" action="#{usermanager.logout}"/>
            </h:form>
        </f:view>
    </body>
</html>
