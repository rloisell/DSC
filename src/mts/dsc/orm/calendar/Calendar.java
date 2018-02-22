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
package mts.dsc.orm.calendar;

public class Calendar {
	public Calendar() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Calendar))
			return false;
		Calendar calendar = (Calendar)aObj;
		if ((getDate() != null && !getDate().equals(calendar.getDate())) || (getDate() == null && calendar.getDate() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getDate() == null ? 0 : getDate().hashCode());
		return hashcode;
	}
	
	private mts.dsc.orm.calendar_category.Calendar_Category Calendar_CategorycalendarCategory;
	
	private java.util.Date date;
	
	private java.util.Set Activity = new java.util.HashSet();
	
	public void setDate(java.util.Date value) {
		this.date = value;
	}
	
	public java.util.Date getDate() {
		return date;
	}
	
	public java.util.Date getORMID() {
		return getDate();
	}
	
	public void setCalendar_CategorycalendarCategory(mts.dsc.orm.calendar_category.Calendar_Category value) {
		this.Calendar_CategorycalendarCategory = value;
	}
	
	public mts.dsc.orm.calendar_category.Calendar_Category getCalendar_CategorycalendarCategory() {
		return Calendar_CategorycalendarCategory;
	}
	
	public void setActivity(java.util.Set value) {
		this.Activity = value;
	}
	
	public java.util.Set getActivity() {
		return Activity;
	}
	
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(getDate());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("Calendar[ ");
			if (getCalendar_CategorycalendarCategory() != null)
				sb.append("Calendar_CategorycalendarCategory.Persist_ID=").append(getCalendar_CategorycalendarCategory().toString(true)).append(" ");
			else
				sb.append("Calendar_CategorycalendarCategory=null ");
			sb.append("Date=").append(getDate()).append(" ");
			sb.append("Activity.size=").append(getActivity().size()).append(" ");
			sb.append("]");
			return sb.toString();
		}
	}
	
	private boolean _saved = false;
	
	public void onSave() {
		_saved=true;
	}
	
	
	public void onLoad() {
		_saved=true;
	}
	
	
	public boolean isSaved() {
		return _saved;
	}
	
	
}
