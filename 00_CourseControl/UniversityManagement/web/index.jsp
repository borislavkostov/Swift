<%-- 
    Document   : index

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>University Management</title>
    </head>
    <body>
        <%
            Class.forName("com.mysql.jdbc.Driver"); 
            try {
                MySQL.MySQLPersonStorage per = new MySQL.MySQLPersonStorage();
                personaldetails.Citizen person = per.pullPerson(58);%>
                 <p><%out.print(person.toString());%></p>
           <%} catch (java.sql.SQLException e) {%>
           <p><%out.print(e.toString());%></p>
            <%}%>

    </body>
</html>
