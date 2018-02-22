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

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class User_PositionDAO {
	public static User_Position loadUser_PositionByORMID(mts.dsc.orm.user.User Useremp, mts.dsc.orm.position.Position Positionposition, java.util.Date startDate) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadUser_PositionByORMID(session, Useremp, Positionposition, startDate);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_Position loadUser_PositionByORMID(mts.dsc.orm.user.User Useremp, mts.dsc.orm.position.Position Positionposition, java.util.Date startDate, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadUser_PositionByORMID(session, Useremp, Positionposition, startDate, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_Position loadUser_PositionByORMID(PersistentSession session, mts.dsc.orm.user.User Useremp, mts.dsc.orm.position.Position Positionposition, java.util.Date startDate) throws PersistentException {
		try {
			User_Position user_position = new mts.dsc.orm.user_position.User_Position();
			user_position.setUseremp(Useremp);
			user_position.setPositionposition(Positionposition);
			user_position.setStartDate(startDate);
			
			return (User_Position) session.load(mts.dsc.orm.user_position.User_Position.class, user_position);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_Position loadUser_PositionByORMID(PersistentSession session, mts.dsc.orm.user.User Useremp, mts.dsc.orm.position.Position Positionposition, java.util.Date startDate, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			User_Position user_position = new mts.dsc.orm.user_position.User_Position();
			user_position.setUseremp(Useremp);
			user_position.setPositionposition(Positionposition);
			user_position.setStartDate(startDate);
			
			return (User_Position) session.load(mts.dsc.orm.user_position.User_Position.class, user_position, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_Position[] listUser_PositionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listUser_PositionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_Position[] listUser_PositionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listUser_PositionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_Position[] listUser_PositionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.user_position.User_Position as User_Position");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (User_Position[]) list.toArray(new User_Position[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_Position[] listUser_PositionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.user_position.User_Position as User_Position");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (User_Position[]) list.toArray(new User_Position[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_Position loadUser_PositionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadUser_PositionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_Position loadUser_PositionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadUser_PositionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static User_Position loadUser_PositionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		User_Position[] user_Positions = listUser_PositionByQuery(session, condition, orderBy);
		if (user_Positions != null && user_Positions.length > 0)
			return user_Positions[0];
		else
			return null;
	}
	
	public static User_Position loadUser_PositionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		User_Position[] user_Positions = listUser_PositionByQuery(session, condition, orderBy, lockMode);
		if (user_Positions != null && user_Positions.length > 0)
			return user_Positions[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateUser_PositionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateUser_PositionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUser_PositionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateUser_PositionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUser_PositionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.user_position.User_Position as User_Position");
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
	
	public static java.util.Iterator iterateUser_PositionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.user_position.User_Position as User_Position");
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
	
	public static User_Position createUser_Position() {
		return new mts.dsc.orm.user_position.User_Position();
	}
	
	public static boolean save(mts.dsc.orm.user_position.User_Position user_Position) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().saveObject(user_Position);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(mts.dsc.orm.user_position.User_Position user_Position) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().deleteObject(user_Position);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.user_position.User_Position user_Position)throws PersistentException {
		try {
			if(user_Position.getUseremp() != null) {
				user_Position.getUseremp().getUser_Position().remove(user_Position);
			}
			
			if(user_Position.getPositionposition() != null) {
				user_Position.getPositionposition().getUser_Position().remove(user_Position);
			}
			
			return delete(user_Position);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.user_position.User_Position user_Position, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(user_Position.getUseremp() != null) {
				user_Position.getUseremp().getUser_Position().remove(user_Position);
			}
			
			if(user_Position.getPositionposition() != null) {
				user_Position.getPositionposition().getUser_Position().remove(user_Position);
			}
			
			try {
				session.delete(user_Position);
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
	
	public static boolean refresh(mts.dsc.orm.user_position.User_Position user_Position) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().refresh(user_Position);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
