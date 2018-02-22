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
package mts.dsc.orm.department_user;

import java.io.Serializable;
public class Department_User implements Serializable {
	public Department_User() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Department_User))
			return false;
		Department_User department_user = (Department_User)aObj;
		if (getUseremp() == null) {
			if (department_user.getUseremp() != null)
				return false;
		}
		else if (!getUseremp().equals(department_user.getUseremp()))
			return false;
		if (getDepartmentdept() == null) {
			if (department_user.getDepartmentdept() != null)
				return false;
		}
		else if (!getDepartmentdept().equals(department_user.getDepartmentdept()))
			return false;
		if ((getStartDate() != null && !getStartDate().equals(department_user.getStartDate())) || (getStartDate() == null && department_user.getStartDate() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		if (getUseremp() != null) {
			hashcode = hashcode + (int) getUseremp().getORMID();
		}
		if (getDepartmentdept() != null) {
			hashcode = hashcode + (int) getDepartmentdept().getORMID();
		}
		hashcode = hashcode + (getStartDate() == null ? 0 : getStartDate().hashCode());
		return hashcode;
	}
	
	private mts.dsc.orm.user.User Useremp;
	
	private mts.dsc.orm.department.Department Departmentdept;
	
	private java.util.Date startDate;
	
	private java.util.Date endDate;
	
	public void setStartDate(java.util.Date value) {
		this.startDate = value;
	}
	
	public java.util.Date getStartDate() {
		return startDate;
	}
	
	public void setEndDate(java.util.Date value) {
		this.endDate = value;
	}
	
	public java.util.Date getEndDate() {
		return endDate;
	}
	
	public void setDepartmentdept(mts.dsc.orm.department.Department value) {
		this.Departmentdept = value;
	}
	
	public mts.dsc.orm.department.Department getDepartmentdept() {
		return Departmentdept;
	}
	
	public void setUseremp(mts.dsc.orm.user.User value) {
		this.Useremp = value;
	}
	
	public mts.dsc.orm.user.User getUseremp() {
		return Useremp;
	}
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(((getUseremp() == null) ? "" : String.valueOf(getUseremp().getORMID())) + " " + ((getDepartmentdept() == null) ? "" : String.valueOf(getDepartmentdept().getORMID())) + " " + getStartDate());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("Department_User[ ");
			if (getUseremp() != null)
				sb.append("Useremp.Persist_ID=").append(getUseremp().toString(true)).append(" ");
			else
				sb.append("Useremp=null ");
			if (getDepartmentdept() != null)
				sb.append("Departmentdept.Persist_ID=").append(getDepartmentdept().toString(true)).append(" ");
			else
				sb.append("Departmentdept=null ");
			sb.append("StartDate=").append(getStartDate()).append(" ");
			sb.append("EndDate=").append(getEndDate()).append(" ");
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
