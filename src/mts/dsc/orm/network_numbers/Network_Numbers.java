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
package mts.dsc.orm.network_numbers;

public class Network_Numbers {
	public Network_Numbers() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Network_Numbers))
			return false;
		Network_Numbers network_numbers = (Network_Numbers)aObj;
		if (getNetworkNumber() != network_numbers.getNetworkNumber())
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (int) getNetworkNumber();
		return hashcode;
	}
	
	private int networkNumber;
	
	private String description;
	
	private java.util.Set Project_Activity = new java.util.HashSet();
	
	public void setNetworkNumber(int value) {
		this.networkNumber = value;
	}
	
	public int getNetworkNumber() {
		return networkNumber;
	}
	
	public int getORMID() {
		return getNetworkNumber();
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
			return String.valueOf(getNetworkNumber());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("Network_Numbers[ ");
			sb.append("NetworkNumber=").append(getNetworkNumber()).append(" ");
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
