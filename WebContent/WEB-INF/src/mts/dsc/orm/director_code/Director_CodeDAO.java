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
package mts.dsc.orm.director_code;

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class Director_CodeDAO {
	public static Director_Code loadDirector_CodeByORMID(String directorCode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadDirector_CodeByORMID(session, directorCode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director_Code loadDirector_CodeByORMID(String directorCode, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadDirector_CodeByORMID(session, directorCode, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director_Code loadDirector_CodeByORMID(PersistentSession session, String directorCode) throws PersistentException {
		try {
			return (Director_Code) session.load(mts.dsc.orm.director_code.Director_Code.class, directorCode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director_Code loadDirector_CodeByORMID(PersistentSession session, String directorCode, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Director_Code) session.load(mts.dsc.orm.director_code.Director_Code.class, directorCode, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director_Code[] listDirector_CodeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listDirector_CodeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director_Code[] listDirector_CodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listDirector_CodeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director_Code[] listDirector_CodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.director_code.Director_Code as Director_Code");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Director_Code[]) list.toArray(new Director_Code[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director_Code[] listDirector_CodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.director_code.Director_Code as Director_Code");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Director_Code[]) list.toArray(new Director_Code[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director_Code loadDirector_CodeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadDirector_CodeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director_Code loadDirector_CodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadDirector_CodeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director_Code loadDirector_CodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Director_Code[] director_Codes = listDirector_CodeByQuery(session, condition, orderBy);
		if (director_Codes != null && director_Codes.length > 0)
			return director_Codes[0];
		else
			return null;
	}
	
	public static Director_Code loadDirector_CodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Director_Code[] director_Codes = listDirector_CodeByQuery(session, condition, orderBy, lockMode);
		if (director_Codes != null && director_Codes.length > 0)
			return director_Codes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDirector_CodeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateDirector_CodeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDirector_CodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateDirector_CodeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDirector_CodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.director_code.Director_Code as Director_Code");
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
	
	public static java.util.Iterator iterateDirector_CodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.director_code.Director_Code as Director_Code");
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
	
	public static Director_Code createDirector_Code() {
		return new mts.dsc.orm.director_code.Director_Code();
	}
	
	public static boolean save(mts.dsc.orm.director_code.Director_Code director_Code) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().saveObject(director_Code);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(mts.dsc.orm.director_code.Director_Code director_Code) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().deleteObject(director_Code);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.director_code.Director_Code director_Code)throws PersistentException {
		try {
			mts.dsc.orm.expense_activity.Expense_Activity[] lExpense_Activitys = (mts.dsc.orm.expense_activity.Expense_Activity[])director_Code.getExpense_Activity().toArray(new mts.dsc.orm.expense_activity.Expense_Activity[director_Code.getExpense_Activity().size()]);
			for(int i = 0; i < lExpense_Activitys.length; i++) {
				lExpense_Activitys[i].setDirector_CodedirectorCode(null);
			}
			return delete(director_Code);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.director_code.Director_Code director_Code, org.orm.PersistentSession session)throws PersistentException {
		try {
			mts.dsc.orm.expense_activity.Expense_Activity[] lExpense_Activitys = (mts.dsc.orm.expense_activity.Expense_Activity[])director_Code.getExpense_Activity().toArray(new mts.dsc.orm.expense_activity.Expense_Activity[director_Code.getExpense_Activity().size()]);
			for(int i = 0; i < lExpense_Activitys.length; i++) {
				lExpense_Activitys[i].setDirector_CodedirectorCode(null);
			}
			try {
				session.delete(director_Code);
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
	
	public static boolean refresh(mts.dsc.orm.director_code.Director_Code director_Code) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().refresh(director_Code);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
