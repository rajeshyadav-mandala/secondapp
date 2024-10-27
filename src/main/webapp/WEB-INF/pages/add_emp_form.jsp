<%@ page isELIgnored="false" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h1 style="color:red; text-align:center""> Register an employee </h1>

<frm:form       modelAttribute="emp">
<table align="center"  border="0" bgcolor="cyan">
  <tr>
    <td> Employee name  </td>
    <td> <frm:input type="text" path="ename"/> </td>
  </tr>
  <tr>
    <td> Employee deptno </td>
    <td> <frm:input type="text" path="deptno"/> </td>
  </tr>
  <tr>
    <td> Employee salary  </td>
    <td> <frm:input type="text" path="salary"/> </td>
  </tr>
  <tr>
    <td>  <input type="submit"  value="Add Employee">   </td>
    <td> <input  type="reset"  value="cancel"/> </td>
  </tr>
</table>


</frm:form>
