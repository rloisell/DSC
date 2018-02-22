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
package mts.dsc.orm.project;

public class Project {
	public Project() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Project))
			return false;
		Project project = (Project)aObj;
		if ((getProjectNo() != null && !getProjectNo().equals(project.getProjectNo())) || (getProjectNo() == null && project.getProjectNo() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getProjectNo() == null ? 0 : getProjectNo().hashCode());
		return hashcode;
	}
	
	private String projectNo;
	
	private String description;
	
	private java.util.Set Project_Activity = new java.util.HashSet();
	
	public void setProjectNo(String value) {
		this.projectNo = value;
	}
	
	public String getProjectNo() {
		return projectNo;
	}
	
	public String getORMID() {
		return getProjectNo();
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
			return String.valueOf(getProjectNo());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("Project[ ");
			sb.append("ProjectNo=").append(getProjectNo()).append(" ");
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
