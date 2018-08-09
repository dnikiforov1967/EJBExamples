/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.template.ejb.examples.ejb;

import java.rmi.RemoteException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import org.template.ejb.examples.ejb.interfaces.Hello;

/**
 * 1.0 style
 * 
 * @author dnikiforov
 */
public class HelloBean implements SessionBean, Hello {

	private SessionContext ctx;
	private String greeting;

	public HelloBean() {
	}
	
	public String getGreeting() {
		return greeting;
	}
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}	

	@Override
	public void setSessionContext(SessionContext ctx) throws EJBException, RemoteException {
		this.ctx = ctx;
	}

	public void ejbCreate() {
		greeting = "OK, I am here";
	}

	@Override
	public void ejbRemove() {
	}

	@Override
	public void ejbActivate() {
	}

	@Override
	public void ejbPassivate() {

	}

}
