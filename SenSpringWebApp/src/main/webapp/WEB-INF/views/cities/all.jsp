<%-- 
    Document   : all
    Created on : Sep 19, 2020, 4:06:52 PM
    Author     : SMARTCS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p><c:out value="${msg}" /></p>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name (AR)</th>
                <th>Name (EN)</th>
                <th colspan="3">Actions</th>
            </tr>
            <c:forEach items="${findCities}" var="iCity">
                <tr>
                    <td><c:out value="${iCity.id}" /></td>
                    <td><c:out value="${iCity.nameAr}" /></td>
                    <td><c:out value="${iCity.nameEn}" /></td>
                    <td><a href="viewCity.jsp?id=<c:out value="${iCity.id}" />">View</a></td>
                    <td><a href="editCity.jsp?id=<c:out value="${iCIty.id}" />">Edit</a></td>
                    <td><a href="deleteCity.jsp?id=<c:out value="${iCity.id}" />"
                           onclick="if(confirm('Are You Sure?')){
                               return true
                           }else {
                               return false
                           }">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="newCity.html">Add New City</a>
        <c:remove var="findCities" />
    </body>
</html>
