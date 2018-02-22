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

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class User_UserDAO {
	public static User_User loadUser_UserByORMID(mts.dsc.orm.user.User Useremp, mts.dsc.orm.user.User UserempId2, java.util.Date startDate) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadUser_UserByORMID(session, Useremp, UserempId2, startDate);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_User loadUser_UserByORMID(mts.dsc.orm.user.User Useremp, mts.dsc.orm.user.User UserempId2, java.util.Date startDate, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadUser_UserByORMID(session, Useremp, UserempId2, startDate, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_User loadUser_UserByORMID(PersistentSession session, mts.dsc.orm.user.User Useremp, mts.dsc.orm.user.User UserempId2, java.util.Date startDate) throws PersistentException {
		try {
			User_User user_user = new mts.dsc.orm.user_user.User_User();
			user_user.setUseremp(Useremp);
			user_user.setUserempId2(UserempId2);
			user_user.setStartDate(startDate);
			
			return (User_User) session.load(mts.dsc.orm.user_user.User_User.class, user_user);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_User loadUser_UserByORMID(PersistentSession session, mts.dsc.orm.user.User Useremp, mts.dsc.orm.user.User UserempId2, java.util.Date startDate, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			User_User user_user = new mts.dsc.orm.user_user.User_User();
			user_user.setUseremp(Useremp);
			user_user.setUserempId2(UserempId2);
			user_user.setStartDate(startDate);
			
			return (User_User) session.load(mts.dsc.orm.user_user.User_User.class, user_user, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_User[] listUser_UserByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listUser_UserByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_User[] listUser_UserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listUser_UserByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_User[] listUser_UserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.user_user.User_User as User_User");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (User_User[]) list.toArray(new User_User[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_User[] listUser_UserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.user_user.User_User as User_User");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (User_User[]) list.toArray(new User_User[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_User loadUser_UserByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadUser_UserByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_User loadUser_UserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadUser_UserByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_User loadUser_UserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		User_User[] user_Users = listUser_UserByQuery(session, condition, orderBy);
		if (user_Users != null && user_Users.length > 0)
			return user_Users[0];
		else
			return null;
	}
	
	public static User_User loadUser_UserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		User_User[] user_Users = listUser_UserByQuery(session, condition, orderBy, lockMode);
		if (user_Users != null && user_Users.length > 0)
			return user_Users[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateUser_UserByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateUser_UserByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUser_UserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateUser_UserByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUser_UserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.user_user.User_User as User_User");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUser_UserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.user_user.User_User as User_User");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_User createUser_User() {
		return new mts.dsc.orm.user_user.User_User();
	}
	
	public static boolean save(mts.dsc.orm.user_user.User_User user_User) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().saveObject(user_User);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(mts.dsc.orm.user_user.User_User user_User) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().deleteObject(user_User);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.user_user.User_User user_User)throws PersistentException {
		try {
			if(user_User.getUseremp() != null) {
				user_User.getUseremp().getUser_User().remove(user_User);
			}
			
			if(user_User.getUserempId2() != null) {
				user_User.getUserempId2().getUser_User1().remove(user_User);
			}
			
			return delete(user_User);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.user_user.User_User user_User, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(user_User.getUseremp() != null) {
				user_User.getUseremp().getUser_User().remove(user_User);
			}
			
			if(user_User.getUserempId2() != null) {
				user_User.getUserempId2().getUser_User1().remove(user_User);
			}
			
			try {
				session.delete(user_User);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(mts.dsc.orm.user_user.User_User user_User) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().refresh(user_User);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
