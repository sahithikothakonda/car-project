<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to buy cars</title>
</head>
<body>

<h1 style="text-align:centre; color:#ff0000;">Welcome to Buy Sell Cars</h1>
<h2>ALL Solution to your problem</h2>
<form:form method="post" action="cars">

<form:label path="model">Model</form:label>
<form:input path="model"/>

<form:label path="year">Date of Manufacture</form:label>
<form:input path="year"/>

<form:label path="kilometers">Kilo meters covered</form:label>
<form:input path="kilometers"/>

<form:label path="brand">Brand</form:label>
<form:input path="brand"/>

<form:label path="status">Status</form:label> 
<form:select path="status" items="${status}"/>


<input type="submit" value="Add">
</form:form>


</body>
</html>