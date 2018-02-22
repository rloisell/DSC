<%@ page import="mts.dsc.employee.Employee" %>
<%@ page import="mts.dsc.orm.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@page import="mts.dsc.orm.user.User"%>
<%@page import="mts.dsc.orm.user.UserDAO"%>
<%@page import="mts.dsc.orm.position.Position"%>
<%@page import="mts.dsc.orm.position.PositionDAO"%>
<%@page import="mts.dsc.orm.department.Department"%>
<%@page import="mts.dsc.orm.department.DepartmentDAO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="../css/main.css" rel="stylesheet" type="text/css" media="screen" />
<jsp:include page="../includes/calendar-header.html" />
<title>Admin User's</title>
</head>

<body onload="createCalendar()">
<% 
HttpSession sessionS = request.getSession(false);
Employee emp=(Employee)sessionS.getAttribute("employee");
if(emp==null) {
	response.sendRedirect("/DSC/LoginServlet");
}

String headerURL ="";
switch (emp.getRole()){
	case 1:	headerURL = "../includes/employeeheader.html"; break;
	case 2: headerURL = "../includes/managerheader.html"; break;
	case (-1): headerURL = "../includes/adminheader.html"; break;
}


Integer year=(Integer)sessionS.getAttribute("year");
Integer month=(Integer)sessionS.getAttribute("month");
Integer day=(Integer)sessionS.getAttribute("month");
GregorianCalendar gC;
if(year==null||month==null||day==null) {gC=new GregorianCalendar();}
else {gC=new GregorianCalendar(year, month, day);}
%>

<script type="text/javascript">
var location1=<% out.println("\"null\""); //path of webpage without query string, or null %>
var year=<%= gC.get(Calendar.YEAR) %>
var month=<%= gC.get(Calendar.MONTH) %>
var day=<%= gC.get(Calendar.DATE) %>
</script>

<jsp:include page="<%= headerURL %>" />
<div id="wrapper">
	<!-- start page -->
	<div id="page">

      <!-- start content -->
      <div id="content">
        <div class="post">
          <h1 class="title"><a href="#"><%out.println(emp.getFirstName() +" "+ emp.getLastName() +" - " + emp.getPositionDesc());%>: Admin Users</a></h1>
          	<form name="addUser" id="newUser" method="post" action="/DSC/AdminUsers">
          		<table id="newUser">
          			<tr><h2 class="title">Add New User:</h2></tr>
          			<tr><td><p>EMPLOYEE ID:</p></td><td><input type="text" name="empID" id="empID" size="5" value="#####"></td></tr>
          			<tr><td><p>FIRST NAME:</p></td><td><input type="text" name="fName" id="fName" size="30" value=""></td><td><p>LAST NAME: </p></td><td><input type="text" name="lName" id="lName" size="30" value=""></td></tr>
          			<tr><td><p>EMAIL:</p></td><td><input type="text" name="email" id="email" size="30" value=""></td></tr>
          			<tr><td><p>NCS DATE:</p></td><jsp:include page="../includes/dateselect.jsp"/></tr>
          			<tr>
          				<td><p>POSITION:</p></td><td>
													<% 
														Position [] allPositions = PositionDAO.listPositionByQuery(null,null);
														out.println("<select name=\"position\" id=\"position\">");
														for ( Position aPosition : allPositions ) {
															out.println("<option value=\""+ aPosition.getPositionID() +"\">"+ aPosition.getDescription() +"</option>");
														}
														out.println("</select><br />");
													%>          			
          										</td>
          				<td><p>START DATE:</p></td><jsp:include page="../includes/dateselect.jsp" />
					</tr>
					<tr>
						<td><p>DEPARTMENT:</p></td><td>
													<% 
														Department [] allDepartments = DepartmentDAO.listDepartmentByQuery(null,null);
														out.println("<select name=\"department\" id=\"department\">");
														for ( Department aDept : allDepartments ) {
															out.println("<option value=\""+ aDept.getDeptID() +"\">"+ aDept.getDeptName() +"</option>");
														}
														out.println("</select><br />");
													%>          			
          										</td>
          				<td><p>START DATE:</p></td><jsp:include page="../includes/dateselect.jsp" />
					</tr>
					<tr><td><p>LAN ID:</p></td><td><input type="text" name="lanID" id="lanID" size="8" value=""></td><td><p>PASSWORD:</p></td><td><input type="text" name="pwd" id="pwd" size="8" value=""></td></tr>
					<tr><td><p>DSC ROLE:</p></td><td><select name="role" id="role"><option value="1">EMPLOYEE</option><option value="2">MANAGER</option><option value="-1">ADMINISTRATOR</option></select></td>
					<tr><td></td><td><p><input name="action" type="submit" id="addNewUser" value="Add User" /></p></td></tr>        			
          		</table>
          	</form>
			<form name="editUser" id="editUser" method="post" action="/DSC/AdminUsers"> 
				<table id="selectUserEdit">
					<tr><h2 class="title">Edit Current User:</h2></tr>
					<tr><td><h3>Select User to Edit:</h3></td>
						<td><p>
						<%
							User [] allUsers = UserDAO.listUserByQuery(null,"lastName");
							out.println("<select name=\"user\" id=\"user\">");
							for (User aUser : allUsers) {
								out.println("<option value=\"" + aUser.getEmpId() + "\">" + aUser.getLastName() + ", " + aUser.getFirstName() + "</option>");
							}
							out.println("</select><br />");
						%>
						</p></td>
						<td><p><input name="action" type="submit" id="EditUser" value="Load User" /></p></td>
					</tr>
				</table>
				<table id="editUserInfo">
          			<tr><td><p>FIRST NAME:</p></td><td><input type="text" name="efName" id="efName" size="30" value=""></td><td><p>LAST NAME: </p></td><td><input type="text" name="elName" id="elName" size="30" value=""></td></tr>
          			<tr><td><p>EMAIL:</p></td><td><input type="text" name="eemail" id="eemail" size="30" value=""></td></tr>
          			<tr><td><p>NCS DATE:</p></td><td><input type="etext" name="encs" id="ncs" size="9" value="yyyy-mm-dd"></td></tr>
          			<tr><td><p>POSITION:</p></td><td>
													<% 
														Position [] eallPositions = PositionDAO.listPositionByQuery(null,null);
														out.println("<select name=\"eposition\" id=\"eposition\">");
														for ( Position aPosition : eallPositions ) {
															out.println("<option value=\""+ aPosition.getPositionID() +"\">"+ aPosition.getDescription() +"</option>");
														}
														out.println("</select><br />");
													%>          			
          										</td>
          			</tr>
          			<tr>
          				<td><p>START DATE:</p></td><jsp:include page="../includes/dateselect.jsp" />
          				<td><p>END DATE:</p></td><jsp:include page="../includes/dateselect.jsp" />
					</tr>
					<tr><td><p>DEPARTMENT:</p></td><td>
													<% 
														Department [] eallDepartments = DepartmentDAO.listDepartmentByQuery(null,null);
														out.println("<select name=\"department\" id=\"department\">");
														for ( Department aDept : eallDepartments ) {
															out.println("<option value=\""+ aDept.getDeptID() +"\">"+ aDept.getDeptName() +"</option>");
														}
														out.println("</select><br />");
													%>          			
          										</td>
          			</tr>
          			<tr>
          				<td><p>START DATE:</p></td><jsp:include page="../includes/dateselect.jsp" />
          				<td><p>END DATE:</p></td><jsp:include page="../includes/dateselect.jsp" />
					</tr>
					<tr><td><p>LAN ID:</p></td><td><input type="text" name="elanID" id="elanID" size="8" value=""></td><td><p>PASSWORD:</p></td><td><input type="text" name="epwd" id="epwd" size="8" value=""></td></tr>
					<tr><td><p>DSC ROLE:</p></td><td><select name="erole" id="erole"><option value="1">EMPLOYEE</option><option value="2">MANAGER</option><option value="-1">ADMINISTRATOR</option></select></td>
					<tr><td></td><td><p><input name="action" type="submit" id="SaveEditUser" value="Save Changes" />&nbsp;&nbsp;&nbsp;&nbsp;<input name="action" type="submit" id="DeleteUser" value="Delete User" /></p></td></tr>
				</table>
			</form>
			<% if (emp.getRole() < 0 ) {
				out.println("<p><a href=\"/DSC/Administrator\">BACK TO ADMINISTRATOR</a></p>");
			} %>
		</div>
	  </div>
      <!-- end content -->
	  <!-- start sidebars -->
	  <jsp:include page="../includes/sidebar.jsp" />
	  <!-- end sidebars -->
	  <div style="clear: both;">&nbsp;</div>
  </div><!-- end page -->
</div><!-- end wrapper -->
<jsp:include page="../includes/footer.html" />
<div style="text-align: center; font-size: 0.75em;"></div>
</body>
</html>