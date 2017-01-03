<%-- 
    Document   : index

--%>

<%@page import="MySQL.MySQLEducationStorage"%>
<%@page import="java.io.IOException"%>
<%@page import="MySQL.MySqlAddressStorage"%>
<%@page import="java.sql.SQLException"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="javax.servlet.*"%>
<%@page import="education.Education"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!int id = 0;%>
<%
    if (request.getParameter("id") != null) {
        id = Integer.parseInt(request.getParameter("id"));
    }
%>
<html>
    <head><style>
            th,td{border: 2px inset dodgerblue;}
            td {width:160px;height:80px;text-align: left;padding: 5px;font-family: "Times New Roman", Times, serif;}
            div{width: 50%;margin: 10% auto; }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>University Management</title>
    </head>
    <body background='http://carbon.outreach.psu.edu/wp-content/uploads/2015/07/background-final.jpg'>
        <div>
            <table   class = "PersonalInfoTable">
                <thead>
                <p>Personal information</p>
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
                                }%>
                        </td>
                        <td><form action="index.jsp">
                                <p>Can you take social assistance</p>
                                <INPUT TYPE="button" onClick="history.go(0)" VALUE="Check">
                            </form></td>
                    </tr>
                    <tr>
                        <%Class.forName("com.mysql.jdbc.Driver");
                            try {
                                MySQLEducationStorage edu = new MySQLEducationStorage();
                                for (Education education : edu.pullEducation(id)) {%>
                        <td><%=education.getInstitutionName()%></br>
                            <%=education.getEnrollmentDate()%>-<%=education.getGraduationDate()%></br>
                            <%=education.getDegree()%>
                        </td>
                        <%}
                            } catch (SQLException e) {
                            }%>
                    </tr>
                </tbody>
            </table>
        </div>


    </body>
</html>
