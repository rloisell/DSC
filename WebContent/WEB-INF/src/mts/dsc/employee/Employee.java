/* THIS IS THE EMPLOYEE CLASS:
 * THE EMPLOYEE CLASS HANDLES ALL THE BUSINESS LOGIC OF ADDING/RECORDING THE ACTIVITIES TO THE LOCAL DATA STRUCTURE
 * WHICH IN THE PROCESS SAVES THE INFO TO THE DATABAS USING THE ACTITIVY CONTAINER METHODS PROVIDED TO IT.
 * THE USER WOULD INTERACT WITH THIS OBJECT TO UPDATE CHANGE PERSONAL INFORMATION AS WELL USING ACCESSOR METHODS
 */
package mts.dsc.employee;

import java.util.*;
import java.text.SimpleDateFormat;

import org.orm.*;
import mts.dsc.activitycontainer.*;
import mts.dsc.orm.*;
import mts.dsc.orm.position.Position;
import mts.dsc.orm.user_position.User_Position;


/**
 * @author loiselle
 *
 */
public class Employee{
	// LOCAL REFERENCE TO USER
	private mts.dsc.orm.user.User aUser;
	
	// LOCAL REFERENCE TO POSITIONS
	private Set myPositions;
	private Object positionsArray[];
	private mts.dsc.orm.position.Position aPosition;
	
	// CURRENT HOURS AND REQUIRED HOURS
	private double requiredHours = 0;
	private double hours = 0;
	private double overtime = 0;

	
	// ACTIVITIES COLLECTION
	private ActivityContainer[] todaysActivities;
	
	// LOCAL REFERENCE TO DATE
	private mts.dsc.orm.calendar.Calendar today;
	private String dateFormatString = new String("yyyy-MM-dd");
	private SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);

	// DEFAULT CONSTRUCTOR
	public Employee() {
	}
	
	// CONSTRUCTOR TO POPULATE EMPLOYEE WITH USER, POSITION, ETC
	public Employee( mts.dsc.orm.user.User aUser ) {
		// POPULATE EMPLOYEE WITH CURRENT USER
		this.aUser = aUser;
		
		// POPULATE EMPLOYEE WITH USERS CURRENT POSITION
		this.myPositions = aUser.getUser_Position();
		this.positionsArray = myPositions.toArray();
		this.aPosition = ((User_Position)positionsArray[myPositions.size() - 1]).getPositionposition();
		
		// LOAD TODAYS ACTIVITIES
		try {
			Date todaysDate = new Date();
			today = mts.dsc.orm.calendar.CalendarDAO.loadCalendarByORMID(todaysDate);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		todaysActivities = getTodaysActivities();
		
		
		// POPULATE EMPLOYEE WITH REQUIRED HOURS IF NOT A MANAGER
		if ( aPosition.getPositionID() != 4) {
			requiredHours = setRequiredHours( aPosition );
		}
	} // END CONSTRUCTOR
	
	// METHODS

	// SET REQUIRED HOURS
	// FUTURE: ADD ADDITIONAL TO DEAL WITH NON FULL TIME EMPLOYEES
	public double setRequiredHours( mts.dsc.orm.position.Position curPosition ) {
		double reqHrs = 0;
		if ( today.getCalendar_CategorycalendarCategory().getCalendarCategory() != 0 ) {
			return reqHrs;
		}
		else {
			mts.dsc.orm.union.Union myUnion = curPosition.getUnionunion();
			if ((myUnion.getUnionId() == 0)&&(curPosition.getStatus().equalsIgnoreCase("FT"))) {
				reqHrs = 7.5;
				return reqHrs;
			} else if ((myUnion.getUnionId() == 1)&&(curPosition.getStatus().equalsIgnoreCase("FT"))) {
				reqHrs = 7.38;	
				return reqHrs;
			} else if ((myUnion.getUnionId() == 2)&&(curPosition.getStatus().equalsIgnoreCase("FT"))) {
				reqHrs = 7.25;
				return reqHrs;
			}
		}
		return -1;
	} // END SET REQUIRED HOURS
	
	// GET OVER TIME
	public double getOvertime() {
		return overtime;
	}	
	
	// SET DATE WITH mts.dsc.orm.calendar.Calendar
	public void setDate(mts.dsc.orm.calendar.Calendar aDate) {
		today = aDate;
	} // END SET DATE
	
	// SET DATE WITH YEAR, MONTH, DATE FROM JS CALENDAR
	public void setDate(String year, String month, String date) {
		String dateQuery = new String("date=\'"+year+"-"+month+"-"+date+"\'");
		try {
			today = mts.dsc.orm.calendar.CalendarDAO.loadCalendarByQuery(dateQuery, null);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// GET DATE
	public mts.dsc.orm.calendar.Calendar getDate() {
		return today;
	} // END GET DATE
	
	// GET REGUIRED HOURS
	public double getRequiredHours() {
		return this.requiredHours;
	} // END GET REQUIRED HOURS
	
	// GET CURRENT HOURS
	public double getCurrentHours() {
		long temp = Math.round(100*(this.hours/60));
		return ((double)temp)/100;
	} // END CURRENT HOURS
	
	// GET OVER TIME HOURS
	public double getOTHours() {
		long temp = Math.round(100*(this.overtime/60));
		return ((double)temp)/100;
	}
	
	// GET EMPLOYEE ID
	public int getEmpId() {
		return aUser.getEmpId();
	}
	
	// SET ROLE ID - CONTROLS USER, MGR, SYS ADMIN ACCESS
	public void setRole(int roleId) {
		aUser.setRoleID(roleId);
		try {
			mts.dsc.orm.user.UserDAO.save(aUser);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	} // END SET ROLD ID
	
	// GET ROLE ID - CONTROLS USER, MGR, SYS ADMIN ACCESS
	public int getRole() {
		return aUser.getRoleID();
	} // END GET ROLE ID
	
	// SET FIRST NAME
	public void setFirstName( String fName ) {
		aUser.setFirstName(fName);
		try {
			mts.dsc.orm.user.UserDAO.save(aUser);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	} // END SET FIRST NAME
	
	// GET FIRST NAME
	public String getFirstName() {
		return aUser.getFirstName();
	} // END GET FIRST NAME
	
	// SET LAST NAME
	public void setLastName( String lName ) {
		aUser.setLastName(lName);
		try {
			mts.dsc.orm.user.UserDAO.save(aUser);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	} // END SET LAST NAME
	
	// GET LAST NAME
	public String getLastName() {
		return aUser.getLastName();
	} // END GET LAST NAME
	
	// SET EMAIL
	public void setEmail( String email ) {
		aUser.setEmail(email);
		try {
			mts.dsc.orm.user.UserDAO.save(aUser);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	} // END SET EMAIL
	
	// GET EMAIL
	public String getEmail() {
		return aUser.getEmail();
	} // END GET EMAIL
	
	// SET NCS DATE
	public void setNCS( java.util.Date aDate ) {
		aUser.setNcsDate(aDate);
		try {
			mts.dsc.orm.user.UserDAO.save(aUser);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	} // END SET NCS
	
	// GET NCS DATE
	public java.util.Date getNCS() {
		return aUser.getNcsDate();
	}
	
	// GET POSITION 
	public String getPositionDesc() {
		return aPosition.getDescription();
	}
	
	// ADD ACTIVITY
	public void setActivity( mts.dsc.activitycontainer.ActivityContainer anActivity ) {
		// ADDING CURRENT ACTIVITY, REMEMBERING TO CALL ACTIVITYCONTAINER.SAVE()
		mts.dsc.activitycontainer.ActivityContainer [] addedActivities = new mts.dsc.activitycontainer.ActivityContainer[todaysActivities.length + 1];
		System.arraycopy(todaysActivities, 0, addedActivities, 0, todaysActivities.length) ;
		hours += anActivity.getActualDuration();
		if (hours > getRequiredHours()) {
			overtime = hours - getRequiredHours();
		}
		} // END SET ACTIVITY
	
	// RETURN TODAYS ACTIVITIES
	public mts.dsc.activitycontainer.ActivityContainer[] getTodaysActivities() {
		todaysActivities = getDateActivities(today);
		return todaysActivities;
	} // END GET TODAYS ACTIVITIES
	
	// RETURN <DATE> ACTIVITIES
	public mts.dsc.activitycontainer.ActivityContainer[] getDateActivities(mts.dsc.orm.calendar.Calendar aDate) {
		mts.dsc.activitycontainer.ActivityContainer [] loadTodaysActivities = new mts.dsc.activitycontainer.ActivityContainer [0];
		try {
			hours = 0;
			String myDate = dateFormat.format(aDate.getDate());
			String activityQuery = new String("UserempId="+ aUser.getEmpId() +" AND Calendardate=\'"+ myDate +"\'");
			mts.dsc.orm.activity.Activity [] allActivities = mts.dsc.orm.activity.ActivityDAO.listActivityByQuery(activityQuery, "activityID");
			loadTodaysActivities = new mts.dsc.activitycontainer.ActivityContainer[allActivities.length];
			// LOAD MY ACTIVITIES
			for( int x = 0; x < allActivities.length; x++ ) {
				mts.dsc.orm.activity.Activity anActivity = (mts.dsc.orm.activity.Activity) allActivities[x];
				mts.dsc.activitycontainer.ActivityContainer curActivity = new mts.dsc.activitycontainer.ActivityContainer(anActivity.getBudgetbudget().getBudgetId());
				curActivity.setActivity(anActivity);
				if ( anActivity.getBudgetbudget().getBudgetId() == 1) {
					String actID; 
					actID = String.valueOf(anActivity.getBudgetbudget().getBudgetId());
					mts.dsc.orm.expense_activity.Expense_Activity expA = mts.dsc.orm.expense_activity.Expense_ActivityDAO.loadExpense_ActivityByQuery("ActivityactivityID="+actID, null);
					curActivity.setExpActivity(expA);
				}
				else if ( anActivity.getBudgetbudget().getBudgetId() == 2) {
					String actID; 
					actID = String.valueOf(anActivity.getBudgetbudget().getBudgetId());
					mts.dsc.orm.project_activity.Project_Activity proA = mts.dsc.orm.project_activity.Project_ActivityDAO.loadProject_ActivityByQuery("ActivityactivityID="+actID, null);
					curActivity.setProActivity(proA);
				}
				loadTodaysActivities[x] = curActivity;
				hours += anActivity.getActualDuration();
				if (hours > getRequiredHours()) {
					overtime = hours - getRequiredHours();
				}
			}
			return loadTodaysActivities;
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		return loadTodaysActivities;
	} // END RETURN <DATE> ACTIVITIES
	
	// REFRESH MY SELF
	public void refresh() {
		// ADD CODE TO REFRESH VARIOUS OBJECT HERE
		try {
			mts.dsc.orm.user.UserDAO.refresh(aUser);
			mts.dsc.orm.position.PositionDAO.refresh(aPosition);
			todaysActivities = getTodaysActivities();
			for ( int x = 0; x < todaysActivities.length; x++ ) {
				mts.dsc.activitycontainer.ActivityContainer anActivity = todaysActivities[x];
				anActivity.refresh();
				todaysActivities[x] = anActivity;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	} // END REFRESH


}
