<%@ page import="mts.dsc.employee.Employee" %>
<%@ page import="mts.dsc.orm.project.Project" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="../css/main.css" rel="stylesheet" type="text/css" media="screen" />
<jsp:include page="../includes/calendar-header.html" />
<title>Admin Activity Options</title>
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
          <h1 class="title"><a href="#"><%out.println(emp.getFirstName() +" "+ emp.getLastName() +" - " + emp.getPositionDesc());%>: Admin Activity Options</a></h1>
			<p> HERE </p>
			<p><a href="/DSC/Administrator">BACK TO ADMINISTRATOR</a></p>
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