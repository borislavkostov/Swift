

<%@page import="MySQL.MySQLSocialInsuranceStorage"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="insurance.SocialInsuranceRecord"%>
<%@page import="java.util.List"%>
<%@page import="businesslogic.SocialInsuranceChecker"%>
<%@page import="personaldetails.Citizen"%>
<%@page import="MySQL.MySQLEducationStorage"%>
<%@page import="java.io.IOException"%>
<%@page import="MySQL.MySqlAddressStorage"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="javax.servlet.*"%>
<%@page import="education.Education"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!int id = 0;%>
<%!Citizen person = null;%>

<%
    if (request.getParameter("id") != null) {
        id = Integer.parseInt(request.getParameter("id"));
    }
%>
<%
    Class.forName("com.mysql.jdbc.Driver");
    String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/PersonCharacteristicsDB?useUnicode=true&characterEncoding=UTF-8";
    String DBMS_USERNAME = "root";
    String DBMS_PASSWORD = "173173";
    MySQL.MySQLPersonStorage per = new MySQL.MySQLPersonStorage(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
    person = per.pullPerson(id);
%>
<html>
    <head><style>
            th,td{border: 2px inset dodgerblue;}
            td {width:200px;height:100px;text-align: left;padding: 5px;font-family: "Times New Roman", Times, serif;}
            div{width: 50%;margin: 10% auto; }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="favicon.ico" />
        <title>University Management</title>
    </head>
    <body background='http://carbon.outreach.psu.edu/wp-content/uploads/2015/07/background-final.jpg'>
        <div>
            <table >
                <thead>
                    Personal information
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <p>Name: <%=person.getFirstName()%> <%=person.getMiddleName()%> <%=person.getLastName()%></br>
                                Date of birth: <%=person.getDateOfBirth()%></br>
                                Years: <%=person.getAge()%></br>
                                Height: <%=person.getHeight()%>cm</p>
                        </td>
                        <td>
                            <p><%=person.getAddress()%></p>
                        </td>
                        <td><form action="AddSocialInsuranceRecord.jsp">
                                <input type="hidden" name="person_id" value="<%=id%>" />
                                <input type="submit" value="Enter new insurance record" />
                            </form>
                            <% if (request.getParameter("insurance") != null) {
                                        Class.forName("com.mysql.jdbc.Driver");
                                        if (SocialInsuranceChecker.check(person)) {%>                                        
                            <p>Amount: <%=String.format("%.2f", SocialInsuranceChecker.sumAmount(person))%></p>
                            <%} else {%>
                            <p>You can't get social insurance</p>
                            <%}
                    }else{%>
                            <form action="ShowInfo.jsp">                                                          
                                <p>Can you take social assistance</p>
                                <input type="hidden" name="insurance" value="<%=id%>" />
                                <input type="submit" name="btSocialInsurance" value="Check">
                            </form></td>
                            <%}%>
                    </tr>
                    <tr>
                        <%
                            for (Education education : person.getEducations()) {%>
                        <td><%=education.getInstitutionName()%></br>
                            <%=education.getEnrollmentDate()%>-<%=education.getGraduationDate()%></br>
                            <%=education.getDegree()%>
                        </td>
                        <%}%>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
