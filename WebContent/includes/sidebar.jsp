<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="mts.dsc.employee.Employee" %>
<%@ page import="mts.dsc.utilities.UserReportGenerator" %>
<div id="sidebar2" class="sidebar">
  <%
  GregorianCalendar gC=new GregorianCalendar();
  String[][] report=UserReportGenerator.generateDailyReport((Employee)session.getAttribute("employee"), gC);
  %>
  <ul>		    
	<li>
	  <h2>Calendar</h2>
	  <jsp:include page="../includes/calendar-body.jsp" />
	</li>
	<li><h2>Defined Hours</h2>
	<div>
	<p>Total Hours: <%= String.valueOf((double)Math.round(100*(Double.parseDouble(report[1][2])+Double.parseDouble(report[1][3])))/100)%><br />
	   Defined Hours: <%= report[1][4]%><br />
	   Sick: <%= report[1][6]%><br />
	   Absent: <%= report[1][5]%><br />
	   Vacation: <%= report[1][7]%>
	</p>
	</div>
	</li>
	<li><h2>Daily Totals</h2>
	<div>
	<p>Actual Hours: <%= String.valueOf((double)Math.round(100*(Double.parseDouble(report[1][2])+Double.parseDouble(report[1][3])))/100)%><br />
	   Overtime: <%= report[1][1]%><br />
	   Expense: <%= report[1][3]%><br />
	   Capital: <%= report[1][2]%><br />
	
	</p>
	</div>
	</li>
  </ul>
</div>