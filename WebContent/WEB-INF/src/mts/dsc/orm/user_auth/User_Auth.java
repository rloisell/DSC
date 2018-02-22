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
package mts.dsc.orm.user_auth;

public class User_Auth {
	public User_Auth() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof User_Auth))
			return false;
		User_Auth user_auth = (User_Auth)aObj;
		if ((getUserName() != null && !getUserName().equals(user_auth.getUserName())) || (getUserName() == null && user_auth.getUserName() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getUserName() == null ? 0 : getUserName().hashCode());
		return hashcode;
	}
	
	private mts.dsc.orm.user.User Useremp;
	
	private String userName;
	
	private String password;
	
	public void setUserName(String value) {
		this.userName = value;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getORMID() {
		return getUserName();
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
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
			return String.valueOf(getUserName());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("User_Auth[ ");
			if (getUseremp() != null)
				sb.append("Useremp.Persist_ID=").append(getUseremp().toString(true)).append(" ");
			else
				sb.append("Useremp=null ");
			sb.append("UserName=").append(getUserName()).append(" ");
			sb.append("Password=").append(getPassword()).append(" ");
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
