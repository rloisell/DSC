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
package mts.dsc.orm.department;

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class DepartmentDAO {
	public static Department loadDepartmentByORMID(int deptID) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadDepartmentByORMID(session, deptID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Department loadDepartmentByORMID(int deptID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadDepartmentByORMID(session, deptID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Department loadDepartmentByORMID(PersistentSession session, int deptID) throws PersistentException {
		try {
			return (Department) session.load(mts.dsc.orm.department.Department.class, new Integer(deptID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Department loadDepartmentByORMID(PersistentSession session, int deptID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Department) session.load(mts.dsc.orm.department.Department.class, new Integer(deptID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Department[] listDepartmentByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listDepartmentByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Department[] listDepartmentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listDepartmentByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Department[] listDepartmentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.department.Department as Department");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Department[]) list.toArray(new Department[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Department[] listDepartmentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.department.Department as Department");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Department[]) list.toArray(new Department[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Department loadDepartmentByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadDepartmentByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Department loadDepartmentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadDepartmentByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Department loadDepartmentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Department[] departments = listDepartmentByQuery(session, condition, orderBy);
		if (departments != null && departments.length > 0)
			return departments[0];
		else
			return null;
	}
	
	public static Department loadDepartmentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Department[] departments = listDepartmentByQuery(session, condition, orderBy, lockMode);
		if (departments != null && departments.length > 0)
			return departments[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDepartmentByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateDepartmentByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDepartmentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateDepartmentByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDepartmentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.department.Department as Department");
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
	
	public static java.util.Iterator iterateDepartmentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.department.Department as Department");
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
	
	public static Department createDepartment() {
		return new mts.dsc.orm.department.Department();
	}
	
	public static boolean save(mts.dsc.orm.department.Department department) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().saveObject(department);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(mts.dsc.orm.department.Department department) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().deleteObject(department);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.department.Department department)throws PersistentException {
		try {
			if(department.getUseremp() != null) {
				department.getUseremp().setDepartment(null);
			}
			
			mts.dsc.orm.department.Department[] lUsedBys = (mts.dsc.orm.department.Department[])department.getUsedBy().toArray(new mts.dsc.orm.department.Department[department.getUsedBy().size()]);
			for(int i = 0; i < lUsedBys.length; i++) {
				lUsedBys[i].getHasDC().remove(department);
			}
			mts.dsc.orm.department.Department[] lHasDCs = (mts.dsc.orm.department.Department[])department.getHasDC().toArray(new mts.dsc.orm.department.Department[department.getHasDC().size()]);
			for(int i = 0; i < lHasDCs.length; i++) {
				lHasDCs[i].getUsedBy().remove(department);
			}
			mts.dsc.orm.department_user.Department_User[] lDepartment_Users = (mts.dsc.orm.department_user.Department_User[])department.getDepartment_User().toArray(new mts.dsc.orm.department_user.Department_User[department.getDepartment_User().size()]);
			for(int i = 0; i < lDepartment_Users.length; i++) {
				lDepartment_Users[i].setDepartmentdept(null);
			}
			return delete(department);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.department.Department department, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(department.getUseremp() != null) {
				department.getUseremp().setDepartment(null);
			}
			
			mts.dsc.orm.department.Department[] lUsedBys = (mts.dsc.orm.department.Department[])department.getUsedBy().toArray(new mts.dsc.orm.department.Department[department.getUsedBy().size()]);
			for(int i = 0; i < lUsedBys.length; i++) {
				lUsedBys[i].getHasDC().remove(department);
			}
			mts.dsc.orm.department.Department[] lHasDCs = (mts.dsc.orm.department.Department[])department.getHasDC().toArray(new mts.dsc.orm.department.Department[department.getHasDC().size()]);
			for(int i = 0; i < lHasDCs.length; i++) {
				lHasDCs[i].getUsedBy().remove(department);
			}
			mts.dsc.orm.department_user.Department_User[] lDepartment_Users = (mts.dsc.orm.department_user.Department_User[])department.getDepartment_User().toArray(new mts.dsc.orm.department_user.Department_User[department.getDepartment_User().size()]);
			for(int i = 0; i < lDepartment_Users.length; i++) {
				lDepartment_Users[i].setDepartmentdept(null);
			}
			try {
				session.delete(department);
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
	
	public static boolean refresh(mts.dsc.orm.department.Department department) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().refresh(department);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
