<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>

    <h1 align="center">Create Registration Form using Form Tag in Spring MVC</h1>
        
    
  <form:form action="registration-complete" method="post" modelAttribute="userRegInfo">
  
    
    
    <div align="center">
    
    <!-- A Simple Input Field -->
    <label>Name : </label>
    <form:input path="name"/>
    
    <br/>
    
    <label>User Name : </label>
    <form:input path="userName"/>
    
    <br/>
    
    <label>Password : </label>
    <form:password path="password"/>
    
    <br/>
    
    <!-- DropDown Field -->
    <label>Branch : </label>
    <form:select path="branch">
        <form:option value="CSE" label="Computer Science"></form:option>
        <form:option value="CSA" label="Computer Science and Application"></form:option>
        <form:option value="EE" label="Electrical Engineering"></form:option>
        <form:option value="ME" label="Mechanical Engineering"></form:option>
    </form:select>
    
    <br/>
    
    <!-- CheckBox Field -->
    <label>Skills : </label>
    Java : <form:checkbox path="skills" value="java"/>
    Python : <form:checkbox path="skills" value="python"/>
    C++ : <form:checkbox path="skills" value="cpp"/>
    DSA : <form:checkbox path="skills" value="dsa"/>
    Spring : <form:checkbox path="skills" value="spring"/>
    
    <br/>
    
    <!-- RadioButton Field -->
    <label>Gender : </label>
    Male<form:radiobutton path="gender" value="male"/>
    Female<form:radiobutton path="gender" value="female"/>
    
    <br/>
    
    <!-- Button Field -->
    <input type="submit" value="Register">
    
    </div>
    
    </form:form>

</body>
</html>