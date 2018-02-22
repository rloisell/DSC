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

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class UnionDAO {
	public static Union loadUnionByORMID(int unionId) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadUnionByORMID(session, unionId);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Union loadUnionByORMID(int unionId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadUnionByORMID(session, unionId, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Union loadUnionByORMID(PersistentSession session, int unionId) throws PersistentException {
		try {
			return (Union) session.load(mts.dsc.orm.union.Union.class, new Integer(unionId));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Union loadUnionByORMID(PersistentSession session, int unionId, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Union) session.load(mts.dsc.orm.union.Union.class, new Integer(unionId), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Union[] listUnionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listUnionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Union[] listUnionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listUnionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Union[] listUnionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.union.Union as Union");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Union[]) list.toArray(new Union[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Union[] listUnionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.union.Union as Union");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Union[]) list.toArray(new Union[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Union loadUnionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadUnionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Union loadUnionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadUnionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Union loadUnionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Union[] unions = listUnionByQuery(session, condition, orderBy);
		if (unions != null && unions.length > 0)
			return unions[0];
		else
			return null;
	}
	
	public static Union loadUnionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Union[] unions = listUnionByQuery(session, condition, orderBy, lockMode);
		if (unions != null && unions.length > 0)
			return unions[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateUnionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateUnionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUnionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateUnionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUnionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.union.Union as Union");
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
	
	public static java.util.Iterator iterateUnionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.union.Union as Union");
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
	
	public static Union createUnion() {
		return new mts.dsc.orm.union.Union();
	}
	
	public static boolean save(mts.dsc.orm.union.Union union) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().saveObject(union);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(mts.dsc.orm.union.Union union) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().deleteObject(union);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.union.Union union)throws PersistentException {
		try {
			mts.dsc.orm.position.Position[] lPositions = (mts.dsc.orm.position.Position[])union.getPosition().toArray(new mts.dsc.orm.position.Position[union.getPosition().size()]);
			for(int i = 0; i < lPositions.length; i++) {
				lPositions[i].setUnionunion(null);
			}
			return delete(union);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.union.Union union, org.orm.PersistentSession session)throws PersistentException {
		try {
			mts.dsc.orm.position.Position[] lPositions = (mts.dsc.orm.position.Position[])union.getPosition().toArray(new mts.dsc.orm.position.Position[union.getPosition().size()]);
			for(int i = 0; i < lPositions.length; i++) {
				lPositions[i].setUnionunion(null);
			}
			try {
				session.delete(union);
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
	
	public static boolean refresh(mts.dsc.orm.union.Union union) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().refresh(union);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
