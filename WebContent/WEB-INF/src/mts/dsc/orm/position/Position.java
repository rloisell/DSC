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
package mts.dsc.orm.position;

public class Position {
	public Position() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Position))
			return false;
		Position position = (Position)aObj;
		if (getPositionID() != position.getPositionID())
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (int) getPositionID();
		return hashcode;
	}
	
	private int positionID;
	
	private int latCode;
	
	private String description;
	
	private String status;
	
	private mts.dsc.orm.union.Union Unionunion;
	
	private java.util.Set User_Position = new java.util.HashSet();
	
	public void setPositionID(int value) {
		this.positionID = value;
	}
	
	public int getPositionID() {
		return positionID;
	}
	
	public int getORMID() {
		return getPositionID();
	}
	
	public void setLatCode(int value) {
		this.latCode = value;
	}
	
	public int getLatCode() {
		return latCode;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setStatus(String value) {
		this.status = value;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setUnionunion(mts.dsc.orm.union.Union value) {
		this.Unionunion = value;
	}
	
	public mts.dsc.orm.union.Union getUnionunion() {
		return Unionunion;
	}
	
	public void setUser_Position(java.util.Set value) {
		this.User_Position = value;
	}
	
	public java.util.Set getUser_Position() {
		return User_Position;
	}
	
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(getPositionID());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("Position[ ");
			sb.append("PositionID=").append(getPositionID()).append(" ");
			sb.append("LatCode=").append(getLatCode()).append(" ");
			sb.append("Description=").append(getDescription()).append(" ");
			sb.append("Status=").append(getStatus()).append(" ");
			if (getUnionunion() != null)
				sb.append("Unionunion.Persist_ID=").append(getUnionunion().toString(true)).append(" ");
			else
				sb.append("Unionunion=null ");
			sb.append("User_Position.size=").append(getUser_Position().size()).append(" ");
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
