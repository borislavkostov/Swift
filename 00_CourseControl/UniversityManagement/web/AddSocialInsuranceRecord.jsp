<%-- 
    Document   : AddSocialInsuranceRecord
    Created on : Jan 7, 2017, 5:37:03 PM
    Author     : templars1914
--%>

<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="MySQL.MySQLSocialInsuranceStorage"%>
<%@page import="insurance.SocialInsuranceRecord"%>
<%@page import="Exception.DALException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            p { font-family: "Times New Roman", Times, serif;font-weight: bold;font-variant: small-caps;}
            input {font-family: "Times New Roman", Times, serif;font-weight: bold;font-variant: small-caps;}
            table{ display: inline-block;}
            td {width:auto;height:auto;text-align: left;padding: 5px;font-family: "Times New Roman", Times, serif;}
            form {display: inline-block;vertical-align:top;}
            div{width: 500px;margin: 0 auto; }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="favicon.ico" />
        <title>New record</title>
    </head>
    <body background='http://carbon.outreach.psu.edu/wp-content/uploads/2015/07/background-final.jpg'>
        <% try {
                Class.forName("com.mysql.jdbc.Driver");
                String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/PersonCharacteristicsDB?useUnicode=true&characterEncoding=UTF-8";
                String DBMS_USERNAME = "root";
                String DBMS_PASSWORD = "173173";
                MySQLSocialInsuranceStorage ins = new MySQLSocialInsuranceStorage(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
                if (request.getParameter("year") != null) {
                    List<SocialInsuranceRecord> socIn = new ArrayList();
                    int year = Integer.parseInt(request.getParameter("year").trim());
                    int month = Integer.parseInt(request.getParameter("month").trim());
                    double amount = Double.parseDouble(request.getParameter("amount"));
                    socIn.add(new SocialInsuranceRecord(year, month, amount));
                    ins.enterSocialInsurance(socIn, Integer.parseInt(request.getParameter("id")));
                    session.setAttribute("id", request.getParameter("id"));
                    response.sendRedirect("ShowInfo.jsp");
                }
            } catch (SQLException e) {
            }%>
            <div>
                <p>Social Insurances</p>
        <table border="1">
            <thead>
                <tr>
                    <th>Year</th>
                    <th>Month</th>
                    <th>Amount</th>
                </tr>
            </thead>
            <tbody>

                <%
                    Class.forName("com.mysql.jdbc.Driver");
                    String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/PersonCharacteristicsDB?useUnicode=true&characterEncoding=UTF-8";
                    String DBMS_USERNAME = "root";
                    String DBMS_PASSWORD = "173173";
                    MySQLSocialInsuranceStorage ins = new MySQLSocialInsuranceStorage(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
                    if (request.getParameter("person_id") != null) {
                        List<SocialInsuranceRecord> socRec = ins.pullSocialInsurance(Integer.parseInt(request.getParameter("person_id")));                  
                     for (SocialInsuranceRecord soc :socRec ) {%>
                <tr>
                    <td><%=soc.getYear()%></td>
                    <td><%=soc.getMonth()%></td>
                    <td><%=soc.getAmount()%></td>
                </tr>
                <% }
                    }%>

            </tbody>
        </table>
        <form action="AddSocialInsuranceRecord.jsp">
            <p>Enter Social Insurance</p>
            <input type="hidden" name="id" value="<%=request.getParameter("person_id")%>" />
            <p>Year</p>
            <input type="text" name="year" value="" />
            <p>Month</p>
            <input type="text" name="month" value="" />
            <p>Amount</p>
            <input type="text" name="amount" value="" />                  
            <input type="submit" value="Enter" />
        </form>
            </div>
    </body>
</html>
