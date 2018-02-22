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
package mts.dsc.orm.department_user;

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class Department_UserDAO {
	public static Department_User loadDepartment_UserByORMID(mts.dsc.orm.user.User Useremp, mts.dsc.orm.department.Department Departmentdept, java.util.Date startDate) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadDepartment_UserByORMID(session, Useremp, Departmentdept, startDate);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Department_User loadDepartment_UserByORMID(mts.dsc.orm.user.User Useremp, mts.dsc.orm.department.Department Departmentdept, java.util.Date startDate, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadDepartment_UserByORMID(session, Useremp, Departmentdept, startDate, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Department_User loadDepartment_UserByORMID(PersistentSession session, mts.dsc.orm.user.User Useremp, mts.dsc.orm.department.Department Departmentdept, java.util.Date startDate) throws PersistentException {
		try {
			Department_User department_user = new mts.dsc.orm.department_user.Department_User();
			department_user.setUseremp(Useremp);
			department_user.setDepartmentdept(Departmentdept);
			department_user.setStartDate(startDate);
			
			return (Department_User) session.load(mts.dsc.orm.department_user.Department_User.class, department_user);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Department_User loadDepartment_UserByORMID(PersistentSession session, mts.dsc.orm.user.User Useremp, mts.dsc.orm.department.Department Departmentdept, java.util.Date startDate, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Department_User department_user = new mts.dsc.orm.department_user.Department_User();
			department_user.setUseremp(Useremp);
			department_user.setDepartmentdept(Departmentdept);
			department_user.setStartDate(startDate);
			
			return (Department_User) session.load(mts.dsc.orm.department_user.Department_User.class, department_user, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Department_User[] listDepartment_UserByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listDepartment_UserByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Department_User[] listDepartment_UserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listDepartment_UserByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Department_User[] listDepartment_UserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.department_user.Department_User as Department_User");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Department_User[]) list.toArray(new Department_User[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Department_User[] listDepartment_UserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.department_user.Department_User as Department_User");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Department_User[]) list.toArray(new Department_User[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Department_User loadDepartment_UserByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadDepartment_UserByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Department_User loadDepartment_UserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadDepartment_UserByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Department_User loadDepartment_UserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Department_User[] department_Users = listDepartment_UserByQuery(session, condition, orderBy);
		if (department_Users != null && department_Users.length > 0)
			return department_Users[0];
		else
			return null;
	}
	
	public static Department_User loadDepartment_UserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Department_User[] department_Users = listDepartment_UserByQuery(session, condition, orderBy, lockMode);
		if (department_Users != null && department_Users.length > 0)
			return department_Users[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDepartment_UserByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateDepartment_UserByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDepartment_UserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateDepartment_UserByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDepartment_UserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.department_user.Department_User as Department_User");
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
	
	public static java.util.Iterator iterateDepartment_UserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.department_user.Department_User as Department_User");
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
	
	public static Department_User createDepartment_User() {
		return new mts.dsc.orm.department_user.Department_User();
	}
	
	public static boolean save(mts.dsc.orm.department_user.Department_User department_User) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().saveObject(department_User);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(mts.dsc.orm.department_user.Department_User department_User) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().deleteObject(department_User);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.department_user.Department_User department_User)throws PersistentException {
		try {
			if(department_User.getUseremp() != null) {
				department_User.getUseremp().getDepartment_User().remove(department_User);
			}
			
			if(department_User.getDepartmentdept() != null) {
				department_User.getDepartmentdept().getDepartment_User().remove(department_User);
			}
			
			return delete(department_User);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.department_user.Department_User department_User, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(department_User.getUseremp() != null) {
				department_User.getUseremp().getDepartment_User().remove(department_User);
			}
			
			if(department_User.getDepartmentdept() != null) {
				department_User.getDepartmentdept().getDepartment_User().remove(department_User);
			}
			
			try {
				session.delete(department_User);
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
	
	public static boolean refresh(mts.dsc.orm.department_user.Department_User department_User) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().refresh(department_User);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
