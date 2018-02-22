<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>DSC Login</title>
<link href="../css/main.css" rel="stylesheet" />
</head>
<body>
<% String logout = request.getParameter("logout");
      	if (logout != null){
      		out.println("<h2 style=\"align\">Logout Successful</h2>");
      	}
      
 %>

<form method="post" action="/DSC/LoginServlet" name="login">
  <table width="209" cellpadding="2" cellspacing="2"
 style="width: 200px; text-align: left; margin-left: auto; margin-right: auto;">
      
      
      
      <tr align="center">
        <th colspan="2" rowspan="1">DSC User Login</th>
      </tr>
      <tr>
        <td width="64">Username:</td>
        <td width="131"><input name="username" size="20" type="text"/></td>
      </tr>
      <tr>
        <td>Password:</td>
        <td><input name="password" type="password" size="20" /></td>
      </tr>
      <tr>
        <td colspan="2" rowspan="1" align="center"><input name="login" type="submit" id="login"
 value="Login" /></td>
      </tr>
  </table>
  <br />
</form>
<p style="text-align:center">
<% 

HttpSession sessionS = request.getSession(false);
if (sessionS != null){
String error = (String) sessionS.getAttribute("error");
String visited = (String) sessionS.getAttribute("visited");
	if (visited != null){
		if (error != null){
			out.println(error);
			out.flush();
			
		}
	}
}
%>
</p>
</body>
</html>
