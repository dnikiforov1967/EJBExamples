/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.template.ejb.examples.ejb.interfaces;

import javax.ejb.EJBObject;

/**
 * 1.0 style
 * 
 * @author dnikiforov
 */
public interface Hello {
	String getGreeting();
	void setGreeting(String greeting);
}
