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

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class Network_NumbersDAO {
	public static Network_Numbers loadNetwork_NumbersByORMID(int networkNumber) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadNetwork_NumbersByORMID(session, networkNumber);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Network_Numbers loadNetwork_NumbersByORMID(int networkNumber, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadNetwork_NumbersByORMID(session, networkNumber, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Network_Numbers loadNetwork_NumbersByORMID(PersistentSession session, int networkNumber) throws PersistentException {
		try {
			return (Network_Numbers) session.load(mts.dsc.orm.network_numbers.Network_Numbers.class, new Integer(networkNumber));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Network_Numbers loadNetwork_NumbersByORMID(PersistentSession session, int networkNumber, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Network_Numbers) session.load(mts.dsc.orm.network_numbers.Network_Numbers.class, new Integer(networkNumber), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Network_Numbers[] listNetwork_NumbersByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listNetwork_NumbersByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Network_Numbers[] listNetwork_NumbersByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listNetwork_NumbersByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Network_Numbers[] listNetwork_NumbersByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.network_numbers.Network_Numbers as Network_Numbers");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Network_Numbers[]) list.toArray(new Network_Numbers[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Network_Numbers[] listNetwork_NumbersByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.network_numbers.Network_Numbers as Network_Numbers");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Network_Numbers[]) list.toArray(new Network_Numbers[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Network_Numbers loadNetwork_NumbersByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadNetwork_NumbersByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Network_Numbers loadNetwork_NumbersByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadNetwork_NumbersByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Network_Numbers loadNetwork_NumbersByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Network_Numbers[] network_Numberses = listNetwork_NumbersByQuery(session, condition, orderBy);
		if (network_Numberses != null && network_Numberses.length > 0)
			return network_Numberses[0];
		else
			return null;
	}
	
	public static Network_Numbers loadNetwork_NumbersByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Network_Numbers[] network_Numberses = listNetwork_NumbersByQuery(session, condition, orderBy, lockMode);
		if (network_Numberses != null && network_Numberses.length > 0)
			return network_Numberses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateNetwork_NumbersByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateNetwork_NumbersByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateNetwork_NumbersByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateNetwork_NumbersByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateNetwork_NumbersByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.network_numbers.Network_Numbers as Network_Numbers");
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
	
	public static java.util.Iterator iterateNetwork_NumbersByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.network_numbers.Network_Numbers as Network_Numbers");
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
	
	public static Network_Numbers createNetwork_Numbers() {
		return new mts.dsc.orm.network_numbers.Network_Numbers();
	}
	
	public static boolean save(mts.dsc.orm.network_numbers.Network_Numbers network_Numbers) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().saveObject(network_Numbers);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(mts.dsc.orm.network_numbers.Network_Numbers network_Numbers) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().deleteObject(network_Numbers);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.network_numbers.Network_Numbers network_Numbers)throws PersistentException {
		try {
			mts.dsc.orm.project_activity.Project_Activity[] lProject_Activitys = (mts.dsc.orm.project_activity.Project_Activity[])network_Numbers.getProject_Activity().toArray(new mts.dsc.orm.project_activity.Project_Activity[network_Numbers.getProject_Activity().size()]);
			for(int i = 0; i < lProject_Activitys.length; i++) {
				lProject_Activitys[i].setNetwork_NumbersnetworkNumber(null);
			}
			return delete(network_Numbers);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.network_numbers.Network_Numbers network_Numbers, org.orm.PersistentSession session)throws PersistentException {
		try {
			mts.dsc.orm.project_activity.Project_Activity[] lProject_Activitys = (mts.dsc.orm.project_activity.Project_Activity[])network_Numbers.getProject_Activity().toArray(new mts.dsc.orm.project_activity.Project_Activity[network_Numbers.getProject_Activity().size()]);
			for(int i = 0; i < lProject_Activitys.length; i++) {
				lProject_Activitys[i].setNetwork_NumbersnetworkNumber(null);
			}
			try {
				session.delete(network_Numbers);
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
	
	public static boolean refresh(mts.dsc.orm.network_numbers.Network_Numbers network_Numbers) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().refresh(network_Numbers);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
