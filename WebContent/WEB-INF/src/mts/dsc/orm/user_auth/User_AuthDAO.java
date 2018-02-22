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

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class User_AuthDAO {
	public static User_Auth loadUser_AuthByORMID(String userName) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadUser_AuthByORMID(session, userName);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_Auth loadUser_AuthByORMID(String userName, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadUser_AuthByORMID(session, userName, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_Auth loadUser_AuthByORMID(PersistentSession session, String userName) throws PersistentException {
		try {
			return (User_Auth) session.load(mts.dsc.orm.user_auth.User_Auth.class, userName);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_Auth loadUser_AuthByORMID(PersistentSession session, String userName, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (User_Auth) session.load(mts.dsc.orm.user_auth.User_Auth.class, userName, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_Auth[] listUser_AuthByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listUser_AuthByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_Auth[] listUser_AuthByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listUser_AuthByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_Auth[] listUser_AuthByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.user_auth.User_Auth as User_Auth");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (User_Auth[]) list.toArray(new User_Auth[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_Auth[] listUser_AuthByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.user_auth.User_Auth as User_Auth");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (User_Auth[]) list.toArray(new User_Auth[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_Auth loadUser_AuthByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadUser_AuthByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_Auth loadUser_AuthByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadUser_AuthByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_Auth loadUser_AuthByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		User_Auth[] user_Auths = listUser_AuthByQuery(session, condition, orderBy);
		if (user_Auths != null && user_Auths.length > 0)
			return user_Auths[0];
		else
			return null;
	}
	
	public static User_Auth loadUser_AuthByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		User_Auth[] user_Auths = listUser_AuthByQuery(session, condition, orderBy, lockMode);
		if (user_Auths != null && user_Auths.length > 0)
			return user_Auths[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateUser_AuthByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateUser_AuthByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUser_AuthByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateUser_AuthByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUser_AuthByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.user_auth.User_Auth as User_Auth");
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
	
	public static java.util.Iterator iterateUser_AuthByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.user_auth.User_Auth as User_Auth");
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
	
	public static User_Auth createUser_Auth() {
		return new mts.dsc.orm.user_auth.User_Auth();
	}
	
	public static boolean save(mts.dsc.orm.user_auth.User_Auth user_Auth) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().saveObject(user_Auth);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(mts.dsc.orm.user_auth.User_Auth user_Auth) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().deleteObject(user_Auth);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.user_auth.User_Auth user_Auth)throws PersistentException {
		try {
			if(user_Auth.getUseremp() != null) {
				user_Auth.getUseremp().setUser_Auth(null);
			}
			
			return delete(user_Auth);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.user_auth.User_Auth user_Auth, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(user_Auth.getUseremp() != null) {
				user_Auth.getUseremp().setUser_Auth(null);
			}
			
			try {
				session.delete(user_Auth);
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
	
	public static boolean refresh(mts.dsc.orm.user_auth.User_Auth user_Auth) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().refresh(user_Auth);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
