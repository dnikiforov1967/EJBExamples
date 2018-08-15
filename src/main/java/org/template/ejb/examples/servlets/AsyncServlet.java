/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.template.ejb.examples.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dnikiforov
 */
@WebServlet(name = "AsyncServlet", urlPatterns = {"/async"}, asyncSupported = true)
public class AsyncServlet extends HttpServlet {

	private static Logger LOG = Logger.getLogger(AsyncServlet.class.getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final PrintWriter writer = resp.getWriter();
		final AsyncContext async = req.startAsync();
		CompletableFuture.runAsync(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException ex) {
					LOG.log(Level.SEVERE, null, ex);
				}
				writer.println("Async task completed");
				writer.flush();
				async.complete();
				LOG.log(Level.INFO, "Async run completed in " + Thread.currentThread().getName());
			}
		});
		LOG.log(Level.INFO, "Async run started in " + Thread.currentThread().getName());
	}

}
