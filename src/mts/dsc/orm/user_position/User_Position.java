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
package mts.dsc.orm.user_position;

import java.io.Serializable;
public class User_Position implements Serializable {
	public User_Position() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof User_Position))
			return false;
		User_Position user_position = (User_Position)aObj;
		if (getUseremp() == null) {
			if (user_position.getUseremp() != null)
				return false;
		}
		else if (!getUseremp().equals(user_position.getUseremp()))
			return false;
		if (getPositionposition() == null) {
			if (user_position.getPositionposition() != null)
				return false;
		}
		else if (!getPositionposition().equals(user_position.getPositionposition()))
			return false;
		if ((getStartDate() != null && !getStartDate().equals(user_position.getStartDate())) || (getStartDate() == null && user_position.getStartDate() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		if (getUseremp() != null) {
			hashcode = hashcode + (int) getUseremp().getORMID();
		}
		if (getPositionposition() != null) {
			hashcode = hashcode + (int) getPositionposition().getORMID();
		}
		hashcode = hashcode + (getStartDate() == null ? 0 : getStartDate().hashCode());
		return hashcode;
	}
	
	private mts.dsc.orm.user.User Useremp;
	
	private mts.dsc.orm.position.Position Positionposition;
	
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
	
	public void setPositionposition(mts.dsc.orm.position.Position value) {
		this.Positionposition = value;
	}
	
	public mts.dsc.orm.position.Position getPositionposition() {
		return Positionposition;
	}
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(((getUseremp() == null) ? "" : String.valueOf(getUseremp().getORMID())) + " " + ((getPositionposition() == null) ? "" : String.valueOf(getPositionposition().getORMID())) + " " + getStartDate());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("User_Position[ ");
			if (getUseremp() != null)
				sb.append("Useremp.Persist_ID=").append(getUseremp().toString(true)).append(" ");
			else
				sb.append("Useremp=null ");
			if (getPositionposition() != null)
				sb.append("Positionposition.Persist_ID=").append(getPositionposition().toString(true)).append(" ");
			else
				sb.append("Positionposition=null ");
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
