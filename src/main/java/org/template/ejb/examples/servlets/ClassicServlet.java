package org.template.ejb.examples.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.template.ejb.examples.ejb.interfaces.Hello;
import org.template.ejb.examples.ejb.interfaces.HelloHome;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dnikiforov
 */
public class ClassicServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InitialContext jndiContext;
		try {
			jndiContext = new InitialContext();
			HelloHome home = (HelloHome) jndiContext.lookup("java:module/HelloBean!" + HelloHome.class.getName());
			Hello hello = home.create();
			final String parameterValue = req.getParameter("name");
			final PrintWriter writer = resp.getWriter();
			writer.println("Classic servlet got " + parameterValue+". "+hello.getGreeting());
			writer.flush();
		} catch (NamingException ex) {
			Logger.getLogger(ClassicServlet.class.getName()).log(Level.SEVERE, null, ex);
		} catch (RemoteException ex) {
			Logger.getLogger(ClassicServlet.class.getName()).log(Level.SEVERE, null, ex);
		} catch (CreateException ex) {
			Logger.getLogger(ClassicServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
