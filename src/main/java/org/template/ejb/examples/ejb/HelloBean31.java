/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.template.ejb.examples.ejb;

import javax.ejb.Stateful;
import org.template.ejb.examples.ejb.interfaces.Hello31;

/**
 *
 * @author dnikiforov
 */
@Stateful
public class HelloBean31 implements Hello31 {

	private String greeting = "3.1 release";
	
	@Override
	public String getGreeting() {
		return greeting;
	}

	@Override
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
}
