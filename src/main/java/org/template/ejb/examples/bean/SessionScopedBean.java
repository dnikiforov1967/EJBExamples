/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.template.ejb.examples.bean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import org.template.ejb.examples.ejb.interfaces.CDIInterface;

/**
 *
 * @author dnikiforov
 */
@SessionScoped
public class SessionScopedBean implements CDIInterface, Serializable {

	private String message = "Init scope";

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
