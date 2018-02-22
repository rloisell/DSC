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
package mts.dsc.orm.union;

public class Union {
	public Union() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Union))
			return false;
		Union union = (Union)aObj;
		if (getUnionId() != union.getUnionId())
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (int) getUnionId();
		return hashcode;
	}
	
	private int unionId;
	
	private String unionName;
	
	private java.util.Set Position = new java.util.HashSet();
	
	public void setUnionId(int value) {
		this.unionId = value;
	}
	
	public int getUnionId() {
		return unionId;
	}
	
	public int getORMID() {
		return getUnionId();
	}
	
	public void setUnionName(String value) {
		this.unionName = value;
	}
	
	public String getUnionName() {
		return unionName;
	}
	
	public void setPosition(java.util.Set value) {
		this.Position = value;
	}
	
	public java.util.Set getPosition() {
		return Position;
	}
	
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(getUnionId());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("Union[ ");
			sb.append("UnionId=").append(getUnionId()).append(" ");
			sb.append("UnionName=").append(getUnionName()).append(" ");
			sb.append("Position.size=").append(getPosition().size()).append(" ");
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
