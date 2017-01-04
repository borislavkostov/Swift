<%-- 
    Document   : index

--%>

<%@page import="businesslogic.SocialInsuranceChecker"%>
<%@page import="personaldetails.Citizen"%>
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
<%!Citizen person = null;%>
<%
    if (request.getParameter("id") != null) {
        id = Integer.parseInt(request.getParameter("id"));
    }
%>
<%
    Class.forName("com.mysql.jdbc.Driver");
    try {
        MySQL.MySQLPersonStorage per = new MySQL.MySQLPersonStorage();
        person = per.pullPerson(id);
    } catch (SQLException e) {

    }%>

<html>
    <head><style>
            th,td{border: 2px inset dodgerblue;}
            td {width:200px;height:100px;text-align: left;padding: 5px;font-family: "Times New Roman", Times, serif;}
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
                        <td>
                            <p>Name: <%=person.getFirstName()%> <%=person.getMiddleName()%> <%=person.getLastName()%></br>
                                Date of birth: <%=person.getDateOfBirth()%></br>
                                Years: <%=person.getAge()%></br>
                                Height: <%=person.getHeight()%>cm</p>
                        </td>
                        <td>
                            <p><%=person.getAddress()%></p>
                        </td>
                        <td><form action="ShowInfo.jsp">
                                <p>Can you take social assistance</p>
                                <input type="submit" name="btSocialInsurance" value="Check">
                                <% boolean check=SocialInsuranceChecker.check(request.getParameter("btSocialInsurance"), person);
                                    if(SocialInsuranceChecker.SocialInsurance(check, person)!=0){%>
                                    <p><%=SocialInsuranceChecker.SocialInsurance(check, person)%></p>
                                    <%}
                                %>
                            </form></td>
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
