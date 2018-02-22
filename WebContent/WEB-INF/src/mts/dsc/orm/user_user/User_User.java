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
package mts.dsc.orm.user_user;

import java.io.Serializable;
public class User_User implements Serializable {
	public User_User() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof User_User))
			return false;
		User_User user_user = (User_User)aObj;
		if (getUseremp() == null) {
			if (user_user.getUseremp() != null)
				return false;
		}
		else if (!getUseremp().equals(user_user.getUseremp()))
			return false;
		if (getUserempId2() == null) {
			if (user_user.getUserempId2() != null)
				return false;
		}
		else if (!getUserempId2().equals(user_user.getUserempId2()))
			return false;
		if ((getStartDate() != null && !getStartDate().equals(user_user.getStartDate())) || (getStartDate() == null && user_user.getStartDate() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		if (getUseremp() != null) {
			hashcode = hashcode + (int) getUseremp().getORMID();
		}
		if (getUserempId2() != null) {
			hashcode = hashcode + (int) getUserempId2().getORMID();
		}
		hashcode = hashcode + (getStartDate() == null ? 0 : getStartDate().hashCode());
		return hashcode;
	}
	
	private mts.dsc.orm.user.User Useremp;
	
	private mts.dsc.orm.user.User UserempId2;
	
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
	
	public void setUseremp(mts.dsc.orm.user.User value) {
		this.Useremp = value;
	}
	
	public mts.dsc.orm.user.User getUseremp() {
		return Useremp;
	}
	
	public void setUserempId2(mts.dsc.orm.user.User value) {
		this.UserempId2 = value;
	}
	
	public mts.dsc.orm.user.User getUserempId2() {
		return UserempId2;
	}
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(((getUseremp() == null) ? "" : String.valueOf(getUseremp().getORMID())) + " " + ((getUserempId2() == null) ? "" : String.valueOf(getUserempId2().getORMID())) + " " + getStartDate());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("User_User[ ");
			if (getUseremp() != null)
				sb.append("Useremp.Persist_ID=").append(getUseremp().toString(true)).append(" ");
			else
				sb.append("Useremp=null ");
			if (getUserempId2() != null)
				sb.append("UserempId2.Persist_ID=").append(getUserempId2().toString(true)).append(" ");
			else
				sb.append("UserempId2=null ");
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
