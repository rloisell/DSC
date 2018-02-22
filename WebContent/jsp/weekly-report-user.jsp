<%@ page import="mts.dsc.utilities.UserReportGenerator" %>
<%@ page import="mts.dsc.employee.Employee" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<html>
<head>
<title>Weekly Report</title>
</head>
<body>
<%
response.setContentType("application/vnd.ms-excel");
HttpSession sessionS = request.getSession(true);
Employee emp=(Employee)sessionS.getAttribute("employee");
String[][] output=null;
if(emp==null) {
	response.sendRedirect("/DSC/LoginServlet");
}
else {
	emp.refresh();
	sessionS.setAttribute("employee", emp);
	GregorianCalendar gC=(GregorianCalendar)sessionS.getAttribute("calendar");
	output=UserReportGenerator.generateWeeklyReport(emp, gC);
}
%>
<table>
<%
if(output!=null) {
	for(int i=0; i<output[0].length; i++) {
		out.println("<tr>");
		for(int j=0; j<output.length; j++) {
			out.print("<td>"+output[j][i]+"</td>");
		}
		out.println("</tr>");
	}
}
else {
	out.println("null");
}
%>
</table>
</body>
</html>