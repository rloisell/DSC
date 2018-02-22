<td>
  	<select name="year" id="year">
  	<% 
		for ( int y = 1965; y < 2025; y++ ) {
			out.println("<option value=\""+ y +"\">"+ y +"</option>");
		}
	%>
  	</select>
 	<select name="month" id="month">
 		<option value="1">January</option>
 		<option value="2">February</option>
 		<option value="3">March</option>
 		<option value="4">April</option>
 		<option value="5">May</option>
 		<option value="6">June</option>
 		<option value="7">July</option>
 		<option value="8">August</option>
 		<option value="9">September</option>
 		<option value="10">October</option>
 		<option value="11">November</option>
 		<option value="12">December</option>
	</select>
	<select name="day" id="day">
	<% 
		for (int x = 1; x <= 31; x ++ ) {
			out.println("<option value=\""+ x +"\">"+ x +"</option>");
		} 
	%>
	</select>
</td>