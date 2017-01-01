<%-- 
    Document   : index

--%>

<%@page import="java.io.IOException"%>
<%@page import="MySQL.MySqlAddressStorage"%>
<%@page import="java.sql.SQLException"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="javax.servlet.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!int id = 0;%>
    <%
    if (request.getParameter("id") != null) {
        id = Integer.parseInt(request.getParameter("id"));
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>University Management</title>
    </head>
    <body><table border="3">
            <thead>
                <tr>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><%
                        Class.forName("com.mysql.jdbc.Driver");
                        try {
                            MySQL.MySQLPersonStorage per = new MySQL.MySQLPersonStorage();
                            personaldetails.Citizen person = per.pullPerson(id);%>
                        <p><%out.print(person.toString());%></p>
                        <%} catch (java.sql.SQLException e) {%>
                        <p><%out.print(e.toString());%></p>
                        <%}%></td>
                    <td><%Class.forName("com.mysql.jdbc.Driver");
                        try {
                            MySqlAddressStorage adr = new MySqlAddressStorage();%>
                        <p><%=adr.pullAddress(id).toString()%><p>
                            <%} catch (SQLException e) {

                                }
                            %></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>



    </body>
</html>
