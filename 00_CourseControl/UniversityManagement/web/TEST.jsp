<%-- 
    Document   : TEST
    Created on : Jan 7, 2017, 4:43:52 PM
    Author     : templars1914
--%>

<%@page import="Exception.DALException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="MySQL.MySQLPersonStorage"%>
<%@page import="personaldetails.Gender"%>
<%@page import="personaldetails.Citizen"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="address.Address"%>
<%@page import="education.Education"%>
<%@page import="education.PrimaryEducation"%>
<%@page import="education.SecondaryEducation"%>
<%@page import="education.HigherEducation"%>
<%@page import="education.HigherEducation"%>
<%@page import="education.EducationDegree"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TEST</title>
    </head>
    <body>
        <%if (request.getParameter("firstName") != null) {
        Class.forName("com.mysql.jdbc.Driver");
        try{
        Citizen person = null;

        String firstName = request.getParameter("firstName");

        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        int height = Integer.parseInt(request.getParameter("height"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"), formatter);
        if (request.getParameter("gender").equals("Male")) {
            person = new Citizen(firstName, middleName, lastName, Gender.Male, height, dateOfBirth);
        } else {
            person = new Citizen(firstName, middleName, lastName, Gender.Female, height, dateOfBirth);
        }
        Address adr = new Address(request.getParameter("country"), request.getParameter("City"), request.getParameter("municipality"), request.getParameter("postalcode"), request.getParameter("street"), request.getParameter("number"),0,0);
        person.setAddress(adr);
        Education edu = null;
        String institutionName = request.getParameter("institutionName");
        LocalDate enrollmentDate = LocalDate.parse(request.getParameter("enrollmentDate"), formatter);
        LocalDate graduationDate = LocalDate.parse(request.getParameter("graduationDate"), formatter);
        if (request.getParameter("education_code").equals("primary")) {
            edu = new PrimaryEducation(institutionName, enrollmentDate, graduationDate);
        } else if (request.getParameter("education_code").equals("bachelor")) {
            edu = new HigherEducation(institutionName, enrollmentDate, graduationDate, EducationDegree.Bachelor);
        } else if (request.getParameter("education_code").equals("doctorate")) {
            edu = new HigherEducation(institutionName, enrollmentDate, graduationDate, EducationDegree.Doctorate);
        } else if (request.getParameter("education_code").equals("master")) {
            edu = new HigherEducation(institutionName, enrollmentDate, graduationDate, EducationDegree.Master);
        } else if (request.getParameter("education_code").equals("secondary")) {
            edu = new SecondaryEducation(institutionName, enrollmentDate, graduationDate);
        }
        person.addEducation(edu);

        String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/PersonCharacteristicsDB?useUnicode=true&characterEncoding=UTF-8";
        String DBMS_USERNAME = "root";
        String DBMS_PASSWORD = "173173";
        MySQLPersonStorage personStorage = new MySQLPersonStorage(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        personStorage.enterPersonTEST(person);
        }catch(SQLException e){}
        //response.sendRedirect("index.jsp");%>

        <h1>Hello World!</h1>
        <%}else{%>
        <h1>SHIT</h1>
        <%}%>
    </body>
</html>
