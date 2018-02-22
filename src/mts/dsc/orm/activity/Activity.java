/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: MTS Allstream Inc.
 * License Type: Purchased
 */
package mts.dsc.orm.activity;

public class Activity {
	public Activity() {
	}
	
	private int activityID;
	
	private mts.dsc.orm.calendar.Calendar Calandardate;
	
	private String description;
	
	private java.sql.Timestamp startTime;
	
	private java.sql.Timestamp endTime;
	
	private java.sql.Time plannedDuration;
	
	private int actualDuration;
	
	private mts.dsc.orm.user.User Useremp;
	
	private mts.dsc.orm.budget.Budget Budgetbudget;
	
	private mts.dsc.orm.category.Category Categorycategory;
	
	private mts.dsc.orm.project_activity.Project_Activity Project_Activity;
	
	private mts.dsc.orm.expense_activity.Expense_Activity Expense_Activity;
	
	private void setActivityID(int value) {
		this.activityID = value;
	}
	
	public int getActivityID() {
		return activityID;
	}
	
	public int getORMID() {
		return getActivityID();
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setStartTime(java.sql.Timestamp value) {
		this.startTime = value;
	}
	
	public java.sql.Timestamp getStartTime() {
		return startTime;
	}
	
	public void setEndTime(java.sql.Timestamp value) {
		this.endTime = value;
	}
	
	public java.sql.Timestamp getEndTime() {
		return endTime;
	}
	
	public void setPlannedDuration(java.sql.Time value) {
		this.plannedDuration = value;
	}
	
	public java.sql.Time getPlannedDuration() {
		return plannedDuration;
	}
	
	public void setActualDuration(int value) {
		this.actualDuration = value;
	}
	
	public int getActualDuration() {
		return actualDuration;
	}
	
	public void setCalandardate(mts.dsc.orm.calendar.Calendar value) {
		this.Calandardate = value;
	}
	
	public mts.dsc.orm.calendar.Calendar getCalandardate() {
		return Calandardate;
	}
	
	public void setUseremp(mts.dsc.orm.user.User value) {
		this.Useremp = value;
	}
	
	public mts.dsc.orm.user.User getUseremp() {
		return Useremp;
	}
	
	public void setCategorycategory(mts.dsc.orm.category.Category value) {
		this.Categorycategory = value;
	}
	
	public mts.dsc.orm.category.Category getCategorycategory() {
		return Categorycategory;
	}
	
	public void setBudgetbudget(mts.dsc.orm.budget.Budget value) {
		this.Budgetbudget = value;
	}
	
	public mts.dsc.orm.budget.Budget getBudgetbudget() {
		return Budgetbudget;
	}
	
	public void setProject_Activity(mts.dsc.orm.project_activity.Project_Activity value) {
		this.Project_Activity = value;
	}
	
	public mts.dsc.orm.project_activity.Project_Activity getProject_Activity() {
		return Project_Activity;
	}
	
	public void setExpense_Activity(mts.dsc.orm.expense_activity.Expense_Activity value) {
		this.Expense_Activity = value;
	}
	
	public mts.dsc.orm.expense_activity.Expense_Activity getExpense_Activity() {
		return Expense_Activity;
	}
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(getActivityID());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("Activity[ ");
			sb.append("ActivityID=").append(getActivityID()).append(" ");
			if (getCalandardate() != null)
				sb.append("Calandardate.Persist_ID=").append(getCalandardate().toString(true)).append(" ");
			else
				sb.append("Calandardate=null ");
			sb.append("Description=").append(getDescription()).append(" ");
			sb.append("StartTime=").append(getStartTime()).append(" ");
			sb.append("EndTime=").append(getEndTime()).append(" ");
			sb.append("PlannedDuration=").append(getPlannedDuration()).append(" ");
			sb.append("ActualDuration=").append(getActualDuration()).append(" ");
			if (getUseremp() != null)
				sb.append("Useremp.Persist_ID=").append(getUseremp().toString(true)).append(" ");
			else
				sb.append("Useremp=null ");
			if (getBudgetbudget() != null)
				sb.append("Budgetbudget.Persist_ID=").append(getBudgetbudget().toString(true)).append(" ");
			else
				sb.append("Budgetbudget=null ");
			if (getCategorycategory() != null)
				sb.append("Categorycategory.Persist_ID=").append(getCategorycategory().toString(true)).append(" ");
			else
				sb.append("Categorycategory=null ");
			if (getProject_Activity() != null)
				sb.append("Project_Activity.Persist_ID=").append(getProject_Activity().toString(true)).append(" ");
			else
				sb.append("Project_Activity=null ");
			if (getExpense_Activity() != null)
				sb.append("Expense_Activity.Persist_ID=").append(getExpense_Activity().toString(true)).append(" ");
			else
				sb.append("Expense_Activity=null ");
			sb.append("]");
			return sb.toString();
		}
	}
	
}
