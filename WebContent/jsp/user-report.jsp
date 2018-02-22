<%@ page import="mts.dsc.employee.Employee" %>
<%@ page import="mts.dsc.orm.project.Project" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="../css/main.css" rel="stylesheet" type="text/css" media="screen" />
<jsp:include page="../includes/calendar-header.html" />
<title>Weekly Report</title>
</head>

<body onload="createCalendar()">
<% 
GregorianCalendar gC=new GregorianCalendar();
String headerURL="";
HttpSession sessionS = request.getSession(false);
Employee emp=null;
if(sessionS==null) {response.sendRedirect("/DSC/LoginServlet");}
else {
	emp=(Employee)sessionS.getAttribute("employee");
	if(emp==null) {
		response.sendRedirect("/DSC/LoginServlet");
	}
	else {
		Integer year=(Integer)sessionS.getAttribute("year");
		Integer month=(Integer)sessionS.getAttribute("month");
		Integer day=(Integer)sessionS.getAttribute("month");
		if(year!=null&&month!=null&&day!=null) {gC=new GregorianCalendar(year, month, day);}

		switch (emp.getRole()){
			case 1:	headerURL = "../includes/employeeheader.html"; break;
			case 2: headerURL = "../includes/managerheader.html"; break;
			case (-1): headerURL = "../includes/adminheader.html"; break;
		}
	}
}
%>
<script type="text/javascript">
var location1=<% out.println("\"/DSC/UserReportServlet\""); //path of webpage without query string, or null %>
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
          <h1 class="title"><a href="#"><%out.println(emp.getFirstName() +" "+ emp.getLastName() +" - " + emp.getPositionDesc() + " - Hrs Req: "+ emp.getRequiredHours() + " - Hrs Comp: " + emp.getCurrentHours());%></a></h1>
		  <p>Enter a date during the week you want the report for.</p>
		  <form id="report" method="get" action="/DSC/UserReportServlet">
		  <p>
  		  <label for="month">Month </label>
		  <select name="month" id="month">
    		<option value="0">January</option>
    		<option value="1">February</option>
    		<option value="2">March</option>
    		<option value="3">April</option>
    		<option value="4">May</option>
    		<option value="5">June</option>
    		<option value="6">July</option>
    		<option value="7">August</option>
    		<option value="8">September</option>
    		<option value="9">October</option>
    		<option value="10">November</option>
    		<option value="11">December</option>
  		  </select>
  		  <label for="day">Date </label>
  		  <input size="5" type="text" name="day" id="day" />
  		  <label for="year">Year </label>
  		  <input size="5" type="text" name="year" id="year" /></p>
		  <p>
  		  <input type="submit" name="submit" id="submit" />
  		  </p>
  		  </form>
		  <p class="error">
		  <%
		  String error=(String)session.getAttribute("error");
		  if(error!=null) {out.println(error);}
		  %>
		  </p>
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