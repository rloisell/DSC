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
package mts.dsc.orm.department;

public class Department {
	public Department() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Department))
			return false;
		Department department = (Department)aObj;
		if (getDeptID() != department.getDeptID())
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (int) getDeptID();
		return hashcode;
	}
	
	private mts.dsc.orm.user.User Useremp;
	
	private int deptID;
	
	private String deptName;
	
	private java.util.Set UsedBy = new java.util.HashSet();
	
	private java.util.Set HasDC = new java.util.HashSet();
	
	private java.util.Set Department_User = new java.util.HashSet();
	
	public void setDeptID(int value) {
		this.deptID = value;
	}
	
	public int getDeptID() {
		return deptID;
	}
	
	public int getORMID() {
		return getDeptID();
	}
	
	public void setDeptName(String value) {
		this.deptName = value;
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public void setUseremp(mts.dsc.orm.user.User value) {
		this.Useremp = value;
	}
	
	public mts.dsc.orm.user.User getUseremp() {
		return Useremp;
	}
	
	public void setUsedBy(java.util.Set value) {
		this.UsedBy = value;
	}
	
	public java.util.Set getUsedBy() {
		return UsedBy;
	}
	
	
	public void setHasDC(java.util.Set value) {
		this.HasDC = value;
	}
	
	public java.util.Set getHasDC() {
		return HasDC;
	}
	
	
	public void setDepartment_User(java.util.Set value) {
		this.Department_User = value;
	}
	
	public java.util.Set getDepartment_User() {
		return Department_User;
	}
	
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(getDeptID());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("Department[ ");
			if (getUseremp() != null)
				sb.append("Useremp.Persist_ID=").append(getUseremp().toString(true)).append(" ");
			else
				sb.append("Useremp=null ");
			sb.append("DeptID=").append(getDeptID()).append(" ");
			sb.append("DeptName=").append(getDeptName()).append(" ");
			sb.append("UsedBy.size=").append(getUsedBy().size()).append(" ");
			sb.append("HasDC.size=").append(getHasDC().size()).append(" ");
			sb.append("Department_User.size=").append(getDepartment_User().size()).append(" ");
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
