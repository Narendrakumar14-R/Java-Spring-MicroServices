<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
</head>
<body>

    <h1 align="center">Registration Successful</h1>
    <h2>The details entered by the user are :</h2>
  
        Name: ${userRegInfo.name}     <br/>
        User Name: ${userRegInfo.userName} <br/>
        Password: ${userRegInfo.password} <br/>
        Branch: ${userRegInfo.branch}   <br/>
        Skills: ${userRegInfo.skills}   <br/>
        Gender: ${userRegInfo.gender}   <br/>
<br/><br/>
<br/><br/>
<br/><br/>
<div align="center">
    <form action="register" method="get">
        <input type="submit" value="Back to Registration Page" />
    </form>
</div>

</body>
</html>
