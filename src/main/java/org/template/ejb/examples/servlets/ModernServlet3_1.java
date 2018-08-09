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
import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.template.ejb.examples.ejb.interfaces.Hello;
import org.template.ejb.examples.ejb.interfaces.HelloHome;

/**
 *
 * @author dnikiforov
 */
@WebServlet(name = "ModernServlet31", urlPatterns = {"/modern"})
public class ModernServlet3_1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String parameterValue = req.getParameter("name");
		final PrintWriter writer = resp.getWriter();
		writer.println("Modern servlet got " + parameterValue);
		writer.flush();
	}

}
