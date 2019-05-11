<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    <f:view>
        ${user.firstname}
    </f:view>
    <table id="listTable" border="3">
        <tr >
            <th bgcolor=>ID</th>
            <th bgcolor=>Primeiro nome</th>
            <th bgcolor=>Ultimo nome</th>
            <th bgcolor=>Usuário</th>
            <th bgcolor=>Senha</th>
            <th bgcolor=>Since</th>
        </tr>
        <!--<tr>
            <td>${user.id}&nbsp;&nbsp;</td> 
            <td>${user.firstname}&nbsp;&nbsp;</td> 
            <td>${user.lastname}&nbsp;&nbsp;</td> 
            <td>${user.username}&nbsp;&nbsp;</td>
            <td>${user.password}&nbsp;&nbsp;</td> 
            <td>${user.since}&nbsp;&nbsp;</td> 
        </tr>--> 

    </table>
</body>
</html>
