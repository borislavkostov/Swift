<%-- 
    Document   : EnterPerson
    Created on : Jan 2, 2017, 8:03:59 PM
    Author     : templars1914
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="MySQL.MySQLPersonStorage"%>
<%@page import="personaldetails.Gender"%>
<%@page import="personaldetails.Citizen"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    if (request.getParameter("id") != null) {
    Citizen person;
    String firstName = request.getParameter("firstName");
    String middleName = request.getParameter("midlleName");
    String lastName = request.getParameter("lastName");
    int height =Integer.parseInt(request.getParameter("height"));
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
    LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"), formatter);
    if(request.getParameter("gender").equals("Male")){
         person = new Citizen(firstName, middleName, lastName,Gender.Male, height, dateOfBirth);
    }else{
         person = new Citizen(firstName, middleName, lastName,Gender.Male, height, dateOfBirth);
    }
    MySQLPersonStorage personStorage = new MySQLPersonStorage();
    
    try{
        personStorage.enterPerson(person);
    }catch (SQLException e){
            }
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter Person</title>
    </head>
    <body>       
        <form name="EnterPerson" action="EnterPerson.jsp">
            <p>First Name</p>
            <input type="text" name="firstName" value="" />
            <p>Middle Name</p>
            <input type="text" name="middleName" value="" />
            <p>Last Name</p>
            <input type="text" name="lastName" value=""  />
            <p>Gender</p>
            <input type="text" name="gender" value="" placeholder="Male/Female" />
            <p>Height</p>
            <input type="text" name="height" value="" placeholder="178" />
            <p>Date of Birth</p>
            <input type="text" name="dateOfBirth" value="" placeholder="2.10.1993" />
            <input type="submit" value="Enter Person" />
        </form>
    </body>
</html>
