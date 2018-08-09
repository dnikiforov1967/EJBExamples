package org.template.ejb.examples.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		final String parameterValue = req.getParameter("name");
		final PrintWriter writer = resp.getWriter();
		writer.println("I have got "+parameterValue);
		writer.flush();
		super.doGet(req, resp);
	}
	
	
	
}
