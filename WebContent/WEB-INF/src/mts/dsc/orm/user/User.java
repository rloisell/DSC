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
package mts.dsc.orm.user;

public class User {
	public User() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof User))
			return false;
		User user = (User)aObj;
		if (getEmpId() != user.getEmpId())
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (int) getEmpId();
		return hashcode;
	}
	
	private int empId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private java.util.Date ncsDate;
	
	private int roleID;
	
	private mts.dsc.orm.department.Department Department;
	
	private java.util.Set Activity = new java.util.HashSet();
	
	private mts.dsc.orm.user_auth.User_Auth User_Auth;
	
	private java.util.Set Department_User = new java.util.HashSet();
	
	private java.util.Set User_Position = new java.util.HashSet();
	
	private java.util.Set User_User = new java.util.HashSet();
	
	private java.util.Set User_User1 = new java.util.HashSet();
	
	public void setEmpId(int value) {
		this.empId = value;
	}
	
	public int getEmpId() {
		return empId;
	}
	
	public int getORMID() {
		return getEmpId();
	}
	
	public void setFirstName(String value) {
		this.firstName = value;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String value) {
		this.lastName = value;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setNcsDate(java.util.Date value) {
		this.ncsDate = value;
	}
	
	public java.util.Date getNcsDate() {
		return ncsDate;
	}
	
	public void setRoleID(int value) {
		this.roleID = value;
	}
	
	public int getRoleID() {
		return roleID;
	}
	
	public void setDepartment(mts.dsc.orm.department.Department value) {
		this.Department = value;
	}
	
	public mts.dsc.orm.department.Department getDepartment() {
		return Department;
	}
	
	public void setActivity(java.util.Set value) {
		this.Activity = value;
	}
	
	public java.util.Set getActivity() {
		return Activity;
	}
	
	
	public void setUser_Auth(mts.dsc.orm.user_auth.User_Auth value) {
		this.User_Auth = value;
	}
	
	public mts.dsc.orm.user_auth.User_Auth getUser_Auth() {
		return User_Auth;
	}
	
	public void setDepartment_User(java.util.Set value) {
		this.Department_User = value;
	}
	
	public java.util.Set getDepartment_User() {
		return Department_User;
	}
	
	
	public void setUser_Position(java.util.Set value) {
		this.User_Position = value;
	}
	
	public java.util.Set getUser_Position() {
		return User_Position;
	}
	
	
	public void setUser_User(java.util.Set value) {
		this.User_User = value;
	}
	
	public java.util.Set getUser_User() {
		return User_User;
	}
	
	
	public void setUser_User1(java.util.Set value) {
		this.User_User1 = value;
	}
	
	public java.util.Set getUser_User1() {
		return User_User1;
	}
	
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(getEmpId());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("User[ ");
			sb.append("EmpId=").append(getEmpId()).append(" ");
			sb.append("FirstName=").append(getFirstName()).append(" ");
			sb.append("LastName=").append(getLastName()).append(" ");
			sb.append("Email=").append(getEmail()).append(" ");
			sb.append("NcsDate=").append(getNcsDate()).append(" ");
			sb.append("RoleID=").append(getRoleID()).append(" ");
			if (getDepartment() != null)
				sb.append("Department.Persist_ID=").append(getDepartment().toString(true)).append(" ");
			else
				sb.append("Department=null ");
			sb.append("Activity.size=").append(getActivity().size()).append(" ");
			if (getUser_Auth() != null)
				sb.append("User_Auth.Persist_ID=").append(getUser_Auth().toString(true)).append(" ");
			else
				sb.append("User_Auth=null ");
			sb.append("Department_User.size=").append(getDepartment_User().size()).append(" ");
			sb.append("User_Position.size=").append(getUser_Position().size()).append(" ");
			sb.append("User_User.size=").append(getUser_User().size()).append(" ");
			sb.append("User_User1.size=").append(getUser_User1().size()).append(" ");
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
