package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import servlets.AllRequestsServlet;

import java.time.LocalDateTime;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args){

        AllRequestsServlet allRequestsServlet = new AllRequestsServlet();

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.addServlet(new ServletHolder(allRequestsServlet), "/*");

        Server server = new Server(8080);
        server.setHandler(contextHandler);
        try {
            server.start();
            logger.info("Server started");
            server.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
