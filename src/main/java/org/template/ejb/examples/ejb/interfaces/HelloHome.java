/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.template.ejb.examples.ejb.interfaces;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 *
 * @author dnikiforov
 */
public interface HelloHome extends EJBHome {
  
	public Hello create () throws RemoteException, CreateException;
	
}
