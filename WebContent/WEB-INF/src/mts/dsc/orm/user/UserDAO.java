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

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class UserDAO {
	public static User loadUserByORMID(int empId) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadUserByORMID(session, empId);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User loadUserByORMID(int empId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadUserByORMID(session, empId, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User loadUserByORMID(PersistentSession session, int empId) throws PersistentException {
		try {
			return (User) session.load(mts.dsc.orm.user.User.class, new Integer(empId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User loadUserByORMID(PersistentSession session, int empId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (User) session.load(mts.dsc.orm.user.User.class, new Integer(empId), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User[] listUserByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listUserByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User[] listUserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listUserByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User[] listUserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.user.User as User");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (User[]) list.toArray(new User[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User[] listUserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.user.User as User");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (User[]) list.toArray(new User[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User loadUserByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadUserByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User loadUserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadUserByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User loadUserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		User[] users = listUserByQuery(session, condition, orderBy);
		if (users != null && users.length > 0)
			return users[0];
		else
			return null;
	}
	
	public static User loadUserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		User[] users = listUserByQuery(session, condition, orderBy, lockMode);
		if (users != null && users.length > 0)
			return users[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateUserByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateUserByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateUserByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.user.User as User");
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
	
	public static java.util.Iterator iterateUserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.user.User as User");
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
	
	public static User createUser() {
		return new mts.dsc.orm.user.User();
	}
	
	public static boolean save(mts.dsc.orm.user.User user) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().saveObject(user);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(mts.dsc.orm.user.User user) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().deleteObject(user);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.user.User user)throws PersistentException {
		try {
			if(user.getDepartment() != null) {
				user.getDepartment().setUseremp(null);
			}
			
			mts.dsc.orm.activity.Activity[] lActivitys = (mts.dsc.orm.activity.Activity[])user.getActivity().toArray(new mts.dsc.orm.activity.Activity[user.getActivity().size()]);
			for(int i = 0; i < lActivitys.length; i++) {
				lActivitys[i].setUseremp(null);
			}
			if(user.getUser_Auth() != null) {
				user.getUser_Auth().setUseremp(null);
			}
			
			mts.dsc.orm.department_user.Department_User[] lDepartment_Users = (mts.dsc.orm.department_user.Department_User[])user.getDepartment_User().toArray(new mts.dsc.orm.department_user.Department_User[user.getDepartment_User().size()]);
			for(int i = 0; i < lDepartment_Users.length; i++) {
				lDepartment_Users[i].setUseremp(null);
			}
			mts.dsc.orm.user_position.User_Position[] lUser_Positions = (mts.dsc.orm.user_position.User_Position[])user.getUser_Position().toArray(new mts.dsc.orm.user_position.User_Position[user.getUser_Position().size()]);
			for(int i = 0; i < lUser_Positions.length; i++) {
				lUser_Positions[i].setUseremp(null);
			}
			mts.dsc.orm.user_user.User_User[] lUser_Users = (mts.dsc.orm.user_user.User_User[])user.getUser_User().toArray(new mts.dsc.orm.user_user.User_User[user.getUser_User().size()]);
			for(int i = 0; i < lUser_Users.length; i++) {
				lUser_Users[i].setUseremp(null);
			}
			mts.dsc.orm.user_user.User_User[] lUser_User1s = (mts.dsc.orm.user_user.User_User[])user.getUser_User1().toArray(new mts.dsc.orm.user_user.User_User[user.getUser_User1().size()]);
			for(int i = 0; i < lUser_User1s.length; i++) {
				lUser_User1s[i].setUserempId2(null);
			}
			return delete(user);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.user.User user, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(user.getDepartment() != null) {
				user.getDepartment().setUseremp(null);
			}
			
			mts.dsc.orm.activity.Activity[] lActivitys = (mts.dsc.orm.activity.Activity[])user.getActivity().toArray(new mts.dsc.orm.activity.Activity[user.getActivity().size()]);
			for(int i = 0; i < lActivitys.length; i++) {
				lActivitys[i].setUseremp(null);
			}
			if(user.getUser_Auth() != null) {
				user.getUser_Auth().setUseremp(null);
			}
			
			mts.dsc.orm.department_user.Department_User[] lDepartment_Users = (mts.dsc.orm.department_user.Department_User[])user.getDepartment_User().toArray(new mts.dsc.orm.department_user.Department_User[user.getDepartment_User().size()]);
			for(int i = 0; i < lDepartment_Users.length; i++) {
				lDepartment_Users[i].setUseremp(null);
			}
			mts.dsc.orm.user_position.User_Position[] lUser_Positions = (mts.dsc.orm.user_position.User_Position[])user.getUser_Position().toArray(new mts.dsc.orm.user_position.User_Position[user.getUser_Position().size()]);
			for(int i = 0; i < lUser_Positions.length; i++) {
				lUser_Positions[i].setUseremp(null);
			}
			mts.dsc.orm.user_user.User_User[] lUser_Users = (mts.dsc.orm.user_user.User_User[])user.getUser_User().toArray(new mts.dsc.orm.user_user.User_User[user.getUser_User().size()]);
			for(int i = 0; i < lUser_Users.length; i++) {
				lUser_Users[i].setUseremp(null);
			}
			mts.dsc.orm.user_user.User_User[] lUser_User1s = (mts.dsc.orm.user_user.User_User[])user.getUser_User1().toArray(new mts.dsc.orm.user_user.User_User[user.getUser_User1().size()]);
			for(int i = 0; i < lUser_User1s.length; i++) {
				lUser_User1s[i].setUserempId2(null);
			}
			try {
				session.delete(user);
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
	
	public static boolean refresh(mts.dsc.orm.user.User user) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().refresh(user);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
