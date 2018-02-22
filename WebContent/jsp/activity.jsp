<%@ page import="mts.dsc.employee.Employee" %>
<%@ page import="java.util.Collection" %>
<%@ page import="mts.dsc.activitycontainer.ActivityContainer"%>
<%@	page import="mts.dsc.orm.category.*" %>
<%@	page import="mts.dsc.orm.project.*" %>
<%@	page import="mts.dsc.orm.cpc_code.*" %>
<%@	page import="mts.dsc.orm.network_numbers.*" %>
<%@ page import="mts.dsc.orm.activity_codes.*" %>
<%@ page import="mts.dsc.orm.director_code.*" %>
<%@ page import="mts.dsc.orm.reason_code.*" %>
<%@ page import="mts.dsc.orm.cpc_code.*" %>
<%@ page import="org.orm.PersistentException" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="../css/main.css" rel="stylesheet" type="text/css" media="screen" />
<jsp:include page="../includes/calendar-header.html" />
<title>Activities</title>
</head>

<body onload="createCalendar()">


<%
GregorianCalendar gC = new GregorianCalendar();

Employee emp = null;

String headerURL ="";
String flag = "";
String jsperror = null;
HttpSession sessionS = request.getSession(false);
if (sessionS == null){
	response.sendRedirect("/DSC/LoginServlet");
}
else {
	emp=(Employee)sessionS.getAttribute("employee");
	if(emp==null) {
		response.sendRedirect("/DSC/LoginServlet");
	}
	else {
		switch (emp.getRole()){
			case 1:	headerURL = "../includes/employeeheader.html"; break;
			case 2: headerURL = "../includes/managerheader.html"; break;
			case (-1): headerURL = "../includes/adminheader.html"; break;	
		}
	Date d = emp.getDate().getDate();
	gC.set(d.getYear() + 1900, d.getMonth(), d.getDate());	
	}
}


%>

<script type="text/javascript">
var location1= <% out.println("\"../ActivityServlet\""); %>
var year = <%= gC.get(Calendar.YEAR) %>
var month = <%= gC.get(Calendar.MONTH) %>
var day = <%= gC.get(Calendar.DATE) %>
</script>

<jsp:include page="<%= headerURL %>" />

<!-- end header -->

<div id="wrapper">
	<!-- start page -->
	<div id="page">

      <!-- start content -->
      <div id="content">
        <div class="post">
          <h1 class="title"><a href="#">
          
          <%
          	if (sessionS != null && emp != null)
          out.println(emp.getFirstName() +" "+ emp.getLastName() +" - " + emp.getPositionDesc() + " - Hrs Req: "+ emp.getRequiredHours() + " - Hrs Comp: " + emp.getCurrentHours());
          
          %></a></h1>
	              
          <form id="activiyForm" name="activityForm" method="post" action="/DSC/ActivityServlet">
	                
            <table width="842" id="activitytable">
              <tr>
                <td width="120">Type</td>
                <td width="711"><input name="typeGroup" type="radio" id="projectRadio" onclick="window.location.href='/DSC/ActivityServlet?action=1'" value="2"  
               
                <% if (sessionS != null && emp != null){
                	flag = (String)session.getAttribute("type");
                	if (flag!=null){ 
                		if (flag.equals("projectRadio")) out.println("checked=\"checked\"");
                	}
                }
                %>
                 />
                    <label for="projectRadio" >Project</label><br />

			<!-- Start Display Project Listing -->
			<% if (sessionS != null && emp != null){
				if (flag != null){
					
					if (flag.equals("projectRadio")){
						
						// Show project listing
						Project[] projects = (Project[])session.getAttribute("projects");
						out.println("<select name=\"project\" id=\"project\">");
						for (Project p : projects){
						out.println("<option value=\"" + p.getProjectNo() + "\">" + p.getProjectNo() + " - " + p.getDescription() + "</option>");
						}
						out.println("</select>");
						
						// Show Network Numbers
						Network_Numbers[] netNums = (Network_Numbers[])session.getAttribute("netNums");
						out.println("<select name=\"networkNumbers\" id=\"networkNumbers\">");
						for (Network_Numbers n : netNums){
						out.println("<option value=\"" + n.getNetworkNumber() + "\">" + n.getNetworkNumber()+ " - " + n.getDescription() + "</option>");
						}
						out.println("</select>");
						
						// Show Activity Codes
						Activity_Codes[] actCodes = (Activity_Codes[])session.getAttribute("actCodes");
						out.println("<select name=\"activityCodes\" id=\"activityCodes\">");
						for (Activity_Codes a : actCodes){
						out.println("<option value=\"" + a.getActivityCode() + "\">" + a.getActivityCode() + " - " + a.getDescription() + "</option>");
						}
						out.println("</select><br />");	
					}
				}
			}
			%>
			<!-- End Display Project Listing -->
                    
                    <input type="radio" name="typeGroup" value="1" id="expenseRadio" onclick="window.location.href='/DSC/ActivityServlet?action=2'"
                    
                    <%	if (sessionS != null && emp != null){
                    	if (flag!=null){ if (flag.equals("expenseRadio")) out.println("checked=\"checked\""); };
                    }
                    %>
                    
                    />
                    <label for="expenseRadio">Expense</label><br />
            <!--  Start Display Expense Listing -->
            <%	if (sessionS != null && emp != null){
            
            	if (flag != null){	
            		if (flag.equals("expenseRadio")){
						// Show director codes
						Director_Code[] directors = (Director_Code[])session.getAttribute("directors");
						out.println("<select name=\"directorCode\" id=\"directors\">");
						for (Director_Code d : directors){
						out.println("<option value=\"" + d.getDirectorCode() + "\">" + d.getDirectorCode() + " - " + d.getDescription() + "</option>");
						}
						out.println("</select>");
						
						// Show Reason Codes
						Reason_Code[] reasons = (Reason_Code[])session.getAttribute("reasons");
						out.println("<select name=\"reasonCode\" id=\"reasonCode\">");
						for (Reason_Code r : reasons){
						out.println("<option value=\"" + r.getReasonCode() + "\">" + r.getReasonCode() + " - " + r.getDescription() + "</option>");
						}
						out.println("</select>");
						
						// Show CPC codes
						CPC_Code[] cpcs = (CPC_Code[])session.getAttribute("cpcs");
						out.println("<select name=\"cpcCode\" id=\"cpcCode\">");
						for (CPC_Code c : cpcs){
						out.println("<option value=\"" + c.getCpcCode() + "\">" + c.getCpcCode() + " - " + c.getDescription() + "</option>");
						}
						out.println("</select>");
					}  	
            	}
            	
            	}%>
            <!-- End Display Expense Listing -->        
                </td>
              </tr>
	                  
              <tr>
                <td><label for="category">Category</label></td>
      <td><select name="category" id="category">
      
      <!-- List all categories in database -->
      <%  if (sessionS != null && emp != null){
      		Category[] categories = (Category[])session.getAttribute("categories");
      		if (categories != null){
      		for (Category cat : categories){
      			out.println("<option value=" + cat.getCategoryID() + ">");
      			out.println(cat.getCategoryName());
      			out.println("</option>");
      		}
      		}
      	}
      %>
           

        </select></td>
    </tr>
              <tr>
                <td><label for="description">Description</label></td>
      <td>
        <input name="description" type="text" id="description" size="50" /></td>
    </tr>
              <tr>
                <td><label for="planned">Planned Duration</label></td>
      <td><input name="plannedHour" type="text" id="plannedHour" value="0" size="2" />  
        hr 
        <input name="plannedMin" type="text" id="plannedMin" value="0" size="2" />   
        minutes    </td>
    </tr>
              <tr>
                <td><label for="actual">Actual Duration</label></td>
                <td><input name="actualHour" type="text" id="actualHour" value="0" size="2" />  
                  hr
                  <input name="actualMin" type="text" id="actualMin" value="0" size="2" />
                  minutes </td>
              </tr>
              <tr>
                <td colspan="2" align="center"><input name="action" type="submit" id="SubmitActivity" value="Submit" /></td>
      </tr>
      <% 
      if (sessionS != null && emp != null){
		String error = (String)session.getAttribute("error");      
      	if (error != null){
      		out.println("<tr><td colspan=\"2\" style=\"color: red\">" + error + "</td></tr>");
      		session.removeAttribute("error");
      	}
      	if (jsperror != null){
      		out.println("<tr><td colspan=\"2\" style=\"color: red\">" + jsperror + "</td></tr>");
      	}
      }
      
      %>
      
      
            </table>
    </form>
	</div>
	<div class="post">
<h1 class="title"><a href="#">Today's Activity List</a></h1>


<form id="activitiesDisplay" name="activitiesDisplay" method="post" action="/DSC/ActivityServlet">
  <table width="842" align="center">
    <tr>
      <th width="48">Type</th>
      <th width="141">Category</th>
      <th width="287">Description</th>
      <th width="140">Planned</th>
      <th width="140">Actual</th>
      <td width="58">Remove</td>
    </tr>
	
	<!-- Print out all activities for current employee and current date  -->
	<%
	if (sessionS != null && emp != null){
	ActivityContainer[] c = emp.getTodaysActivities();
	for(ActivityContainer a : c) {
		if (a != null){
			int actM = a.getActualDuration() % 60;
			int actH = a.getActualDuration() / 60;
			out.println("<tr>");
			out.println("<td align=\"center\">"+a.getBudget().getBudgetDescription()+"</td>");
			out.println("<td align=\"center\">"+a.getCategory().getCategoryName()+"</td>");
			out.println("<td align=\"center\"><input type=\"text\" size=\"40\" value=\"" + a.getDescription()+ "\" /></td>");
			out.println("<td align=\"center\"><input type=\"text\" size=\"2\" value=\"" +   "\" />" + " : " + "<input type=\"text\" size=\"2\" value=\"" +  "\" /></td>");
			out.println("<td align=\"center\"><input type=\"text\" size=\"2\" value=\"" + actH + "\" />" + " : " + "<input type=\"text\" size=\"2\" value=\"" + actM + "\" /></td>");
			out.println("<td align=\"center\"><input type=\"checkbox\" name=\"delete\" value=\"" + a.getActivityID() + "\" /></td>");
			out.println("</tr>");
		}
	}
	}
	else {
		out.println("<tr><td colspan=\"6\">There was no session or employee found</td></tr>");
	}
	%>
    
    <tr>
      <td>&nbsp;</td>
	  <td>&nbsp;</td>
	  <td>&nbsp;</td>
	  <td>&nbsp;</td>
	  <td>&nbsp;</td>
	  <td>&nbsp;</td>
    </tr>
    <tr>
      <td colspan="6" align="right"><input name="action" type="submit" id="submitUpdate" value="Update" /></td>
    </tr>
  </table>
</form>	    
							    	
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

