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
package mts.dsc.orm.activity_codes;

public class Activity_Codes {
	public Activity_Codes() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Activity_Codes))
			return false;
		Activity_Codes activity_codes = (Activity_Codes)aObj;
		if (getActivityCode() != activity_codes.getActivityCode())
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (int) getActivityCode();
		return hashcode;
	}
	
	private int activityCode;
	
	private String description;
	
	private java.util.Set Project_Activity = new java.util.HashSet();
	
	public void setActivityCode(int value) {
		this.activityCode = value;
	}
	
	public int getActivityCode() {
		return activityCode;
	}
	
	public int getORMID() {
		return getActivityCode();
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setProject_Activity(java.util.Set value) {
		this.Project_Activity = value;
	}
	
	public java.util.Set getProject_Activity() {
		return Project_Activity;
	}
	
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(getActivityCode());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("Activity_Codes[ ");
			sb.append("ActivityCode=").append(getActivityCode()).append(" ");
			sb.append("Description=").append(getDescription()).append(" ");
			sb.append("Project_Activity.size=").append(getProject_Activity().size()).append(" ");
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
