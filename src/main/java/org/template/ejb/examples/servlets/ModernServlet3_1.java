/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.template.ejb.examples.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.template.ejb.examples.ejb.interfaces.CDIInterface;
import org.template.ejb.examples.ejb.interfaces.Hello31;

/**
 *
 * @author dnikiforov
 */
@WebServlet(name = "ModernServlet31", urlPatterns = {"/modern"})
public class ModernServlet3_1 extends HttpServlet {

	@Inject
	private CDIInterface cdiInterface;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			final HttpSession session = req.getSession(true);
			Hello31 hello = (Hello31) session.getAttribute("helloBean");
			if (hello == null) {
				InitialContext jndiContext = new InitialContext();
				hello = (Hello31) jndiContext.lookup("java:module/HelloBean31!"+Hello31.class.getName());
				session.setAttribute("helloBean", hello);
			}
			final String parameterValue = req.getParameter("name");
			final PrintWriter writer = resp.getWriter();
			writer.println("Modern servlet got " + parameterValue + ". " + hello.getGreeting());
			writer.println("Modern servlet got " + parameterValue + ". " + cdiInterface.getMessage());
			hello.setGreeting(parameterValue);
			cdiInterface.setMessage(parameterValue);
			writer.flush();
		} catch (NamingException ex) {
			Logger.getLogger(ClassicServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
