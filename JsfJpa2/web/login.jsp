<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>

        <h1>Login</h1>

        <f:view>
            <h:messages style="color: red"
                        showDetail="true">
            </h:messages>
            <h:form id="login">
                <h:panelGrid columns="2" border="0">
                    Usuário: <h:inputText id="username" 
                                 value="#{usermanager.username}"/>        
                    Senha: <h:inputSecret id="password"
                                   value="#{usermanager.password}"/>
                </h:panelGrid>
                <h:commandButton id="submit" 
                                 type="submit"
                                 value="Logar"
                                 action="#{usermanager.validateUser}"/>
                <br>
                <h:commandLink id="listar"
                               value="Listar"
                               action="#{usermanager.listUser}"/>
                <br>
                <h:commandLink id="create"
                               value="Criar nova conta"
                               action="create"/>
                <br>
                <h:commandLink id="generate"
                               value="Gerar contas (PARA TESTES)"
                               action="#{usermanager.generateUsers}"/>
            </h:form>

        </f:view>

    </body>
</html>
