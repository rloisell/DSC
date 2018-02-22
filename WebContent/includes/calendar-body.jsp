<div id="calendar_wrap">

</div>
<script type="text/javascript">
var calendarDisplayed=false;
var cal;
var todaysdate=new Date();
todaysdate.setFullYear(2009, 1, 14);
function dateChanged(calendar)
{
    if (calendar.dateClicked) {
      var y = calendar.date.getFullYear();
      var m = calendar.date.getMonth()+1;     // integer, 0..11
      var d = calendar.date.getDate();      // integer, 1..31
      //TO DO
	  //what to do with the calendar date
	  
	  if(location1!="null") {window.location=location1+"?year="+y+"&month="+m+"&day="+d;}
	  
	  // redirect...
	  //needs to redirect to current page????
	  //refresh with query string????
      //window.location = "http://hostname/dsc/pagename?year="+y+"month="+m+"day="+d;
    }
}
function createCalendar()
{
	if(calendarDisplayed==false) {
		cal=Calendar.setup(
		{
			flat         : "calendar_wrap",
			flatCallback : dateChanged,
			date 		 : new Date(year, month, day),
			onClose		 : closeCalendar
			<%
			//if(calendar!=null) {out.println(", date : new Date("+calendar.get(Calendar.YEAR)+", "+calendar.get(Calendar.MONTH)+", "+calendar.get(Calendar.DATE)+")");}
			%>
		}
		);
		calendarDisplayed=true;
	}
}
function closeCalendar(calendar)
{
	calendar.destroy();
}
</script>