<%@ page import="mts.dsc.employee.Employee" %>
<%@ page import="mts.dsc.orm.user_user.User_User" %>
<%@ page import="mts.dsc.orm.user_user.User_UserDAO" %>
<%@ page import="mts.dsc.orm.user.User" %>
<%@ page import="mts.dsc.orm.user.UserDAO" %>
<%@ page import="mts.dsc.utilities.ManagerReportGenerator" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Weekly Report</title>
</head>

<body>
<%
HttpSession sessionS = request.getSession(true);
Employee emp=(Employee)sessionS.getAttribute("employee");
//int year=Integer.parseInt((String)sessionS.getAttribute("year"));
//int month=Integer.parseInt((String)sessionS.getAttribute("month"));
//int day=Integer.parseInt((String)sessionS.getAttribute("month"));
if(emp==null) {
	response.sendRedirect("/DSC/LoginServlet");
}
GregorianCalendar startDate=new GregorianCalendar(2009, 03, 19);
ArrayList<Employee> employees=new ArrayList<Employee>();
String condition="Userempid2="+emp.getEmpId();
User_User[] managees=User_UserDAO.listUser_UserByQuery(condition, null);
for(User_User u : managees) {
	Employee e=new Employee(u.getUseremp());
	employees.add(e);
}
String[][] report=ManagerReportGenerator.generateWeeklyReport(employees, startDate);
for(int i=0; i<report.length; i++) {
out.println("test");
}
%>
</body>
</html>
