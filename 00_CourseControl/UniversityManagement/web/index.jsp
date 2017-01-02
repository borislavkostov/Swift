
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            p { font-family: "Times New Roman", Times, serif;font-weight: bold;font-variant: small-caps;}
            input {font-family: "Times New Roman", Times, serif;font-weight: bold;font-variant: small-caps;}
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter ID</title>
    </head>
    <body>
        <form  action="ShowInfo.jsp" method="POST">
            <p>Enter Person ID</p>
            <input type="text" name="id" size="10" placeholder="Person ID..." />
            <input type="submit" value="Search" name="SearchIDButton" />
        </form>
        <form action="EnterPerson.jsp">
            <input type="submit" value="Enter Person" />
        </form>
    </body>
</html>
