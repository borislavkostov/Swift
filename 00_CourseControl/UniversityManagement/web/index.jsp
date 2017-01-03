
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            p { font-family: "Times New Roman", Times, serif;font-weight: bold;font-variant: small-caps;}
            input {font-family: "Times New Roman", Times, serif;font-weight: bold;font-variant: small-caps;}
            form {margin: 0 auto;width: auto}
            div{width: 50%;margin: 10% auto; }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter ID</title>
    </head>
    <body background='http://carbon.outreach.psu.edu/wp-content/uploads/2015/07/background-final.jpg'>
        <div>
            <p>Enter Person ID</p>
            <form  action="ShowInfo.jsp" method="POST" style ='float: left; padding: 1px;'>  
                <input type="text" name="id" size="10" placeholder="Person ID..." />
                <input type="submit" value="Search" name="SearchIDButton" />
            </form>  
            <form action="EnterPerson.jsp"style ='float: left; padding: 1px;'>
                <input type="submit" value="Enter Person" />
            </form>
        </div>
    </body>
</html>
