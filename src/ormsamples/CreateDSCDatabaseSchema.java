/**
 * Licensee: MTS Allstream Inc.
 * License Type: Purchased
 */
package ormsamples;

import org.orm.*;
public class CreateDSCDatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(mts.dsc.orm.department_user.DSCPersistentManager.instance());
			mts.dsc.orm.department_user.DSCPersistentManager.instance().disposePersistentManager();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
