package com.scry.assignment.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.scry.assignment.config.Config;
import com.scry.assignment.service.BookingService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Controller {	

	/**
	 * Start the server and create different routes
	 */
	public void startServer() {
		HttpServer server = null;
		try {
			// create server
			server = HttpServer.create(new InetSocketAddress(Config.port), 0);
			
			// create contexts or routes
			server.createContext("/assignment/bookings", new FetchBookingHandler());

			// start server
			server.setExecutor(null);
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Class implementing HttpHandler
	 *
	 */
	class FetchBookingHandler implements HttpHandler {
		public void handle(HttpExchange httpExchange) throws IOException {
			if("GET".equals(httpExchange.getRequestMethod())) { 
		       String response = new BookingService().getAllBookings();		       
		       handleResponse(httpExchange, response);
			}			
		}
	}
	
	/**
	 * Handle response
	 * @param httpExchange
	 * @param responseJson
	 * @throws IOException
	 */
	private void handleResponse(HttpExchange httpExchange, String responseJson) throws IOException {				
		OutputStream outputStream = httpExchange.getResponseBody();
		httpExchange.sendResponseHeaders(200, responseJson.length());
		outputStream.write(responseJson.getBytes());
		outputStream.close();
	}

}