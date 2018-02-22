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
package mts.dsc.orm.calendar_category;

public class Calendar_Category {
	public Calendar_Category() {
	}
	
	private int calendarCategory;
	
	private String calendarCatName;
	
	private String description;
	
	private java.util.Set Calandar = new java.util.HashSet();
	
	private void setCalendarCategory(int value) {
		this.calendarCategory = value;
	}
	
	public int getCalendarCategory() {
		return calendarCategory;
	}
	
	public int getORMID() {
		return getCalendarCategory();
	}
	
	public void setCalendarCatName(String value) {
		this.calendarCatName = value;
	}
	
	public String getCalendarCatName() {
		return calendarCatName;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setCalandar(java.util.Set value) {
		this.Calandar = value;
	}
	
	public java.util.Set getCalandar() {
		return Calandar;
	}
	
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(getCalendarCategory());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("Calendar_Category[ ");
			sb.append("CalendarCategory=").append(getCalendarCategory()).append(" ");
			sb.append("CalendarCatName=").append(getCalendarCatName()).append(" ");
			sb.append("Description=").append(getDescription()).append(" ");
			sb.append("Calandar.size=").append(getCalandar().size()).append(" ");
			sb.append("]");
			return sb.toString();
		}
	}
	
}
