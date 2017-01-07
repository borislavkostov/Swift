<%-- 
    Document   : EnterPerson
    Created on : Jan 2, 2017, 8:03:59 PM
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
        personStorage.enterPersonWeb(person);
        }catch(SQLException e){}
        response.sendRedirect("index.jsp");}%>
    <head>
        <style>
            div{width: 25%;margin: 0 auto; }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter Person</title>
    </head>
    <body background='http://carbon.outreach.psu.edu/wp-content/uploads/2015/07/background-final.jpg'>       
        <div>
            <form action="EnterPerson.jsp" method="POST">
                <p>First Name</p>
                <input type="text" name="firstName" value="" />
                <p>Middle Name</p>
                <input type="text" name="middleName" value="" />
                <p>Last Name</p>
                <input type="text" name="lastName" value=""  />
                <p>Gender</p>
               <input type="radio" name="gender" value="Male" checked> Male<input type="radio" name="gender" value="Female"> Female<br>
                <p>Height</p>
                <input type="text" name="height" value="" placeholder="178" />
                <p>Date of Birth</p>
                <input type="text" name="dateOfBirth" value="" placeholder="2.10.1993" />
                <p>Country</p>
                <input type="text" name="country" value="" placeholder="Bulgaria" />
                <p>City</p>
                <input type="text" name="City" value="" placeholder="Sofia" />
                <p>Municipality</p>
                <input type="text" name="municipality" value="" placeholder="Mladost" />
                <p>Postal Code</p>
                <input type="text" name="postalcode" value="" placeholder="1750..1000" />
                <p>Street</p>
                <input type="text" name="street" value="" placeholder="Jerusalim" />
                <p>Number</p>
                <input type="text" name="number" value="" placeholder="13...145" />
                <p>Institution name</p>
                <input type="text" name="institutionName" value=""  />
                <p>Enrollment date</p>
                <input type="text" name="enrollmentDate" value="" placeholder="15.10.2015" />
                <p>Graduation date</p>
                <input type="text" name="graduationDate" value="" placeholder="25.05.2020" /></br>
                <select name="education_code">
                    <option value="primary">Primary</option>
                    <option value="secondary">Secondary</option>
                    <option value="master">Master</option>
                    <option value="bachelor">Bachelor</option>
                    <option value="doctorate">Doctorate</option>
                </select></br>
                <input type="submit" value="submit" name="submit" />
            </form>
        </div>
    </body>
</html>
