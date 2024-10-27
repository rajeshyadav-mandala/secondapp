<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color:green; text-align:center""> ${messageString} </h1>


<style>
    table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
        font-size: 18px;
        text-align: left;
    }
    th, td {
        padding: 12px;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #4CAF50;
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    tr:hover {
        background-color: #ddd;
    }
    td {
        color: #333;
    }
</style>

<c:choose>
    <c:when test="${!empty list}">
        <table>
            <tr> 
                <th> eno </th> 
                <th> deptno </th> 
                <th> ename </th> 
                <th> salary </th> 
                <th> Operations </th>
            </tr>
            <c:forEach var="emp" items="${list}">
                <tr> 
                    <td> ${emp.eno} </td>
                    <td> ${emp.deptno} </td>
                    <td> ${emp.ename} </td>
                    <td> ${emp.salary} </td>
                    <td><a href="emp_edit?no=${emp.eno}"> Edit </a> &nbsp; &nbsp;
                    <a href="emp_delete?no=${emp.eno}"> Delete </a> </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise> No employee list found </c:otherwise>
</c:choose>

<center>

<a href= "./"><img src="Images/home.jpg"></a> &nbsp; &nbsp;

<a href= "emp_add"><img src="Images/add.jpg"></a> &nbsp; &nbsp; 

</center>